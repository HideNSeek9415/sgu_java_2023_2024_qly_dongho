package gui.dashboard;
import java.awt.Dimension;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Font;
import javax.swing.border.EmptyBorder;
import javax.swing.SwingConstants;

public class ThemNhaCungCap extends javax.swing.JPanel {

    public ThemNhaCungCap() {
    	setPreferredSize(new Dimension(761, 318));
        initComponents();
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
        btnNCC.setBorder(new EmptyBorder(10, 0, 5, 0));
        pnlThem = new javax.swing.JPanel();
        btnThem = new javax.swing.JButton();
        pnlHuy = new javax.swing.JPanel();
        btnHuy = new javax.swing.JButton();

        setLayout(new java.awt.BorderLayout());

        titlePanel.setBackground(new java.awt.Color(51, 0, 51));
        titlePanel.setForeground(new java.awt.Color(255, 255, 255));

        txtNCC.setFont(new Font("Segoe UI", Font.BOLD, 24)); // NOI18N
        txtNCC.setForeground(new java.awt.Color(255, 255, 255));
        txtNCC.setText("THÊM NHÀ CUNG CẤP");

        add(titlePanel, java.awt.BorderLayout.PAGE_START);
        titlePanel.setLayout(new GridLayout(0, 1, 0, 0));
        titlePanel.add(txtNCC);

        mainPanel.setBackground(new java.awt.Color(255, 255, 255));
        mainPanel.setLayout(new java.awt.GridLayout(2, 2, 20, 0));

        pnlTen.setBackground(new java.awt.Color(255, 255, 255));

        nhapTenNCC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nhapTenNCCActionPerformed(evt);
            }
        });

        txtTenNCC.setFont(new Font("Segoe UI", Font.BOLD, 14)); // NOI18N
        txtTenNCC.setText("Tên Nhà Cung Cấp");

        mainPanel.add(pnlTen);
        pnlTen.setLayout(new GridLayout(2, 1, 0, 0));
        pnlTen.add(txtTenNCC);
        pnlTen.add(nhapTenNCC);

        pnlDiaChi.setBackground(new java.awt.Color(255, 255, 255));

        nhapDiaChi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nhapDiaChiActionPerformed(evt);
            }
        });

        txtDiaChi.setFont(new Font("Segoe UI", Font.BOLD, 14)); // NOI18N
        txtDiaChi.setText("Địa Chỉ");

        mainPanel.add(pnlDiaChi);
        pnlDiaChi.setLayout(new GridLayout(2, 1, 0, 0));
        pnlDiaChi.add(txtDiaChi);
        pnlDiaChi.add(nhapDiaChi);

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
        pnlEmail.setLayout(new GridLayout(2, 1, 0, 0));
        pnlEmail.add(txtEmail);
        pnlEmail.add(nhapEmail);

        pnlSDT.setBackground(new java.awt.Color(255, 255, 255));

        txtSDT.setFont(new Font("Segoe UI", Font.BOLD, 14)); // NOI18N
        txtSDT.setText("Số Điện Thoại");

        nhapSDT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nhapSDTActionPerformed(evt);
            }
        });

        mainPanel.add(pnlSDT);
        pnlSDT.setLayout(new GridLayout(2, 1, 0, 0));
        pnlSDT.add(txtSDT);
        pnlSDT.add(nhapSDT);

        add(mainPanel, java.awt.BorderLayout.CENTER);

        btnNCC.setBackground(new java.awt.Color(255, 255, 255));

        pnlThem.setPreferredSize(new java.awt.Dimension(230, 45));
        pnlThem.setLayout(new java.awt.BorderLayout());

        btnThem.setBackground(new Color(0, 128, 0));
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
