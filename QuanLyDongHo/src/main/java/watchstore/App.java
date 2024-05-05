package watchstore;


import javax.swing.UIManager;
import gui.login.*;

public class App {
	public static void main(String[] args) throws Exception {
		UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		(new LoginGUI()).setVisible(true);

	}
}