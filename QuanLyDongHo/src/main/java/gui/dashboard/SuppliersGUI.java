package gui.dashboard;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.Font;

public class SuppliersGUI extends NewJPanel {

	private static final long serialVersionUID = 1L;
	private JScrollPane scrollPane;
	private JTable table;

	/**
	 * Create the panel.
	 */
	public SuppliersGUI() {
		pnContent.setLayout(new BorderLayout(0, 0));
		
		scrollPane = new JScrollPane();
		pnContent.add(scrollPane);
		
		table = new JTable();
		table.setRowHeight(25);
		table.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"NCC01", "Trường ĐH Sài Gòn", "273 An Dương Vương, Phường 3, Quận 5, TP HCM", "sgu@edu.com.vn", "0695912684"},
				{"NCC02", "CTTNHH MTV Bán Cái Đồng Hồ", "022 Financial Center Rd, Downtown Dubai, Dubai", "bdha@ko.ko", "0188923543"},
			},
			new String[] {
				"Mã NCC", "Tên nhà cung cấp", "Địa chỉ", "E-mail", "Số điện thoại"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(15);
		table.getColumnModel().getColumn(0).setMinWidth(10);
		table.getColumnModel().getColumn(1).setPreferredWidth(220);
		table.getColumnModel().getColumn(2).setPreferredWidth(240);
		table.getColumnModel().getColumn(3).setPreferredWidth(100);
		table.getColumnModel().getColumn(4).setPreferredWidth(100);
		scrollPane.setViewportView(table);
		designTitle();
	}
	
	private void designTitle() {
		// TODO Auto-generated method stub
		table.getTableHeader().setBackground(Color.decode("#f4c82d"));
		table.getTableHeader().setFont(table.getFont());
		
	}
	
	@Override
	protected void setAddEvent() {
		// TODO Auto-generated method stub
		JFrame fr = new JFrame();
		JPanel contentPane = new ThemNhaCungCap();
		fr.setContentPane(contentPane);
		fr.setBounds(10, 10, 761, 318);
		fr.setResizable(false);
		fr.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		fr.setLocationRelativeTo(null);
		fr.setVisible(true);
	}
	
	@Override
	protected void setDetailEvent() {
		JFrame fr = new SupplierDetails();
		fr.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		fr.setLocationRelativeTo(null);
		fr.setVisible(true);
	}

}
