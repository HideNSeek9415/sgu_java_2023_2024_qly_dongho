package gui.login;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.JTextField;
import javax.swing.border.SoftBevelBorder;
import javax.swing.plaf.metal.MetalButtonUI;
import javax.swing.text.MaskFormatter;

import org.kordamp.ikonli.fontawesome5.FontAwesomeSolid;
import org.kordamp.ikonli.materialdesign.MaterialDesign;
import org.kordamp.ikonli.swing.FontIcon;

import com.toedter.calendar.JDateChooser;

import bll.AccountBLL;
import bll.CustomerBLL;
import dao.CustomerDAO;
import dto.Account;
import dto.Customer;
import system.SystemInfo;

import javax.swing.border.BevelBorder;
import javax.swing.JRadioButton;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.border.EtchedBorder;
import javax.swing.JFormattedTextField;

public class RegisGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel pnHeader;
	private JLabel lblNewLabel;
	private JPanel pnContent1;
	private JLabel lblUsername;
	private JTextField txtUsername;
	private JLabel lblPasswd;
	private JRadioButton btnShowPasswd;
	private JButton btnNext;
	private JPasswordField txtPasswd;
	private JButton btnExit;
	private JRadioButton btnShowConfirm;
	private JPasswordField txtConfirm;
	private JLabel lblConfirm;
	private JPanel pnContent2;
	private JLabel lblName;
	private JTextField txtName;
	private JLabel lblGender;
	private JLabel lblBirthday;
	private JLabel lblPhone;
	private JFormattedTextField txtPhone;
	private JLabel lblAddress;
	private JTextArea txtAddress;
	private JPanel pnGender;
	private JRadioButton rdnMale;
	private JRadioButton rdnFemale;
	private ButtonGroup btnGr = new ButtonGroup();
	private JButton btnRegis;
	private JButton btnBack;
	private JDateChooser dateBirthday;

	
	private final static int ACCOUNT = 1;
	private final static int INFO = 2;
	
	private Account acc;
	private Customer ctm;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
					RegisGUI frame = new RegisGUI();
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
	public RegisGUI() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(10, 10, 500, 634);
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(this.contentPane);
		this.contentPane.setLayout(new BorderLayout(0, 0));
		
		this.pnHeader = new JPanel();
		this.pnHeader.setPreferredSize(new Dimension(10, 70));
		this.pnHeader.setBackground(new Color(249, 148, 6));
		this.contentPane.add(this.pnHeader, BorderLayout.NORTH);
		this.pnHeader.setLayout(new GridLayout(0, 1, 0, 0));
		
		this.lblNewLabel = new JLabel("ĐĂNG KÝ");
		this.lblNewLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		this.lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		this.lblNewLabel.setForeground(Color.WHITE);
		this.lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		this.lblNewLabel.setBorder(new EmptyBorder(0, 20, 0, 0));
		this.pnHeader.add(this.lblNewLabel);
		
		this.pnContent1 = new JPanel();
		this.pnContent1.setSize(new Dimension(0, 700));
		this.pnContent1.setBorder(null);
		this.pnContent1.setLayout(null);
		this.pnContent1.setPreferredSize(new Dimension(0, 0));
		this.pnContent1.setBackground(new Color(42, 62, 80));
		this.contentPane.add(this.pnContent1, BorderLayout.CENTER);
		
		this.lblUsername = new JLabel("Tên người dùng");
		this.lblUsername.setIconTextGap(10);
		this.lblUsername.setForeground(Color.WHITE);
		this.lblUsername.setFont(new Font("Tahoma", Font.BOLD, 18));
		this.lblUsername.setBounds(63, 80, 350, 30);
		this.pnContent1.add(this.lblUsername);
		
		this.txtUsername = new JTextField();
		this.txtUsername.setFont(new Font("Tahoma", Font.PLAIN, 15));
		this.txtUsername.setColumns(10);
		this.txtUsername.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		this.txtUsername.setBounds(63, 110, 350, 30);
		this.pnContent1.add(this.txtUsername);
		
		this.lblPasswd = new JLabel("Mật khẩu");
		this.lblPasswd.setIconTextGap(10);
		this.lblPasswd.setForeground(Color.WHITE);
		this.lblPasswd.setFont(new Font("Tahoma", Font.BOLD, 18));
		this.lblPasswd.setBounds(63, 150, 350, 30);
		this.pnContent1.add(this.lblPasswd);
		
		this.btnShowPasswd = new JRadioButton("");
		this.btnShowPasswd.setOpaque(false);
		this.btnShowPasswd.setHorizontalTextPosition(SwingConstants.CENTER);
		this.btnShowPasswd.setHorizontalAlignment(SwingConstants.CENTER);
		this.btnShowPasswd.setForeground(Color.BLACK);
		this.btnShowPasswd.setFont(new Font("Tahoma", Font.PLAIN, 20));
		this.btnShowPasswd.setBounds(373, 180, 30, 30);
		this.pnContent1.add(this.btnShowPasswd);
		
		this.btnNext = new JButton("Tiếp theo");
		this.btnNext.setFocusPainted(false);
		this.btnNext.setForeground(Color.WHITE);
		this.btnNext.setFont(new Font("Tahoma", Font.BOLD, 15));
		this.btnNext.setBorderPainted(false);
		this.btnNext.setBorder(null);
		this.btnNext.setBackground(new Color(64, 128, 128));
		this.btnNext.setBounds(63, 333, 350, 30);
		this.pnContent1.add(this.btnNext);
		
		this.txtPasswd = new JPasswordField();
		this.txtPasswd.setFont(new Font("Tahoma", Font.PLAIN, 15));
		this.txtPasswd.setColumns(10);
		this.txtPasswd.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		this.txtPasswd.setBounds(63, 180, 350, 30);
		this.pnContent1.add(this.txtPasswd);
		
		this.btnExit = new JButton("Thoát");
		this.btnExit.setFocusPainted(false);
		this.btnExit.setForeground(Color.WHITE);
		this.btnExit.setFont(new Font("Tahoma", Font.BOLD, 15));
		this.btnExit.setBorderPainted(false);
		this.btnExit.setBorder(null);
		this.btnExit.setBackground(new Color(64, 128, 128));
		this.btnExit.setBounds(63, 373, 350, 30);
		this.pnContent1.add(this.btnExit);
		
		this.btnShowConfirm = new JRadioButton("");
		this.btnShowConfirm.setOpaque(false);
		this.btnShowConfirm.setHorizontalTextPosition(SwingConstants.CENTER);
		this.btnShowConfirm.setHorizontalAlignment(SwingConstants.CENTER);
		this.btnShowConfirm.setForeground(Color.BLACK);
		this.btnShowConfirm.setFont(new Font("Tahoma", Font.PLAIN, 20));
		this.btnShowConfirm.setBounds(373, 250, 30, 30);
		this.pnContent1.add(this.btnShowConfirm);
		
		this.txtConfirm = new JPasswordField();
		this.txtConfirm.setFont(new Font("Tahoma", Font.PLAIN, 15));
		this.txtConfirm.setColumns(10);
		this.txtConfirm.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		this.txtConfirm.setBounds(63, 250, 350, 30);
		this.pnContent1.add(this.txtConfirm);
		
		this.lblConfirm = new JLabel("Xác nhận mật khẩu");
		this.lblConfirm.setIconTextGap(10);
		this.lblConfirm.setForeground(Color.WHITE);
		this.lblConfirm.setFont(new Font("Tahoma", Font.BOLD, 18));
		this.lblConfirm.setBounds(63, 220, 350, 30);
		this.pnContent1.add(this.lblConfirm);
		
		this.pnContent2 = new JPanel();
		this.pnContent2.setSize(new Dimension(476, 700));
		this.pnContent2.setBackground(new Color(42, 62, 80));
		this.pnContent2.setBorder(null);
		this.pnContent2.setPreferredSize(new Dimension(0, 0));
		this.contentPane.add(this.pnContent2, BorderLayout.EAST);
		this.pnContent2.setLayout(null);
		
		this.lblName = new JLabel("Họ và tên");
		this.lblName.setIconTextGap(10);
		this.lblName.setForeground(Color.WHITE);
		this.lblName.setFont(new Font("Tahoma", Font.BOLD, 18));
		this.lblName.setBounds(63, 30, 350, 30);
		this.pnContent2.add(this.lblName);
		
		this.txtName = new JTextField();
		this.txtName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		this.txtName.setColumns(10);
		this.txtName.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		this.txtName.setBounds(63, 60, 350, 30);
		this.pnContent2.add(this.txtName);
		
		this.lblGender = new JLabel("Giới tính");
		this.lblGender.setIconTextGap(10);
		this.lblGender.setForeground(Color.WHITE);
		this.lblGender.setFont(new Font("Tahoma", Font.BOLD, 18));
		this.lblGender.setBounds(63, 100, 350, 30);
		this.pnContent2.add(this.lblGender);
		
		this.lblBirthday = new JLabel("Ngày sinh");
		this.lblBirthday.setIconTextGap(10);
		this.lblBirthday.setForeground(Color.WHITE);
		this.lblBirthday.setFont(new Font("Tahoma", Font.BOLD, 18));
		this.lblBirthday.setBounds(63, 170, 350, 30);
		this.pnContent2.add(this.lblBirthday);
		
		this.lblPhone = new JLabel("Số điện thoại");
		this.lblPhone.setIconTextGap(10);
		this.lblPhone.setForeground(Color.WHITE);
		this.lblPhone.setFont(new Font("Tahoma", Font.BOLD, 18));
		this.lblPhone.setBounds(63, 240, 350, 30);
		this.pnContent2.add(this.lblPhone);
		
		try {
			this.txtPhone = new JFormattedTextField(new MaskFormatter("0#########"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		this.txtPhone.setFont(new Font("Tahoma", Font.PLAIN, 15));
		this.txtPhone.setColumns(10);
		this.txtPhone.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		this.txtPhone.setBounds(63, 270, 350, 30);
		this.pnContent2.add(this.txtPhone);
		
		this.lblAddress = new JLabel("Địa chỉ");
		this.lblAddress.setIconTextGap(10);
		this.lblAddress.setForeground(Color.WHITE);
		this.lblAddress.setFont(new Font("Tahoma", Font.BOLD, 18));
		this.lblAddress.setBounds(63, 310, 350, 30);
		this.pnContent2.add(this.lblAddress);
		
		this.txtAddress = new JTextArea();
		this.txtAddress.setLineWrap(true);
		this.txtAddress.setWrapStyleWord(true);
		this.txtAddress.setFont(new Font("Tahoma", Font.PLAIN, 15));
		this.txtAddress.setColumns(10);
		this.txtAddress.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		this.txtAddress.setBounds(63, 340, 350, 54);
		this.pnContent2.add(this.txtAddress);
		
		this.pnGender = new JPanel();
		this.pnGender.setBorder(new EmptyBorder(0, 10, 0, 0));
		this.pnGender.setOpaque(false);
		this.pnGender.setBounds(63, 130, 350, 30);
		this.pnContent2.add(this.pnGender);
		this.pnGender.setLayout(new GridLayout(0, 2, 0, 0));
		
		this.rdnMale = new JRadioButton("Nam");
		this.rdnMale.setForeground(new Color(255, 255, 255));
		this.rdnMale.setFont(new Font("Tahoma", Font.PLAIN, 16));
		this.rdnMale.setOpaque(false);
		this.pnGender.add(this.rdnMale);
		
		this.rdnFemale = new JRadioButton("Nữ");
		this.rdnFemale.setOpaque(false);
		this.rdnFemale.setForeground(Color.WHITE);
		this.rdnFemale.setFont(new Font("Tahoma", Font.PLAIN, 16));
		this.pnGender.add(this.rdnFemale);
		
		btnGr.add(rdnMale);
		btnGr.add(rdnFemale);
		
		this.btnRegis = new JButton("Đăng ký");
		this.btnRegis.setFocusPainted(false);
		this.btnRegis.setForeground(Color.WHITE);
		this.btnRegis.setFont(new Font("Tahoma", Font.BOLD, 15));
		this.btnRegis.setBorderPainted(false);
		this.btnRegis.setBorder(null);
		this.btnRegis.setBackground(new Color(64, 128, 128));
		this.btnRegis.setBounds(63, 420, 350, 30);
		this.pnContent2.add(this.btnRegis);
		
		this.btnBack = new JButton("Trở lại");
		this.btnBack.setFocusPainted(false);
		this.btnBack.setForeground(Color.WHITE);
		this.btnBack.setFont(new Font("Tahoma", Font.BOLD, 15));
		this.btnBack.setBorderPainted(false);
		this.btnBack.setBorder(null);
		this.btnBack.setBackground(new Color(64, 128, 128));
		this.btnBack.setBounds(63, 460, 350, 30);
		this.pnContent2.add(this.btnBack);
		
		changeFormEff();
		addIcon();
		addDatePicker();
		decorateRdnbtn(rdnMale);
		decorateRdnbtn(rdnFemale);
		makeButtonEffect(btnBack);
		makeButtonEffect(btnNext);
		makeButtonEffect(btnRegis);
		makeButtonEffect(btnExit);
		togglePasswordVisible(txtPasswd, btnShowPasswd);
		togglePasswordVisible(txtConfirm, btnShowConfirm);
		
		signin();

	}

	private void signin() {
		btnNext.addActionListener(e -> {
			Account a = new Account();
			a.setUsername(txtUsername.getText());
			a.setPassword(String.valueOf(txtPasswd.getPassword()));
			String confirm = String.valueOf(txtConfirm.getPassword());
			switch (AccountBLL.signin(a, confirm)) {
			case AccountBLL.EMPTY_FIELD:
				JOptionPane.showMessageDialog(null, "Các trường không được trống!", "Lỗi", JOptionPane.ERROR_MESSAGE);
				break;
			case AccountBLL.INVALID_USERNAME:
				String fm = String.format("Tên người dùng yêu cầu tối thiểu 6 ký tự\nchỉ chứa ký tự thường và số");
				JOptionPane.showMessageDialog(null, fm, "Lỗi", JOptionPane.ERROR_MESSAGE);
				break;
			case AccountBLL.USERNAME_EXISTED:
				JOptionPane.showMessageDialog(null, "Tên người dùng đã được sử dụng!", "Lỗi", JOptionPane.ERROR_MESSAGE);
				break;
			case AccountBLL.INVALID_PASSWORD:
				JOptionPane.showMessageDialog(null, "Mật khẩu yêu cầu tối thiểu 8 ký tự", "Lỗi", JOptionPane.ERROR_MESSAGE);
				break;
			case AccountBLL.CONFIRM_PASSWD_MISMATCHED:
				JOptionPane.showMessageDialog(null, "Mật khẩu xác nhận không đúng", "Lỗi", JOptionPane.ERROR_MESSAGE);
				break;
			case AccountBLL.VALID:
				acc = a;
				changeForm(INFO);
				break;
			}
		});
		btnRegis.addActionListener(e -> {
			ctm = new Customer();
			ctm.setAccount(acc);
			ctm.setFullName(txtName.getText());
			ctm.setDateOfBirth(dateBirthday.getDate());
			ctm.setAddress(txtAddress.getText());
			ctm.setGender(rdnMale.isSelected() ? "Nam" : "Nữ");
			ctm.setPhoneNumber(txtPhone.getValue() != null ? txtPhone.getValue().toString() : "");
			
			switch (CustomerBLL.checkInfo(ctm)) {
			case CustomerBLL.EMPTY_FIELD:
				System.out.println(ctm);
				JOptionPane.showMessageDialog(null, "Các trường không được trống!", "Lỗi", JOptionPane.ERROR_MESSAGE);
				break;
			case CustomerBLL.INVALID_PHONE_NUMBER:
				System.out.println(ctm);
				JOptionPane.showMessageDialog(null, "Số điện thoại không hợp lệ!", "Lỗi", JOptionPane.ERROR_MESSAGE);
				break;
			case CustomerBLL.USED_PHONE_NUMBER:
				System.out.println(ctm);
				JOptionPane.showMessageDialog(null, "Số điện thoại đã được sử dụng!", "Lỗi", JOptionPane.ERROR_MESSAGE);
				break;
			case CustomerBLL.VALID:
				CustomerBLL.addCustomer(ctm);
				JOptionPane.showMessageDialog(null, SystemInfo.currentUser, "Info", JOptionPane.INFORMATION_MESSAGE);
				break;
			}
		});
	}

	private void changeFormEff() {
		this.btnBack.addActionListener(e -> {
			changeForm(ACCOUNT);
		});
	}

	private void decorateRdnbtn(AbstractButton btn) {
		btn.setFocusPainted(false);
		btn.setIcon(FontIcon.of(FontAwesomeSolid.SQUARE_FULL, btn.getFont().getSize() - 4, btn.getForeground()));
		btn.setSelectedIcon(FontIcon.of(FontAwesomeSolid.CHECK_SQUARE, btn.getFont().getSize() - 2, btn.getForeground()));
		btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btn.setIconTextGap(10);
	}

	private void addDatePicker() {
		dateBirthday = new JDateChooser();
		dateBirthday.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		dateBirthday.setBounds(63, 200, 350, 30);
		dateBirthday.setDateFormatString("dd/MM/yyyy");
		dateBirthday.setFont(new Font("Tahoma", Font.PLAIN, 15));
		this.pnContent2.add(dateBirthday);
	}

	private void addIcon() {
		this.lblUsername.setIcon(FontIcon.of(FontAwesomeSolid.USER, lblUsername.getFont().getSize() - 3, lblUsername.getForeground()));
		this.lblPasswd.setIcon(FontIcon.of(FontAwesomeSolid.LOCK, lblPasswd.getFont().getSize() - 3, lblPasswd.getForeground()));
		this.lblConfirm.setIcon(FontIcon.of(MaterialDesign.MDI_MARKER_CHECK, lblConfirm.getFont().getSize() - 1, lblConfirm.getForeground()));
		this.btnShowPasswd.setIcon(FontIcon.of(FontAwesomeSolid.EYE_SLASH, btnShowPasswd.getFont().getSize() - 3, btnShowPasswd.getForeground()));
		this.btnShowPasswd.setSelectedIcon(FontIcon.of(FontAwesomeSolid.EYE, btnShowPasswd.getFont().getSize() - 3, btnShowPasswd.getForeground()));
		this.btnShowConfirm.setIcon(FontIcon.of(FontAwesomeSolid.EYE_SLASH, btnShowConfirm.getFont().getSize() - 3, btnShowConfirm.getForeground()));
		this.btnShowConfirm.setSelectedIcon(FontIcon.of(FontAwesomeSolid.EYE, btnShowConfirm.getFont().getSize() - 3, btnShowConfirm.getForeground()));
		this.lblName.setIcon(FontIcon.of(MaterialDesign.MDI_RENAME_BOX, lblName.getFont().getSize(), lblName.getForeground()));
		this.lblGender.setIcon(FontIcon.of(MaterialDesign.MDI_GENDER_MALE_FEMALE, lblGender.getFont().getSize(), lblGender.getForeground()));
		this.lblBirthday.setIcon(FontIcon.of(MaterialDesign.MDI_CAKE, lblBirthday.getFont().getSize() - 1, lblBirthday.getForeground()));
		this.lblPhone.setIcon(FontIcon.of(MaterialDesign.MDI_CELLPHONE, lblPhone.getFont().getSize() - 1, lblPhone.getForeground()));
		this.lblAddress.setIcon(FontIcon.of(MaterialDesign.MDI_HOUZZ, lblAddress.getFont().getSize() - 1, lblAddress.getForeground()));


	}
	
	private void changeForm(int frm) {
		new Thread(new Runnable() {
			private final static int maxWidth = 476;
			private final static int step = 10;
			private final static int delayPerStep = 12;


			@Override
			public void run() {
				try {
					switch (frm) {
					case INFO:
						for (int i = 0; i <= maxWidth; i += step) {
							i = i > maxWidth ? maxWidth : i;
							pnContent2.setPreferredSize(new Dimension(i, 700));
							pnContent1.setPreferredSize(new Dimension(476 - i, 700));
							pnContent2.revalidate();
	        				pnContent1.revalidate();
							Thread.sleep(delayPerStep);
						}
						break;
					case ACCOUNT:
						for (int i = 0; i <= maxWidth; i += 10) {
							i = i > maxWidth ? maxWidth : i;
							pnContent1.setPreferredSize(new Dimension(i, 700));
							pnContent2.setPreferredSize(new Dimension(476 - i, 700));
							pnContent2.revalidate();
	        				pnContent1.revalidate();
							Thread.sleep(delayPerStep);
						}
						break;
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}).start();

	}
	
	private void makeButtonEffect(JButton btn) {
		Color bgColor = btn.getBackground();
		Color foreColor = btn.getForeground();
		btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btn.addMouseListener(new MouseAdapter() {
			@Override
		    public void mouseEntered(MouseEvent e) {
		    	btn.setBackground(Color.decode("#fa925b"));
		    	btn.setForeground(Color.decode("#131a46"));
		    }
			@Override
		    public void mouseExited(MouseEvent e) {
		    	btn.setBackground(bgColor);
		    	btn.setForeground(foreColor);
		    }
		});
		btn.setUI(new MetalButtonUI() {
			@Override
		    protected Color getSelectColor() {
		    	return btn.getBackground();
		    }
			@Override
		    protected Color getFocusColor() {
				return btn.getBackground();
		    }
		});
	}

	private void togglePasswordVisible(JPasswordField passwdField, AbstractButton tglBtn) {
		passwdField.setEchoChar('\u25CF');
		tglBtn.addItemListener(e -> {
			if (tglBtn.isSelected()) {
				passwdField.setEchoChar((char) 0);
			} else {
				passwdField.setEchoChar('\u25CF');
			}
		});
	}
	
}
