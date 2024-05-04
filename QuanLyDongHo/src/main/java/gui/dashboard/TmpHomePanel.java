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
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.awt.FlowLayout;
import javax.swing.JScrollPane;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ScrollPaneConstants;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.border.TitledBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;
import javax.swing.SpinnerNumberModel;
import javax.swing.JCheckBox;

public class TmpHomePanel extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private JPanel panel;
	private JPanel panel_2;
	private JLabel lblNewLabel;
	private JPanel panel_3;
	private JPanel panel_1;
	private JButton btnCart;
	private JLabel lblNewLabel_1;
	private JPanel panel_4;
	private JPanel panel_5;
	private JButton btnSearch;
	private JTextField textField;
	private JComboBox<String> cbbType;
	private JComboBox<String> cbbBrand;
	private JLabel lblNewLabel_2;
	private JSpinner cpMin;
	private JLabel lblNewLabel_3;
	private JSpinner cpMax;
	private JTabbedPane tabbedPane;
	private JPanel panel_6;
	private JButton btnReload;
	private JCheckBox chkDiscount;

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
		
		btnSearch = new JButton("");
		btnSearch.setPreferredSize(new Dimension(30, 30));
		btnSearch.setForeground(Color.WHITE);
		btnSearch.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnSearch.setFocusPainted(false);
		btnSearch.setBorder(new EmptyBorder(15, 0, 15, 0));
		btnSearch.setBackground(new Color(64, 128, 128));
		btnSearch.setIcon(FontIcon.of(MaterialDesignM.MAGNIFY, 15, btnSearch.getForeground()));

		panel_5.add(btnSearch);
		
		textField = new JTextField();
		textField.setPreferredSize(new Dimension(200, 28));
		panel_5.add(textField);
		
		cbbType = new JComboBox<String>();
		cbbType.setModel(new DefaultComboBoxModel<>(new String[] {"Loại đồng hồ", "Đồng hồ cơ", "Đồng hồ điện tử", "Đồng hồ thông minh"}));
		cbbType.setBackground(new Color(255, 255, 255));
		cbbType.setPreferredSize(new Dimension(120, 26));
		panel_5.add(cbbType);
		
		cbbBrand = new JComboBox<String>();
		cbbBrand.setModel(new DefaultComboBoxModel<>(new String[] {"Thương hiệu", "CASIO", "ORIENT", "APPLE", "CITIZEN"}));
		cbbBrand.setBackground(new Color(255, 255, 255));
		cbbBrand.setPreferredSize(new Dimension(120, 26));
		panel_5.add(cbbBrand);
		
		chkDiscount = new JCheckBox("Giảm giá");
		chkDiscount.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panel_5.add(chkDiscount);
		
		panel_4 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_4.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		panel_4.setOpaque(false);
		panel_2.add(panel_4);
		
		lblNewLabel_2 = new JLabel("Giá từ: ");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_4.add(lblNewLabel_2);
		
		cpMin = new JSpinner();
		cpMin.setModel(new SpinnerNumberModel(0, 0, 999900000, 100000));
		cpMin.setPreferredSize(new Dimension(150, 28));
		panel_4.add(cpMin);
		
		lblNewLabel_3 = new JLabel("Đến:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_4.add(lblNewLabel_3);
		
		cpMax = new JSpinner();
		cpMax.setModel(new SpinnerNumberModel(0, 0, 999900000, 100000));
		cpMax.setPreferredSize(new Dimension(150, 28));
		panel_4.add(cpMax);
		
		btnReload = new JButton("Đặt lại");
		btnReload.setFont(new Font("Tahoma", Font.BOLD, 12));
		panel_4.add(btnReload);
		
		lblNewLabel = new JLabel("Bạn muốn mua gì?");
		lblNewLabel.setFont(new Font("SansSerif", Font.BOLD, 17));
		panel.add(lblNewLabel, BorderLayout.WEST);
		
		panel_3 = new JPanel();
		panel_3.setOpaque(false);
		panel.add(panel_3, BorderLayout.WEST);
		panel_3.setLayout(new GridLayout(0, 1, 0, 0));
		
		lblNewLabel_1 = new JLabel("Bạn muốn mua gì?");
		lblNewLabel_1.setFont(new Font("SansSerif", Font.BOLD, 18));
		panel_3.add(lblNewLabel_1);
		
		panel_1 = new JPanel();
		panel_1.setOpaque(false);
		panel.add(panel_1, BorderLayout.EAST);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		btnCart = new JButton("");
		btnCart.setPreferredSize(new Dimension(50, 50));
		btnCart.setForeground(Color.WHITE);
		btnCart.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnCart.setFocusPainted(false);
		btnCart.setBorder(new EmptyBorder(15, 0, 15, 0));
		btnCart.setBackground(new Color(255, 128, 64));
		btnCart.setIcon(FontIcon.of(MaterialDesignC.CART, 25, btnCart.getForeground()));

		panel_1.add(btnCart);
		
		tabbedPane = new JTabbedPane(JTabbedPane.BOTTOM);
		tabbedPane.setBackground(new Color(255, 255, 255));
		add(tabbedPane, BorderLayout.CENTER);
		
		panel_6 = new JPanel();
		panel_6.setOpaque(false);
		tabbedPane.addTab("1", null, panel_6, null);
		
		reloadPanel();
		addEvent();

	}
	
	private ArrayList<Product> filter(ArrayList<Product> products, Predicate<Product> condition) {
		return (ArrayList<Product>) products.stream().filter(condition).collect(Collectors.toList());
	}
	
	private void searchEvent() {
		ArrayList<Product> products = ProductDAO.getInstance().readAllData();
		
		String searchText = textField.getText().trim().toLowerCase();
		String selectedCategory = (String) cbbType.getSelectedItem();
		String selectedBrand = (String) cbbBrand.getSelectedItem();
		int minV = (int) cpMin.getValue();
		int maxV = (int) cpMax.getValue();
		boolean isdiscountselected = chkDiscount.isSelected();

		products = filter(products, product -> maxV == 0 || (product.isDiscount() ? product.getDiscountPrice() <= maxV : product.getSellPrice() <= maxV));		
		products = filter(products, product -> minV == 0 || product.isDiscount() ? product.getDiscountPrice() >= minV : product.getSellPrice() >= minV);
		products = filter(products, product -> searchText.isBlank() || product.getProductName().toLowerCase().contains(searchText));
		products = filter(products, product -> selectedCategory.equals("Loại đồng hồ") || product.getCategory().equalsIgnoreCase(selectedCategory));
		products = filter(products, product -> selectedBrand.equals("Thương hiệu") || product.getBrand().equalsIgnoreCase(selectedBrand));
		products = filter(products, product -> !isdiscountselected || product.isDiscount());
		
		
		if (products.size() == 0) {
			JOptionPane.showMessageDialog(null, "Không tìm thấy sản phẩm đủ điều kiện", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
		} else {			
			filterPrdInPanel(products);
		}
	}
	
	private void filterPrdInPanel(ArrayList<Product> products) {
		int productPerPage = 10;
		tabbedPane.removeAll();
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
		
		for (int i = 0; i < products.size(); i++) {
			JPanel prdpn = new ProductDisplay(products.get(i));
			((JPanel) pnPrd[i/productPerPage].getComponent(i%productPerPage)).add(prdpn);
		}
	}

	
	private void addEvent() {
		btnReload.addActionListener(e -> {
			reloadPanel();
			textField.setText("");
			cbbType.setSelectedIndex(0);
			cbbBrand.setSelectedIndex(0);
			cpMin.setValue(0);
			cpMax.setValue(0);
			chkDiscount.setSelected(false);
		});
		btnSearch.addActionListener(e -> searchEvent());
		btnCart.addActionListener(e -> {
			JFrame fr = new zShoppingCartFrame();
			fr.setLocationRelativeTo(null);
			fr.setVisible(true);
			fr.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		});
	}
	
	

	public void reloadPanel() {
		// TODO Auto-generated method stub
		ArrayList<Product> products = ProductDAO.getInstance().readAllData();
		int productPerPage = 10;
		tabbedPane.removeAll();
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
		
		for (int i = 0; i < products.size(); i++) {
			JPanel prdpn = new ProductDisplay(products.get(i));
			((JPanel) pnPrd[i/productPerPage].getComponent(i%productPerPage)).add(prdpn);
		}
	}
}
