package gui.dashboard;
import java.awt.Dimension;


import javax.swing.GroupLayout.Alignment;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JRootPane;
import javax.swing.JTable;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Font;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import bll.SupplierBLL;
import dao.SupplierDAO;
import dto.Supplier;

import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;


public class ThemNhaCungCap extends javax.swing.JFrame {
	JTable table;
	
    public ThemNhaCungCap() {
    	setMinimumSize(new Dimension(716, 500));
    	setPreferredSize(new Dimension(761, 500));
        initComponents();
    }

    public JTable getTable() {
    	return table;
    }
    
    public void setTable(JTable table) {
    	this.table = table;
    }
    
    protected void reloadTable() {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.setRowCount(0);
		ArrayList<Supplier> datas = SupplierBLL.getInstance().readAllData();
		for (Supplier data: datas) {
			if(data.getSupplierStatus().equals("active")) {
				Object[] rowData = {data.getSupplierId(), data.getSupplierName(), data.getEmail(), data.getSupplierStatus(), data.getPhoneNumber()};
				model.addRow(rowData);
			}
		}
	}
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        titlePanel = new javax.swing.JPanel();
        titlePanel.setPreferredSize(new Dimension(10, 70));
        txtNCC = new javax.swing.JLabel();
        txtNCC.setOpaque(true);
        txtNCC.setBackground(new Color(22, 122, 198));
        txtNCC.setHorizontalAlignment(SwingConstants.CENTER);
        mainPanel = new javax.swing.JPanel();
        mainPanel.setBorder(new EmptyBorder(0, 20, 0, 20));
        pnlTen = new javax.swing.JPanel();
        pnlTen.setMinimumSize(new Dimension(10, 1000));
        pnlTen.setPreferredSize(new Dimension(0, 1000));
        nhapTenNCC = new javax.swing.JTextField();
        nhapTenNCC.setFont(new Font("Tahoma", Font.PLAIN, 10));
        nhapTenNCC.setPreferredSize(new Dimension(500, 1000));
        nhapTenNCC.setMinimumSize(new Dimension(500, 1000));
        txtTenNCC = new javax.swing.JLabel();
        txtTenNCC.setMinimumSize(new Dimension(500, 500));
        txtTenNCC.setPreferredSize(new Dimension(10, 10));
        pnlEmail = new javax.swing.JPanel();
        pnlEmail.setMinimumSize(new Dimension(10, 1000));
        pnlEmail.setPreferredSize(new Dimension(0, 1000));
        txtEmail = new javax.swing.JLabel();
        txtEmail.setMinimumSize(new Dimension(500, 500));
        txtEmail.setPreferredSize(new Dimension(10, 10));
        nhapEmail = new javax.swing.JTextField();
        nhapEmail.setFont(new Font("Tahoma", Font.PLAIN, 10));
        nhapEmail.setPreferredSize(new Dimension(500, 1000));
        nhapEmail.setMinimumSize(new Dimension(500, 1000));
        pnlSDT = new javax.swing.JPanel();
        pnlSDT.setMinimumSize(new Dimension(10, 1000));
        pnlSDT.setPreferredSize(new Dimension(0, 1000));
        txtSDT = new javax.swing.JLabel();
        txtSDT.setMinimumSize(new Dimension(500, 500));
        txtSDT.setPreferredSize(new Dimension(10, 10));
        nhapSDT = new javax.swing.JTextField();
        nhapSDT.setFont(new Font("Tahoma", Font.PLAIN, 10));
        nhapSDT.setPreferredSize(new Dimension(500, 1000));
        nhapSDT.setMinimumSize(new Dimension(500, 1000));
        btnNCC = new javax.swing.JPanel();
        btnNCC.setBorder(new EmptyBorder(10, 0, 5, 0));
        pnlThem = new javax.swing.JPanel();
        btnThem = new javax.swing.JButton();
        setTable(table);
        btnThem.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		supNameErrorMsg.setText("");
        		supPhoneErrorMsg.setText("");
        		supEmailErrorMsg.setText("");
        		
        		boolean emptyInput = false;
        		boolean checkValid = true;
        		if (nhapTenNCC.getText().equals("")) {
        			supNameErrorMsg.setText("Tên nhà cung cấp không được để trống");
        			emptyInput = true;
        		}
        		else if(SupplierBLL.getInstance().isDuplicate("supplier_name", nhapTenNCC.getText())) {
        			supNameErrorMsg.setText("Tên nhà cung cấp đã tồn tại");
        			checkValid=false;
        		}
        		
