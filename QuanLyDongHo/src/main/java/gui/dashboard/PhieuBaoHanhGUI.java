package gui.dashboard;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.border.EmptyBorder;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

public class PhieuBaoHanhGUI extends JPanel {

	private static final long serialVersionUID = 1L;
	private JPanel panel;
	private JPanel panel_1;
	private JPanel panel_2;
	private JPanel panel_3;
	private JLabel lblNewLabel;
	private JPanel panel_4;
	private JPanel panel_5;
	private JPanel panel_6;
	private JPanel panel_7;
	private JLabel lblNewLabel_1;
	private JTextField textField_1;
	private JLabel lblNewLabel_2;
	private JTextField textField_2;
	private JPanel panel_8;
	private JLabel lblNewLabel_3;
	private JTextField textField_3;
	private JLabel lblNewLabel_4;
	private JTextField textField_4;
	private JPanel panel_9;
	private JPanel panel_10;
	private JPanel panel_11;
	private JPanel panel_12;
	private JLabel lblNewLabel_5;
	private JTextField textField_5;
	private JLabel lblNewLabel_6;
	private JTextField textField_6;
	private JLabel lblNewLabel_7;
	private JTextField textField_7;
	private JButton btnNewButton;
	private JPanel panel_13;
	private JPanel panel_14;
	private JLabel lblNewLabel_8;
	private JLabel lblNewLabel_9;
	private JLabel lblNewLabel_10;

