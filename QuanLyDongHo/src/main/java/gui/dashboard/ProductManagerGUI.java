package gui.dashboard;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.Font;
import java.sql.SQLException;
import java.util.ArrayList;
import dao.ProductDAO;
import dto.Product;

public class ProductManagerGUI extends NewJPanel {

    private static final long serialVersionUID = 1L;
    private JScrollPane scrollPane;
    private JTable table;

    public ProductManagerGUI() {
        pnContent.setLayout(new BorderLayout(0, 0));

        scrollPane = new JScrollPane();
        scrollPane.setFont(new Font("Tahoma", Font.PLAIN, 14));
        pnContent.add(scrollPane, BorderLayout.CENTER);

        table = new JTable();
        table.setRowHeight(25);
        table.setFont(new Font("Times New Roman", Font.PLAIN, 14));

        ProductDAO productDAO = ProductDAO.getInstance();
		ArrayList<Product> productList = productDAO.readAllData();
		displayProducts(productList);
        
        scrollPane.setViewportView(table);
        designTitle();
    }

    private void displayProducts(ArrayList<Product> productList) {
    	DefaultTableModel model = new DefaultTableModel(
            	new Object[][] {},
            	new String[] {
            		"Mã SP",
            		"Tên sản phẩm",
            		"Tồn kho",
            		"Loại sản phẩm",
            		"Thương hiệu",
            		"Giá",
            		"Giá giảm",
            		"Giảm giá"
            	}
        );
        for (Product product : productList) {
            Object[] rowData = {
                    product.getId(),
                    product.getProductName(),
                    product.getQuantity(),
                    product.getCategory(),
                    product.getBrand(),
                    product.getSellPrice(),
                    product.getDiscountPrice(),
                    product.isDiscount() ? "Đang giảm giá" : "Không"
            };
            model.addRow(rowData);
        }
        table.setModel(model);

        table.getColumnModel().getColumn(0).setResizable(false);
        table.getColumnModel().getColumn(0).setPreferredWidth(70);
        table.getColumnModel().getColumn(0).setMaxWidth(1400);
        table.getColumnModel().getColumn(1).setResizable(false);
        table.getColumnModel().getColumn(1).setPreferredWidth(280);
        table.getColumnModel().getColumn(2).setResizable(false);
        table.getColumnModel().getColumn(2).setPreferredWidth(15);
        table.getColumnModel().getColumn(3).setResizable(false);
        table.getColumnModel().getColumn(3).setPreferredWidth(80);
        table.getColumnModel().getColumn(4).setResizable(false);
        table.getColumnModel().getColumn(4).setPreferredWidth(80);
        table.getColumnModel().getColumn(5).setResizable(false);
        table.getColumnModel().getColumn(5).setPreferredWidth(80);
        table.getColumnModel().getColumn(6).setResizable(false);
        table.getColumnModel().getColumn(6).setPreferredWidth(80);
        table.getColumnModel().getColumn(7).setResizable(false);
        table.getColumnModel().getColumn(7).setPreferredWidth(80);
    }

    private void designTitle() {
        table.getTableHeader().setBackground(Color.decode("#f4c82d"));
        table.getTableHeader().setFont(table.getFont());
    }

    @Override
    protected void setAddEvent() {
        JFrame fr = new ThemSPGUI();
        fr.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        fr.setLocationRelativeTo(null);
        fr.setVisible(true);
    }
}
