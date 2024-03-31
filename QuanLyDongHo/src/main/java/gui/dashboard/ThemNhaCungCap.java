package com.mycompany.qldh;

public class ThemNhaCungCap extends javax.swing.JPanel {

    public ThemNhaCungCap() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        titlePanel = new javax.swing.JPanel();
        txtNCC = new javax.swing.JLabel();
        mainPanel = new javax.swing.JPanel();
        pnlTen = new javax.swing.JPanel();
        nhapTenNCC = new javax.swing.JTextField();
        txtTenNCC = new javax.swing.JLabel();
        pnlDiaChi = new javax.swing.JPanel();
        nhapDiaChi = new javax.swing.JTextField();
        txtDiaChi = new javax.swing.JLabel();
        pnlEmail = new javax.swing.JPanel();
        txtEmail = new javax.swing.JLabel();
        nhapEmail = new javax.swing.JTextField();
        pnlSDT = new javax.swing.JPanel();
        txtSDT = new javax.swing.JLabel();
        nhapSDT = new javax.swing.JTextField();
        btnNCC = new javax.swing.JPanel();
        pnlThem = new javax.swing.JPanel();
        btnThem = new javax.swing.JButton();
        pnlHuy = new javax.swing.JPanel();
        btnHuy = new javax.swing.JButton();

        setLayout(new java.awt.BorderLayout());

        titlePanel.setBackground(new java.awt.Color(51, 0, 51));
        titlePanel.setForeground(new java.awt.Color(255, 255, 255));

        txtNCC.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        txtNCC.setForeground(new java.awt.Color(255, 255, 255));
        txtNCC.setText("THÊM NHÀ CUNG CẤP");

        javax.swing.GroupLayout titlePanelLayout = new javax.swing.GroupLayout(titlePanel);
        titlePanel.setLayout(titlePanelLayout);
        titlePanelLayout.setHorizontalGroup(
            titlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(titlePanelLayout.createSequentialGroup()
                .addGap(304, 304, 304)
                .addComponent(txtNCC)
                .addContainerGap(328, Short.MAX_VALUE))
        );
        titlePanelLayout.setVerticalGroup(
            titlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(titlePanelLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(txtNCC)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        add(titlePanel, java.awt.BorderLayout.PAGE_START);

        mainPanel.setBackground(new java.awt.Color(255, 255, 255));
        mainPanel.setLayout(new java.awt.GridLayout(2, 2, 20, 0));

        pnlTen.setBackground(new java.awt.Color(255, 255, 255));

        nhapTenNCC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nhapTenNCCActionPerformed(evt);
            }
        });

        txtTenNCC.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtTenNCC.setText("Tên Nhà Cung Cấp");

        javax.swing.GroupLayout pnlTenLayout = new javax.swing.GroupLayout(pnlTen);
        pnlTen.setLayout(pnlTenLayout);
        pnlTenLayout.setHorizontalGroup(
            pnlTenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTenLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(pnlTenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtTenNCC)
                    .addComponent(nhapTenNCC, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(51, Short.MAX_VALUE))
        );
        pnlTenLayout.setVerticalGroup(
            pnlTenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlTenLayout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addComponent(txtTenNCC)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(nhapTenNCC, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );

        mainPanel.add(pnlTen);

        pnlDiaChi.setBackground(new java.awt.Color(255, 255, 255));

        nhapDiaChi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nhapDiaChiActionPerformed(evt);
            }
        });

        txtDiaChi.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtDiaChi.setText("Địa Chỉ");

        javax.swing.GroupLayout pnlDiaChiLayout = new javax.swing.GroupLayout(pnlDiaChi);
        pnlDiaChi.setLayout(pnlDiaChiLayout);
        pnlDiaChiLayout.setHorizontalGroup(
            pnlDiaChiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDiaChiLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(pnlDiaChiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtDiaChi)
                    .addComponent(nhapDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(56, Short.MAX_VALUE))
        );
        pnlDiaChiLayout.setVerticalGroup(
            pnlDiaChiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDiaChiLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(txtDiaChi)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(nhapDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        mainPanel.add(pnlDiaChi);

        pnlEmail.setBackground(new java.awt.Color(255, 255, 255));
        pnlEmail.setForeground(new java.awt.Color(255, 255, 255));

        txtEmail.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtEmail.setText("Email");

        nhapEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nhapEmailActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlEmailLayout = new javax.swing.GroupLayout(pnlEmail);
        pnlEmail.setLayout(pnlEmailLayout);
        pnlEmailLayout.setHorizontalGroup(
            pnlEmailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlEmailLayout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(pnlEmailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtEmail)
                    .addComponent(nhapEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(49, Short.MAX_VALUE))
        );
        pnlEmailLayout.setVerticalGroup(
            pnlEmailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlEmailLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(txtEmail)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(nhapEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        mainPanel.add(pnlEmail);

        pnlSDT.setBackground(new java.awt.Color(255, 255, 255));

        txtSDT.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtSDT.setText("Số Điện Thoại");

        nhapSDT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nhapSDTActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlSDTLayout = new javax.swing.GroupLayout(pnlSDT);
        pnlSDT.setLayout(pnlSDTLayout);
        pnlSDTLayout.setHorizontalGroup(
            pnlSDTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSDTLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(pnlSDTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtSDT)
                    .addComponent(nhapSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(55, Short.MAX_VALUE))
        );
        pnlSDTLayout.setVerticalGroup(
            pnlSDTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSDTLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(txtSDT)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(nhapSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        mainPanel.add(pnlSDT);

        add(mainPanel, java.awt.BorderLayout.CENTER);

        btnNCC.setBackground(new java.awt.Color(255, 255, 255));

        pnlThem.setPreferredSize(new java.awt.Dimension(230, 45));
        pnlThem.setLayout(new java.awt.BorderLayout());

        btnThem.setBackground(new java.awt.Color(51, 204, 0));
        btnThem.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnThem.setForeground(new java.awt.Color(255, 255, 255));
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

        add(btnNCC, java.awt.BorderLayout.PAGE_END);
    }// </editor-fold>//GEN-END:initComponents

    private void nhapTenNCCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nhapTenNCCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nhapTenNCCActionPerformed

    private void nhapEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nhapEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nhapEmailActionPerformed

    private void nhapDiaChiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nhapDiaChiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nhapDiaChiActionPerformed

    private void nhapSDTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nhapSDTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nhapSDTActionPerformed

    private void btnHuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnHuyActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHuy;
    private javax.swing.JPanel btnNCC;
    private javax.swing.JButton btnThem;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JTextField nhapDiaChi;
    private javax.swing.JTextField nhapEmail;
    private javax.swing.JTextField nhapSDT;
    private javax.swing.JTextField nhapTenNCC;
    private javax.swing.JPanel pnlDiaChi;
    private javax.swing.JPanel pnlEmail;
    private javax.swing.JPanel pnlHuy;
    private javax.swing.JPanel pnlSDT;
    private javax.swing.JPanel pnlTen;
    private javax.swing.JPanel pnlThem;
    private javax.swing.JPanel titlePanel;
    private javax.swing.JLabel txtDiaChi;
    private javax.swing.JLabel txtEmail;
    private javax.swing.JLabel txtNCC;
    private javax.swing.JLabel txtSDT;
    private javax.swing.JLabel txtTenNCC;
    // End of variables declaration//GEN-END:variables
}
