package gui.dashboard;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import dao.ProductDAO;
import dto.Product;
import system.ExportManager;

public class ProductManagerGUI extends NewJPanel {

    private static final long serialVersionUID = 1L;
    private JScrollPane scrollPane;
    private JTable table;
    private DefaultTableModel model;
    ArrayList<Product> productList;

    public ProductManagerGUI() {
        pnContent.setLayout(new BorderLayout(0, 0));

        scrollPane = new JScrollPane();
        scrollPane.setFont(new Font("Tahoma", Font.PLAIN, 14));
        pnContent.add(scrollPane, BorderLayout.CENTER);

        table = new JTable();
        table.setRowHeight(25);
        table.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        
    	DefaultTableModel md = new DefaultTableModel(
            	new Object[][] {},
            	new String[] {
            		"Mã SP",
            		"Tên sản phẩm",
            		"Tồn kho",
            		"Loại sản phẩm",
            		"Thương hiệu",
            		"Giá",
            		"Giá giảm",
            		"Trạng thái"
            	}
        );
        table.setModel(md);

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
    	model = md;

		displayProducts();
		
        
        scrollPane.setViewportView(table);
        designTitle();
        
        btnImport.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ExportManager.exportToExcel(table);
            }
        });
    }

    public void displayProducts() {
    	productList = ProductDAO.getInstance().readAllData();
    	model.setRowCount(0);

        for (Product product : productList) {
            Object[] rowData = {
                product.getId(),
                product.getProductName(),
                product.getQuantity(),
                product.getCategory(),
                product.getBrand(),
                product.getSellPrice(),
                product.getDiscountPrice(),
                product.getStatus()
            };
            model.addRow(rowData);
        }
    }

    private void designTitle() {
        table.getTableHeader().setBackground(Color.decode("#f4c82d"));
        table.getTableHeader().setFont(table.getFont());
    }

    @Override
    protected void setDetailEvent() {
    	int id = (Integer) table.getValueAt(table.getSelectedRow(), 0);
    	Product p = ProductDAO.getInstance().readByID(id);
        JFrame fr = new ThemSPGUI(p);
        fr.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        fr.setLocationRelativeTo(null);
        fr.setVisible(true);
    }
}
