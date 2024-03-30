package gui.dashboard;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.Font;

public class ProductManagerGUI extends NewJPanel {

	private static final long serialVersionUID = 1L;
	private JScrollPane scrollPane;
	private JTable table;

	/**
	 * Create the panel.
	 */
	public ProductManagerGUI() {
		pnContent.setLayout(new BorderLayout(0, 0));
		
		scrollPane = new JScrollPane();
		scrollPane.setFont(new Font("Tahoma", Font.PLAIN, 14));
		pnContent.add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		table.setRowHeight(25);
		table.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"DH001", "Đồng hồ Casio sang trọng dành cho người giàu", "20", "Đồng hồ cơ", "CASIO", "Đồng hồ Nam", "Bạch kim"},
				{"DH002", "Đồng hồ Rolex FLEXIBLE dành cho người nghèo", "50", "Đồng hồ điện giật", "ROLEX", "Đồng hồ Nữ", "Vàng"},
				{"DH003", "Đồng hồ Cartier là hãng nào tui cũng không biết", "10", "Đồng hồ thông minh", "CARTIER", "Đồng lõa", "Tím lịm"},
			},
			new String[] {
				"Mã SP", "Tên sản phẩm", "Tồn kho", "Loại sản phẩm", "Thương hiệu", "Kiểu dáng", "Màu"
			}
		) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			Class[] columnTypes = new Class[] {
				Object.class, String.class, String.class, Object.class, Object.class, Object.class, Object.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(0).setPreferredWidth(70);
		table.getColumnModel().getColumn(0).setMaxWidth(1400);
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(1).setPreferredWidth(320);
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
		scrollPane.setViewportView(table);
		
		designTitle();

	}
		

	private void designTitle() {
		// TODO Auto-generated method stub
		table.getTableHeader().setBackground(Color.decode("#f4c82d"));
		table.getTableHeader().setFont(table.getFont());
		
	}

}
