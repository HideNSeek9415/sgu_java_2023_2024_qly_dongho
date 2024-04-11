package gui.dashboard;

import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Color;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.metal.MetalScrollPaneUI;

import dao.ProductDAO;
import dto.Product;

import java.awt.GridLayout;
import java.awt.event.*;
import java.util.ArrayList;
import java.awt.FlowLayout;
import javax.swing.JScrollPane;
import javax.swing.BoxLayout;
import javax.swing.ScrollPaneConstants;

public class TmpHomePanel extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private int row = 4;
	private int col = 4;
	private JScrollPane scrollPane;
	private JPanel panel;

	/**
	 * Create the panel.
	 */
	public TmpHomePanel() {
		setBorder(new EmptyBorder(25, 25, 25, 25));
		setBackground(new Color(255, 255, 255));
		setPreferredSize(new Dimension(1150, 800));
		setLayout(new GridLayout(1, 0, 0, 0));
		
		scrollPane = new JScrollPane();
		scrollPane.setBorder(null);
		add(scrollPane);
		
		panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBorder(new EmptyBorder(10, 10, 10, 10));
		scrollPane.setViewportView(panel);
		panel.setLayout(new GridLayout(4, 4, 10, 10));
		
		addStuff();

	}

	private void addStuff() {
		// TODO Auto-generated method stub
		ArrayList<Product> products = ProductDAO.getInstance().readAllData();
		for (Product product : products) {
			JPanel prdpn = new ProductDisplay(product);
			prdpn.setPreferredSize(new Dimension(240, 350));
			prdpn.setMinimumSize(new Dimension(240, 350));
			prdpn.setMinimumSize(new Dimension(240, 350));
			prdpn.setSize(new Dimension(240, 320));
			panel.add(prdpn);
		}
	}
}
