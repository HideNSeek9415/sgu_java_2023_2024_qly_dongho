package gui.dashboard;

import java.awt.Dimension;
import java.awt.Color;
import java.awt.Font;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.JFrame;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class ThemPhieuNhap extends javax.swing.JFrame {
    
    public ThemPhieuNhap() {
    	getContentPane().setBackground(new Color(240, 247, 250));
        initComponents();
        addEvent();
    }

    private void addEvent() {
		// TODO Auto-generated method stub
    	btnThemSP.addActionListener(e -> {
    		JFrame fr = new ThemSPGUI();
    		fr.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    		fr.setLocationRelativeTo(null);
    		fr.setVisible(true);
    	});
	}

	@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        phieuNhap = new javax.swing.JPanel();
        phieuNhap.setBackground(new Color(240, 247, 250));
        spPhieuNhap = new javax.swing.JScrollPane();
        tblSpPN = new javax.swing.JTable();
        timKiem = new javax.swing.JTextField();
        spDaCo = new javax.swing.JScrollPane();
        tblSpDC = new javax.swing.JTable();
        nhapGiaNhap = new javax.swing.JTextField();
        nhapMaSP = new javax.swing.JTextField();
        sideBarPN = new javax.swing.JPanel();
        sideBarPN.setOpaque(false);
        maPhieuNhap = new javax.swing.JTextField();
        tenNhanVien = new javax.swing.JTextField();
        tongTien = new javax.swing.JLabel();
        tongTien.setFont(new Font("SansSerif", Font.BOLD, 15));
        nhapHang = new javax.swing.JButton();
        nhapHang.setFont(new Font("SansSerif", Font.BOLD, 12));
        txtMaPN = new javax.swing.JLabel();
        txtMaPN.setFont(new Font("SansSerif", Font.BOLD, 12));
        txtNV = new javax.swing.JLabel();
        txtNV.setFont(new Font("SansSerif", Font.BOLD, 12));
        txtNCC = new javax.swing.JLabel();
        txtNCC.setFont(new Font("SansSerif", Font.BOLD, 12));
        chonNhaCC = new javax.swing.JComboBox<>();
        chonSanPham = new javax.swing.JComboBox<>();
        tenSanPham = new javax.swing.JTextField();
        phuongThucNhap = new javax.swing.JComboBox<>();
        txtareaGhiChu = new javax.swing.JScrollPane();
        ghiChu = new javax.swing.JTextArea();
        nhapMaSp = new javax.swing.JLabel();
        nhapMaSp.setFont(new Font("SansSerif", Font.BOLD, 12));
        txtTenSP = new javax.swing.JLabel();
        txtTenSP.setFont(new Font("SansSerif", Font.BOLD, 12));
        txtCauHinh = new javax.swing.JLabel();
        txtCauHinh.setFont(new Font("SansSerif", Font.BOLD, 12));
        txtGiaNhap = new javax.swing.JLabel();
        txtGiaNhap.setFont(new Font("SansSerif", Font.BOLD, 12));
        txtPTNhap = new javax.swing.JLabel();
        txtPTNhap.setFont(new Font("SansSerif", Font.BOLD, 12));
        txtGhiChu = new javax.swing.JLabel();
        txtGhiChu.setFont(new Font("SansSerif", Font.BOLD, 12));
        btnThemSP = new javax.swing.JButton();
        btnThemSP.setForeground(new Color(255, 255, 255));
        btnThemSP.setBackground(new Color(0, 128, 0));
        btnThemSP.setFont(new Font("Tahoma", Font.BOLD, 13));
        btnHuySp = new javax.swing.JButton();
        btnHuySp.setForeground(new Color(255, 255, 255));
        btnHuySp.setBackground(new Color(159, 124, 17));
        btnHuySp.setFont(new Font("Tahoma", Font.BOLD, 13));
        btnSuaSP = new javax.swing.JButton();
        btnSuaSP.setForeground(new Color(255, 255, 255));
        btnSuaSP.setBackground(new Color(0, 64, 128));
        btnSuaSP.setFont(new Font("Tahoma", Font.BOLD, 13));
        btnXoaSP = new javax.swing.JButton();
        btnXoaSP.setForeground(new Color(255, 255, 255));
        btnXoaSP.setBackground(new Color(172, 21, 21));
        btnXoaSP.setFont(new Font("Tahoma", Font.BOLD, 13));
        txtSL = new javax.swing.JLabel();
        txtSL.setFont(new Font("SansSerif", Font.BOLD, 12));
        SL = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(new java.awt.Dimension(1100, 600));

        phieuNhap.setPreferredSize(new java.awt.Dimension(1100, 600));

        tblSpPN.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Mã Sản Phẩm", "Tên Sản Phẩm", "Ram", "Rom", "Màu Sắc", "Đơn Giá", "Số Lượng"
            }
        ));
        spPhieuNhap.setViewportView(tblSpPN);

        tblSpDC.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Mã Sản Phẩm", "Tên Sản Phẩm"
            }
        ));
        spDaCo.setViewportView(tblSpDC);

        nhapMaSP.setEnabled(false);

        sideBarPN.setBackground(new java.awt.Color(255, 255, 255));

        maPhieuNhap.setEnabled(false);

        tenNhanVien.setEnabled(false);

        tongTien.setText("TỔNG TIỀN:");

        nhapHang.setText("Nhập Hàng");

        txtMaPN.setText("Mã Phiếu Nhập");

        txtNV.setText("Nhân Viên Nhập");

        txtNCC.setText("Nhà Cung Cấp");

        chonNhaCC.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Chọn nhà cung cấp", " " }));
        chonNhaCC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chonNhaCCActionPerformed(evt);
            }
        });
        
        lblGiaTriTongTien = new JLabel("12,350,000 vnđ");
        lblGiaTriTongTien.setHorizontalAlignment(SwingConstants.RIGHT);
        lblGiaTriTongTien.setHorizontalTextPosition(SwingConstants.CENTER);
        lblGiaTriTongTien.setForeground(new Color(255, 0, 0));
        lblGiaTriTongTien.setFont(new Font("SansSerif", Font.BOLD, 17));

        javax.swing.GroupLayout sideBarPNLayout = new javax.swing.GroupLayout(sideBarPN);
        sideBarPNLayout.setHorizontalGroup(
        	sideBarPNLayout.createParallelGroup(Alignment.TRAILING)
        		.addGroup(sideBarPNLayout.createSequentialGroup()
        			.addGap(15)
        			.addGroup(sideBarPNLayout.createParallelGroup(Alignment.TRAILING)
        				.addGroup(Alignment.LEADING, sideBarPNLayout.createSequentialGroup()
        					.addComponent(tongTien, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(lblGiaTriTongTien, GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE))
        				.addComponent(nhapHang, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        				.addComponent(maPhieuNhap, GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE)
        				.addComponent(tenNhanVien, GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE)
        				.addComponent(txtMaPN, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
        				.addComponent(txtNV, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE)
        				.addComponent(txtNCC, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
        				.addComponent(chonNhaCC, Alignment.LEADING, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        			.addContainerGap())
        );
        sideBarPNLayout.setVerticalGroup(
        	sideBarPNLayout.createParallelGroup(Alignment.LEADING)
        		.addGroup(sideBarPNLayout.createSequentialGroup()
        			.addGap(12)
        			.addComponent(txtMaPN)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(maPhieuNhap, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
        			.addGap(15)
        			.addComponent(txtNV)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(tenNhanVien, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
        			.addGap(18)
        			.addComponent(txtNCC)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(chonNhaCC, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED, 272, Short.MAX_VALUE)
        			.addGroup(sideBarPNLayout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(lblGiaTriTongTien, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
        				.addComponent(tongTien))
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(nhapHang, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
        			.addGap(13))
        );
        sideBarPN.setLayout(sideBarPNLayout);

        chonSanPham.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Chọn Sản Phẩm" }));
        chonSanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chonSanPhamActionPerformed(evt);
            }
        });

        tenSanPham.setEnabled(false);

        phuongThucNhap.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nhập theo lô", "Nhập theo máy" }));

        ghiChu.setColumns(20);
        ghiChu.setRows(5);
        txtareaGhiChu.setViewportView(ghiChu);

        nhapMaSp.setText("Mã Sản Phẩm");

        txtTenSP.setText("Tên Sản Phẩm");

        txtCauHinh.setText("Cấu Hình");

        txtGiaNhap.setText("Giá Nhập");

        txtPTNhap.setText("Phương Thức Nhập");

        txtGhiChu.setText("Ghi chú");

        btnThemSP.setText("Thêm Sản Phẩm");

        btnHuySp.setText("Hủy Bỏ");

        btnSuaSP.setText("Sửa Sản Phẩm");

        btnXoaSP.setText("Xóa Sản Phẩm");

        txtSL.setText("Số Lượng");

        javax.swing.GroupLayout phieuNhapLayout = new javax.swing.GroupLayout(phieuNhap);
        phieuNhapLayout.setHorizontalGroup(
        	phieuNhapLayout.createParallelGroup(Alignment.LEADING)
        		.addGroup(phieuNhapLayout.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(phieuNhapLayout.createParallelGroup(Alignment.LEADING)
        				.addGroup(phieuNhapLayout.createSequentialGroup()
        					.addGroup(phieuNhapLayout.createParallelGroup(Alignment.LEADING)
        						.addGroup(phieuNhapLayout.createSequentialGroup()
        							.addGroup(phieuNhapLayout.createParallelGroup(Alignment.LEADING, false)
        								.addComponent(spDaCo, GroupLayout.DEFAULT_SIZE, 438, Short.MAX_VALUE)
        								.addComponent(timKiem))
        							.addGap(12)
        							.addGroup(phieuNhapLayout.createParallelGroup(Alignment.TRAILING)
        								.addGroup(phieuNhapLayout.createSequentialGroup()
        									.addGroup(phieuNhapLayout.createParallelGroup(Alignment.LEADING)
        										.addComponent(nhapMaSp, GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE)
        										.addComponent(nhapMaSP, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE))
        									.addGap(18)
        									.addGroup(phieuNhapLayout.createParallelGroup(Alignment.LEADING)
        										.addComponent(tenSanPham, GroupLayout.PREFERRED_SIZE, 246, GroupLayout.PREFERRED_SIZE)
        										.addComponent(txtTenSP, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)))
        								.addGroup(phieuNhapLayout.createSequentialGroup()
        									.addGroup(phieuNhapLayout.createParallelGroup(Alignment.TRAILING)
        										.addGroup(phieuNhapLayout.createSequentialGroup()
        											.addComponent(txtCauHinh, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
        											.addGap(72))
        										.addGroup(phieuNhapLayout.createSequentialGroup()
        											.addComponent(chonSanPham, 0, 131, Short.MAX_VALUE)
        											.addGap(18)))
        									.addGroup(phieuNhapLayout.createParallelGroup(Alignment.LEADING)
        										.addComponent(nhapGiaNhap, 207, 207, 207)
        										.addComponent(txtGiaNhap, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)))
        								.addGroup(phieuNhapLayout.createSequentialGroup()
        									.addComponent(txtGhiChu, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
        									.addGap(0, 274, Short.MAX_VALUE))
        								.addGroup(phieuNhapLayout.createSequentialGroup()
        									.addGroup(phieuNhapLayout.createParallelGroup(Alignment.LEADING)
        										.addGroup(phieuNhapLayout.createSequentialGroup()
        											.addComponent(txtPTNhap, GroupLayout.PREFERRED_SIZE, 134, GroupLayout.PREFERRED_SIZE)
        											.addGap(0, 127, Short.MAX_VALUE))
        										.addComponent(phuongThucNhap, 0, 261, Short.MAX_VALUE))
        									.addGap(18)
        									.addGroup(phieuNhapLayout.createParallelGroup(Alignment.LEADING)
        										.addComponent(SL, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
        										.addComponent(txtSL, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)))
        								.addGroup(phieuNhapLayout.createSequentialGroup()
        									.addPreferredGap(ComponentPlacement.UNRELATED)
        									.addComponent(txtareaGhiChu, GroupLayout.DEFAULT_SIZE, 356, Short.MAX_VALUE))))
        						.addGroup(phieuNhapLayout.createSequentialGroup()
        							.addComponent(btnThemSP, GroupLayout.PREFERRED_SIZE, 191, GroupLayout.PREFERRED_SIZE)
        							.addGap(18)
        							.addComponent(btnHuySp, GroupLayout.PREFERRED_SIZE, 191, GroupLayout.PREFERRED_SIZE)
        							.addPreferredGap(ComponentPlacement.UNRELATED)
        							.addComponent(btnSuaSP, GroupLayout.PREFERRED_SIZE, 191, GroupLayout.PREFERRED_SIZE)
        							.addPreferredGap(ComponentPlacement.UNRELATED)
        							.addComponent(btnXoaSP, GroupLayout.PREFERRED_SIZE, 191, GroupLayout.PREFERRED_SIZE)
        							.addGap(0, 0, Short.MAX_VALUE)))
        					.addGap(18))
        				.addGroup(phieuNhapLayout.createSequentialGroup()
        					.addComponent(spPhieuNhap, GroupLayout.DEFAULT_SIZE, 806, Short.MAX_VALUE)
        					.addPreferredGap(ComponentPlacement.RELATED)))
        			.addComponent(sideBarPN, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap())
        );
        phieuNhapLayout.setVerticalGroup(
        	phieuNhapLayout.createParallelGroup(Alignment.LEADING)
        		.addGroup(phieuNhapLayout.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(phieuNhapLayout.createParallelGroup(Alignment.LEADING)
        				.addGroup(phieuNhapLayout.createSequentialGroup()
        					.addGroup(phieuNhapLayout.createParallelGroup(Alignment.TRAILING)
        						.addGroup(phieuNhapLayout.createSequentialGroup()
        							.addGroup(phieuNhapLayout.createParallelGroup(Alignment.BASELINE)
        								.addComponent(nhapMaSp)
        								.addComponent(txtTenSP))
        							.addGap(5)
        							.addGroup(phieuNhapLayout.createParallelGroup(Alignment.BASELINE)
        								.addComponent(nhapMaSP, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
        								.addComponent(tenSanPham, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
        							.addPreferredGap(ComponentPlacement.RELATED)
        							.addGroup(phieuNhapLayout.createParallelGroup(Alignment.LEADING)
        								.addComponent(txtGiaNhap)
        								.addComponent(txtCauHinh))
        							.addGap(4)
        							.addGroup(phieuNhapLayout.createParallelGroup(Alignment.BASELINE)
        								.addComponent(chonSanPham, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
        								.addComponent(nhapGiaNhap, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
        							.addPreferredGap(ComponentPlacement.RELATED)
        							.addGroup(phieuNhapLayout.createParallelGroup(Alignment.BASELINE)
        								.addComponent(txtPTNhap)
        								.addComponent(txtSL))
        							.addPreferredGap(ComponentPlacement.RELATED)
        							.addGroup(phieuNhapLayout.createParallelGroup(Alignment.LEADING)
        								.addComponent(phuongThucNhap, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
        								.addComponent(SL, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
        							.addPreferredGap(ComponentPlacement.RELATED)
        							.addComponent(txtGhiChu)
        							.addPreferredGap(ComponentPlacement.RELATED)
        							.addComponent(txtareaGhiChu, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE))
        						.addGroup(phieuNhapLayout.createSequentialGroup()
        							.addComponent(timKiem, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
        							.addPreferredGap(ComponentPlacement.RELATED)
        							.addComponent(spDaCo, GroupLayout.PREFERRED_SIZE, 236, GroupLayout.PREFERRED_SIZE)))
        					.addPreferredGap(ComponentPlacement.UNRELATED)
        					.addGroup(phieuNhapLayout.createParallelGroup(Alignment.BASELINE)
        						.addComponent(btnThemSP, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
        						.addComponent(btnHuySp, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
        						.addComponent(btnSuaSP, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
        						.addComponent(btnXoaSP, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
        					.addGap(18)
        					.addComponent(spPhieuNhap, GroupLayout.PREFERRED_SIZE, 230, GroupLayout.PREFERRED_SIZE))
        				.addComponent(sideBarPN, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        phieuNhap.setLayout(phieuNhapLayout);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(phieuNhap, javax.swing.GroupLayout.DEFAULT_SIZE, 1103, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(phieuNhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void chonSanPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chonSanPhamActionPerformed

    }//GEN-LAST:event_chonSanPhamActionPerformed

    private void chonNhaCCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chonNhaCCActionPerformed

    }//GEN-LAST:event_chonNhaCCActionPerformed
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField SL;
    private javax.swing.JButton btnHuySp;
    private javax.swing.JButton btnSuaSP;
    private javax.swing.JButton btnThemSP;
    private javax.swing.JButton btnXoaSP;
    private javax.swing.JComboBox<String> chonNhaCC;
    private javax.swing.JComboBox<String> chonSanPham;
    private javax.swing.JTextArea ghiChu;
    private javax.swing.JTextField maPhieuNhap;
    private javax.swing.JTextField nhapGiaNhap;
    private javax.swing.JButton nhapHang;
    private javax.swing.JTextField nhapMaSP;
    private javax.swing.JLabel nhapMaSp;
    private javax.swing.JPanel phieuNhap;
    private javax.swing.JComboBox<String> phuongThucNhap;
    private javax.swing.JPanel sideBarPN;
    private javax.swing.JScrollPane spDaCo;
    private javax.swing.JScrollPane spPhieuNhap;
    private javax.swing.JTable tblSpDC;
    private javax.swing.JTable tblSpPN;
    private javax.swing.JTextField tenNhanVien;
    private javax.swing.JTextField tenSanPham;
    private javax.swing.JTextField timKiem;
    private javax.swing.JLabel tongTien;
    private javax.swing.JLabel txtCauHinh;
    private javax.swing.JLabel txtGhiChu;
    private javax.swing.JLabel txtGiaNhap;
    private javax.swing.JLabel txtMaPN;
    private javax.swing.JLabel txtNCC;
    private javax.swing.JLabel txtNV;
    private javax.swing.JLabel txtPTNhap;
    private javax.swing.JLabel txtSL;
    private javax.swing.JLabel txtTenSP;
    private javax.swing.JScrollPane txtareaGhiChu;
    private JLabel lblGiaTriTongTien;
}
