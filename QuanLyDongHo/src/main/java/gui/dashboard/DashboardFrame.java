package gui.dashboard;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Dimension;
import java.awt.BorderLayout;
import javax.swing.border.EtchedBorder;
import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ButtonGroup;
import javax.swing.JToggleButton;
import java.awt.Color;
import java.awt.Cursor;

import javax.swing.plaf.metal.MetalToggleButtonUI;

import org.kordamp.ikonli.fontawesome5.FontAwesomeSolid;
import org.kordamp.ikonli.swing.FontIcon;
import javax.swing.JLabel;
import java.awt.Rectangle;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.MatteBorder;

public class DashboardFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel pnSidebar;
	private JPanel pnContent;
	private JPanel pnHeader;
	private JPanel pnNavigation;
	private JPanel pnLogout;
	private ButtonGroup btnGroup = new ButtonGroup();
	private JLabel lblCurrentUser;
	private JLabel lblPosition;
	private JLabel lblIcon;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
					DashboardFrame frame = new DashboardFrame();
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
	public DashboardFrame() {
		setBounds(new Rectangle(10, 10, 1400, 800));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.contentPane = new JPanel();
		this.contentPane.setPreferredSize(new Dimension(1400, 800));
		this.contentPane.setBorder(null);

		setContentPane(this.contentPane);
		this.contentPane.setLayout(new BorderLayout(0, 0));
		
		this.pnSidebar = new JPanel();
		this.pnSidebar.setBackground(new Color(42, 62, 80));
		this.pnSidebar.setBorder(new MatteBorder(0, 0, 0, 1, (Color) new Color(0, 0, 0)));
		this.pnSidebar.setPreferredSize(new Dimension(250, 10));
		this.contentPane.add(this.pnSidebar, BorderLayout.WEST);
		this.pnSidebar.setLayout(new BorderLayout(0, 0));
		
		this.pnHeader = new JPanel();
		this.pnHeader.setBackground(this.pnSidebar.getBackground());
		this.pnHeader.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		this.pnHeader.setPreferredSize(new Dimension(10, 70));
		this.pnSidebar.add(this.pnHeader, BorderLayout.NORTH);
		this.pnHeader.setLayout(null);
		
		this.lblCurrentUser = new JLabel("Nguyễn Văn A");
		this.lblCurrentUser.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		this.lblCurrentUser.setForeground(new Color(255, 255, 255));
		this.lblCurrentUser.setFont(new Font("JetBrains Mono", Font.BOLD, 15));
		this.lblCurrentUser.setBounds(60, 15, 180, 20);
		this.pnHeader.add(this.lblCurrentUser);
		
		this.lblPosition = new JLabel("Warehouse Manager");
		this.lblPosition.setForeground(new Color(255, 255, 255));
		this.lblPosition.setFont(new Font("JetBrains Mono", Font.PLAIN, 10));
		this.lblPosition.setBounds(60, 35, 180, 20);
		this.pnHeader.add(this.lblPosition);
		
		this.lblIcon = new JLabel("");
		this.lblIcon.setHorizontalTextPosition(SwingConstants.CENTER);
		this.lblIcon.setHorizontalAlignment(SwingConstants.CENTER);
		this.lblIcon.setBounds(10, 15, 40, 40);
		FontIcon circleIcon = FontIcon.of(FontAwesomeSolid.USER_TAG, 30, Color.white);
		this.lblIcon.setIcon(circleIcon);
		this.pnHeader.add(this.lblIcon);
		
		this.pnNavigation = new JPanel();
		this.pnNavigation.setBackground(this.pnSidebar.getBackground());
		this.pnNavigation.setBorder(new EmptyBorder(15, 0, 15, 0));
		this.pnSidebar.add(this.pnNavigation, BorderLayout.CENTER);
		this.pnNavigation.setLayout(new GridLayout(15, 0, 0, 5));
		
		this.pnLogout = new JPanel();
		this.pnLogout.setBackground(this.pnSidebar.getBackground());
		this.pnLogout.setPreferredSize(new Dimension(10, 40));
		this.pnSidebar.add(this.pnLogout, BorderLayout.SOUTH);
		
		this.pnContent = new JPanel();
		this.contentPane.add(this.pnContent, BorderLayout.CENTER);
		this.pnContent.setLayout(null);
		
		FunctionBtn homeFunc = new FunctionBtn(FunctionBtn.HOME);
		addFunction(homeFunc);
		homeFunc.getToggleButton().doClick();
		addLogoutBtn();
		
	}
	

	public void addFunction(FunctionBtn func) {
		JToggleButton tgl = func.getToggleButton();
		JPanel panel = func.getPanel();
		this.btnGroup.add(tgl);
		this.pnNavigation.add(tgl);
		tgl.addItemListener(e -> {
			if (e.getStateChange() == ItemEvent.SELECTED) {
				contentPane.remove(pnContent);
				pnContent = panel;
				contentPane.add(pnContent, BorderLayout.CENTER);
				contentPane.revalidate();
				contentPane.repaint();
				tgl.setBackground(new Color(255, 209, 82));
				tgl.setForeground(new Color(21, 28, 38));
				((FontIcon) tgl.getIcon()).setIconColor(tgl.getForeground());
			} else if (e.getStateChange() == ItemEvent.DESELECTED) {
				tgl.setBackground(pnSidebar.getBackground());
				tgl.setForeground(Color.white);
				((FontIcon) tgl.getIcon()).setIconColor(tgl.getForeground());
			}
		});
	}
	
	private void addLogoutBtn() {
		JToggleButton toggleButton = new JToggleButton();
		toggleButton.setBackground(new Color(42, 62, 80));
		toggleButton.setHorizontalAlignment(SwingConstants.LEFT);
		toggleButton.setBorder(new EmptyBorder(0, 15, 0, 0));
		toggleButton.setFont(new Font("JetBrains Mono", Font.PLAIN, 18));
		toggleButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		toggleButton.setForeground(Color.white);
		FontIcon icon = FontIcon.of(FontAwesomeSolid.DOOR_OPEN);
		icon.setIconColor(Color.white);
		icon.setIconSize(toggleButton.getFont().getSize());
		int realGap = 15 + (icon.getIconHeight() - icon.getIconWidth());
		this.pnLogout.setLayout(new GridLayout(0, 1, 0, 0));
		toggleButton.setIcon(icon);
		toggleButton.setIconTextGap(realGap);
		toggleButton.setText("Đăng xuất");
		toggleButton.setUI(new MetalToggleButtonUI() {
			@Override
		    protected Color getFocusColor() {
		        return toggleButton.getBackground();
		    }
		    protected Color getSelectColor() {
		        return toggleButton.getBackground();
		    }
		});
		this.pnLogout.add(toggleButton);
		toggleButton.addMouseListener(new MouseAdapter() {
		    @Override
			public void mouseEntered(MouseEvent e) {
		    	if (!toggleButton.isSelected()) {
		    		toggleButton.setBackground(Color.white);
		    		toggleButton.setForeground(Color.black);
		    		((FontIcon) toggleButton.getIcon()).setIconColor(Color.black);
		    	}
		    }
		    @Override
		    public void mouseExited(MouseEvent e) {
		    	if (!toggleButton.isSelected()) {
		    		toggleButton.setBackground(new Color(42, 62, 80));
		    		toggleButton.setForeground(Color.white);
		    		((FontIcon) toggleButton.getIcon()).setIconColor(Color.white);
		    	}
		    }
		});
	}
	
	protected void changeLabel(String name, String position) {
		lblCurrentUser.setText(name);
		lblPosition.setText(position);
		lblCurrentUser.addMouseListener(new MouseAdapter() {
			@Override
		    public void mouseEntered(MouseEvent e) {
				lblCurrentUser.setText("<html><u>" + name + "</u></html>");
		    }
			@Override
		    public void mouseExited(MouseEvent e) {
				lblCurrentUser.setText(name);
		    }
			@Override
		    public void mouseClicked(MouseEvent e) {
				JFrame fr = new UserInfo();
				fr.setLocationRelativeTo(null);
				fr.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				fr.setVisible(true);
		    }
		});
	}
}
