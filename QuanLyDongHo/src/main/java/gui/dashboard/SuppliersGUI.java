package gui.dashboard;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import bll.SupplierBLL;
import dto.Supplier;

import java.awt.Font;
import java.util.ArrayList;

public class SuppliersGUI extends NewJPanel {

	private static final long serialVersionUID = 1L;
	private JScrollPane scrollPane;
	private JTable table;
	private DefaultTableModel model;

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
				{"NCC01", "Trường ĐH Sài Gòn", "sgu@edu.com.vn", "0695912684"},
				{"NCC02", "CTTNHH MTV Bán Cái Đồng Hồ", "bdha@ko.ko", "0188923543"},
			},
			new String[] {
				"Mã NCC", "Tên nhà cung cấp", "E-mail", "Số điện thoại"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(15);
		table.getColumnModel().getColumn(0).setMinWidth(10);
		table.getColumnModel().getColumn(1).setPreferredWidth(220);
		table.getColumnModel().getColumn(2).setPreferredWidth(240);
		table.getColumnModel().getColumn(3).setPreferredWidth(100);
		scrollPane.setViewportView(table);
		designTitle();
		model = (DefaultTableModel) table.getModel();
		reloadTable();
	}
	
	private void reloadTable() {
		// TODO Auto-generated method stub
		ArrayList<Supplier> suppliers = SupplierBLL.getSupplierList();
		model.setRowCount(0);
		for (Supplier supplier : suppliers) {
			Object[] data = {
				supplier.getSupplierId(),
				supplier.getSupplierName(),
				supplier.getEmail(),
				supplier.getPhoneNumber()
			};
			model.addRow(data);
		}
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
		int Sid = (Integer) table.getValueAt(table.getSelectedRow(), 0);
		SupplierDetails.selectedSupplier = SupplierBLL.getByID(Sid);
		JFrame fr = new SupplierDetails();
		fr.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		fr.setLocationRelativeTo(null);
		fr.setVisible(true);
	}

}
