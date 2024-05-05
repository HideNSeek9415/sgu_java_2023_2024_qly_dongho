package gui.dashboard;
import javax.swing.JFrame;

import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import dao.SupplierDAO;
import dto.Supplier;
import system.ExportManager;
import bll.SupplierBLL;

import java.awt.Font;
import java.awt.event.FocusListener;
import java.util.ArrayList;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import bll.SupplierBLL;
import dto.Supplier;

import java.awt.Font;
import java.util.ArrayList;

public class SuppliersGUI extends NewJPanel {

	private static final long serialVersionUID = 1L;
	private JScrollPane scrollPane;
	private JTable table;
	private DefaultTableModel model;

	/**
	 * Create the panel.
	 */
	public SuppliersGUI() {
		pnContent.setLayout(new BorderLayout(0, 0));
		
		comboBox.setVisible(false);
		String placeholderText = "Nhập tên nhà cung cấp";
		txtSearch.setText(placeholderText);
		
		scrollPane = new JScrollPane();
		pnContent.add(scrollPane);
		
		table = new JTable();
		table.setRowHeight(25);
		table.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"NCC01", "Trường ĐH Sài Gòn", "sgu@edu.com.vn", "0695912684"},
				{"NCC02", "CTTNHH MTV Bán Cái Đồng Hồ", "bdha@ko.ko", "0188923543"},
			},
			new String[] {
				"Mã NCC", "Tên nhà cung cấp", "E-mail", "Số điện thoại"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(15);
		table.getColumnModel().getColumn(0).setMinWidth(10);
		table.getColumnModel().getColumn(1).setPreferredWidth(220);
		table.getColumnModel().getColumn(2).setPreferredWidth(240);
		table.getColumnModel().getColumn(3).setPreferredWidth(100);
		scrollPane.setViewportView(table);
		designTitle();
		reloadTable();
		
		txtSearch.addFocusListener(new FocusListener() {
		    @Override
		    public void focusGained(FocusEvent e) {
		        if (txtSearch.getText().equals(placeholderText)) {
		        	table.clearSelection();
		            txtSearch.setText("");
		        }
		    }

		    @Override
		    public void focusLost(FocusEvent e) {

		    }
		});
		
		txtSearch.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                reloadTableAfterSearch();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
            	reloadTableAfterSearch();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
            	reloadTableAfterSearch();
            }
        });
		model = (DefaultTableModel) table.getModel();
		reloadTable();
		btnImport.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ExportManager.exportToExcel(table);
            }
        });
	}
	
	private void reloadTable() {
		ArrayList<Supplier> suppliers = SupplierBLL.getSupplierList();
		model = (DefaultTableModel) table.getModel();
		model.setRowCount(0);
		for (Supplier supplier : suppliers) {
			Object[] data = {
				supplier.getSupplierId(),
				supplier.getSupplierName(),
				supplier.getEmail(),
				supplier.getPhoneNumber()
			};
			model.addRow(data);
		}
	}

	private void designTitle() {
		// TODO Auto-generated method stub
		table.getTableHeader().setBackground(Color.decode("#f4c82d"));
		table.getTableHeader().setFont(table.getFont());
		
	}
	
	@Override
	protected void setAddEvent() {
		// TODO Auto-generated method stub
		JFrame fr = new ThemNhaCungCap();
		fr.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		fr.setSize(761, 500);
		((ThemNhaCungCap)fr).setTable(table);
		fr.setLocationRelativeTo(null);
		fr.setVisible(true);
	}
	
	@Override
	protected void setEditEvent() {
		if (table.getSelectedRows().length == 1 ) {
			JFrame fr = new SuaNhaCungCap(getTable());
			fr.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			fr.setSize(761, 500);
			fr.setLocationRelativeTo(null);
			fr.setVisible(true);
		}
		else
			JOptionPane.showMessageDialog(getRootPane(), "Vui lòng chọn 1 nhà cung cấp để sửa");
	}
	
	@Override
	protected void setDelEvent() {
		int [] selectedRows = table.getSelectedRows();
		if(selectedRows.length == 0) JOptionPane.showMessageDialog(getRootPane(), "Vui lòng chọn ít nhất 1 nhà cung cấp");
		else {
			for(int i:selectedRows) {
				int idSupplier = Integer.parseInt(table.getValueAt(i, 0).toString());
				if(SupplierBLL.getInstance().deleteSupplier(idSupplier) == false)
					JOptionPane.showMessageDialog(getRootPane(), "Xóa nhà cung cấp thất bại với mã nhà cung cấp: " + (i+1));
				else {
					JOptionPane.showMessageDialog(getRootPane(), "Xóa nhà cung cấp thành công");
					reloadTable();
				}
			}
		}
	}
	
	@Override
	protected void setDetailEvent() {
		int Sid = (Integer) table.getValueAt(table.getSelectedRow(), 0);
		SupplierDetails.selectedSupplier = SupplierBLL.getByID(Sid);
		JFrame fr = new SupplierDetails();
		fr.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		fr.setLocationRelativeTo(null);
		fr.setVisible(true);
	}
	
	private boolean searchResult(String parentString) {
		String[] words = parentString.split("\\s+");
		String txtSearchString = txtSearch.getText().toLowerCase();
		for(String word:words) {
			if (word.length() >= txtSearchString.length()) { // Kiểm tra xem độ dài từ trong chuỗi có lớn hơn hoặc bằng từ khóa tìm kiếm không
	            boolean match = true;
	            for (int i = 0; i < txtSearchString.length(); i++) {
	                if (word.charAt(i) != txtSearchString.charAt(i)) {
	                    match = false;
	                    break;
	                }
	            }
	            if (match) {
	                return true;
	            }
	        }
		}
		return false;
	}
	
	protected void reloadTableAfterSearch() {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.setRowCount(0);
		ArrayList<Supplier> datas = SupplierBLL.getInstance().readAllData();
		for (Supplier data: datas) {
			if(searchResult(data.getSupplierName().toLowerCase()) && data.getSupplierStatus().equals("active")){
				Object[] rowData = {data.getSupplierId(), data.getSupplierName(), data.getEmail(), data.getSupplierStatus(), data.getPhoneNumber()};
				model.addRow(rowData);
			}
		}
	}

	protected JTable getTable() {
		return table;
	}
}
