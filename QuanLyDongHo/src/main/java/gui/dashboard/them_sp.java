/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package gui.dashboard;

import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class them_sp extends javax.swing.JFrame {

    /**
     * Creates new form them_sp
     */
    public them_sp() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel11 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel17 = new javax.swing.JPanel();
        buttonShowIllustrationImg = new javax.swing.JButton();
        jPanel18 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        textFieldProductname = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        comboBoxOrigin = new javax.swing.JComboBox<>();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        comboBoxWaterProof = new javax.swing.JComboBox<>();
        jPanel7 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        textFieldBatteryCap = new javax.swing.JTextField();
        jPanel8 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        textFieldColor = new javax.swing.JTextField();
        jPanel9 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        comboBoxCategory = new javax.swing.JComboBox<>();
        jPanel10 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        textFieldWeight = new javax.swing.JTextField();
        jPanel13 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        textFieldWarranty = new javax.swing.JTextField();
        jPanel14 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        comboBoxScreenType = new javax.swing.JComboBox<>();
        jPanel6 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(22, 122, 198));

        jLabel10.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Thêm sản phẩm mới");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, 769, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_START);

        jPanel2.setLayout(new java.awt.BorderLayout());

        jPanel17.setPreferredSize(new java.awt.Dimension(275, 332));

        buttonShowIllustrationImg.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        buttonShowIllustrationImg.setText("Hình minh họa");
        buttonShowIllustrationImg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonShowIllustrationImgActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addComponent(buttonShowIllustrationImg, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(69, Short.MAX_VALUE))
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(buttonShowIllustrationImg)
                .addContainerGap(367, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel17, java.awt.BorderLayout.LINE_START);

        jPanel18.setLayout(new java.awt.BorderLayout());

        jPanel5.setPreferredSize(new java.awt.Dimension(494, 350));
        jPanel5.setLayout(new java.awt.GridLayout(3, 3));

        jPanel12.setLayout(new java.awt.GridLayout(2, 1));

        jLabel1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel1.setText("Tên sản phẩm");
        jPanel12.add(jLabel1);
        jPanel12.add(textFieldProductname);

        jPanel5.add(jPanel12);

        jPanel3.setLayout(new java.awt.GridLayout(2, 1));

        jLabel2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel2.setText("Xuất xứ");
        jPanel3.add(jLabel2);

        comboBoxOrigin.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        comboBoxOrigin.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", "Việt Nam", "Trung Quốc", "Mỹ", "Thái Lan", "Đài Loan", "Đức" }));
        jPanel3.add(comboBoxOrigin);

        jPanel5.add(jPanel3);

        jPanel4.setLayout(new java.awt.GridLayout(2, 1));

        jLabel3.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel3.setText("Chống nước");
        jPanel4.add(jLabel3);

        comboBoxWaterProof.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        comboBoxWaterProof.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", "Có", "Không" }));
        jPanel4.add(comboBoxWaterProof);

        jPanel5.add(jPanel4);

        jPanel7.setLayout(new java.awt.GridLayout(2, 1));

        jLabel4.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel4.setText("Dung lượng pin");
        jPanel7.add(jLabel4);
        jPanel7.add(textFieldBatteryCap);

        jPanel5.add(jPanel7);

        jPanel8.setLayout(new java.awt.GridLayout(2, 1));

        jLabel5.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel5.setText("Màu sắc");
        jPanel8.add(jLabel5);
        jPanel8.add(textFieldColor);

        jPanel5.add(jPanel8);

        jPanel9.setLayout(new java.awt.GridLayout(2, 1));

        jLabel6.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel6.setText("Phân loại");
        jPanel9.add(jLabel6);

        comboBoxCategory.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        comboBoxCategory.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", "Đồng hồ cơ", "Đồng hồ thông minh", "Đồng hồ điện tử" }));
        jPanel9.add(comboBoxCategory);

        jPanel5.add(jPanel9);

        jPanel10.setLayout(new java.awt.GridLayout(2, 1));

        jLabel7.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel7.setText("Trọng lượng");
        jPanel10.add(jLabel7);
        jPanel10.add(textFieldWeight);

        jPanel5.add(jPanel10);

        jPanel13.setLayout(new java.awt.GridLayout(2, 1));

        jLabel8.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel8.setText("Bảo hành");
        jPanel13.add(jLabel8);
        jPanel13.add(textFieldWarranty);

        jPanel5.add(jPanel13);

        jPanel14.setLayout(new java.awt.GridLayout(2, 1));

        jLabel9.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel9.setText("Dạng màn hình");
        jPanel14.add(jLabel9);

        comboBoxScreenType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", "LCD", "AMOLED", "Màn hình cảm ứng" }));
        jPanel14.add(comboBoxScreenType);

        jPanel5.add(jPanel14);

        jPanel18.add(jPanel5, java.awt.BorderLayout.PAGE_START);

        jPanel6.setLayout(new java.awt.GridBagLayout());

        jButton2.setBackground(new java.awt.Color(56, 159, 214));
        jButton2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Tạo cấu hình");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.ipadx = 16;
        gridBagConstraints.ipady = 15;
        gridBagConstraints.insets = new java.awt.Insets(7, 9, 7, 9);
        jPanel6.add(jButton2, gridBagConstraints);

        jButton3.setBackground(new java.awt.Color(219, 88, 96));
        jButton3.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Hủy bỏ");
        jButton3.setPreferredSize(new java.awt.Dimension(97, 23));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.ipadx = 41;
        gridBagConstraints.ipady = 13;
        gridBagConstraints.insets = new java.awt.Insets(6, 10, 6, 10);
        jPanel6.add(jButton3, gridBagConstraints);

        jPanel18.add(jPanel6, java.awt.BorderLayout.CENTER);

        jPanel2.add(jPanel18, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        textFieldBatteryCap.setText("");
        textFieldColor.setText("");
        textFieldProductname.setText("");
        textFieldWarranty.setText("");
        textFieldWeight.setText("");
        comboBoxCategory.setSelectedIndex(0);
        comboBoxWaterProof.setSelectedIndex(0);
        comboBoxOrigin.setSelectedIndex(0);
        comboBoxScreenType.setSelectedIndex(0);
        JOptionPane.showMessageDialog(rootPane, "Thêm cấu hình thành công");
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void buttonShowIllustrationImgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonShowIllustrationImgActionPerformed
        JOptionPane.showMessageDialog(rootPane, "Hiển thị ảnh");
    }//GEN-LAST:event_buttonShowIllustrationImgActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(them_sp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(them_sp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(them_sp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(them_sp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new them_sp().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonShowIllustrationImg;
    private javax.swing.JComboBox<String> comboBoxCategory;
    private javax.swing.JComboBox<String> comboBoxOrigin;
    private javax.swing.JComboBox<String> comboBoxScreenType;
    private javax.swing.JComboBox<String> comboBoxWaterProof;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JTextField textFieldBatteryCap;
    private javax.swing.JTextField textFieldColor;
    private javax.swing.JTextField textFieldProductname;
    private javax.swing.JTextField textFieldWarranty;
    private javax.swing.JTextField textFieldWeight;
    // End of variables declaration//GEN-END:variables
}
