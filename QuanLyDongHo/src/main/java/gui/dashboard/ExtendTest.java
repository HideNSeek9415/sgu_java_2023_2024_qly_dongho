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
		addFunction(new FunctionBtn(FunctionBtn.PRODUCT_PROPERTIES));
		addFunction(new FunctionBtn(FunctionBtn.WAREHOUSE));
		addFunction(new FunctionBtn(FunctionBtn.RECIEPTS));
		addFunction(new FunctionBtn(FunctionBtn.ORDERS));
		addFunction(new FunctionBtn(FunctionBtn.CUSTOMERS));
		addFunction(new FunctionBtn(FunctionBtn.SUPPLIES));
		addFunction(new FunctionBtn(FunctionBtn.EMPLOYEES));
		addFunction(new FunctionBtn(FunctionBtn.ACOOUNTS));
		addFunction(new FunctionBtn(FunctionBtn.STATISTICAL));
		addFunction(new FunctionBtn(FunctionBtn.PERMISSION));
		addFunction(new FunctionBtn(322));
		changeLabel("Bùi Trung Hiếu", "Admin");
	}

}
