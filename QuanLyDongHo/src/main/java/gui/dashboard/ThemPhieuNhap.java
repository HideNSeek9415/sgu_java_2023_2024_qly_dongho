
package com.mycompany.qldh;

import java.awt.Dimension;

public class ThemPhieuNhap extends javax.swing.JFrame {
    
    public ThemPhieuNhap() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        phieuNhap = new javax.swing.JPanel();
        spPhieuNhap = new javax.swing.JScrollPane();
        tblSpPN = new javax.swing.JTable();
        timKiem = new javax.swing.JTextField();
        spDaCo = new javax.swing.JScrollPane();
        tblSpDC = new javax.swing.JTable();
        nhapGiaNhap = new javax.swing.JTextField();
        nhapMaSP = new javax.swing.JTextField();
        sideBarPN = new javax.swing.JPanel();
        maPhieuNhap = new javax.swing.JTextField();
        tenNhanVien = new javax.swing.JTextField();
        tongTien = new javax.swing.JLabel();
        nhapHang = new javax.swing.JButton();
        txtMaPN = new javax.swing.JLabel();
        txtNV = new javax.swing.JLabel();
        txtNCC = new javax.swing.JLabel();
        chonNhaCC = new javax.swing.JComboBox<>();
        chonSanPham = new javax.swing.JComboBox<>();
        tenSanPham = new javax.swing.JTextField();
        phuongThucNhap = new javax.swing.JComboBox<>();
        txtareaGhiChu = new javax.swing.JScrollPane();
        ghiChu = new javax.swing.JTextArea();
        nhapMaSp = new javax.swing.JLabel();
        txtTenSP = new javax.swing.JLabel();
        txtCauHinh = new javax.swing.JLabel();
        txtGiaNhap = new javax.swing.JLabel();
        txtPTNhap = new javax.swing.JLabel();
        txtGhiChu = new javax.swing.JLabel();
        btnThemSP = new javax.swing.JButton();
        btnHuySp = new javax.swing.JButton();
        btnSuaSP = new javax.swing.JButton();
        btnXoaSP = new javax.swing.JButton();
        txtSL = new javax.swing.JLabel();
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

        javax.swing.GroupLayout sideBarPNLayout = new javax.swing.GroupLayout(sideBarPN);
        sideBarPN.setLayout(sideBarPNLayout);
        sideBarPNLayout.setHorizontalGroup(
            sideBarPNLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sideBarPNLayout.createSequentialGroup()
                .addGroup(sideBarPNLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(sideBarPNLayout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addComponent(tongTien, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 116, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, sideBarPNLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(sideBarPNLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(nhapHang, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(maPhieuNhap, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE)
                            .addComponent(tenNhanVien, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE)
                            .addComponent(txtMaPN, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNV, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNCC, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(chonNhaCC, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        sideBarPNLayout.setVerticalGroup(
            sideBarPNLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sideBarPNLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(txtMaPN)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(maPhieuNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(txtNV)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tenNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtNCC)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chonNhaCC, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 274, Short.MAX_VALUE)
                .addComponent(tongTien)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(nhapHang, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13))
        );

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
        phieuNhap.setLayout(phieuNhapLayout);
        phieuNhapLayout.setHorizontalGroup(
            phieuNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phieuNhapLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phieuNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(phieuNhapLayout.createSequentialGroup()
                        .addGroup(phieuNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(spDaCo, javax.swing.GroupLayout.DEFAULT_SIZE, 438, Short.MAX_VALUE)
                            .addComponent(timKiem))
                        .addGap(18, 18, 18)
                        .addGroup(phieuNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtareaGhiChu)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, phieuNhapLayout.createSequentialGroup()
                                .addGroup(phieuNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(nhapMaSP, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(nhapMaSp))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(phieuNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tenSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtTenSP, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(phieuNhapLayout.createSequentialGroup()
                                .addGroup(phieuNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(chonSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtCauHinh, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(phieuNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(nhapGiaNhap)
                                    .addGroup(phieuNhapLayout.createSequentialGroup()
                                        .addComponent(txtGiaNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))))
                            .addGroup(phieuNhapLayout.createSequentialGroup()
                                .addComponent(txtGhiChu, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(phieuNhapLayout.createSequentialGroup()
                                .addGroup(phieuNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(phieuNhapLayout.createSequentialGroup()
                                        .addComponent(txtPTNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(phuongThucNhap, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(phieuNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(SL, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtSL, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addComponent(spPhieuNhap)
                    .addGroup(phieuNhapLayout.createSequentialGroup()
                        .addComponent(btnThemSP, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnHuySp, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnSuaSP, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnXoaSP, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addComponent(sideBarPN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        phieuNhapLayout.setVerticalGroup(
            phieuNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phieuNhapLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phieuNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(phieuNhapLayout.createSequentialGroup()
                        .addGroup(phieuNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, phieuNhapLayout.createSequentialGroup()
                                .addGroup(phieuNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(nhapMaSp)
                                    .addComponent(txtTenSP))
                                .addGap(5, 5, 5)
                                .addGroup(phieuNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(nhapMaSP, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tenSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(phieuNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtGiaNhap)
                                    .addComponent(txtCauHinh))
                                .addGap(4, 4, 4)
                                .addGroup(phieuNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(chonSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(nhapGiaNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(phieuNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtPTNhap)
                                    .addComponent(txtSL))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(phieuNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(phuongThucNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(SL, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtGhiChu)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtareaGhiChu, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(phieuNhapLayout.createSequentialGroup()
                                .addComponent(timKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(spDaCo, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(phieuNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnThemSP, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnHuySp, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSuaSP, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnXoaSP, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(spPhieuNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(sideBarPN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(8, Short.MAX_VALUE))
        );

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
    // End of variables declaration//GEN-END:variables
}
