package gui.dashboard;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.border.CompoundBorder;
import javax.swing.border.MatteBorder;

import org.kordamp.ikonli.materialdesign2.MaterialDesignA;
import org.kordamp.ikonli.materialdesign2.MaterialDesignC;
import org.kordamp.ikonli.swing.FontIcon;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import java.awt.Cursor;

public class UserInfo extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel panel;
	private JPanel panel_1;
	private JPanel panel_2;
	private JPanel panel_3;
	private JLabel lblNewLabel;
	private JPanel panel_4;
	private JLabel txtNguynVnA;
	private JPanel panel_5;
	private JLabel lblGiiTnh;
	private JPanel panel_6;
	private JLabel textField;
	private JPanel panel_7;
	private JPanel panel_8;
	private JLabel lblNewLabel_2;
	private JPanel panel_9;
	private JTextField txtEmialkdsdlkdowesko;
	private JPanel panel_10;
	private JPanel panel_11;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_3;
	private JPanel panel_12;
	private JPanel panel_13;
	private JTextField textField_1;
	private JTextField txtPhPhng;
	private JPanel panel_14;
	private JButton btnNewButton;
	private JButton btnHyThayi;
	private JPanel panel_15;
	private JPanel panel_16;
	private JLabel lblNewLabel_4;
	private JTextField lblNewLabel_5;
	private JPanel panel_17;
	private JLabel lblNewLabel_6;
	private JTextField lblNewLabel_7;
	private JLabel lblNewLabel_8;
	private JPanel panel_18;
	private JLabel lblNewLabel_9;
	private JLabel lblNewLabel_10;
	private JPanel panel_19;
	private JLabel lblNewLabel_11;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserInfo frame = new UserInfo();
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
	public UserInfo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 654, 647);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		panel = new JPanel();
		panel.setBorder(new EmptyBorder(0, 15, 0, 15));
		panel.setOpaque(false);
		panel.setPreferredSize(new Dimension(10, 270));
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(new GridLayout(5, 0, 0, 0));
		
		panel_3 = new JPanel();
		panel_3.setBorder(new CompoundBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(68, 68, 68)), new EmptyBorder(0, 1, 0, 12)));
		panel_3.setOpaque(false);
		panel.add(panel_3);
		panel_3.setLayout(new BorderLayout(0, 0));
		
		lblNewLabel = new JLabel("Họ và tên:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setPreferredSize(new Dimension(200, 16));
		panel_3.add(lblNewLabel, BorderLayout.WEST);
		
		panel_4 = new JPanel();
		panel_4.setBorder(new EmptyBorder(10, 0, 10, 0));
		panel_4.setOpaque(false);
		panel_3.add(panel_4, BorderLayout.CENTER);
		panel_4.setLayout(new BorderLayout(0, 0));
		
		txtNguynVnA = new JLabel();
		txtNguynVnA.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtNguynVnA.setBorder(null);
		txtNguynVnA.setText("Nguyễn Văn A");
		panel_4.add(txtNguynVnA, BorderLayout.CENTER);
		
		panel_5 = new JPanel();
		panel_5.setOpaque(false);
		panel_5.setBorder(new CompoundBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(68, 68, 68)), new EmptyBorder(0, 1, 0, 12)));
		panel.add(panel_5);
		panel_5.setLayout(new BorderLayout(0, 0));
		
		lblGiiTnh = new JLabel("Giới tính:");
		lblGiiTnh.setPreferredSize(new Dimension(200, 16));
		lblGiiTnh.setFont(new Font("Tahoma", Font.BOLD, 18));
		panel_5.add(lblGiiTnh, BorderLayout.WEST);
		
		panel_6 = new JPanel();
		panel_6.setOpaque(false);
		panel_6.setBorder(new EmptyBorder(10, 0, 10, 0));
		panel_5.add(panel_6, BorderLayout.CENTER);
		panel_6.setLayout(new BorderLayout(0, 0));
		
		textField = new JLabel();
		textField.setText("Nam");
		textField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField.setBorder(null);
		panel_6.add(textField, BorderLayout.CENTER);
		
		panel_7 = new JPanel();
		panel_7.setOpaque(false);
		panel_7.setBorder(new CompoundBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(68, 68, 68)), new EmptyBorder(0, 1, 0, 12)));
		panel.add(panel_7);
		panel_7.setLayout(new BorderLayout(0, 0));
		
		lblNewLabel_2 = new JLabel("Email:");
		lblNewLabel_2.setPreferredSize(new Dimension(200, 16));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		panel_7.add(lblNewLabel_2, BorderLayout.WEST);
		
		panel_9 = new JPanel();
		panel_9.setOpaque(false);
		panel_9.setBorder(new EmptyBorder(10, 0, 10, 0));
		panel_7.add(panel_9, BorderLayout.CENTER);
		panel_9.setLayout(new BorderLayout(0, 0));
		
		txtEmialkdsdlkdowesko = new JTextField();
		txtEmialkdsdlkdowesko.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtEmialkdsdlkdowesko.setText("emialkd.sdl@kdowe.sko");
		txtEmialkdsdlkdowesko.setBorder(null);
		panel_9.add(txtEmialkdsdlkdowesko, BorderLayout.CENTER);
		txtEmialkdsdlkdowesko.setColumns(10);
		
		panel_10 = new JPanel();
		panel_10.setOpaque(false);
		panel_10.setBorder(new CompoundBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(68, 68, 68)), new EmptyBorder(0, 1, 0, 12)));
		panel.add(panel_10);
		panel_10.setLayout(new BorderLayout(0, 0));
		
		lblNewLabel_1 = new JLabel("Số điện thoại:");
		lblNewLabel_1.setPreferredSize(new Dimension(200, 16));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		panel_10.add(lblNewLabel_1, BorderLayout.WEST);
		
		panel_13 = new JPanel();
		panel_13.setOpaque(false);
		panel_13.setBorder(new EmptyBorder(10, 0, 10, 0));
		panel_10.add(panel_13, BorderLayout.CENTER);
		panel_13.setLayout(new BorderLayout(0, 0));
		
		textField_1 = new JTextField();
		textField_1.setText("0322569884");
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_1.setColumns(10);
		textField_1.setBorder(null);
		panel_13.add(textField_1, BorderLayout.CENTER);
		
		panel_11 = new JPanel();
		panel_11.setOpaque(false);
		panel_11.setBorder(new CompoundBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(68, 68, 68)), new EmptyBorder(0, 1, 0, 12)));
		panel.add(panel_11);
		panel_11.setLayout(new BorderLayout(0, 0));
		
		lblNewLabel_3 = new JLabel("Địa chỉ:");
		lblNewLabel_3.setPreferredSize(new Dimension(200, 16));
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 18));
		panel_11.add(lblNewLabel_3, BorderLayout.WEST);
		
		panel_12 = new JPanel();
		panel_12.setOpaque(false);
		panel_12.setBorder(new EmptyBorder(10, 0, 10, 0));
		panel_11.add(panel_12, BorderLayout.CENTER);
		panel_12.setLayout(new BorderLayout(0, 0));
		
		txtPhPhng = new JTextField();
		txtPhPhng.setText("34 Phố Phường, P. 3, Q. Ba Chỉ, TP. Abc Def");
		txtPhPhng.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtPhPhng.setColumns(10);
		txtPhPhng.setBorder(null);
		panel_12.add(txtPhPhng, BorderLayout.CENTER);
		
		panel_8 = new JPanel();
		panel_8.setOpaque(false);
		panel_8.setBorder(null);
		contentPane.add(panel_8, BorderLayout.SOUTH);
		panel_8.setLayout(new BorderLayout(0, 0));
		
		panel_1 = new JPanel();
		panel_1.setBorder(new EmptyBorder(20, 0, 0, 15));
		panel_1.setOpaque(false);
		panel_1.setPreferredSize(new Dimension(160, 10));
		contentPane.add(panel_1, BorderLayout.EAST);
		panel_1.setLayout(new GridLayout(5, 0, 0, 20));
		
		btnNewButton = new JButton("Lưu thay đổi");
		btnNewButton.setFocusPainted(false);
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setBackground(new Color(0, 128, 0));
		panel_1.add(btnNewButton);
		
		btnHyThayi = new JButton("Hủy thay đổi");
		btnHyThayi.setFocusPainted(false);
		btnHyThayi.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnHyThayi.setForeground(new Color(255, 255, 255));
		btnHyThayi.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnHyThayi.setBackground(new Color(180, 33, 33));
		panel_1.add(btnHyThayi);
		
		panel_2 = new JPanel();
		panel_2.setBorder(new EmptyBorder(0, 15, 0, 15));
		panel_2.setOpaque(false);
		contentPane.add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		panel_14 = new JPanel();
		panel_14.setBorder(new MatteBorder(0, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panel_14.setPreferredSize(new Dimension(10, 100));
		panel_14.setOpaque(false);
		panel_2.add(panel_14, BorderLayout.NORTH);
		panel_14.setLayout(new BorderLayout(0, 0));
		
		lblNewLabel_8 = new JLabel("Warehouse Manager");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_8.setVerticalTextPosition(SwingConstants.BOTTOM);
		lblNewLabel_8.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_8.setIcon(FontIcon.of(MaterialDesignA.ACCOUNT_CIRCLE, 70, Color.black));
		lblNewLabel_8.setPreferredSize(new Dimension(150, 16));
		panel_14.add(lblNewLabel_8, BorderLayout.WEST);
		
		panel_18 = new JPanel();
		panel_18.setOpaque(false);
		panel_14.add(panel_18, BorderLayout.CENTER);
		panel_18.setLayout(new GridLayout(2, 0, 0, 0));
		
		lblNewLabel_9 = new JLabel("Khách hàng");
		lblNewLabel_9.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel_9.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel_9.setHorizontalAlignment(SwingConstants.CENTER);
		panel_18.add(lblNewLabel_9);
		
		lblNewLabel_10 = new JLabel("tiềm năng");
		lblNewLabel_10.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_10.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_10.setFont(new Font("Tahoma", Font.BOLD, 25));
		panel_18.add(lblNewLabel_10);
		
		panel_15 = new JPanel();
		panel_15.setBorder(new MatteBorder(0, 1, 0, 1, (Color) new Color(0, 0, 0)));
		panel_15.setOpaque(false);
		panel_2.add(panel_15, BorderLayout.CENTER);
		panel_15.setLayout(new GridLayout(6, 0, 0, 0));
		
		panel_16 = new JPanel();
		panel_16.setBorder(new CompoundBorder(new EmptyBorder(0, 5, 0, 5), new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0))));
		panel_16.setOpaque(false);
		panel_15.add(panel_16);
		panel_16.setLayout(new BorderLayout(0, 0));
		
		lblNewLabel_4 = new JLabel("Tên người dùng:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_4.setPreferredSize(new Dimension(150, 16));
		panel_16.add(lblNewLabel_4, BorderLayout.WEST);
		
		lblNewLabel_5 = new JTextField("nguoidungfacebook");
		lblNewLabel_5.setBorder(null);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel_16.add(lblNewLabel_5, BorderLayout.CENTER);
		
		panel_17 = new JPanel();
		panel_17.setOpaque(false);
		panel_17.setBorder(new CompoundBorder(new EmptyBorder(0, 5, 0, 5), new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0))));
		panel_15.add(panel_17);
		panel_17.setLayout(new BorderLayout(0, 0));
		
		lblNewLabel_6 = new JLabel("Mật khẩu:");
		lblNewLabel_6.setPreferredSize(new Dimension(150, 16));
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel_17.add(lblNewLabel_6, BorderLayout.WEST);
		
		lblNewLabel_7 = new JTextField("nguoidungfacebook");
		lblNewLabel_7.setBorder(null);
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel_17.add(lblNewLabel_7, BorderLayout.CENTER);
		
		panel_19 = new JPanel();
		panel_19.setOpaque(false);
		panel_19.setBorder(new CompoundBorder(new EmptyBorder(0, 5, 0, 5), new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0))));
		panel_15.add(panel_19);
		panel_19.setLayout(new BorderLayout(0, 0));
		
		lblNewLabel_11 = new JLabel("Ngày tham gia:");
		lblNewLabel_11.setPreferredSize(new Dimension(150, 16));
		lblNewLabel_11.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel_19.add(lblNewLabel_11, BorderLayout.WEST);
		
		textField_2 = new JTextField("24/6/2024");
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textField_2.setBorder(null);
		panel_19.add(textField_2, BorderLayout.CENTER);
	}

}
