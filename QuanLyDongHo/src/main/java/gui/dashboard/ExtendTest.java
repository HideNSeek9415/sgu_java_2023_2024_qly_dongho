package gui.dashboard;

import java.awt.EventQueue;

import javax.swing.UIManager;

import system.ConfigPRJ;

public class ExtendTest extends DashboardFrame {

	private static final long serialVersionUID = 1L;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					System.out.println("câu chuyện về một chú cáo nâu nhanh nhẹn nhảy qua chú chó lười biếng");
					UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
					ExtendTest frame = new ExtendTest();	
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	
	public ExtendTest() {
		super();
		addFunction(new FunctionBtn(FunctionBtn.PRODUCTS));
		addFunction(new FunctionBtn(FunctionBtn.RECEIPTS));
		addFunction(new FunctionBtn(FunctionBtn.ORDERS));
		addFunction(new FunctionBtn(FunctionBtn.CUSTOMERS));
		addFunction(new FunctionBtn(FunctionBtn.SUPPLIERS));
		addFunction(new FunctionBtn(FunctionBtn.EMPLOYEES));
		addFunction(new FunctionBtn(FunctionBtn.STATISTICAL));
		addFunction(new FunctionBtn(FunctionBtn.PERMISSION));
		addFunction(new FunctionBtn(FunctionBtn.WARRANTY));
		addFunction(new FunctionBtn(FunctionBtn.HISTORY));
		addFunction(new FunctionBtn(""));
		changeLabel(ConfigPRJ.currentUser.getFullName(), ConfigPRJ.currentUser.getAccount().getRoleName());
		ConfigPRJ.loadPermission("ADM");
	}

}
