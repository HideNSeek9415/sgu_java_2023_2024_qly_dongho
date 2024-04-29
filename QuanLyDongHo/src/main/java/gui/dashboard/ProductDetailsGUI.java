package gui.dashboard;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Dimension;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;
import java.text.DecimalFormat;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import java.awt.Color;
import java.awt.Font;
import javax.swing.border.MatteBorder;

import org.kordamp.ikonli.swing.FontIcon;

import dto.Product;

import javax.swing.JSpinner;
import javax.swing.AbstractButton;
import javax.swing.JButton;
import java.awt.Cursor;
import javax.swing.border.LineBorder;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.plaf.metal.MetalButtonUI;

public class ProductDetailsGUI extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JPanel pnLeft;
    private JPanel pnRight;
    private JLabel lblImg;
    private JPanel pnAmount;
    private JPanel pnInfo;
    private JPanel pnBtn;
    private JLabel lblPrdtName;
    private JPanel pnProperties;
    private JPanel pnProp2;
    private JLabel lblProp2;
    private JLabel lblType;
    private JPanel pnProp3;
    private JLabel lblTnhTrng;
    private JLabel lblBrand;
    private JPanel pnProp4;
    private JLabel lblSLng;
    private JLabel lblQuantity;
    private JLabel lblGia;
    private JLabel lblSolg;
    private JLabel lblPaid;
    private JPanel panel;
    private JButton btnSell;
    private JButton btnAddToCart;
    private JLabel lblCross;
    private JPanel panel_1;
    private JLabel lblPaid_1;
    private JPanel pnProp1_1;
    private JLabel lblProp1_1;
    private JLabel pnStatus_1;
    private JPanel pnProp1_2;
    private JPanel pnProp1_3;
	private Product selectedProduct;
	private JButton btnSub;
	private JLabel lblAmount;
	private JButton btnAdd;
	private int numOfPrd = 1;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
                    
                    ProductDetailsGUI frame = new ProductDetailsGUI(null);
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public ProductDetailsGUI(Product product) {
    	selectedProduct = product;
        String productName = product.getProductName();
        String category = product.getCategory();
        String brand = product.getBrand();
        double sellPrice = product.getSellPrice();
        double discountPrice = product.getDiscountPrice();
        int quantity = product.getQuantity();
        String productStatus = product.getStatus();
        String imageURL = product.getImageUrl();
        
    	setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 806, 372);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(255, 255, 255));
        contentPane.setPreferredSize(new Dimension(600, 300));
        contentPane.setBorder(null);
        
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));
        
        pnLeft = new JPanel();
        pnLeft.setOpaque(false);
        pnLeft.setBorder(new EmptyBorder(25, 25, 25, 25));
        pnLeft.setPreferredSize(new Dimension(300, 300));
        contentPane.add(pnLeft, BorderLayout.WEST);
        pnLeft.setLayout(new GridLayout(1, 0, 0, 0));
        
        lblImg = new JLabel();
        lblImg.setPreferredSize(new Dimension(50, 32));
        lblImg.setForeground(new Color(255, 255, 255));
        lblImg.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 30));
        lblImg.setOpaque(true);
        lblImg.setBackground(new Color(0, 128, 128));
        lblImg.setHorizontalAlignment(SwingConstants.CENTER);
        lblImg.setHorizontalTextPosition(SwingConstants.CENTER);
        pnLeft.add(lblImg);
        
        
        pnRight = new JPanel();
        pnRight.setOpaque(false);
        contentPane.add(pnRight, BorderLayout.CENTER);
        pnRight.setLayout(new GridLayout(3, 0, 0, 0));
        
        pnInfo = new JPanel();
        pnInfo.setOpaque(false);
        pnRight.add(pnInfo);
        pnInfo.setLayout(new GridLayout(2, 0, 0, 0));
        
        lblPrdtName = new JLabel();
        lblPrdtName.setText(productName);
        lblPrdtName.setVerticalAlignment(SwingConstants.BOTTOM);
        lblPrdtName.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
        lblPrdtName.setFont(new Font("Times-Narrow", Font.BOLD, 23));
        pnInfo.add(lblPrdtName);
        
        pnProperties = new JPanel();
        pnProperties.setOpaque(false);
        pnInfo.add(pnProperties);
        pnProperties.setLayout(new GridLayout(1, 3, 0, 0));
            
        pnProp2 = new JPanel();
        pnProp2.setOpaque(false);
        pnProperties.add(pnProp2);
        pnProp2.setLayout(new GridLayout(2, 0, 0, 0));
        
        lblProp2 = new JLabel("Loại đồng hồ:");
        lblProp2.setVerticalAlignment(SwingConstants.BOTTOM);
        lblProp2.setForeground(Color.BLACK);
        lblProp2.setFont(new Font("Roboto Mono", Font.BOLD, 13));
        pnProp2.add(lblProp2);
        
        lblType = new JLabel();
        lblType.setText(category);
        lblType.setVerticalAlignment(SwingConstants.TOP);
        lblType.setForeground(new Color(166, 44, 44));
        lblType.setFont(new Font("Roboto Mono", Font.BOLD, 13));
        pnProp2.add(lblType);
        
        pnProp3 = new JPanel();
        pnProp3.setOpaque(false);
        pnProperties.add(pnProp3);
        pnProp3.setLayout(new GridLayout(2, 0, 0, 0));
        
        lblTnhTrng = new JLabel("Thương hiệu:");
        lblTnhTrng.setVerticalAlignment(SwingConstants.BOTTOM);
        lblTnhTrng.setForeground(Color.BLACK);
        lblTnhTrng.setFont(new Font("Roboto Mono", Font.BOLD, 13));
        pnProp3.add(lblTnhTrng);
        
        lblBrand = new JLabel();
        lblBrand.setText(brand);
        lblBrand.setVerticalAlignment(SwingConstants.TOP);
        lblBrand.setForeground(new Color(166, 44, 44));
        lblBrand.setFont(new Font("Roboto Mono", Font.BOLD, 13));
        pnProp3.add(lblBrand);
        
        pnProp4 = new JPanel();
        pnProp4.setOpaque(false);
        pnProperties.add(pnProp4);
        pnProp4.setLayout(new GridLayout(2, 0, 0, 0));
        
        lblSLng = new JLabel("Tồn kho:");
        lblSLng.setVerticalAlignment(SwingConstants.BOTTOM);
        lblSLng.setForeground(Color.BLACK);
        lblSLng.setFont(new Font("Roboto Mono", Font.BOLD, 13));
        pnProp4.add(lblSLng);

        lblQuantity = new JLabel(String.valueOf(quantity));
        lblQuantity.setVerticalAlignment(SwingConstants.TOP);
        lblQuantity.setForeground(new Color(166, 44, 44));
        lblQuantity.setFont(new Font("Roboto Mono", Font.BOLD, 13));
        pnProp4.add(lblQuantity);

        pnAmount = new JPanel();
        pnAmount.setOpaque(false);
        pnRight.add(pnAmount);
        pnAmount.setLayout(new GridLayout(3, 2, 0, 0));

        pnProp1_1 = new JPanel();
        pnProp1_1.setOpaque(false);
        pnAmount.add(pnProp1_1);
        pnProp1_1.setLayout(new GridLayout(2, 0, 0, 0));

        lblProp1_1 = new JLabel("Bảo hành:");
        lblProp1_1.setVerticalAlignment(SwingConstants.BOTTOM);
        lblProp1_1.setForeground(Color.BLACK);
        lblProp1_1.setFont(new Font("Roboto Mono", Font.BOLD, 13));
        pnProp1_1.add(lblProp1_1);

        pnStatus_1 = new JLabel("5 Năm");
        pnStatus_1.setVerticalAlignment(SwingConstants.TOP);
        pnStatus_1.setForeground(new Color(166, 44, 44));
        pnStatus_1.setFont(new Font("Roboto Mono", Font.BOLD, 13));
        pnProp1_1.add(pnStatus_1);

        pnProp1_2 = new JPanel();
        pnProp1_2.setOpaque(false);
        pnAmount.add(pnProp1_2);
        pnProp1_2.setLayout(new GridLayout(2, 0, 0, 0));

        pnProp1_3 = new JPanel();
        pnProp1_3.setOpaque(false);
        pnAmount.add(pnProp1_3);
        pnProp1_3.setLayout(new GridLayout(2, 0, 0, 0));

        lblGia = new JLabel("Giá:");
        lblGia.setBorder(new EmptyBorder(0, 30, 0, 0));
        lblGia.setHorizontalAlignment(SwingConstants.LEFT);
        lblGia.setFont(new Font("Segoe UI", Font.BOLD, 21));
        pnAmount.add(lblGia);


       
        String formattedPrice = formatCurrency(sellPrice);

        lblPaid = new JLabel(formattedPrice);
        lblPaid.setForeground(new Color(255, 0, 0));
        lblPaid.setFont(new Font("Segoe UI", Font.BOLD, 21));
        pnAmount.add(lblPaid);

        lblCross = new JLabel() {
            @Override
            public void setText(String text) {
                super.setText("<html><strike>" + text + "</strike></html>");
            }
        };
        lblCross.setHorizontalAlignment(SwingConstants.CENTER);
        lblCross.setText("");
        lblCross.setForeground(new Color(128, 128, 128));
        lblCross.setFont(new Font("Segoe UI", Font.BOLD, 15));
        pnAmount.add(lblCross);

        lblSolg = new JLabel("Số lượng:");
        lblSolg.setBorder(new EmptyBorder(0, 30, 0, 0));
        lblSolg.setHorizontalAlignment(SwingConstants.LEFT);
        lblSolg.setFont(new Font("Segoe UI", Font.BOLD, 21));
        pnAmount.add(lblSolg);

        panel = new JPanel();
        panel.setOpaque(false);
        panel.setBorder(new EmptyBorder(0, 0, 5, 0));
        pnAmount.add(panel);
        panel.setLayout(new GridLayout(0, 3, 10, 0));
        
        btnSub = new JButton("-");
        btnSub.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnSub.setFocusPainted(false);
        btnSub.setBorderPainted(false);
        btnSub.setHorizontalTextPosition(SwingConstants.CENTER);
        btnSub.setBackground(new Color(246, 246, 246));
        btnSub.setFont(new Font("SansSerif", Font.BOLD, 33));
        btnSub.setUI(new MetalButtonUI());
        panel.add(btnSub);
        
        lblAmount = new JLabel(String.valueOf(numOfPrd));
        lblAmount.setHorizontalAlignment(SwingConstants.CENTER);
        lblAmount.setFont(new Font("SansSerif", Font.BOLD, 18));
        panel.add(lblAmount);
        
        btnAdd = new JButton("+");
        btnAdd.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnAdd.setFocusPainted(false);
        btnAdd.setHorizontalTextPosition(SwingConstants.CENTER);
        btnAdd.setFont(new Font("SansSerif", Font.BOLD, 33));
        btnAdd.setBorderPainted(false);
        btnAdd.setBackground(new Color(246, 246, 246));
        btnAdd.setUI(new MetalButtonUI());
        panel.add(btnAdd);

        panel_1 = new JPanel();
        panel_1.setOpaque(false);
        panel_1.setBorder(new EmptyBorder(5, 30, 5, 30));
        pnAmount.add(panel_1);
        panel_1.setLayout(new BorderLayout(0, 0));

        lblPaid_1 = new JLabel("-25%");
        lblPaid_1.setOpaque(true);
        lblPaid_1.setHorizontalTextPosition(SwingConstants.CENTER);
        lblPaid_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblPaid_1.setForeground(new Color(240, 92, 92));
        lblPaid_1.setFont(new Font("Segoe UI", Font.BOLD, 21));
        lblPaid_1.setBorder(null);
        lblPaid_1.setBackground(new Color(249, 233, 226));
