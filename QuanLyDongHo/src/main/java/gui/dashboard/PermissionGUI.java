package gui.dashboard;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.FlowLayout;
import javax.swing.SwingConstants;
import java.awt.CardLayout;
import java.awt.Cursor;

public class PermissionGUI extends JPanel {

	private static final long serialVersionUID = 1L;
	private JPanel panel;
	private JPanel cards;
	private JPanel panel_2;
	private JPanel panel_3;
	private CardLayout cl_cards = new CardLayout(0, 0);
	private JLabel lblSLR = new JLabel();
	private JLabel lblWHM = new JLabel();
	private JPanel slrP = new PermissionTable(PermissionTable.SLR);
	private JPanel whmP = new PermissionTable(PermissionTable.WHM);

	/**
	 * Create the panel.
	 */
	public PermissionGUI() {

		setBorder(new EmptyBorder(20, 20, 20, 20));
		setPreferredSize(new Dimension(1150, 760));
		setBackground(new Color(240, 247, 250));
		setLayout(new BorderLayout(0, 0));
		
		panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		
		cards = new JPanel();
		cards.setOpaque(false);
		cards.setPreferredSize(new Dimension(7, 680));
		panel.add(cards, BorderLayout.SOUTH);
		cards.setLayout(cl_cards);
		slrP.setPreferredSize(new Dimension(10, 10));
		cards.add(slrP, "slr");
		cards.add(whmP, "whm");

		
		panel_2 = new JPanel();
		panel_2.setPreferredSize(new Dimension(10, 50));
		panel_2.setOpaque(false);
		panel_2.setBorder(new EmptyBorder(0, 10, 0, 0));
		panel.add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(new GridLayout(0, 4, 1, 0));
		lblSLR.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		lblSLR.setText("Nhân viên bán hàng");
		lblSLR.setForeground(new Color(255, 255, 255));
		lblSLR.setBackground(Color.decode("#295f2d"));
		lblSLR.setOpaque(true);
		lblSLR.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblSLR.setHorizontalAlignment(SwingConstants.CENTER);
		panel_2.add(lblSLR);
		lblWHM.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		
		lblWHM.setText("Người quản lý kho");
		lblWHM.setOpaque(true);
		lblWHM.setHorizontalAlignment(SwingConstants.CENTER);
		lblWHM.setForeground(Color.WHITE);
		lblWHM.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblWHM.setBackground(new Color(64, 128, 128));
		panel_2.add(lblWHM);
		
		panel_3 = new JPanel();
		panel_3.setOpaque(false);
		panel_3.setPreferredSize(new Dimension(350, 10));
		panel.add(panel_3, BorderLayout.EAST);
		panel_3.setLayout(new GridLayout(0, 1, 0, 0));
		
		loadEvent();
		
	}

	private void loadEvent() {
		// TODO Auto-generated method stub
		lblSLR.addMouseListener(new MouseAdapter() {
		    public void mouseClicked(MouseEvent e) {
		    	cl_cards.show(cards, "slr");
				lblWHM.setBackground(new Color(64, 128, 128));
				lblSLR.setBackground(Color.decode("#295f2d"));
		    }
		});
		lblWHM.addMouseListener(new MouseAdapter() {
		    public void mouseClicked(MouseEvent e) {
		    	cl_cards.show(cards, "whm");
				lblWHM.setBackground(Color.decode("#295f2d"));
				lblSLR.setBackground(new Color(64, 128, 128));
		    }
		});
	}

}
