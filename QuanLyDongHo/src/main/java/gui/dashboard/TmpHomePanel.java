package gui.dashboard;

import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Color;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.metal.MetalScrollPaneUI;

import org.kordamp.ikonli.materialdesign2.MaterialDesignA;
import org.kordamp.ikonli.materialdesign2.MaterialDesignC;
import org.kordamp.ikonli.materialdesign2.MaterialDesignM;
import org.kordamp.ikonli.swing.FontIcon;

import dao.ProductDAO;
import dto.Product;

import java.awt.GridLayout;
import java.awt.event.*;
import java.util.ArrayList;
import java.awt.FlowLayout;
import javax.swing.JScrollPane;
import javax.swing.BoxLayout;
import javax.swing.ScrollPaneConstants;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.border.TitledBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;

public class TmpHomePanel extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private int row = 4;
	private int col = 4;
	private JPanel panel;
	private JPanel panel_2;
	private JLabel lblNewLabel;
	private JPanel panel_3;
	private JPanel panel_1;
	private JButton btnNewButton;
	private JLabel lblNewLabel_1;
	private JPanel panel_4;
	private JPanel panel_5;
	private JButton btnNewButton_1;
	private JTextField textField;
	private JComboBox comboBox;
	private JComboBox comboBox_1;
	private JLabel lblNewLabel_2;
	private JSpinner spinner;
	private JLabel lblNewLabel_3;
	private JSpinner spinner_1;
	private JTabbedPane tabbedPane;
	private JPanel panel_6;

	/**
	 * Create the panel.
	 */
	public TmpHomePanel() {
		setBorder(new EmptyBorder(25, 25, 10, 25));
		setBackground(new Color(255, 255, 255));
		setPreferredSize(new Dimension(1150, 800));
		setLayout(new BorderLayout(0, 0));
		
		panel = new JPanel();
		panel.setOpaque(false);
		panel.setPreferredSize(new Dimension(10, 75));
		add(panel, BorderLayout.NORTH);
		panel.setLayout(new BorderLayout(0, 0));
		
		panel_2 = new JPanel();
		panel_2.setBorder(new EmptyBorder(0, 30, 0, 0));
		panel_2.setOpaque(false);
		panel.add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(new GridLayout(2, 1, 0, 0));
		
		panel_5 = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel_5.getLayout();
		flowLayout_1.setAlignment(FlowLayout.RIGHT);
		panel_5.setOpaque(false);
		panel_2.add(panel_5);
		
		btnNewButton_1 = new JButton("");
		btnNewButton_1.setPreferredSize(new Dimension(30, 30));
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnNewButton_1.setFocusPainted(false);
		btnNewButton_1.setBorder(new EmptyBorder(15, 0, 15, 0));
		btnNewButton_1.setBackground(new Color(64, 128, 128));
		btnNewButton_1.setIcon(FontIcon.of(MaterialDesignM.MAGNIFY, 15, btnNewButton_1.getForeground()));

		panel_5.add(btnNewButton_1);
		
		textField = new JTextField();
		textField.setPreferredSize(new Dimension(200, 28));
		panel_5.add(textField);
		
		comboBox = new JComboBox();
		comboBox.setBackground(new Color(255, 255, 255));
		comboBox.setPreferredSize(new Dimension(120, 26));
		panel_5.add(comboBox);
		
		comboBox_1 = new JComboBox();
		comboBox_1.setBackground(new Color(255, 255, 255));
		comboBox_1.setPreferredSize(new Dimension(120, 26));
		panel_5.add(comboBox_1);
		
		panel_4 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_4.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		panel_4.setOpaque(false);
		panel_2.add(panel_4);
		
		lblNewLabel_2 = new JLabel("Giá từ: ");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_4.add(lblNewLabel_2);
		
		spinner = new JSpinner();
		spinner.setPreferredSize(new Dimension(150, 28));
		panel_4.add(spinner);
		
		lblNewLabel_3 = new JLabel("Đến:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_4.add(lblNewLabel_3);
		
		spinner_1 = new JSpinner();
		spinner_1.setPreferredSize(new Dimension(150, 28));
		panel_4.add(spinner_1);
		
		lblNewLabel = new JLabel("Bạn muốn mua gì?");
		lblNewLabel.setFont(new Font("SansSerif", Font.BOLD, 17));
		panel.add(lblNewLabel, BorderLayout.WEST);
		
		panel_3 = new JPanel();
		panel_3.setOpaque(false);
		panel.add(panel_3, BorderLayout.WEST);
		panel_3.setLayout(new GridLayout(1, 0, 0, 0));
		
		lblNewLabel_1 = new JLabel("Bạn muốn mua gì?");
		lblNewLabel_1.setFont(new Font("SansSerif", Font.BOLD, 18));
		panel_3.add(lblNewLabel_1);
		
		panel_1 = new JPanel();
		panel_1.setBorder(new EmptyBorder(21, 0, 21, 0));
		panel_1.setOpaque(false);
		panel.add(panel_1, BorderLayout.EAST);
		panel_1.setLayout(new GridLayout(0, 1, 0, 0));
		
		btnNewButton = new JButton("Giỏ hàng");
		btnNewButton.setPreferredSize(new Dimension(105, 35));
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnNewButton.setFocusPainted(false);
		btnNewButton.setBorder(new EmptyBorder(15, 0, 15, 0));
		btnNewButton.setBackground(new Color(255, 128, 64));
		btnNewButton.setIcon(FontIcon.of(MaterialDesignC.CART, 18, btnNewButton.getForeground()));

		panel_1.add(btnNewButton);
		
		tabbedPane = new JTabbedPane(JTabbedPane.BOTTOM);
		tabbedPane.setBackground(new Color(255, 255, 255));
		add(tabbedPane, BorderLayout.CENTER);
		
		panel_6 = new JPanel();
		panel_6.setOpaque(false);
		tabbedPane.addTab("1", null, panel_6, null);
		
		reloadPanel();

	}

	private void reloadPanel() {
		// TODO Auto-generated method stub
		int productPerPage = 10;
		tabbedPane.removeAll();
		ArrayList<Product> products = ProductDAO.getInstance().readAllData();
		int numberOfPage = products.size()/productPerPage + 1;
		JPanel[] pnPrd = new JPanel[numberOfPage];
		for (int i = 0; i < numberOfPage; i++) {
			pnPrd[i] = new JPanel();
			pnPrd[i].setOpaque(false);
			pnPrd[i].setLayout(new GridLayout(2, 5, 0, 0));
			for (int j = 0; j < productPerPage; j++) {
				JPanel pn = new JPanel();
				pn.setOpaque(false);
				pnPrd[i].add(pn);
			}
			tabbedPane.addTab(String.valueOf(i + 1), null, pnPrd[i], null);
		}
		
//		for (Product product : products) {
//			JPanel prdpn = new ProductDisplay(product);
//			prdpn.setPreferredSize(new Dimension(240, 350));
//			prdpn.setMinimumSize(new Dimension(240, 350));
//			prdpn.setMinimumSize(new Dimension(240, 350));
//			prdpn.setSize(new Dimension(240, 320));
//			panel.add(prdpn);
//		}
		
		for (int i = 0; i < products.size(); i++) {
			JPanel prdpn = new ProductDisplay(products.get(i));
			((JPanel) pnPrd[i/productPerPage].getComponent(i%productPerPage)).add(prdpn);
		}
	}
}