//        panel_1.add(lblPaid_1);
        
        pnBtn = new JPanel();
        pnBtn.setBorder(new EmptyBorder(0, 30, 25, 30));
        pnBtn.setOpaque(false);
        pnRight.add(pnBtn);
        pnBtn.setLayout(new GridLayout(2, 0, 0, 5));
        
        btnSell = new JButton("Mua ngay");
        btnSell.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnSell.setFocusPainted(false);
        btnSell.setFont(new Font("Roboto Mono", Font.BOLD, 19));
        btnSell.setForeground(new Color(255, 255, 255));
        btnSell.setBackground(new Color(46, 139, 87));
        pnBtn.add(btnSell);
        
        btnAddToCart = new JButton("Thêm vào giỏ");
        btnAddToCart.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnAddToCart.setFocusPainted(false);
        btnAddToCart.setForeground(new Color(0, 0, 0));
        btnAddToCart.setFont(new Font("Roboto Mono", Font.BOLD, 19));
        btnAddToCart.setBackground(new Color(255, 255, 255));
        pnBtn.add(btnAddToCart);
        
        addStuff();
        updateAmount();
    }
        
    private void updateAmount() {
    	btnSub.setEnabled(false);
        btnSub.addActionListener(e -> {
        	numOfPrd--;
        	if (numOfPrd == 1) {
        		btnSub.setEnabled(false);
        	}
        	lblAmount.setText(String.valueOf(numOfPrd));
        	double totalPrice = numOfPrd*selectedProduct.getSellPrice();
        	String formatTotalPrice = String.format("%,.0f VNĐ", totalPrice);
        	lblPaid.setText(formatTotalPrice);
        });
        btnAdd.addActionListener(e -> {
        	numOfPrd++;
        	btnSub.setEnabled(true);
        	lblAmount.setText(String.valueOf(numOfPrd));
        	double totalPrice = numOfPrd*selectedProduct.getSellPrice();
        	String formatTotalPrice = String.format("%,.0f VNĐ", totalPrice);
        	lblPaid.setText(formatTotalPrice);
        });
    }

    private void addStuff() {
        // TODO Auto-generated method stub
        makeHoverEff(btnSell);
        makeHoverEff(btnAddToCart);
        addImageProduct();
    }
    
    private void makeHoverEff(AbstractButton btn) {
        Color bg = btn.getBackground();
        Color fore = btn.getForeground();
        btn.removeActionListener(null);
        btn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                if (btn.isEnabled()) {
                    btn.setBackground(Color.decode("#c6763e"));
                    btn.setForeground(Color.white);
                } 
            }

            @Override
            public void mouseExited(MouseEvent e) {
                if (btn.isEnabled()) {
                    btn.setBackground(bg);
                    btn.setForeground(fore);
                }
            }
        });
    }
    
    private void addImageProduct() {
    	Image icon = new ImageIcon(getClass().getResource(selectedProduct.getImageUrl())).getImage();
    	icon = icon.getScaledInstance(312, 312, Image.SCALE_SMOOTH);
    	lblImg.setText("");
    	lblImg.setIcon(new ImageIcon(icon));
	}
    
    private String formatCurrency(double amount) {
        DecimalFormat decimalFormat = new DecimalFormat("#,##0 VNĐ");
        return decimalFormat.format(amount);
    }
}
