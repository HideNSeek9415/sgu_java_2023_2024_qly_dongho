package gui.dashboard;

import java.awt.EventQueue;

import java.awt.GridBagConstraints;

import javax.swing.JFrame;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import bll.ExportInvoiceBLL;
import bll.ProductBLL;
import bll.SupplierBLL;
import dto.ExportInvoice;
import dto.ExportInvoiceDetail;
import dto.Product;
import dto.Supplier;
import system.ConfigPRJ;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.GridBagLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class ConfirmPayment extends JFrame{
	boolean flag = false;
	private JTable table;
	private DefaultTableModel model;
	private ArrayList<Product> products = zShoppingCartFrame.getShoppingCart();
	private ArrayList<Product> selectedProducts = new ArrayList<>();
	/**
	 * Create the application.
	 */
	public ConfirmPayment(int selectedIDProduct, int quantity) {
		setPreferredSize(new Dimension(761, 500));
        getContentPane().setLayout(new GridBagLayout());

        // Label chiếm 20% của frame
        JLabel lblXcNhnThanh = new JLabel("Xác nhận thanh toán");
        GridBagConstraints gbc_lblXcNhnThanh = new GridBagConstraints();
        gbc_lblXcNhnThanh.gridx = 0;
        gbc_lblXcNhnThanh.gridy = 0;
        gbc_lblXcNhnThanh.weightx = 0.2;
        gbc_lblXcNhnThanh.fill = GridBagConstraints.BOTH;
        getContentPane().add(lblXcNhnThanh, gbc_lblXcNhnThanh);

        // Table chiếm 60% của frame
        table = new JTable(5, 3); // Giả sử table có 5 hàng và 3 cột
        JScrollPane scrollPane = new JScrollPane(table);
        GridBagConstraints gbcScrollPane = new GridBagConstraints();
        gbcScrollPane.gridx = 0;
        gbcScrollPane.gridy = 1;
        gbcScrollPane.weighty = 0.6;
        gbcScrollPane.fill = GridBagConstraints.BOTH;
        getContentPane().add(scrollPane, gbcScrollPane);

        // Panel chứa 2 button
        JPanel buttonPanel = new JPanel();
        JButton confirmBtn = new JButton("Xác nhận");
        confirmBtn.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		confirmBtnActionPerformed();
        			
        	}
        });
        JButton discardBtn = new JButton("Hủy");
        discardBtn.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		discardBtnActionPerformed();
        	}
        });
        discardBtn.setPreferredSize(new Dimension(79, 28));
        buttonPanel.add(confirmBtn);
        buttonPanel.add(discardBtn);

        // Button Panel chiếm 20% của frame
        GridBagConstraints gbcButtonPanel = new GridBagConstraints();
        gbcButtonPanel.gridx = 0;
        gbcButtonPanel.gridy = 2;
        gbcButtonPanel.weightx = 0.2;
        gbcButtonPanel.fill = GridBagConstraints.BOTH;
        getContentPane().add(buttonPanel, gbcButtonPanel);
        
		table.setModel(new javax.swing.table.DefaultTableModel(
	            new Object [][] {
	                {"Dong ho 1", 50000},
	                {"Dong ho 2", 30000},
	                {"Dong ho 3", 150000},
	                {"Dong ho 4", 80000},
	            },
	            new String [] {
	                "Sản phẩm", "Giá tiền"
	            }
	        ));
        scrollPane.setViewportView(table);
        model = (DefaultTableModel) table.getModel();
        if (selectedIDProduct > -1) reloadTableWithOneProduct(selectedIDProduct, quantity);
        else reloadTableWithShoppingCart();;
        initialize();
	}

	protected boolean getFlag() {
		return flag;
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
	}
	
	private void confirmBtnActionPerformed() {
		if (!ConfigPRJ.currentUser.getAccount().getRoleId().equals("CTM")) {
			JOptionPane.showMessageDialog(getRootPane(), "Yêu cầu đăng nhập với vai trò là khách hàng");			
		} else if (table.getSelectedRow() < 0) {
			JOptionPane.showMessageDialog(getRootPane(), "Vui lòng chọn ít nhất 1 sản phẩm");			
		} else {
			int []selectedRows = table.getSelectedRows();
			addStuff(selectedRows);
			boolean errorEI = true, errorEID = true;
			int maxId = ExportInvoiceBLL.getInstance().getNextId();
			int next_id;
			int maxIdDetail = ExportInvoiceBLL.getInstance().getNextIdDetail();
			int next_id_detail;
			if (maxId == -1) JOptionPane.showMessageDialog(rootPane, "Lỗi khi lấy mã phiếu nhập mới nhất");
			if (maxIdDetail == -1) JOptionPane.showMessageDialog(rootPane, "Lỗi khi lấy mã chi tiết phiếu nhập mới nhất");
			else if (maxId > -1 && maxIdDetail > -1){
				//Add vào db phiếu xuất
				next_id = (maxId == 0) ? 1 : maxId+1;  
				next_id_detail = (maxIdDetail == 0) ? 1 : maxIdDetail+1;
				
				java.util.Date currentDate = new java.util.Date();
				// Chuyển đổi sang java.sql.Date
				java.sql.Date sqlDate = new java.sql.Date(currentDate.getTime());

				//Tạo phiếu xuất mới vào database				
//				Mặc định để system.ConfigPRJ.currentUser.getId() là 1
				ExportInvoice exportInvoice = new ExportInvoice(ExportInvoiceBLL.getInstance().getNextId() + 1, -1, ConfigPRJ.currentUser.getId(), currentDate, 0);
    			if (ExportInvoiceBLL.getInstance().createExportInvoice(exportInvoice) == false) {
    				JOptionPane.showMessageDialog(rootPane, "Lỗi khi thêm vào database phiếu xuất");
    				errorEI = false;
    			}
				
				// Tạo chi tiết phiếu xuất mới vào database
				for (Product product : selectedProducts) {
					int productPrice = product.getDiscountPrice() == 0 ? product.getSellPrice() : product.getDiscountPrice();
					ExportInvoiceDetail exportInvoiceDetail = new ExportInvoiceDetail(next_id_detail, next_id, product.getId(), 
							productPrice);
	    			if (ExportInvoiceBLL.getInstance().createExportInvoiceDetail(exportInvoiceDetail) == false) {
	    				JOptionPane.showMessageDialog(getContentPane(), "Lỗi khi thêm vào database chi tiết phiếu xuất");
	    				errorEID = false;
	    			}
					if (maxIdDetail == -1) {
						JOptionPane.showMessageDialog(rootPane, "Lỗi khi lấy mã chi tiết phiếu nhập mới nhất");
						errorEID = false;
					}
					else if(maxIdDetail > -1) {
						maxIdDetail = ExportInvoiceBLL.getInstance().getNextIdDetail();
						next_id_detail = (maxIdDetail == 0) ? 1 : maxIdDetail+1;
					}
				}
    			if (errorEI && errorEID){
    				for (Product product : selectedProducts) {
    					if (ProductBLL.decreaseQuantity(product.getId()) == false) {
    						JOptionPane.showMessageDialog(getRootPane(), "Thực hiện giảm số lượng sản phẩm trên db thất bại");
    					}
    				}
    				
    				model = (DefaultTableModel) table.getModel();
        			JOptionPane.showMessageDialog(getRootPane(), "Thanh toán thành công");
        			
        			//Đảo ngược mảng để thuận tiện cho việc xóa row
        			for (int i = 0; i < selectedRows.length / 2; i++) {
        			    int temp = selectedRows[i];
        			    selectedRows[i] = selectedRows[selectedRows.length - 1 - i];
        			    selectedRows[selectedRows.length - 1 - i] = temp;
        			}
        			
        			for (int i : selectedRows) {
        				model.removeRow(i);
        			}
    			}
			}
		}
		((TmpHomePanel) ConfigPRJ.menu.get("HOME")).reloadPanel();
		((LichSuMuaHangGUI) ConfigPRJ.menu.get("HISTORY")).refresh();
	}

	private void discardBtnActionPerformed(){
		this.dispose();
	}
	
	
	private void reloadTableWithShoppingCart() {
		products = zShoppingCartFrame.getShoppingCart();
		model = (DefaultTableModel) table.getModel();
		model.setRowCount(0);
		for (Product product : products) {
			int productPrice = product.getDiscountPrice() == 0 ? product.getSellPrice() : product.getDiscountPrice();
			Object[] data = {
				product.getProductName(),
				productPrice
			};
			model.addRow(data);
		}
	}
	
	private void reloadTableWithOneProduct(int selectedIdProduct, int quantity){
		products = null;
		products = new ArrayList<>();
		for(int i = 0; i < quantity; i++)
			products.add(ProductBLL.getById(selectedIdProduct));
		model = (DefaultTableModel) table.getModel();
		model.setRowCount(0);
		int productPrice = products.get(0).getDiscountPrice() == 0 ? products.get(0).getSellPrice() : products.get(0).getDiscountPrice();
		Object[] data = {
				products.get(0).getProductName(),
				productPrice
			};
		for (int i = 0; i < quantity; i++) {
			model.addRow(data);
		}
	}
	
	private void addStuff(int []selectedRows) {
		for(int i : selectedRows) {
			selectedProducts.add(ProductBLL.getById(products.get(i).getId()));
		}
	}
}
