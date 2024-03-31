package gui.dashboard;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProductGridPanel extends JPanel {
    private static final Color DEFAULT_BACKGROUND_COLOR = Color.WHITE;

    public ProductGridPanel() {
        Color white = Color.WHITE;
    
        setLayout(new GridLayout(0, 4, 10, 10));
        setBackground(DEFAULT_BACKGROUND_COLOR);
    
        String[] productNames = {"Sản phẩm 1", "Sản phẩm 2", "Sản phẩm 3", "Sản phẩm 4", "Sản phẩm 5", "Sản phẩm 6", "Sản phẩm 7", "Sản phẩm 8", "Sản phẩm 9", "Sản phẩm 10", "Sản phẩm 1", "Sản phẩm 2", "Sản phẩm 3", "Sản phẩm 4", "Sản phẩm 5", "Sản phẩm 6", "Sản phẩm 7", "Sản phẩm 8", "Sản phẩm 9", "Sản phẩm 10"};
        double[] productPrices = {10.99, 19.99, 7.99, 14.99, 24.99, 12.99, 9.99, 16.99, 11.99, 8.99, 10.99, 19.99, 7.99, 14.99, 24.99, 12.99, 9.99, 16.99, 11.99, 8.99};
        String[] productImages = {"Java/img/img1.png", "Java/img/img2.png", "Java/img/img3.png", "Java/img/img4.png", "Java/img/img5.png", "Java/img/img6.png", "Java/img/img7.png", "Java/img/img8.png", "Java/img/img9.png", "Java/img/img10.png", "Java/img/img1.png", "Java/img/img2.png", "Java/img/img3.png", "Java/img/img4.png", "Java/img/img5.png", "Java/img/img6.png", "Java/img/img7.png", "Java/img/img8.png", "Java/img/img9.png", "Java/img/img10.png"};
    
        for (int i = 0; i < productNames.length; i++) {
            String productName = productNames[i];
            double productPrice = productPrices[i];
            String productImage = productImages[i];
    
            JPanel productFrame = new JPanel();
            productFrame.setLayout(new BorderLayout());
            productFrame.setBorder(BorderFactory.createEtchedBorder());
            productFrame.setBackground(white);
    
            ImageIcon imageIcon = new ImageIcon(productImage);
            Image image = imageIcon.getImage();
            Image scaledImage = image.getScaledInstance(150, 150, Image.SCALE_SMOOTH);
            ImageIcon scaledImageIcon = new ImageIcon(scaledImage);
            JLabel imageLabel = new JLabel(scaledImageIcon);
            imageLabel.setHorizontalAlignment(SwingConstants.CENTER);
            productFrame.add(imageLabel, BorderLayout.CENTER);
    
            JLabel nameLabel = new JLabel(productName);
            nameLabel.setHorizontalAlignment(SwingConstants.CENTER);
            productFrame.add(nameLabel, BorderLayout.NORTH);
    
            
            JPanel bottomPanel = new JPanel(new GridLayout(2, 1));
            JLabel priceLabel = new JLabel(String.format("$%.2f", productPrice));
            priceLabel.setHorizontalAlignment(SwingConstants.CENTER);
            priceLabel.setBackground(white);
            priceLabel.setOpaque(true);
            bottomPanel.add(priceLabel);

            JButton buyButton = new JButton("Mua");
            buyButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    showProductDetails(productName, productPrice, productImage);
                }
            });
            buyButton.setHorizontalAlignment(SwingConstants.CENTER);
            bottomPanel.add(buyButton);
    
            productFrame.add(bottomPanel, BorderLayout.SOUTH);
    
            imageLabel.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    showProductDetails(productName, productPrice, productImage);
                }
            });
    
            add(productFrame);
        }
    }

    private void showProductDetails(String productName, double productPrice, String productImage) {
        
        JDialog dialog = new JDialog((Frame) SwingUtilities.getWindowAncestor(this), "Thông tin sản phẩm", true);
        dialog.setLayout(new BorderLayout());
    
        
        JPanel detailsPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0.4; 
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
    
        
        JPanel imagePanel = new JPanel();
        imagePanel.setLayout(new BorderLayout());
    
        
        ImageIcon imageIcon = new ImageIcon(productImage);
        Image image = imageIcon.getImage();
        Image scaledImage = image.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
        ImageIcon scaledImageIcon = new ImageIcon(scaledImage);
        JLabel imageLabel = new JLabel(scaledImageIcon);
        imageLabel.setHorizontalAlignment(SwingConstants.CENTER);
        imagePanel.add(imageLabel, BorderLayout.CENTER);
        imagePanel.setBackground(DEFAULT_BACKGROUND_COLOR);

        detailsPanel.add(imagePanel, gbc);

        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 0.6; 
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
    
        
        JPanel infoPanel = new JPanel();
        infoPanel.setLayout(new GridLayout(5, 1));
    
       
        JLabel nameLabel = new JLabel(productName);
        nameLabel.setFont(new Font("Arial", Font.BOLD, 18));
        nameLabel.setHorizontalAlignment(SwingConstants.LEFT);
        infoPanel.add(nameLabel);
    
        
        JLabel descriptionLabel = new JLabel("Mô tả: đồng hồ đẹp nhất thế giới");
        descriptionLabel.setHorizontalAlignment(SwingConstants.LEFT);
        infoPanel.add(descriptionLabel);
        
        
        JLabel quantityLabel = new JLabel("Số lượng:");
        quantityLabel.setHorizontalAlignment(SwingConstants.LEFT);
        quantityLabel.setBackground(DEFAULT_BACKGROUND_COLOR);
        quantityLabel.setOpaque(true);

        SpinnerModel spinnerModel = new SpinnerNumberModel(1, 1, 100, 1);
        JSpinner quantitySpinner = new JSpinner(spinnerModel);
        quantitySpinner.setBackground(DEFAULT_BACKGROUND_COLOR);

        JPanel SL = new JPanel(new GridBagLayout());
        SL.setBackground(DEFAULT_BACKGROUND_COLOR);
        GridBagConstraints gbct = new GridBagConstraints();
        gbct.gridx = 0;
        gbct.gridy = 0;
        gbct.weightx = 0.95; 
        gbct.fill = GridBagConstraints.HORIZONTAL;
        SL.add(quantityLabel, gbct);

        gbct.gridx = 1;
        gbct.weightx = 0.05; 
        gbct.fill = GridBagConstraints.HORIZONTAL;
        SL.add(quantitySpinner, gbct);

        infoPanel.add(SL);


        
        JLabel totalLabel = new JLabel("Tổng tiền: $0.00");
        totalLabel.setHorizontalAlignment(SwingConstants.LEFT);
        infoPanel.add(totalLabel);

        quantitySpinner.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int quantity = (int) quantitySpinner.getValue();
                if (quantity == 0) {
                    totalLabel.setText(String.format("Tổng tiền: $%.2f", productPrice));
                } else {
                    double total = productPrice * quantity;
                    totalLabel.setText(String.format("Tổng tiền: $%.2f", total));
                }
            }
        });
    
        
        JPanel quantityPanel = new JPanel();
        quantityPanel.setLayout(new BorderLayout());

        quantityPanel.add(totalLabel, BorderLayout.CENTER);

        JButton paymentButton = new JButton("Thanh toán");
        quantityPanel.add(paymentButton, BorderLayout.EAST);
        quantityPanel.setBackground(DEFAULT_BACKGROUND_COLOR);
        infoPanel.add(quantityPanel);
        infoPanel.setBackground(DEFAULT_BACKGROUND_COLOR);
        
        detailsPanel.add(infoPanel, gbc);
    
        
        dialog.add(detailsPanel, BorderLayout.CENTER);
    
        dialog.setSize(700, 400);
        dialog.setLocationRelativeTo(this);
        dialog.setVisible(true);
    }
       
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Product Grid Panel");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(800, 600);


            ProductGridPanel productPanel = new ProductGridPanel();
            frame.add(productPanel);

            frame.setVisible(true);
        });
    }
}