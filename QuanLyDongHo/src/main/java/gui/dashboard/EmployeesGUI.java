package gui.dashboard;
import java.awt.BorderLayout;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import dao.EmployeeDAO;
import dto.Employee;
import system.ConfigPRJ;

public class EmployeesGUI extends NewJPanel {

	private static final long serialVersionUID = 1L;
	private JScrollPane scrollPane;
	private JTable table;

	/**
	 * Create the panel.
	 */
	public EmployeesGUI() {
		pnContent.setLayout(new BorderLayout(0, 0));
		
		scrollPane = new JScrollPane();
		scrollPane.setOpaque(true);
		pnContent.add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Mã NV", "Tên NV", "Giới tính", "Ngày sinh", "SĐT", "Địa chỉ", "Vai trò", "Trạng thái"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(15);
		table.getColumnModel().getColumn(1).setPreferredWidth(150);
		table.getColumnModel().getColumn(2).setPreferredWidth(30);
		table.getColumnModel().getColumn(3).setPreferredWidth(40);
		scrollPane.setViewportView(table);
		reloadTable();
		btnDel.setVisible(false);
		btnEdit.setVisible(false);
		btnRecovery.setVisible(false);
		btnSearch.setVisible(false);
		btnReload.setVisible(false);
		txtSearch.setVisible(false);
	}
	
	public void reloadTable() {
		// TODO Auto-generated method stub
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.setRowCount(0);
		ArrayList<Employee> employees = EmployeeDAO.getInstance().readAllData();
		for (Employee employee: employees) {
			Object[] data = {
				employee.getId(),
				employee.getFullName(),
				employee.getGender(),
				(new SimpleDateFormat("dd/MM/yyyy")).format(employee.getDateOfBirth()),
				employee.getPhoneNumber(),
				employee.getAddress(),
				EmployeeDAO.getInstance().getRoleName(employee.getAccountId()),
				EmployeeDAO.getInstance().isActive(employee.getId()) ? "Đang hoạt động" : "Ngưng hoạt động"
			};
			model.addRow(data);
		}
	}

	@Override
	protected void setAddEvent() {
		if (!ConfigPRJ.shwMsg(ConfigPRJ.employee.get("add"))) return; 
		JFrame fr = new ThemNVGUI();
		fr.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		fr.setLocationRelativeTo(null);
		fr.setVisible(true);

	}
	
	@Override
	protected void setDetailEvent() {
		if (!ConfigPRJ.shwMsg(ConfigPRJ.employee.get("edit"))) return; 
		JFrame fr = new ThongTinNV((int) table.getValueAt(table.getSelectedRow(), 0));
		fr.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		fr.setLocationRelativeTo(null);
		fr.setVisible(true);

	}

}
