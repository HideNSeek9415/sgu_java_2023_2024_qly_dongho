package gui.dashboard;

import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Color;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.FlowLayout;

public class TmpHomePanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JPanel panel;
	
	private int row = 2;
	private int col = 4;

	/**
	 * Create the panel.
	 */
	public TmpHomePanel() {
		setBorder(new EmptyBorder(25, 25, 25, 25));
		setBackground(new Color(255, 255, 255));
		setPreferredSize(new Dimension(1150, 800));
		setLayout(new GridLayout(1, 0, 0, 0));
		
		panel = new JPanel();
		panel.setOpaque(false);
		add(panel);
		panel.setLayout(new FlowLayout(FlowLayout.LEFT, 15, 15));
		
		addStuff();

	}

	private void addStuff() {
		// TODO Auto-generated method stub
		for (int i = 1; i <= row*col; i++) {
			JPanel prdpn = new ProductDisplay();
			prdpn.setPreferredSize(new Dimension(240, 320));
			prdpn.setMinimumSize(new Dimension(240, 320));
			prdpn.setMinimumSize(new Dimension(240, 320));
			prdpn.setSize(new Dimension(240, 320));
			panel.add(prdpn);
		}
	}
}
