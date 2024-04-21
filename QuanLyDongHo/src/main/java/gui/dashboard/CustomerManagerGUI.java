package gui.dashboard;

import java.awt.BorderLayout;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import dao.CustomerDAO;
import dto.Customer;

public class CustomerManagerGUI extends NewJPanel {

	private static final long serialVersionUID = 1L;
	private JTable table;

	/**
	 * Create the panel.
	 */
	public CustomerManagerGUI() {
		pnContent.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		pnContent.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, "", null},
			},
			new String[] {
				"M\u00E3 KH", "T\u00EAn kh\u00E1ch h\u00E0ng", " Gi\u1EDBi t\u00EDnh", "Ng\u00E0y sinh", "S\u1ED1 \u0111i\u1EC7n tho\u1EA1i", "\u0110\u1ECBa ch\u1EC9"
			}
		));
		scrollPane.setViewportView(table);
		reloadTable();
	}

	private void reloadTable() {
		// TODO Auto-generated method stub
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.setRowCount(0);
		ArrayList<Customer> customers = CustomerDAO.getInstance().readAllData();
		for (Customer customer: customers) {
			Object[] data = {
				customer.getId(),
				customer.getFullName(),
				customer.getGender().equals("male") ? "Nam" : "Nữ",
				(new SimpleDateFormat("dd/MM/yyyy")).format(customer.getDateOfBirth()),
				customer.getPhoneNumber(),
				customer.getAddress()
			};
			model.addRow(data);
		}
	}

}
