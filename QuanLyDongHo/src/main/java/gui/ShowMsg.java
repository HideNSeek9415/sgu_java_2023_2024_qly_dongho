package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.kordamp.ikonli.fontawesome5.FontAwesomeSolid;
import org.kordamp.ikonli.materialdesign2.MaterialDesignC;
import org.kordamp.ikonli.swing.FontIcon;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;

import java.awt.Font;
import java.util.concurrent.atomic.AtomicBoolean;

import javax.swing.JButton;
import javax.swing.SwingConstants;

import java.awt.Cursor;
import java.awt.Dimension;
import javax.swing.border.MatteBorder;

public class ShowMsg extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnConfirm;
	private JLabel lblIcon;
	private JLabel lblNewLabel;
	private JLabel txtMsg;
	private FontIcon icon;
    private static AtomicBoolean result = new AtomicBoolean();



	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ShowMsg frame = new ShowMsg();
					frame.setVisible(true);
					System.out.println(showConfirmDialog("Hahahaha", null));
			        showValidationMsg("Hahahaha", null);
			        showInvalidMsg("Hahahaha", null);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ShowMsg() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 300);
		setUndecorated(true);
		setLocationRelativeTo(null);
		this.contentPane = new JPanel();
		this.contentPane.setBackground(new Color(255, 255, 255));
		this.contentPane.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));

		setContentPane(this.contentPane);
		this.contentPane.setLayout(null);
		
		this.btnConfirm = new JButton("Xác nhận");
		this.btnConfirm.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		this.btnConfirm.setForeground(new Color(255, 255, 255));
		this.btnConfirm.setBackground(new Color(246, 86, 86));
		this.btnConfirm.setBorderPainted(false);
		this.btnConfirm.setBounds(0, 250, 400, 50);
		this.contentPane.add(this.btnConfirm);
		
		this.lblIcon = new JLabel("");
		this.lblIcon.setFont(new Font("Tahoma", Font.PLAIN, 72));
		this.lblIcon.setHorizontalAlignment(SwingConstants.CENTER);
		this.lblIcon.setBounds(155, 20, 90, 90);
		this.contentPane.add(this.lblIcon);
		
		this.lblNewLabel = new JLabel("Thông báo từ hệ thống!");
		this.lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 22));
		this.lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		this.lblNewLabel.setBounds(0, 120, 400, 30);
		this.contentPane.add(this.lblNewLabel);
		
		txtMsg = new JLabel();
		txtMsg.setForeground(new Color(69, 69, 69));
		txtMsg.setMaximumSize(new Dimension(280, 0));
		txtMsg.setVerticalAlignment(SwingConstants.TOP);
		txtMsg.setHorizontalAlignment(SwingConstants.CENTER);
		txtMsg.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		txtMsg.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtMsg.setBorder(null);
		txtMsg.setBounds(60, 160, 280, 90);
		this.contentPane.add(txtMsg);
		this.setFocusableWindowState(true);
		requestFocus();
		setMsgText("Lỗi này là gì tôi cũng không biết nữa, bạn tự fix đi!");
		defineThing();
	}

	private void setMsgText(String msg) {
		final String html = "<html><center><body style='width: %1spx'>%1s";
		txtMsg.setText(String.format(html, 200, msg));
	}

	private void defineThing() {
		icon = FontIcon.of(FontAwesomeSolid.EXCLAMATION_TRIANGLE);
		icon.setIconSize(lblIcon.getFont().getSize());
		icon.setIconColor(btnConfirm.getBackground());
		lblIcon.setIcon(icon);
		btnConfirm.addActionListener(e -> {
			dispose();
		});
		btnConfirm.setFocusPainted(false);
	}
	
	private void setLocationRelativeComponent(Component relaComp) {
		if (relaComp != null) {
			int x = relaComp.getX() + (relaComp.getWidth() - this.getWidth())/2;
			int y = relaComp.getY() + (relaComp.getHeight() - this.getHeight())/2;
			this.setLocation(x, y);
		} 
	}
	
	public static void showInvalidMsg(String msg, Component relaComp) {
		new Thread(new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				ShowMsg msgNotif =  new ShowMsg();
				msgNotif.setLocationRelativeComponent(relaComp);
				msgNotif.setMsgText(msg);
				msgNotif.setVisible(true);
			}
		}).start();
		return;
	}
	public static void showValidationMsg(String msg, Component relaComp) {
		new Thread(new Runnable() {
			@Override
			public void run() {
				ShowMsg msgNotif =  new ShowMsg();
				msgNotif.setLocationRelativeComponent(relaComp);
				msgNotif.setMsgText(msg);
				msgNotif.btnConfirm.setBackground(Color.decode("#18864b"));
				msgNotif.icon.setIkon(MaterialDesignC.CHECK_CIRCLE);
				msgNotif.icon.setIconColor(Color.decode("#18864b"));
				msgNotif.setVisible(true);
			}
		}).start();
		return;
	}
	
	public static boolean showConfirmDialog(String msg, Component relaComp) {
		result.set(true);
		Thread thisThread = new Thread(new Runnable() {
			@Override
			public void run() {
				ShowMsg msgNotif =  new ShowMsg();
				msgNotif.setLocationRelativeComponent(relaComp);
				msgNotif.setMsgText(msg);
				msgNotif.btnConfirm.setBackground(Color.decode("#18864b"));
				msgNotif.btnConfirm.setSize(200, 50);
				JButton btnUnchange;
				btnUnchange = new JButton("Hủy bỏ");
				btnUnchange.setFont(new Font("Times New Roman", Font.PLAIN, 20));
				btnUnchange.setForeground(new Color(255, 255, 255));
				btnUnchange.setBackground(new Color(246, 86, 86));
				btnUnchange.setBorderPainted(false);
				btnUnchange.setBounds(200, 250, 200, 50);
				btnUnchange.addActionListener(e -> {
	                result.set(false);
					msgNotif.dispose();
				});
				msgNotif.getContentPane().add(btnUnchange);
				msgNotif.icon.setIkon(FontAwesomeSolid.QUESTION_CIRCLE);
				msgNotif.icon.setIconColor(Color.decode("#000000"));
				msgNotif.setVisible(true);
			}
		});
		thisThread.start();
		try {
			thisThread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return result.get();
	}
	
}
