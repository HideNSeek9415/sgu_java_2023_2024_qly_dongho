/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package gui.dashboard;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JTable;

import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.util.Random;
import java.util.stream.Collectors;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JFileChooser;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;

import java.awt.Font;
import javax.swing.border.EmptyBorder;

import dao.ProductDAO;
import dto.Product;
import system.ConfigPRJ;

import java.awt.Color;
import java.awt.GridBagConstraints;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.text.MaskFormatter;

import bll.ProductBLL;

import javax.swing.JFormattedTextField;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JToggleButton;
import java.awt.Cursor;

/**
 *
 * @author User
 */
public class ThemSPGUI extends javax.swing.JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8788851938238260823L;
	private JTable table;
	private Product prd;
	private Boolean imgChg = false;
	private String newImgPath = "";



    
    public ThemSPGUI(Product p) {
    	prd = p;
    	getContentPane().setBackground(new Color(240, 247, 250));
        initComponents();
        loadProductInfo();
    }

    private void loadProductInfo() {
		// TODO Auto-generated method stub
       
        txtSellPrice.setValue(prd.getSellPrice());
        txtDiscountPrice.setValue(prd.getDiscountPrice());
    	Image icon = new ImageIcon(getClass().getResource(prd.getImageUrl())).getImage();
    	icon = icon.getScaledInstance(lblImage.getWidth(), lblImage.getHeight(), Image.SCALE_SMOOTH);
    	lblImage.setText("");
    	lblImage.setIcon(new ImageIcon(icon));
    	lblId.setText(String.valueOf(prd.getId()));
    	txtName.setText(prd.getProductName());
    	cbbType.setSelectedItem(prd.getCategory());
    	cbbBrand.setSelectedItem(prd.getBrand());
    	cbbDiscount.setSelectedIndex(prd.isDiscount() ? 1 : 0);
    	lblQuantity.setText(String.valueOf(prd.getQuantity()));
    	lblStatus.setText(prd.getStatus());
    	
    	btnDR.setSelected(!prd.getProductStatus());
  		if (btnDR.isSelected()) {
			btnDR.setText("Đăng bán");
			btnDR.setBackground(Color.decode("#19727a"));
		} else {
			btnDR.setText("Tạm ngưng");
			btnDR.setBackground(Color.decode("#167ac6"));
		}
    	
    	btnDR.addActionListener(e -> {
    		if (btnDR.isSelected()) {
    			btnDR.setText("Đăng bán");
    			btnDR.setBackground(Color.decode("#19727a"));
    		} else {
    			btnDR.setText("Tạm ngưng");
    			btnDR.setBackground(Color.decode("#167ac6"));
    		}
    	});
    	
    	
    	btnUpdate.addActionListener(e -> {
    		prd.setProductName(txtName.getText());
    		prd.setCategory(cbbType.getSelectedItem().toString());
    		prd.setBrand(cbbBrand.getSelectedItem().toString());
    		prd.setSellPrice(((SpinnerNumberModel) txtSellPrice.getModel()).getNumber().intValue());
    		prd.setDiscountPrice(((SpinnerNumberModel) txtDiscountPrice.getModel()).getNumber().intValue());
    		prd.setDiscount(cbbDiscount.getSelectedIndex() == 0 ? false : true);
    		prd.setProductStatus(!btnDR.isSelected());
    		ProductBLL.updateProduct(prd);
    		if (imgChg) {
    			prd.setImageUrl(saveImg(newImgPath));
    		}
    		this.dispose();
    		((TmpHomePanel) ConfigPRJ.menu.get("HOME")).reloadPanel();
    		((ProductManagerGUI) ConfigPRJ.menu.get("PRODUCTS")).displayProducts();
    	});
    	
    	JFrame self = this;
    	lblImage.addMouseListener(new MouseAdapter() {
    		
    		JFrame fr = self;
    		
    	    public void mouseClicked(MouseEvent e) {
    	    	JFileChooser fileChooser = new JFileChooser();
    			fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);

    			int result = fileChooser.showOpenDialog(null);
    			if (result == JFileChooser.APPROVE_OPTION) {
    				imgChg = true;
    				newImgPath = fileChooser.getSelectedFile().getPath();
        	    	Image ic = new ImageIcon(newImgPath).getImage();
        	    	ic = ic.getScaledInstance(lblImage.getWidth(), lblImage.getHeight(), Image.SCALE_SMOOTH);
        	    	lblImage.setIcon(new ImageIcon(ic));
                }
    			fr.revalidate();
    			fr.repaint();
    	    }
    	});
	}
    
	private String saveImg(String path) {
		String imgPath = path;
		String newName = new Random().ints(15, 'a', 'z' + 1)
                .mapToObj(c -> String.valueOf((char) c))
                .collect(Collectors.joining()) + ".jpg";
        try {
        	Path source = Paths.get(imgPath);
        	String desP = getClass().getResource("/img/products").getPath().substring(1).replace('/', '\\');
        	String desP2 = desP.replace("target\\classes", "src\\main\\resources");
			Path destination = Paths.get(desP, newName);
			Path destination2 = Paths.get(desP2, newName);
			Files.copy(source, destination);
			Files.copy(source, destination2);
		} catch (Exception e) {
			e.printStackTrace();
		}
        return "/img/products/" + newName;
	}

	public JTable getTable() {
		return table;
	}


	public void setTable(JTable table) {
		this.table = table;
	}

    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel11 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel1.setPreferredSize(new Dimension(850, 75));
        jLabel10 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel2.setOpaque(false);
        jPanel17 = new javax.swing.JPanel();
        jPanel17.setBorder(new EmptyBorder(10, 10, 10, 10));
        jPanel17.setOpaque(false);
        lblImage = new JLabel();
        lblImage.setBorder(new LineBorder(new Color(143, 143, 143)));
        lblImage.setHorizontalAlignment(SwingConstants.CENTER);
        jPanel18 = new javax.swing.JPanel();
        jPanel18.setOpaque(false);
        jPanel18.setBorder(new EmptyBorder(0, 0, 0, 10));
        jPanel5 = new javax.swing.JPanel();
        jPanel5.setOpaque(false);
        jPanel12 = new javax.swing.JPanel();
        jPanel12.setOpaque(false);
        jPanel3 = new javax.swing.JPanel();
        jPanel3.setOpaque(false);
        jPanel4 = new javax.swing.JPanel();
        jPanel4.setOpaque(false);
        jPanel7 = new javax.swing.JPanel();
        jPanel7.setOpaque(false);
        jPanel8 = new javax.swing.JPanel();
        jPanel8.setOpaque(false);
        jPanel9 = new javax.swing.JPanel();
        jPanel9.setOpaque(false);
        jPanel10 = new javax.swing.JPanel();
        jPanel10.setOpaque(false);
        jPanel13 = new javax.swing.JPanel();
        jPanel13.setOpaque(false);
        jPanel14 = new javax.swing.JPanel();
        jPanel14.setOpaque(false);
        jLabel9 = new javax.swing.JLabel();
        lblStatus = new JLabel();
        lblStatus.setBackground(new Color(255, 255, 255));
        jPanel6 = new javax.swing.JPanel();
        jPanel6.setOpaque(false);
        btnUpdate = new javax.swing.JButton();
        btnUpdate.setPreferredSize(new Dimension(134, 25));
        btnUpdate.setBorderPainted(false);
        btnExit = new javax.swing.JButton();
        btnExit.setBorderPainted(false);

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

        jLabel10.setFont(new Font("Arial", Font.BOLD, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Thông tin sản phẩm");
        
        btnDR = new JToggleButton("Xóa");
        btnDR.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnDR.setFocusPainted(false);
        btnDR.setForeground(new Color(255, 255, 255));
        btnDR.setBackground(new Color(68, 152, 208));
        btnDR.setFont(new Font("Tahoma", Font.BOLD, 14));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1Layout.setHorizontalGroup(
        	jPanel1Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel1Layout.createSequentialGroup()
        			.addGap(40)
        			.addComponent(jLabel10, GroupLayout.PREFERRED_SIZE, 415, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED, 137, Short.MAX_VALUE)
        			.addComponent(btnDR, GroupLayout.PREFERRED_SIZE, 197, GroupLayout.PREFERRED_SIZE)
        			.addGap(61))
        );
        jPanel1Layout.setVerticalGroup(
        	jPanel1Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel1Layout.createSequentialGroup()
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(jPanel1Layout.createSequentialGroup()
        					.addContainerGap()
        					.addComponent(jLabel10, GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE))
        				.addGroup(jPanel1Layout.createSequentialGroup()
        					.addGap(18)
        					.addComponent(btnDR, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)))
        			.addContainerGap())
        );
        jPanel1.setLayout(jPanel1Layout);

        getContentPane().add(jPanel1, BorderLayout.NORTH);

        jPanel2.setLayout(new java.awt.BorderLayout());

        jPanel17.setPreferredSize(new Dimension(275, 120));

        lblImage.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblImage.setText("Hình minh họa");

        jPanel2.add(jPanel17, BorderLayout.WEST);
        jPanel17.setLayout(new GridLayout(0, 1, 0, 0));
        jPanel17.add(lblImage);

        jPanel18.setLayout(new java.awt.BorderLayout());

        jPanel5.setPreferredSize(new Dimension(494, 220));
        GridLayout gl_jPanel5 = new GridLayout(3, 3);
        gl_jPanel5.setHgap(10);
        jPanel5.setLayout(gl_jPanel5);

        jPanel12.setLayout(new java.awt.GridLayout(2, 1));
        jLabel8 = new javax.swing.JLabel();
        jPanel12.add(jLabel8);
        
        jLabel8.setFont(new Font("Arial", Font.BOLD, 14)); // NOI18N
        jLabel8.setText("Mã SP");

        jPanel5.add(jPanel12);
        lblId = new JLabel();
        jPanel12.add(lblId);
        jPanel3.setLayout(new GridLayout(0, 1, 0, 0));
        jLabel1 = new javax.swing.JLabel();
        jPanel3.add(jLabel1);
        
        jLabel1.setFont(new Font("Arial", Font.BOLD, 14)); // NOI18N
        jLabel1.setText("Tên sản phẩm");

        jPanel5.add(jPanel3);
        txtName = new javax.swing.JTextField();
        jPanel3.add(txtName);
        jPanel4.setLayout(new GridLayout(0, 1, 0, 0));
        jLabel6 = new javax.swing.JLabel();
        jPanel4.add(jLabel6);
        
        jLabel6.setFont(new Font("Arial", Font.BOLD, 14)); // NOI18N
        jLabel6.setText("Phân loại");
        cbbType = new javax.swing.JComboBox<>();
        jPanel4.add(cbbType);
        cbbType.setBackground(new Color(255, 255, 255));
        
        cbbType.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cbbType.setModel(new DefaultComboBoxModel(new String[] {"Đồng hồ cơ", "Đồng hồ thông minh", "Đồng hồ điện tử"}));

        jPanel5.add(jPanel4);
        jPanel7.setLayout(new GridLayout(0, 1, 0, 0));

        jPanel5.add(jPanel7);
        jLabel4 = new javax.swing.JLabel();
        jPanel7.add(jLabel4);
        
        jLabel4.setFont(new Font("Arial", Font.BOLD, 14)); // NOI18N
        jLabel4.setText("Thương hiệu");
        cbbBrand = new JComboBox();
        cbbBrand.setFont(new Font("Tahoma", Font.BOLD, 12));
        cbbBrand.setModel(new DefaultComboBoxModel(new String[] {"CASIO", "ORIENT", "APPLE", "CITIZEN"}));
        jPanel7.add(cbbBrand);
        jPanel8.setLayout(new GridLayout(0, 1, 0, 0));

        jPanel5.add(jPanel8);
        jLabel7 = new javax.swing.JLabel();
        jPanel8.add(jLabel7);
        
        jLabel7.setFont(new Font("Arial", Font.BOLD, 14)); // NOI18N
        jLabel7.setText("Giá bán");
		txtSellPrice = new JSpinner();
		txtSellPrice.setModel(new SpinnerNumberModel(0, 0, 999999000, 1000));
        jPanel8.add(txtSellPrice);
        jPanel9.setLayout(new GridLayout(0, 1, 0, 0));
        jLabel3 = new javax.swing.JLabel();
        jPanel9.add(jLabel3);
        
        jLabel3.setFont(new Font("Arial", Font.BOLD, 14)); // NOI18N
        jLabel3.setText("Giảm giá");

        jPanel5.add(jPanel9);
        cbbDiscount = new javax.swing.JComboBox<>();
        jPanel9.add(cbbDiscount);
        cbbDiscount.setBackground(new Color(255, 255, 255));
        
        cbbDiscount.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cbbDiscount.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {"Không", "Có" }));
        jPanel10.setLayout(new GridLayout(0, 1, 0, 0));

        jPanel5.add(jPanel10);
        jLabel5 = new javax.swing.JLabel();
        jPanel10.add(jLabel5);
        
        jLabel5.setFont(new Font("Arial", Font.BOLD, 14)); // NOI18N
        jLabel5.setText("Giá khuyên mãi");
   
			txtDiscountPrice = new JSpinner();
			txtDiscountPrice.setModel(new SpinnerNumberModel(0, 0, prd.getSellPrice()*9/10, 1000));

        jPanel10.add(txtDiscountPrice);
        jPanel13.setLayout(new GridLayout(0, 1, 0, 0));

        jPanel5.add(jPanel13);
        jLabel2 = new javax.swing.JLabel();
        jPanel13.add(jLabel2);
        
        jLabel2.setFont(new Font("Arial", Font.BOLD, 14)); // NOI18N
        jLabel2.setText("Tồn kho");
        
        lblQuantity = new JLabel();
        jPanel13.add(lblQuantity);
        jPanel14.setLayout(new GridLayout(0, 1, 0, 0));

        jLabel9.setFont(new Font("Arial", Font.BOLD, 14)); // NOI18N
        jLabel9.setText("Trạng thái SP");
        jPanel14.add(jLabel9);
        jPanel14.add(lblStatus);

        jPanel5.add(jPanel14);

        jPanel18.add(jPanel5, java.awt.BorderLayout.PAGE_START);

        jPanel6.setLayout(new java.awt.GridBagLayout());

        btnUpdate.setBackground(new java.awt.Color(56, 159, 214));
        btnUpdate.setFont(new Font("Arial", Font.BOLD, 14)); // NOI18N
        btnUpdate.setForeground(new java.awt.Color(255, 255, 255));
        btnUpdate.setText("Cập nhật");
        gbc_btnUpdate = new java.awt.GridBagConstraints();
        gbc_btnUpdate.gridy = 0;
        gbc_btnUpdate.gridx = 0;
        gbc_btnUpdate.ipadx = 16;
        gbc_btnUpdate.ipady = 15;
        gbc_btnUpdate.insets = new java.awt.Insets(7, 9, 7, 9);
        jPanel6.add(btnUpdate, gbc_btnUpdate);

        btnExit.setBackground(new java.awt.Color(219, 88, 96));
        btnExit.setFont(new Font("Arial", Font.BOLD, 14)); // NOI18N
        btnExit.setForeground(new java.awt.Color(255, 255, 255));
        btnExit.setText("Hủy bỏ");
        btnExit.setPreferredSize(new Dimension(110, 25));
        gbc_btnExit = new java.awt.GridBagConstraints();
        gbc_btnExit.gridx = 1;
        gbc_btnExit.gridy = 0;
        gbc_btnExit.ipadx = 41;
        gbc_btnExit.ipady = 13;
        gbc_btnExit.insets = new java.awt.Insets(6, 10, 6, 10);
        jPanel6.add(btnExit, gbc_btnExit);

        jPanel18.add(jPanel6, java.awt.BorderLayout.CENTER);

        jPanel2.add(jPanel18, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);

        pack();
    }
    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ThemSPGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ThemSPGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ThemSPGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ThemSPGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ThemSPGUI(ProductDAO.getInstance().readByID(2)).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JLabel lblImage;
    private javax.swing.JComboBox<String> cbbType;
    private JLabel lblStatus;
    private javax.swing.JComboBox<String> cbbDiscount;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JButton btnExit;
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
    private JComboBox cbbBrand;
    private JSpinner txtDiscountPrice;
    protected javax.swing.JTextField txtName;
    private JLabel lblId;
    private JSpinner txtSellPrice;
    private JLabel lblQuantity;
    private GridBagConstraints gbc_btnUpdate;
    private GridBagConstraints gbc_btnExit;
    private JToggleButton btnDR;
    // End of variables declaration//GEN-END:variables
    
    public void setProductQuantity(String quantity) {
    	lblQuantity.setText(quantity);
    }
    
    public void setProductID(String id) {
    	lblId.setText(id);
    }
    
    public void setProductName(String productName) {
        txtName.setText(productName);
    }

	public String getComboBoxCategoryValue() {
		JOptionPane.showMessageDialog(cbbType, cbbType.getSelectedItem().toString());
		return cbbType.getSelectedItem().toString();
	}

	public String getComboBoxDiscountValue() {
		return cbbDiscount.getSelectedItem().toString();
	}


	public String getTextFieldProductnameValue() {
		return txtName.getText();
	}


	public String getTextFieldProductIDValue() {
		return lblId.getText();
	}

	public String getTextFieldQuantityValue() {
		return lblQuantity.getText();
	}
}
