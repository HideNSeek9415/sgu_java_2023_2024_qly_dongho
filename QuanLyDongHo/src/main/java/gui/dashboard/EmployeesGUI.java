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
				{"NV001", "Nh\u00E2n Vi\u00EAn 1", "Nam", "4/4/2003", "020232251", "Smaw, KDW, Freadk", null},
				{"NV002", "Nh\u00E2n Vi\u00EAn 2", "N\u1EEF", "5/5/2000", "012515648", "Ndif, Fpekf, Kofiesnf", null},
				{"NV003", "Nh\u00E2n Vi\u00EAn 3", "Nam", "3/3/1999", "039481274", "JFIe, Ifiejos, JFIe", null},
			},
			new String[] {
				"M\u00E3 NV", "T\u00EAn NV", "Gi\u1EDBi t\u00EDnh", "Ng\u00E0y sinh", "S\u0110T", "\u0110\u1ECBa ch\u1EC9", "Vai tr\u00F2"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(15);
		table.getColumnModel().getColumn(1).setPreferredWidth(150);
		table.getColumnModel().getColumn(2).setPreferredWidth(30);
		table.getColumnModel().getColumn(3).setPreferredWidth(40);
		scrollPane.setViewportView(table);
		reloadTable();

	}
	
	private void reloadTable() {
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
				EmployeeDAO.getInstance().getRoleName(employee.getAccountId())
			};
			model.addRow(data);
		}
	}

	@Override
	protected void setAddEvent() {
		JFrame fr = new ThemNVGUI();
		fr.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		fr.setLocationRelativeTo(null);
		fr.setVisible(true);

	}

}
