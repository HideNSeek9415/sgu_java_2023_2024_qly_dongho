package gui.dashboard;

import java.awt.BorderLayout;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

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
				{null, null, null, null, null, null, null, null},
			},
			new String[] {
				"M\u00E3 KH", "T\u00EAn kh\u00E1ch h\u00E0ng", " Gi\u1EDBi t\u00EDnh", "Ng\u00E0y sinh", "E-mail", "S\u1ED1 \u0111i\u1EC7n tho\u1EA1i", "T\u00E0i kho\u1EA3n", "M\u1EADt kh\u1EA9u"
			}
		));
		scrollPane.setViewportView(table);
	}

}
