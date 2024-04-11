package gui.login;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

import org.kordamp.ikonli.fontawesome5.FontAwesomeSolid;
import org.kordamp.ikonli.swing.FontIcon;

import bll.AccountBLL;
import dao.AccountDAO;
import dao.CustomerDAO;
import dao.EmployeeDAO;
import dto.Account;

import javax.swing.border.SoftBevelBorder;
import javax.swing.plaf.metal.MetalButtonUI;
import javax.swing.border.BevelBorder;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.Cursor;

public class LoginGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel pnHeader;
	private JPanel pnLogo;
	private JLabel lblNewLabel;
	private JPanel pnContent;
	private JLabel lblUsername;
	private JTextField txtUsername;
	private JLabel lblPasswd;
	private JPasswordField txtPasswd;
	private JRadioButton btnShowPasswd;
	private JButton btnLogin;
	private JButton btnRegis;
	private JLabel lblForgotPasswd;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
					LoginGUI frame = new LoginGUI();
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
	public LoginGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 540);
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(this.contentPane);
		this.contentPane.setLayout(new BorderLayout(0, 0));
		
		this.pnHeader = new JPanel();
		this.pnHeader.setBackground(new Color(249, 148, 6));
		this.pnHeader.setPreferredSize(new Dimension(10, 70));
		this.contentPane.add(this.pnHeader, BorderLayout.NORTH);
		this.pnHeader.setLayout(new GridLayout(0, 1, 0, 0));
		
		this.lblNewLabel = new JLabel("ĐĂNG NHẬP");
		this.lblNewLabel.setBorder(new EmptyBorder(0, 20, 0, 0));
		this.lblNewLabel.setForeground(new Color(255, 255, 255));
		this.lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		this.lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		this.lblNewLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		this.pnHeader.add(this.lblNewLabel);
		
		this.pnLogo = new JPanel();
		this.pnLogo.setBackground(new Color(42, 62, 80));
		this.contentPane.add(this.pnLogo, BorderLayout.CENTER);
		
		this.pnContent = new JPanel();
		this.pnContent.setPreferredSize(new Dimension(10, 310));
		this.pnContent.setBackground(new Color(42, 62, 80));
		this.contentPane.add(this.pnContent, BorderLayout.SOUTH);
		this.pnContent.setLayout(null);
		
		this.lblUsername = new JLabel("Tên người dùng");
		this.lblUsername.setIconTextGap(10);
		this.lblUsername.setForeground(new Color(255, 255, 255));
		this.lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 18));
		this.lblUsername.setBounds(63, 10, 350, 30);
		this.pnContent.add(this.lblUsername);
		
		this.txtUsername = new JTextField();
		this.txtUsername.setFont(new Font("Tahoma", Font.PLAIN, 15));
		this.txtUsername.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		this.txtUsername.setBounds(63, 40, 350, 30);
		this.pnContent.add(this.txtUsername);
		this.txtUsername.setColumns(10);
		
		this.lblPasswd = new JLabel("Mật khẩu");
		this.lblPasswd.setIconTextGap(10);
		this.lblPasswd.setForeground(Color.WHITE);
		this.lblPasswd.setFont(new Font("Tahoma", Font.PLAIN, 18));
		this.lblPasswd.setBounds(63, 80, 350, 30);
		this.pnContent.add(this.lblPasswd);
		
		this.btnShowPasswd = new JRadioButton("");
		this.btnShowPasswd.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		this.btnShowPasswd.setForeground(new Color(0, 0, 0));
		this.btnShowPasswd.setOpaque(false);
		this.btnShowPasswd.setHorizontalTextPosition(SwingConstants.CENTER);
		this.btnShowPasswd.setHorizontalAlignment(SwingConstants.CENTER);
		this.btnShowPasswd.setFont(new Font("Tahoma", Font.PLAIN, 20));
		this.btnShowPasswd.setBounds(373, 110, 30, 30);
		this.pnContent.add(this.btnShowPasswd);
		
		this.btnLogin = new JButton("Đăng nhập");
		this.btnLogin.setBorderPainted(false);
		this.btnLogin.setForeground(new Color(255, 255, 255));
		this.btnLogin.setBorder(null);
		this.btnLogin.setBackground(new Color(64, 128, 128));
		this.btnLogin.setFont(new Font("Tahoma", Font.BOLD, 15));
		this.btnLogin.setBounds(63, 170, 350, 30);
		this.pnContent.add(this.btnLogin);
		
		this.txtPasswd = new JPasswordField();
		this.txtPasswd.setFont(new Font("Tahoma", Font.PLAIN, 15));
		this.txtPasswd.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		this.txtPasswd.setColumns(10);
		this.txtPasswd.setBounds(63, 110, 350, 30);
		this.pnContent.add(this.txtPasswd);
		
		this.btnRegis = new JButton("Đăng ký");
		this.btnRegis.setForeground(Color.WHITE);
		this.btnRegis.setFont(new Font("Tahoma", Font.BOLD, 15));
		this.btnRegis.setBorderPainted(false);
		this.btnRegis.setBorder(null);
		this.btnRegis.setBackground(new Color(64, 128, 128));
		this.btnRegis.setBounds(63, 210, 350, 30);
		this.pnContent.add(this.btnRegis);
				
		this.lblForgotPasswd = new JLabel("Quên mật khẩu?");
		this.lblForgotPasswd.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		this.lblForgotPasswd.setForeground(new Color(255, 255, 255));
		this.lblForgotPasswd.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		this.lblForgotPasswd.setHorizontalAlignment(SwingConstants.RIGHT);
		this.lblForgotPasswd.setBounds(313, 146, 100, 13);
		this.pnContent.add(this.lblForgotPasswd);
		
		addIcon();
		makeButtonEffect(btnLogin);
		makeButtonEffect(btnRegis);
		makeOtherEffect();
		buttonEvent();
	}

	private void buttonEvent() {
		btnLogin.addActionListener(e -> {
			Account account = new Account();
			account.setUsername(txtUsername.getText());
			account.setPassword(new String(txtPasswd.getPassword()));
			switch (AccountBLL.checkLoginData(account)) {
			case AccountBLL.EMPTY_FIELD:
				JOptionPane.showMessageDialog(null, "Các trường không được trống!", "Lỗi", JOptionPane.ERROR_MESSAGE);
				break;
			case AccountBLL.USER_NOT_EXIST:
				JOptionPane.showMessageDialog(null, "Tên người dùng không tồn tại!", "Lỗi", JOptionPane.ERROR_MESSAGE);
				break;
			case AccountBLL.PASSWORD_INCORRECT:
				JOptionPane.showMessageDialog(null, "Mật khẩu không chính xác", "Lỗi", JOptionPane.ERROR_MESSAGE);
				break;
			case AccountBLL.VALID:
				account = AccountDAO.getInstance().getUserByUsername(account.getUsername());
				if (AccountDAO.getInstance().getRoleId(account.getId()).equals("CTM")) {
					String info = CustomerDAO.getInstance().getCustomerByAccountId(account.getId()).toString();
					JOptionPane.showMessageDialog(null, info, "Info", JOptionPane.INFORMATION_MESSAGE);
				} else {
					String info = EmployeeDAO.getInstance().getEmployeeByAccountId(account.getId()).toString();
					JOptionPane.showMessageDialog(null, info, "Info", JOptionPane.INFORMATION_MESSAGE);
				}
				break;
			}
		});
	}

	private void addIcon() {
		this.lblUsername.setIcon(FontIcon.of(FontAwesomeSolid.USER, lblUsername.getFont().getSize() - 3, lblUsername.getForeground()));
		this.lblPasswd.setIcon(FontIcon.of(FontAwesomeSolid.LOCK, lblPasswd.getFont().getSize() - 3, lblPasswd.getForeground()));
		this.btnShowPasswd.setIcon(FontIcon.of(FontAwesomeSolid.EYE_SLASH, btnShowPasswd.getFont().getSize() - 3, btnShowPasswd.getForeground()));
		this.btnShowPasswd.setSelectedIcon(FontIcon.of(FontAwesomeSolid.EYE, btnShowPasswd.getFont().getSize() - 3, btnShowPasswd.getForeground()));
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
	
	private void makeOtherEffect() {
		this.lblForgotPasswd.addMouseListener(new MouseAdapter() {
			@Override
		    public void mouseEntered(MouseEvent e) {
				lblForgotPasswd.setText("<html><u>Quên mật khẩu?</u></html>");
		    }
			@Override
		    public void mouseExited(MouseEvent e) {
				lblForgotPasswd.setText("Quên mật khẩu?");
		    }
		});
		this.btnShowPasswd.addItemListener(e -> {
			if (btnShowPasswd.isSelected()) {
				txtPasswd.setEchoChar((char) 0);
			} else {
				txtPasswd.setEchoChar('\u25CF');
			}
		});
	}
}
