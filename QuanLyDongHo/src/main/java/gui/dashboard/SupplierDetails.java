package gui.dashboard;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import java.awt.Color;
import java.awt.Font;
import javax.swing.BoxLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTabbedPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;

import org.kordamp.ikonli.materialdesign2.MaterialDesignF;
import org.kordamp.ikonli.materialdesign2.MaterialDesignM;
import org.kordamp.ikonli.materialdesign2.MaterialDesignS;
import org.kordamp.ikonli.swing.FontIcon;
import javax.swing.JFileChooser;

public class SupplierDetails extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel panel;
	private JPanel panel_2;
	private JLabel lblNewLabel;
	private JLabel lblSupplierName;
	private JLabel lblNewLabel_1;
	private JScrollPane scrollPane;
	private JTable table;
	private JTabbedPane tabbedPane;
	private JPanel pnAvailable;
	private JPanel pnNew;
	private JPanel panel_1;
	private JLabel lblNewLabel_2;
	private JPanel panel_3;
	private JButton btnSearch;
	private JTextField searchById;
	private JPanel panel_4;
	private JLabel lblNewLabel_3;
	private JLabel lblPrdName;
	private JPanel panel_5;
	private JLabel lblNewLabel_5;
	private JLabel lblPrdType;
	private JPanel panel_6;
	private JLabel lblNewLabel_7;
	private JLabel lblPrdBrand;
	private JPanel panel_7;
	private JPanel panel_9;
	private JButton btnAddPrd;
	private JPanel panel_10;
	private JLabel lblNewLabel_9;
	private JTextField txtNewPrdName;
	private JPanel panel_11;
	private JLabel lblNewLabel_10;
	private JComboBox cbbPrdType;
	private JPanel panel_12;
	private JLabel lblNewLabel_11;
	private JComboBox cbbPrdBrand;
	private JPanel panel_13;
	private JLabel lblNewLabel_4;
	private JPanel panel_14;
	private JPanel panel_16;
	private JButton btnAddNewPrd;
	private JPanel panel_17;
	private JTextField textField;
	private JButton btnUrl;
	private JPanel panel_8;
	private JButton btnExit1;
	private JPanel panel_15;
	private JButton btnExit2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
					SupplierDetails frame = new SupplierDetails();
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
	public SupplierDetails() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 910, 602);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(null);

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		panel = new JPanel();
		panel.setForeground(new Color(255, 255, 255));
		panel.setBackground(new Color(22, 122, 198));
		panel.setBorder(new EmptyBorder(0, 10, 0, 0));
		panel.setPreferredSize(new Dimension(10, 50));
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(new BorderLayout(0, 0));
		
		lblNewLabel = new JLabel("Nhà cung cấp: ");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("SansSerif", Font.BOLD, 20));
		panel.add(lblNewLabel, BorderLayout.WEST);
		
		lblSupplierName = new JLabel("Trường ĐH Sài Gòn");
		lblSupplierName.setForeground(Color.WHITE);
		lblSupplierName.setFont(new Font("SansSerif", Font.BOLD, 20));
		panel.add(lblSupplierName, BorderLayout.CENTER);
		
		panel_2 = new JPanel();
		panel_2.setOpaque(false);
		contentPane.add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		lblNewLabel_1 = new JLabel("DANH SÁCH SẢN PHẨM");
		lblNewLabel_1.setPreferredSize(new Dimension(133, 30));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("SansSerif", Font.BOLD, 16));
		lblNewLabel_1.setOpaque(true);
		panel_2.add(lblNewLabel_1, BorderLayout.NORTH);
		
		scrollPane = new JScrollPane();
		scrollPane.setBackground(new Color(255, 255, 255));
		panel_2.add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
			},
			new String[] {
				"M\u00E3 s\u1EA3n ph\u1EA9m", "T\u00EAn s\u1EA3n ph\u1EA9m", "Ki\u1EC3u d\u00E1ng", "Th\u01B0\u01A1ng hi\u1EC7u"
			}
		));
		scrollPane.setViewportView(table);
		
		tabbedPane = new JTabbedPane(JTabbedPane.RIGHT);
		tabbedPane.setOpaque(true);
		tabbedPane.setPreferredSize(new Dimension(330, 0));
		contentPane.add(tabbedPane, BorderLayout.EAST);
		
		pnAvailable = new JPanel();
		tabbedPane.addTab("SP Có sẵn", null, pnAvailable, null);
		tabbedPane.setBackgroundAt(0, new Color(255, 255, 255));
		pnAvailable.setLayout(new GridLayout(7, 0, 0, 0));
		
		panel_1 = new JPanel();
		panel_1.setBorder(new EmptyBorder(0, 10, 0, 10));
		pnAvailable.add(panel_1);
		panel_1.setLayout(new GridLayout(2, 1, 0, 0));
		
		lblNewLabel_2 = new JLabel("Mã sản phẩm:");
		lblNewLabel_2.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel_2.setFont(new Font("SansSerif", Font.BOLD, 13));
		panel_1.add(lblNewLabel_2);
		
		panel_3 = new JPanel();
		panel_1.add(panel_3);
		panel_3.setLayout(new BorderLayout(0, 0));
		
		btnSearch = new JButton("");
		btnSearch.setPreferredSize(new Dimension(40, 28));
		btnSearch.setIcon(FontIcon.of(MaterialDesignM.MAGNIFY, 20, Color.black));
		panel_3.add(btnSearch, BorderLayout.EAST);
		
		searchById = new JTextField();
		searchById.setPreferredSize(new Dimension(25, 28));
		panel_3.add(searchById, BorderLayout.CENTER);
		searchById.setColumns(10);
		
		panel_4 = new JPanel();
		panel_4.setBorder(new EmptyBorder(0, 10, 0, 10));
		pnAvailable.add(panel_4);
		panel_4.setLayout(new GridLayout(2, 1, 0, 0));
		
		lblNewLabel_3 = new JLabel("Tên sản phẩm:");
		lblNewLabel_3.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel_3.setFont(new Font("SansSerif", Font.BOLD, 13));
		panel_4.add(lblNewLabel_3);
		
		lblPrdName = new JLabel("Sản phẩm có tên ABCDEF");
		panel_4.add(lblPrdName);
		
		panel_5 = new JPanel();
		panel_5.setBorder(new EmptyBorder(0, 10, 0, 10));
		pnAvailable.add(panel_5);
		panel_5.setLayout(new GridLayout(2, 1, 0, 0));
		
		lblNewLabel_5 = new JLabel("Loại đồng hồ");
		lblNewLabel_5.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel_5.setFont(new Font("SansSerif", Font.BOLD, 13));
		panel_5.add(lblNewLabel_5);
		
		lblPrdType = new JLabel("Sản phẩm có tên ABCDEF");
		panel_5.add(lblPrdType);
		
		panel_6 = new JPanel();
		panel_6.setBorder(new EmptyBorder(0, 10, 0, 10));
		pnAvailable.add(panel_6);
		panel_6.setLayout(new GridLayout(2, 1, 0, 0));
		
		lblNewLabel_7 = new JLabel("Thương hiệu");
		lblNewLabel_7.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel_7.setFont(new Font("SansSerif", Font.BOLD, 13));
		panel_6.add(lblNewLabel_7);
		
		lblPrdBrand = new JLabel("Sản phẩm có tên ABCDEF");
		panel_6.add(lblPrdBrand);
		
		panel_7 = new JPanel();
		pnAvailable.add(panel_7);
		
		panel_9 = new JPanel();
		panel_9.setBorder(new EmptyBorder(25, 30, 5, 30));
		pnAvailable.add(panel_9);
		panel_9.setLayout(new GridLayout(1, 0, 0, 0));
		
		btnAddPrd = new JButton("Thêm sản phẩm");
		btnAddPrd.setFocusPainted(false);
		btnAddPrd.setForeground(new Color(255, 255, 255));
		btnAddPrd.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnAddPrd.setBackground(new Color(0, 128, 0));
		panel_9.add(btnAddPrd);
		
		panel_8 = new JPanel();
		panel_8.setBorder(new EmptyBorder(5, 30, 25, 30));
		pnAvailable.add(panel_8);
		panel_8.setLayout(new GridLayout(1, 0, 0, 0));
		
		btnExit1 = new JButton("Hủy thao tác");
		btnExit1.setForeground(Color.WHITE);
		btnExit1.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnExit1.setFocusPainted(false);
		btnExit1.setBackground(new Color(128, 40, 26));
		panel_8.add(btnExit1);
		
		pnNew = new JPanel();
		tabbedPane.addTab("SP Mới\r\n", null, pnNew, null);
		pnNew.setLayout(new GridLayout(7, 0, 0, 0));
		
		panel_10 = new JPanel();
		panel_10.setBorder(new EmptyBorder(0, 10, 0, 10));
		pnNew.add(panel_10);
		panel_10.setLayout(new GridLayout(2, 1, 0, 0));
		
		lblNewLabel_9 = new JLabel("Tên sản phẩm:");
		lblNewLabel_9.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel_9.setFont(new Font("SansSerif", Font.BOLD, 13));
		panel_10.add(lblNewLabel_9);
		
		txtNewPrdName = new JTextField();
		panel_10.add(txtNewPrdName);
		txtNewPrdName.setColumns(10);
		
		panel_11 = new JPanel();
		panel_11.setBorder(new EmptyBorder(0, 10, 0, 10));
		pnNew.add(panel_11);
		panel_11.setLayout(new GridLayout(2, 1, 0, 0));
		
		lblNewLabel_10 = new JLabel("Loại đồng hồ:");
		lblNewLabel_10.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel_10.setFont(new Font("SansSerif", Font.BOLD, 13));
		panel_11.add(lblNewLabel_10);
		
		cbbPrdType = new JComboBox();
		cbbPrdType.setBackground(new Color(255, 255, 255));
		panel_11.add(cbbPrdType);
		
		panel_12 = new JPanel();
		panel_12.setBorder(new EmptyBorder(0, 10, 0, 10));
		pnNew.add(panel_12);
		panel_12.setLayout(new GridLayout(2, 1, 0, 0));
		
		lblNewLabel_11 = new JLabel("Thương hiệu:");
		lblNewLabel_11.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel_11.setFont(new Font("SansSerif", Font.BOLD, 13));
		panel_12.add(lblNewLabel_11);
		
		cbbPrdBrand = new JComboBox();
		cbbPrdBrand.setBackground(Color.WHITE);
		panel_12.add(cbbPrdBrand);
		
		panel_13 = new JPanel();
		panel_13.setBorder(new EmptyBorder(0, 10, 0, 10));
		pnNew.add(panel_13);
		panel_13.setLayout(new GridLayout(2, 1, 0, 0));
		
		lblNewLabel_4 = new JLabel("Đường dẫn đến ảnh:");
		lblNewLabel_4.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel_4.setFont(new Font("SansSerif", Font.BOLD, 13));
		panel_13.add(lblNewLabel_4);
		
		panel_17 = new JPanel();
		panel_13.add(panel_17);
		panel_17.setLayout(new BorderLayout(0, 0));
		
		textField = new JTextField();
		panel_17.add(textField, BorderLayout.CENTER);
		textField.setColumns(10);
		
		btnUrl = new JButton("");
		btnUrl.setBackground(new Color(0, 64, 64));
		btnUrl.setPreferredSize(new Dimension(40, 12));
		btnUrl.setIcon(FontIcon.of(MaterialDesignF.FILE_IMAGE, 20, Color.white));
		panel_17.add(btnUrl, BorderLayout.EAST);
		
		panel_14 = new JPanel();
		pnNew.add(panel_14);
		
		panel_16 = new JPanel();
		panel_16.setBorder(new EmptyBorder(25, 30, 5, 30));
		pnNew.add(panel_16);
		panel_16.setLayout(new GridLayout(1, 0, 0, 0));
		
		btnAddNewPrd = new JButton("Thêm sản phẩm");
		btnAddNewPrd.setForeground(Color.WHITE);
		btnAddNewPrd.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnAddNewPrd.setFocusPainted(false);
		btnAddNewPrd.setBackground(new Color(0, 128, 0));
		panel_16.add(btnAddNewPrd);
		
		panel_15 = new JPanel();
		panel_15.setBorder(new EmptyBorder(5, 30, 25, 30));
		pnNew.add(panel_15);
		panel_15.setLayout(new GridLayout(1, 0, 0, 0));
		
		btnExit2 = new JButton("Hủy thao tác");
		btnExit2.setForeground(Color.WHITE);
		btnExit2.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnExit2.setFocusPainted(false);
		btnExit2.setBackground(new Color(128, 40, 26));
		panel_15.add(btnExit2);
	}

}
