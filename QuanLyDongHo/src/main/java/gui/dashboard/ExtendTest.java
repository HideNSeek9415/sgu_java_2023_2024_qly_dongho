package gui.dashboard;

import java.awt.EventQueue;

import javax.swing.UIManager;

public class ExtendTest extends DashboardFrame {

	private static final long serialVersionUID = 1L;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
					ExtendTest frame = new ExtendTest();
					frame.setVisible(true);
//					gui.ShowMsg.showValidationMsg("Xác nhận thông tin thành công", frame);
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
		addFunction(new FunctionBtn(FunctionBtn.ACCOUNTS));
		addFunction(new FunctionBtn(FunctionBtn.STATISTICAL));
		addFunction(new FunctionBtn(FunctionBtn.PERMISSION));
		addFunction(new FunctionBtn(FunctionBtn.WARRANTY));
		addFunction(new FunctionBtn(FunctionBtn.HISTORY));
		addFunction(new FunctionBtn(""));
		changeLabel("Bùi Trung Hiếu", "Admin");
	}

}
