package gui.dashboard;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.GridLayout;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.border.CompoundBorder;
import javax.swing.border.MatteBorder;
import javax.swing.text.MaskFormatter;

import org.kordamp.ikonli.materialdesign2.MaterialDesignA;
import org.kordamp.ikonli.materialdesign2.MaterialDesignC;
import org.kordamp.ikonli.swing.FontIcon;

import dto.Account;
import dto.Customer;
import dto.Employee;
import dto.Person;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import java.awt.Cursor;
import com.toedter.calendar.JDateChooser;

import bll.CustomerBLL;
import bll.EmployeeBLL;
import dao.AccountDAO;
import dao.EmployeeDAO;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFormattedTextField;

public class UserInfo extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel panel;
	private JPanel panel_1;
	private JPanel panel_2;
	private JPanel panel_3;
	private JLabel lblNewLabel;
	private JPanel panel_4;
	private JTextField txtName;
	private JPanel panel_5;
	private JLabel lblGiiTnh;
	private JPanel panel_6;
	private JPanel panel_7;
	private JPanel panel_8;
	private JLabel lblNewLabel_2;
	private JPanel panel_9;
	private JPanel panel_10;
	private JPanel panel_11;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_3;
	private JPanel panel_12;
	private JPanel panel_13;
	private JFormattedTextField txtPhone;
	private JTextField txtAdress;
	private JPanel panel_14;
	private JButton btnSave;
	private JButton btnHyThayi;
	private JPanel panel_15;
	private JPanel panel_16;
	private JLabel lblNewLabel_4;
	private JTextField txtUsername;
	private JPanel panel_17;
	private JLabel lblNewLabel_6;
	private JTextField txtPasswd;
	private JLabel lblRole;
	private JPanel panel_18;
	private JLabel lblR;
	private JLabel lblNewLabel_10;
	private JPanel panel_19;
	private JLabel lblNewLabel_11;
	private JLabel lblJoin;
	
	private Person user;
	private JDateChooser dateChooser;
	private JComboBox<String> cbGender;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserInfo frame = new UserInfo(EmployeeBLL.getEmployee(1));
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
	public UserInfo(Person user) {
		this.user = user;
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
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setPreferredSize(new Dimension(200, 16));
		panel_3.add(lblNewLabel, BorderLayout.WEST);
		
		panel_4 = new JPanel();
		panel_4.setBorder(new EmptyBorder(10, 0, 10, 0));
		panel_4.setOpaque(false);
		panel_3.add(panel_4, BorderLayout.CENTER);
		panel_4.setLayout(new BorderLayout(0, 0));
		
		txtName = new JTextField();
		txtName.setForeground(new Color(0, 0, 0));
		txtName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtName.setBorder(null);
		txtName.setText("Nguyễn Văn A");
		panel_4.add(txtName, BorderLayout.CENTER);
		
		panel_5 = new JPanel();
		panel_5.setOpaque(false);
		panel_5.setBorder(new CompoundBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(68, 68, 68)), new EmptyBorder(0, 1, 0, 12)));
		panel.add(panel_5);
		panel_5.setLayout(new BorderLayout(0, 0));
		
		lblGiiTnh = new JLabel("Giới tính:");
		lblGiiTnh.setForeground(new Color(0, 0, 0));
		lblGiiTnh.setPreferredSize(new Dimension(200, 16));
		lblGiiTnh.setFont(new Font("Tahoma", Font.BOLD, 18));
		panel_5.add(lblGiiTnh, BorderLayout.WEST);
		
		panel_6 = new JPanel();
		panel_6.setOpaque(false);
		panel_6.setBorder(new EmptyBorder(10, 0, 10, 0));
		panel_5.add(panel_6, BorderLayout.CENTER);
		panel_6.setLayout(new BorderLayout(0, 0));
		
		cbGender = new JComboBox<String>();
		cbGender.setModel(new DefaultComboBoxModel(new String[] {"Nam", "Nữ"}));
		cbGender.setBackground(new Color(255, 255, 255));
		panel_6.add(cbGender, BorderLayout.CENTER);
		
		panel_7 = new JPanel();
		panel_7.setOpaque(false);
		panel_7.setBorder(new CompoundBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(68, 68, 68)), new EmptyBorder(0, 1, 0, 12)));
		panel.add(panel_7);
		panel_7.setLayout(new BorderLayout(0, 0));
		
		lblNewLabel_2 = new JLabel("Ngày sinh");
		lblNewLabel_2.setForeground(new Color(0, 0, 0));
		lblNewLabel_2.setPreferredSize(new Dimension(200, 16));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		panel_7.add(lblNewLabel_2, BorderLayout.WEST);
		
		panel_9 = new JPanel();
		panel_9.setOpaque(false);
		panel_9.setBorder(new EmptyBorder(10, 0, 10, 0));
		panel_7.add(panel_9, BorderLayout.CENTER);
		panel_9.setLayout(new BorderLayout(0, 0));
		
		dateChooser = new JDateChooser();
		dateChooser.setBackground(new Color(255, 255, 255));
		panel_9.add(dateChooser, BorderLayout.CENTER);
		
		panel_10 = new JPanel();
		panel_10.setOpaque(false);
		panel_10.setBorder(new CompoundBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(68, 68, 68)), new EmptyBorder(0, 1, 0, 12)));
		panel.add(panel_10);
		panel_10.setLayout(new BorderLayout(0, 0));
		
		lblNewLabel_1 = new JLabel("Số điện thoại:");
		lblNewLabel_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1.setPreferredSize(new Dimension(200, 16));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		panel_10.add(lblNewLabel_1, BorderLayout.WEST);
		
		panel_13 = new JPanel();
		panel_13.setOpaque(false);
		panel_13.setBorder(new EmptyBorder(10, 0, 10, 0));
		panel_10.add(panel_13, BorderLayout.CENTER);
		panel_13.setLayout(new BorderLayout(0, 0));
		
		try {
			txtPhone = new JFormattedTextField(new MaskFormatter("0## ### ## ##"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		txtPhone.setForeground(new Color(0, 0, 0));
		txtPhone.setSelectedTextColor(new Color(255, 255, 255));
		txtPhone.setBackground(new Color(255, 255, 255));
		txtPhone.setText("0322569884");
		txtPhone.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtPhone.setColumns(10);
		txtPhone.setBorder(null);
		panel_13.add(txtPhone, BorderLayout.CENTER);
		
		panel_11 = new JPanel();
		panel_11.setOpaque(false);
		panel_11.setBorder(new CompoundBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(68, 68, 68)), new EmptyBorder(0, 1, 0, 12)));
		panel.add(panel_11);
		panel_11.setLayout(new BorderLayout(0, 0));
		
		lblNewLabel_3 = new JLabel("Địa chỉ:");
		lblNewLabel_3.setForeground(new Color(0, 0, 0));
		lblNewLabel_3.setPreferredSize(new Dimension(200, 16));
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 18));
		panel_11.add(lblNewLabel_3, BorderLayout.WEST);
		
		panel_12 = new JPanel();
		panel_12.setOpaque(false);
		panel_12.setBorder(new EmptyBorder(10, 0, 10, 0));
		panel_11.add(panel_12, BorderLayout.CENTER);
		panel_12.setLayout(new BorderLayout(0, 0));
		
		txtAdress = new JTextField();
		txtAdress.setForeground(new Color(0, 0, 0));
		txtAdress.setSelectedTextColor(new Color(255, 255, 255));
		txtAdress.setBackground(new Color(255, 255, 255));
		txtAdress.setText("34 Phố Phường, P. 3, Q. Ba Chỉ, TP. Abc Def");
		txtAdress.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtAdress.setColumns(10);
		txtAdress.setBorder(null);
		panel_12.add(txtAdress, BorderLayout.CENTER);
		
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
		
		btnSave = new JButton("Lưu thay đổi");
		btnSave.setFocusPainted(false);
		btnSave.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSave.setForeground(new Color(255, 255, 255));
		btnSave.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnSave.setBackground(new Color(0, 128, 64));
		panel_1.add(btnSave);
		
		btnHyThayi = new JButton("Hủy thay đổi");
		btnHyThayi.setFocusPainted(false);
		btnHyThayi.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnHyThayi.setForeground(new Color(255, 255, 255));
		btnHyThayi.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnHyThayi.setBackground(new Color(255, 91, 91));
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
		
		lblRole = new JLabel("Warehouse Manager");
		lblRole.setForeground(new Color(0, 0, 0));
		lblRole.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblRole.setVerticalTextPosition(SwingConstants.BOTTOM);
		lblRole.setHorizontalTextPosition(SwingConstants.CENTER);
		lblRole.setHorizontalAlignment(SwingConstants.CENTER);
		lblRole.setIcon(FontIcon.of(MaterialDesignA.ACCOUNT_CIRCLE, 70, lblRole.getForeground()));
		lblRole.setPreferredSize(new Dimension(150, 16));
		panel_14.add(lblRole, BorderLayout.WEST);
		
		panel_18 = new JPanel();
		panel_18.setOpaque(false);
		panel_14.add(panel_18, BorderLayout.CENTER);
		panel_18.setLayout(new GridLayout(2, 0, 0, 0));
		
		lblR = new JLabel("Khách hàng");
		lblR.setForeground(new Color(0, 0, 0));
		lblR.setVerticalAlignment(SwingConstants.BOTTOM);
		lblR.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblR.setHorizontalAlignment(SwingConstants.CENTER);
		panel_18.add(lblR);
		
		lblNewLabel_10 = new JLabel("tiềm năng");
		lblNewLabel_10.setForeground(new Color(0, 0, 0));
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
		lblNewLabel_4.setForeground(new Color(0, 0, 0));
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_4.setPreferredSize(new Dimension(150, 16));
		panel_16.add(lblNewLabel_4, BorderLayout.WEST);
		
		txtUsername = new JTextField("nguoidungfacebook");
		txtUsername.setForeground(new Color(0, 0, 0));
		txtUsername.setBackground(new Color(255, 255, 255));
		txtUsername.setSelectedTextColor(new Color(255, 255, 255));
		txtUsername.setBorder(null);
		txtUsername.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel_16.add(txtUsername, BorderLayout.CENTER);
		
		panel_17 = new JPanel();
		panel_17.setOpaque(false);
		panel_17.setBorder(new CompoundBorder(new EmptyBorder(0, 5, 0, 5), new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0))));
		panel_15.add(panel_17);
		panel_17.setLayout(new BorderLayout(0, 0));
		
		lblNewLabel_6 = new JLabel("Mật khẩu:");
		lblNewLabel_6.setForeground(new Color(0, 0, 0));
		lblNewLabel_6.setPreferredSize(new Dimension(150, 16));
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel_17.add(lblNewLabel_6, BorderLayout.WEST);
		
		txtPasswd = new JTextField("nguoidungfacebook");
		txtPasswd.setForeground(new Color(0, 0, 0));
		txtPasswd.setBackground(new Color(255, 255, 255));
		txtPasswd.setSelectedTextColor(new Color(255, 255, 255));
		txtPasswd.setBorder(null);
		txtPasswd.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel_17.add(txtPasswd, BorderLayout.CENTER);
		
		panel_19 = new JPanel();
		panel_19.setOpaque(false);
		panel_19.setBorder(new CompoundBorder(new EmptyBorder(0, 5, 0, 5), new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0))));
		panel_15.add(panel_19);
		panel_19.setLayout(new BorderLayout(0, 0));
		
		lblNewLabel_11 = new JLabel("Ngày tham gia:");
		lblNewLabel_11.setForeground(new Color(0, 0, 0));
		lblNewLabel_11.setPreferredSize(new Dimension(150, 16));
		lblNewLabel_11.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel_19.add(lblNewLabel_11, BorderLayout.WEST);
		
		lblJoin = new JLabel("24/6/2024");
		lblJoin.setForeground(new Color(0, 0, 0));
		lblJoin.setBackground(new Color(255, 255, 255));
		lblJoin.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblJoin.setBorder(null);
		panel_19.add(lblJoin, BorderLayout.CENTER);
		
		setInfo();
		addEvent();
	}

	private void addEvent() {
		btnSave.addActionListener(e -> {
			Account a = new Account();
			Person u = null;
			if (user instanceof Customer) {
				u = new Customer();
			} else if (user instanceof Employee) {
				u = new Employee();
				a.setRoleId(user.getAccount().getRoleId());
			}
			
			u.setId(user.getId());
			u.setFullName(txtName.getText());
			u.setGender((String) cbGender.getSelectedItem());
			u.setDateOfBirth(dateChooser.getDate());
			u.setAddress(txtAdress.getText());
			u.setPhoneNumber(txtPhone.getText().replaceAll("\\s+", ""));
			a.setUsername(txtUsername.getText());
			a.setPassword(txtPasswd.getText());
			a.setId(user.getAccountId());
			u.setAccountId(a.getId());
			u.setAccount(a);
			if (u instanceof Customer) {
				int check = CustomerBLL.checkInfo((Customer) u);
				if (check == CustomerBLL.VALID || check == 2) {
					CustomerBLL.updateUser((Customer) u);
				} else {
					JOptionPane.showMessageDialog(null, "Thông tin không hợp lệ", "Thông báo", JOptionPane.ERROR_MESSAGE);
				}
				
			} else if (u instanceof Employee) {
				int check = EmployeeBLL.checkInfo((Employee) u);
				if (check == EmployeeBLL.VALID || check == 2) {
					EmployeeBLL.updateUser((Employee) u);
				} else {
					JOptionPane.showMessageDialog(null, "Thông tin không hợp lệ", "Thông báo", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		}

	private void setInfo() {
		txtName.setText(user.getFullName());
		cbGender.setSelectedItem(user.getGender());
		dateChooser.setDate(user.getDateOfBirth());
		txtAdress.setText(user.getAddress());
		txtPhone.setText(user.getPhoneNumber());
		
		Account userAccount = user.getAccount();
		if (user instanceof Customer) {
			lblRole.setText("Khách hàng");
			lblR.setText("Khách hàng");
		} else if (user instanceof Employee) {
			lblRole.setText(userAccount.getRoleName());
			lblR.setText("Nhân viên");
		}
		
		txtUsername.setText(userAccount.getUsername());
		txtPasswd.setText(userAccount.getPassword());
		lblJoin.setText((new SimpleDateFormat("dd/MM/yyyy")).format(userAccount.getCreatedDate()));
	}

}