	/**
	 * Create the panel.
	 */
	public PhieuBaoHanhGUI() {
		setBackground(new Color(255, 255, 255));
		setPreferredSize(new Dimension(1000, 500));
		setBorder(new EmptyBorder(25, 25, 25, 25));
		setLayout(new BorderLayout(0, 0));
		
		panel = new JPanel();
		panel.setBackground(new Color(240, 247, 250));
		panel.setPreferredSize(new Dimension(700, 500));
		add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		
		panel_1 = new JPanel();
		panel_1.setBackground(new Color(66, 136, 232));
		panel_1.setPreferredSize(new Dimension(900, 80));
		panel.add(panel_1, BorderLayout.NORTH);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		lblNewLabel = new JLabel("PHIẾU BẢO HÀNH");
		lblNewLabel.setBackground(new Color(0, 0, 160));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 21));
		lblNewLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblNewLabel, BorderLayout.CENTER);
		
		panel_2 = new JPanel();
		panel_2.setPreferredSize(new Dimension(550, 10));
		panel.add(panel_2, BorderLayout.WEST);
		panel_2.setLayout(new GridLayout(5, 1, 0, 0));
		
		panel_5 = new JPanel();
		panel_5.setBackground(new Color(240, 247, 250));
		panel_5.setBorder(new EmptyBorder(20, 25, 20, 25));
		panel_2.add(panel_5);
		panel_5.setLayout(new BorderLayout(30, 30));
		
		panel_14 = new JPanel();
		panel_14.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_5.add(panel_14, BorderLayout.CENTER);
		panel_14.setLayout(new GridLayout(0, 3, 0, 0));
		
		lblNewLabel_8 = new JLabel("Mã đơn hàng");
		lblNewLabel_8.setBackground(new Color(255, 255, 255));
		lblNewLabel_8.setOpaque(true);
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_8.setFont(new Font("SansSerif", Font.PLAIN, 14));
		panel_14.add(lblNewLabel_8);
		
		lblNewLabel_9 = new JLabel("Mã khách hàng");
		lblNewLabel_9.setBorder(new MatteBorder(0, 1, 0, 1, (Color) new Color(0, 0, 0)));
		lblNewLabel_9.setBackground(new Color(255, 255, 255));
		lblNewLabel_9.setOpaque(true);
		lblNewLabel_9.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_9.setFont(new Font("SansSerif", Font.PLAIN, 14));
		panel_14.add(lblNewLabel_9);
		
		lblNewLabel_10 = new JLabel("Mã sản phẩm");
		lblNewLabel_10.setBackground(new Color(255, 255, 255));
		lblNewLabel_10.setOpaque(true);
		lblNewLabel_10.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_10.setFont(new Font("SansSerif", Font.PLAIN, 14));
		panel_14.add(lblNewLabel_10);
		
		panel_6 = new JPanel();
		panel_6.setBackground(new Color(240, 247, 250));
		panel_6.setBorder(new EmptyBorder(20, 25, 20, 25));
		panel_2.add(panel_6);
		panel_6.setLayout(new BorderLayout(0, 20));
		
		lblNewLabel_1 = new JLabel("Tên sản phẩm");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setPreferredSize(new Dimension(140, 13));
		panel_6.add(lblNewLabel_1, BorderLayout.WEST);
		
		textField_1 = new JTextField();
		panel_6.add(textField_1, BorderLayout.CENTER);
		textField_1.setColumns(10);
		
		panel_7 = new JPanel();
		panel_7.setBackground(new Color(240, 247, 250));
		panel_7.setBorder(new EmptyBorder(20, 25, 20, 25));
		panel_2.add(panel_7);
		panel_7.setLayout(new BorderLayout(0, 0));
		
		lblNewLabel_2 = new JLabel("Phiên bản");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setPreferredSize(new Dimension(140, 13));
		panel_7.add(lblNewLabel_2, BorderLayout.WEST);
		
		textField_2 = new JTextField();
		panel_7.add(textField_2, BorderLayout.CENTER);
		textField_2.setColumns(10);
		
		panel_8 = new JPanel();
		panel_8.setBackground(new Color(240, 247, 250));
		panel_8.setBorder(new EmptyBorder(20, 25, 20, 25));
		panel_2.add(panel_8);
		panel_8.setLayout(new BorderLayout(0, 0));
		
		lblNewLabel_3 = new JLabel("Ngày mua");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3.setPreferredSize(new Dimension(140, 13));
		panel_8.add(lblNewLabel_3, BorderLayout.WEST);
		
		textField_3 = new JTextField();
		panel_8.add(textField_3, BorderLayout.CENTER);
		textField_3.setColumns(10);
		
		panel_4 = new JPanel();
		panel_4.setBackground(new Color(240, 247, 250));
		panel_4.setBorder(new EmptyBorder(20, 25, 20, 25));
		panel_2.add(panel_4);
		panel_4.setLayout(new BorderLayout(0, 0));
		
		lblNewLabel_4 = new JLabel("Thời gian bảo hành");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_4.setPreferredSize(new Dimension(140, 13));
		panel_4.add(lblNewLabel_4, BorderLayout.WEST);
		
		textField_4 = new JTextField();
		textField_4.setPreferredSize(new Dimension(60, 28));
		panel_4.add(textField_4, BorderLayout.CENTER);
		textField_4.setColumns(10);
		
		panel_3 = new JPanel();
		panel_3.setOpaque(false);
		panel.add(panel_3, BorderLayout.CENTER);
		panel_3.setLayout(new GridLayout(5, 1, 0, 0));
		
		panel_10 = new JPanel();
		panel_10.setBackground(new Color(240, 247, 250));
		panel_10.setBorder(new EmptyBorder(20, 25, 20, 25));
		panel_3.add(panel_10);
		panel_10.setLayout(new GridLayout(0, 2, 0, 0));
		
		lblNewLabel_5 = new JLabel("Mã phiếu");
		lblNewLabel_5.setHorizontalTextPosition(SwingConstants.LEFT);
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel_10.add(lblNewLabel_5);
		
		textField_5 = new JTextField();
		textField_5.setHorizontalAlignment(SwingConstants.LEFT);
		textField_5.setPreferredSize(new Dimension(70, 30));
		panel_10.add(textField_5);
		textField_5.setColumns(10);
		
		panel_9 = new JPanel();
		panel_9.setBackground(new Color(240, 247, 250));
		panel_9.setBorder(new EmptyBorder(0, 25, 0, 25));
		panel_9.setPreferredSize(new Dimension(10, 150));
		panel_3.add(panel_9);
		panel_9.setLayout(new GridLayout(2, 1, 0, 0));
		
		lblNewLabel_6 = new JLabel("Tình trạng máy");
		lblNewLabel_6.setPreferredSize(new Dimension(69, 40));
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel_9.add(lblNewLabel_6);
		
		textField_6 = new JTextField();
		panel_9.add(textField_6);
		textField_6.setColumns(10);
		
		panel_12 = new JPanel();
		panel_12.setBorder(new EmptyBorder(0, 25, 0, 25));
		panel_12.setBackground(new Color(240, 247, 250));
		panel_3.add(panel_12);
		panel_12.setLayout(new GridLayout(2, 1, 0, 0));
		
		lblNewLabel_7 = new JLabel("Ngày trả");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel_12.add(lblNewLabel_7);
		
		textField_7 = new JTextField();
		textField_7.setPreferredSize(new Dimension(7, 40));
		panel_12.add(textField_7);
		textField_7.setColumns(10);
		
		panel_13 = new JPanel();
		panel_13.setOpaque(false);
		panel_3.add(panel_13);
		
		panel_11 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_11.getLayout();
		flowLayout.setVgap(0);
		flowLayout.setHgap(0);
		panel_11.setBackground(new Color(240, 247, 250));
		panel_11.setBorder(new EmptyBorder(15, 25, 15, 25));
		panel_3.add(panel_11);
		
		btnNewButton = new JButton("Tạo phiếu");
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(68, 185, 80));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNewButton.setPreferredSize(new Dimension(350, 40));
		panel_11.add(btnNewButton);

	}

}
