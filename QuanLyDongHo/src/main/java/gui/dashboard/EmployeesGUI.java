package gui.dashboard;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

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
				{"NV001", "Nh\u00E2n Vi\u00EAn 1", "Nam", "4/4/2003", "020232251", "Smaw, KDW, Freadk"},
				{"NV002", "Nh\u00E2n Vi\u00EAn 2", "N\u1EEF", "5/5/2000", "012515648", "Ndif, Fpekf, Kofiesnf"},
				{"NV003", "Nh\u00E2n Vi\u00EAn 3", "Nam", "3/3/1999", "039481274", "JFIe, Ifiejos, JFIe"},
			},
			new String[] {
				"M\u00E3 NV", "T\u00EAn NV", "Gi\u1EDBi t\u00EDnh", "Ng\u00E0y sinh", "S\u0110T", "\u0110\u1ECBa ch\u1EC9"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(15);
		table.getColumnModel().getColumn(1).setPreferredWidth(150);
		table.getColumnModel().getColumn(2).setPreferredWidth(30);
		table.getColumnModel().getColumn(3).setPreferredWidth(40);
		scrollPane.setViewportView(table);

	}

}