        		if (nhapEmail.getText().equals("")) {
        			supEmailErrorMsg.setText("Email không được để trống");
        			emptyInput = true;
        		}
        		else if(SupplierBLL.getInstance().isDuplicate("email", nhapEmail.getText())) {
        			supEmailErrorMsg.setText("Email đã tồn tại");
        			checkValid=false;
        		}
        		else if (!CheckValid.isValidEmail(nhapEmail.getText())) {
        			checkValid=false;
        			supEmailErrorMsg.setText("Vui lòng nhập đúng định dạng email");
        		}
        		
        		if (nhapSDT.getText().equals("")) {
        			supPhoneErrorMsg.setText("Số điện thoại không được để trống");
        			emptyInput = true;
        		}
        		else if(!CheckValid.isValidPhoneNumber(nhapSDT.getText())) {
        			checkValid=false;
        			supPhoneErrorMsg.setText("Số điện thoại phải đủ 10 chữ số");
        		}
        		else if(SupplierBLL.getInstance().isDuplicate("phone_number", nhapSDT.getText())) {
        			supPhoneErrorMsg.setText("Số điện thoại đã tồn tại");
        			checkValid=false;
        		}

        		if (!emptyInput && checkValid) {
        			int maxId = SupplierBLL.getInstance().getNextId();
        			int next_id;
        			if (maxId == -1) JOptionPane.showMessageDialog(rootPane, "Lỗi khi lấy nhà cung cấp mới nhất");
        			else {
        				next_id = (maxId == 0) ? 1 : maxId+1;  
        				Supplier sp = new Supplier(next_id, nhapTenNCC.getText(), nhapEmail.getText(), "active", nhapSDT.getText());
	        			//Thêm nhà cung cấp mới vào database
	        			if(SupplierBLL.getInstance().addSupplier(sp) == false)
	        				JOptionPane.showMessageDialog(rootPane, "Lỗi khi thêm vào database");
	        			else {
		        			reloadTable();
		        			JOptionPane.showMessageDialog(getRootPane(), "Thêm nhà cung cấp thành công");
	        			}
        			}
        			nhapTenNCC.setText("");
            		nhapEmail.setText("");
            		nhapSDT.setText("");
        		}
        		
        	}
        });
        pnlHuy = new javax.swing.JPanel();
        btnHuy = new javax.swing.JButton();

        getContentPane().setLayout(new java.awt.BorderLayout());

        titlePanel.setBackground(new java.awt.Color(51, 0, 51));
        titlePanel.setForeground(new java.awt.Color(255, 255, 255));

        txtNCC.setFont(new Font("Segoe UI", Font.BOLD, 24)); // NOI18N
        txtNCC.setForeground(new java.awt.Color(255, 255, 255));
        txtNCC.setText("THÊM NHÀ CUNG CẤP");

        getContentPane().add(titlePanel, java.awt.BorderLayout.PAGE_START);
        titlePanel.setLayout(new GridLayout(0, 1, 0, 0));
        titlePanel.add(txtNCC);

        mainPanel.setBackground(new java.awt.Color(255, 255, 255));
        mainPanel.setLayout(new java.awt.GridLayout(3, 1, 20, 0));

        pnlTen.setBackground(new java.awt.Color(255, 255, 255));

        nhapTenNCC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nhapTenNCCActionPerformed(evt);
            }
        });

        txtTenNCC.setFont(new Font("Segoe UI", Font.BOLD, 14)); // NOI18N
        txtTenNCC.setText("Tên Nhà Cung Cấp");

        mainPanel.add(pnlTen);
        pnlTen.setLayout(new GridLayout(3, 1, 0, 0));
        pnlTen.add(txtTenNCC);
        pnlTen.add(nhapTenNCC);
        
        supNameErrorMsg = new JLabel("");
        supNameErrorMsg.setMinimumSize(new Dimension(500, 500));
        supNameErrorMsg.setPreferredSize(new Dimension(10, 10));
        supNameErrorMsg.setForeground(Color.RED);
        supNameErrorMsg.setFont(new Font("Segoe UI", Font.BOLD, 14));
        pnlTen.add(supNameErrorMsg);

        pnlEmail.setBackground(new java.awt.Color(255, 255, 255));
        pnlEmail.setForeground(new java.awt.Color(255, 255, 255));

        txtEmail.setFont(new Font("Segoe UI", Font.BOLD, 14)); // NOI18N
        txtEmail.setText("Email");

        nhapEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nhapEmailActionPerformed(evt);
            }
        });

        mainPanel.add(pnlEmail);
        pnlEmail.setLayout(new GridLayout(3, 1, 0, 0));
        pnlEmail.add(txtEmail);
        pnlEmail.add(nhapEmail);
        
        supEmailErrorMsg = new JLabel("");
        supEmailErrorMsg.setMinimumSize(new Dimension(500, 500));
        supEmailErrorMsg.setPreferredSize(new Dimension(10, 10));
        supEmailErrorMsg.setForeground(Color.RED);
        supEmailErrorMsg.setFont(new Font("Segoe UI", Font.BOLD, 14));
        pnlEmail.add(supEmailErrorMsg);

        pnlSDT.setBackground(new java.awt.Color(255, 255, 255));

        txtSDT.setFont(new Font("Segoe UI", Font.BOLD, 14)); // NOI18N
        txtSDT.setText("Số Điện Thoại");

        nhapSDT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nhapSDTActionPerformed(evt);
            }
        });

        mainPanel.add(pnlSDT);
        pnlSDT.setLayout(new GridLayout(3, 1, 0, 0));
        pnlSDT.add(txtSDT);
        pnlSDT.add(nhapSDT);
        
        supPhoneErrorMsg = new JLabel("");
        supPhoneErrorMsg.setMinimumSize(new Dimension(500, 500));
        supPhoneErrorMsg.setPreferredSize(new Dimension(10, 10));
        supPhoneErrorMsg.setForeground(Color.RED);
        supPhoneErrorMsg.setFont(new Font("Segoe UI", Font.BOLD, 14));
        pnlSDT.add(supPhoneErrorMsg);

        getContentPane().add(mainPanel, java.awt.BorderLayout.CENTER);

        btnNCC.setBackground(new java.awt.Color(255, 255, 255));

        pnlThem.setPreferredSize(new java.awt.Dimension(230, 45));
        pnlThem.setLayout(new java.awt.BorderLayout());

        btnThem.setBackground(new Color(22, 122, 198));
        btnThem.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnThem.setText("THÊM ĐƠN VỊ");
        pnlThem.add(btnThem, java.awt.BorderLayout.CENTER);

        btnNCC.add(pnlThem);

        pnlHuy.setPreferredSize(new java.awt.Dimension(230, 45));
        pnlHuy.setLayout(new java.awt.BorderLayout());

        btnHuy.setBackground(new java.awt.Color(204, 0, 51));
        btnHuy.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnHuy.setForeground(new java.awt.Color(255, 255, 255));
        btnHuy.setText("HỦY BỎ");
        btnHuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuyActionPerformed(evt);
            }
        });
        pnlHuy.add(btnHuy, java.awt.BorderLayout.CENTER);

        btnNCC.add(pnlHuy);

        getContentPane().add(btnNCC, java.awt.BorderLayout.PAGE_END);
    }// </editor-fold>//GEN-END:initComponents

    private void nhapTenNCCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nhapTenNCCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nhapTenNCCActionPerformed

    private void nhapEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nhapEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nhapEmailActionPerformed

    private void nhapSDTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nhapSDTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nhapSDTActionPerformed

    private void btnHuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnHuyActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    protected javax.swing.JButton btnHuy;
    protected javax.swing.JPanel btnNCC;
    protected javax.swing.JButton btnThem;
    protected javax.swing.JPanel mainPanel;
    protected javax.swing.JTextField nhapEmail;
    protected javax.swing.JTextField nhapSDT;
    protected javax.swing.JTextField nhapTenNCC;
    protected javax.swing.JPanel pnlEmail;
    protected javax.swing.JPanel pnlHuy;
    protected javax.swing.JPanel pnlSDT;
    protected javax.swing.JPanel pnlTen;
    protected javax.swing.JPanel pnlThem;
    protected javax.swing.JPanel titlePanel;
    protected javax.swing.JLabel txtEmail;
    protected javax.swing.JLabel txtNCC;
    protected javax.swing.JLabel txtSDT;
    protected javax.swing.JLabel txtTenNCC;
    protected JLabel supNameErrorMsg;
    protected JLabel supEmailErrorMsg;
    protected JLabel supPhoneErrorMsg;
    // End of variables declaration//GEN-END:variables
}
