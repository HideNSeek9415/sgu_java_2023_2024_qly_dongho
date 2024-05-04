package gui.dashboard;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import org.kordamp.ikonli.materialdesign2.MaterialDesignC;
import org.kordamp.ikonli.swing.FontIcon;

import bll.ProductBLL;
import dao.ProductDAO;
import dto.Product;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URL;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;
import javax.swing.border.EmptyBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;

public class zShoppingCartFrame extends JFrame {
    private JPanel cartPanel;
    private int totalPrice = 0;
    private JLabel totalLabel;
    private JScrollPane scrollPane;
    private JFrame storedFrame = null;
    public static ArrayList<Product> pInCart = new ArrayList<>();


    public zShoppingCartFrame() {
    	setResizable(false);
    	setBackground(new Color(255, 255, 255));
    	setTitle("Giỏ hàng");
        setSize(504, 677);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel contentPane = new JPanel();
        contentPane.setLayout(new BorderLayout());

        cartPanel = new JPanel();
        cartPanel.setLayout(new BoxLayout(cartPanel, BoxLayout.Y_AXIS));
        cartPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        cartPanel.setBackground(new Color(255, 255, 255));

        
        totalLabel = new JLabel("Tổng tiền: " + formatCurrency(totalPrice)); // Khởi tạo nhãn tổng tiền


        scrollPane = new JScrollPane(cartPanel);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        contentPane.add(scrollPane, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(new Color(255, 255, 255));
        contentPane.add(buttonPanel, BorderLayout.SOUTH);
        
        buttonPanel.add(totalLabel);
        
        JButton checkoutButton = new JButton("Thanh toán");
        checkoutButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        checkoutButton.setFocusPainted(false);
        checkoutButton.setBorderPainted(false);
        checkoutButton.setFont(new Font("SansSerif", Font.BOLD, 12));
        checkoutButton.setForeground(new Color(0, 0, 0));
        checkoutButton.setBackground(new Color(255, 255, 255));
        checkoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	confirmPayment();
            	cleanShoppingCart();
            }
        });
        
        
        buttonPanel.setLayout(new GridLayout(0, 1, 0, 0));
        buttonPanel.add(checkoutButton);

        setContentPane(contentPane);
        updateCartPanel();
        makeHoverEff(checkoutButton);
        setVisible(false);
        

    }
    
    public static boolean addProduct(int prdId) {
    	Product product = ProductDAO.getInstance().readByID(prdId);
    	if (product.getQuantity() <= 0) 
    		return false;
    	else {
    		pInCart.add(product);
    		return true;
    	}
    	
      
    }
    
    protected static ArrayList<Product> getShoppingCart(){
    	return pInCart;
    }
    
    private int calculateTotalPrice() {
        totalPrice = 0;
        for (Product item : pInCart) {
        	totalPrice += item.isDiscount() ? item.getDiscountPrice() : item.getSellPrice();
        }
        return totalPrice;
    }

    // Cập nhật panel giỏ hàng
    private void updateCartPanel() {
        cartPanel.removeAll(); // Xóa tất cả các đơn hàng hiện tại trước khi cập nhật
        for (Product product : pInCart) {
        	JPanel prdPanel = new JPanel();
            
            prdPanel.setBackground(new Color(255, 255, 255));
            prdPanel.setPreferredSize(new Dimension(445, 100));

            prdPanel.setLayout(null);
            cartPanel.add(prdPanel);
            cartPanel.add(Box.createVerticalStrut(10));
            
            JLabel lblImg = new JLabel();
            lblImg.setBounds(6, 5, 90, 90);
        	Image icon = new ImageIcon(getClass().getResource(product.getImageUrl())).getImage();
        	icon = icon.getScaledInstance(lblImg.getWidth(), lblImg.getHeight(), Image.SCALE_SMOOTH);
        	lblImg.setIcon(new ImageIcon(icon));
            prdPanel.add(lblImg);
            
            JLabel lblName = new JLabel(product.getProductName());
            lblName.setFont(new Font("SansSerif", Font.BOLD, 12));
            lblName.setBounds(108, 6, 254, 25);
            prdPanel.add(lblName);
            
            JLabel lblPrice = new JLabel("Đơn giá: ");
            lblPrice.setFont(new Font("SansSerif", Font.BOLD, 12));
            lblPrice.setBounds(108, 31, 58, 25);
            prdPanel.add(lblPrice);
            
            String price = String.valueOf(formatCurrency(product.isDiscount() ? product.getDiscountPrice() : product.getSellPrice()));
            JLabel lblDisplayPrice = new JLabel(price);
            lblDisplayPrice.setForeground(new Color(128, 0, 0));
            lblDisplayPrice.setFont(new Font("SansSerif", Font.BOLD, 12));
            lblDisplayPrice.setBounds(178, 31, 261, 25);
            prdPanel.add(lblDisplayPrice);
            
            JButton btnRm = new JButton();
            btnRm.setHorizontalTextPosition(SwingConstants.CENTER);
            btnRm.setBackground(new Color(104, 32, 32));
            btnRm.setFocusPainted(false);
            btnRm.setBounds(414, 5, 25, 25);
            btnRm.setIcon(FontIcon.of(MaterialDesignC.CLOSE, 15, Color.white));
            prdPanel.add(btnRm);
            
            btnRm.addActionListener(e -> {
            	pInCart.remove(product);
            	updateCartPanel();
            });

        }
        
        calculateTotalPrice();
        totalLabel.setText("Tổng tiền: " + formatCurrency(totalPrice));

        this.revalidate();
        this.repaint();
    }
    
    private void makeHoverEff(AbstractButton btn) {
        Color bg = btn.getBackground();
        Color fore = btn.getForeground();
        btn.removeActionListener(null);
        btn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                if (btn.isEnabled()) {
                    btn.setBackground(Color.decode("#1b7990"));
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

    private void makeHoverEff2(AbstractButton btn) {
        Color bg = btn.getBackground();
        Color fore = btn.getForeground();
        btn.removeActionListener(null);
        btn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                if (btn.isEnabled()) {
                    btn.setBackground(Color.decode("#FF9900"));
                    btn.setForeground(Color.black);
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
    


    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                try {
					UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
				} catch (Exception e) {
					e.printStackTrace();
				}
                (new zShoppingCartFrame()).setVisible(true);
            }
        });
    }

    private String formatCurrency(int amount) {
    	DecimalFormat decimalFormat = new DecimalFormat("#,##0 VNĐ");
    	return decimalFormat.format(amount);
    }
    
    private void cleanShoppingCart() {
//    	if ( ((ConfirmPayment)storedFrame).isClickConfirmButton() ) { 
//        	pInCart.clear();
//        	updateCartPanel();
//        }
    }
    
    private void setStoredFrame() {
    	
    }
    
    private void confirmPayment() {
    	JFrame fr = new ConfirmPayment(-1, 0);
		fr.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		fr.setSize(761, 500);
//		((ThemNhaCungCap)fr).setTable(table);
		fr.setLocationRelativeTo(null);
		fr.setVisible(true);
		setStoredFrame();
    }
}


