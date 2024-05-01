package gui.dashboard;

import java.awt.EventQueue;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import bll.SupplierBLL;
import dto.Supplier;

import java.awt.Dimension;

public class SuaNhaCungCap extends ThemNhaCungCap{
	protected JTable table;
	private JFrame frame;
	protected int selectedRow;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SuaNhaCungCap window = new SuaNhaCungCap();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SuaNhaCungCap() {
		initialize();
		
//		setTable(super.getTable());
		txtNCC.setText("Sửa nhà cung cấp");
		removeActionListener();
		btnThem.setText("Sửa đơn vị");
		
		selectedRow = table.getSelectedRow();
		nhapTenNCC.setText(table.getValueAt(selectedRow, 1).toString());
		nhapEmail.setText(table.getValueAt(selectedRow, 2).toString());
		nhapSDT.setText(table.getValueAt(selectedRow, 4).toString());
		
		btnThem.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				btnThemActionPerformed(e);
			}
		});
	}
	
	public SuaNhaCungCap(JTable table) {
		initialize();
		
		setTable(table);
		txtNCC.setText("Sửa nhà cung cấp");
		removeActionListener();
		btnThem.setText("Sửa đơn vị");
		
		selectedRow = table.getSelectedRow();
		nhapTenNCC.setText(table.getValueAt(selectedRow, 1).toString());
		nhapEmail.setText(table.getValueAt(selectedRow, 2).toString());
		nhapSDT.setText(table.getValueAt(selectedRow, 4).toString());
		
		btnThem.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				btnThemActionPerformed(e);
			}
		});
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setPreferredSize(new Dimension(761, 500));
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	@Override
	public JTable getTable() {
		return table;
	}
	
	@Override
	public void setTable(JTable table) {
		this.table = table;
	}

	public void removeActionListener() {
		ActionListener[] listeners = btnThem.getActionListeners();
        for (ActionListener listener : listeners) {
            btnThem.removeActionListener(listener);
        }
	}
	
	private void btnThemActionPerformed(ActionEvent e){
		boolean emptyInput = false;
		boolean checkValid = true;
		int id = Integer.parseInt(table.getValueAt(selectedRow, 0).toString());
		if (nhapTenNCC.getText().equals("")) {
			supNameErrorMsg.setText("Tên nhà cung cấp không được để trống");
			emptyInput = true;
		}
		else if(SupplierBLL.getInstance().isDuplicate(id, "supplier_name", nhapTenNCC.getText())) {
			supNameErrorMsg.setText("Tên nhà cung cấp đã tồn tại");
			checkValid=false;
		}
		
		if (nhapEmail.getText().equals("")) {
			supEmailErrorMsg.setText("Email không được để trống");
			emptyInput = true;
		}
		else if(SupplierBLL.getInstance().isDuplicate(id, "email", nhapEmail.getText())) {
			supEmailErrorMsg.setText("Email đã tồn tại");
			checkValid=false;
		}
		else if (!CheckValid.isValidEmail(nhapEmail.getText())) {
			checkValid=false;
			supEmailErrorMsg.setText("Vui lòng nhập đúng định dạng email");
		}
		
		if (nhapSDT.getText().equals("")) {
			supPhoneErrorMsg.setText("Số điện thoại không được để trống");
			emptyInput = true;
		}
		else if(!CheckValid.isValidPhoneNumber(nhapSDT.getText())) {
			checkValid=false;
			supPhoneErrorMsg.setText("Số điện thoại phải đủ 10 chữ số và bắt đầu bằng số 0");
		}
		else if(SupplierBLL.getInstance().isDuplicate(id, "phone_number", nhapSDT.getText())) {
			supPhoneErrorMsg.setText("Số điện thoại đã tồn tại");
			checkValid=false;
		}

		if (!emptyInput && checkValid) {
				Supplier sp = new Supplier(id, nhapTenNCC.getText(), nhapEmail.getText(), "active", nhapSDT.getText());
    			//Thêm nhà cung cấp sau khi chỉnh sửa và đưa vào database
    			if(SupplierBLL.getInstance().editSupplier(id, sp) == false)
    				JOptionPane.showMessageDialog(rootPane, "Lỗi khi sửa và đưa vào database");
    			else {
        			reloadTable();
        			JOptionPane.showMessageDialog(getRootPane(), "Sửa nhà cung cấp thành công");
        			this.dispose();
    			}
		}
	}
	
	@Override
	protected void reloadTable() {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.setRowCount(0);
		ArrayList<Supplier> datas = SupplierBLL.getInstance().readAllData();
		for (Supplier data: datas) {
			if(data.getSupplierStatus().equals("active")) {
				Object[] rowData = {data.getSupplierId(), data.getSupplierName(), data.getEmail(), data.getSupplierStatus(), data.getPhoneNumber()};
				model.addRow(rowData);
			}
		}
	}
}
