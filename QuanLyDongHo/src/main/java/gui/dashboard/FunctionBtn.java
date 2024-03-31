package gui.dashboard;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.metal.MetalToggleButtonUI;

import org.kordamp.ikonli.fontawesome.FontAwesome;
import org.kordamp.ikonli.fontawesome5.FontAwesomeSolid;
import org.kordamp.ikonli.swing.FontIcon;


public class FunctionBtn {
	private JToggleButton toggleButton = new JToggleButton();
	private JPanel panel = new JPanel();
	private FontIcon icon;
	
	public final static int HOME = 1;
	public final static int PRODUCTS = 2;
	public final static int PRODUCT_PROPERTIES = 3;
	public final static int WAREHOUSE = 4;
	public final static int ORDERS = 5;
	public final static int RECIEPTS = 6;
	public final static int CUSTOMERS = 7;
	public final static int SUPPLIES = 8;
	public final static int EMPLOYEES = 9;
	public final static int ACOOUNTS = 10;
	public final static int STATISTICAL = 11;
	public final static int PERMISSION = 12;
	
	
	public JToggleButton getToggleButton() {
		return toggleButton;
	}

	public JPanel getPanel() {
		return panel;
	}

	public FunctionBtn(int type) {
		toggleButton.setBackground(new Color(42, 62, 80));
		toggleButton.setHorizontalAlignment(SwingConstants.LEFT);
		toggleButton.setBorder(new EmptyBorder(0, 15, 0, 0));
		toggleButton.setFont(new Font("JetBrains Mono", Font.PLAIN, 18));
		toggleButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		switch (type) {
		case HOME:
			icon = FontIcon.of(FontAwesomeSolid.HOME);
			toggleButton.setText("Trang chủ");
			panel = new NewJPanel(true, true, true, true, true, true, true) {};
			break;
		case PRODUCTS:
			icon = FontIcon.of(FontAwesomeSolid.SHOPPING_BAG);
			toggleButton.setText("Sản phẩm");
			panel = new ProductManagerGUI();
			break;
		case PRODUCT_PROPERTIES:
			icon = FontIcon.of(FontAwesomeSolid.SHAPES);
			toggleButton.setText("Thuộc tính SP");
			panel = new NewJPanel(true, true, true, false, false, true, true) {};
			break;
		case WAREHOUSE:
			icon = FontIcon.of(FontAwesomeSolid.BOX_OPEN);
			toggleButton.setText("Kho hàng");
			panel = new NewJPanel(true, false, true, false, true, false, true) {};
			break;
		case ORDERS:
			icon = FontIcon.of(FontAwesomeSolid.INBOX);
			toggleButton.setText("Phiếu xuất");
			panel.setBackground(Color.decode("#939201"));
			panel = new PhieuXuatGUI();
			break;
		case RECIEPTS:
			icon = FontIcon.of(FontAwesomeSolid.ENVELOPE_OPEN_TEXT);
			toggleButton.setText("Phiếu nhập");
			panel = new PhieuNhapGUI();
			break;
		case CUSTOMERS:
			icon = FontIcon.of(FontAwesomeSolid.USERS);
			toggleButton.setText("Khách hàng");
			break;
		case SUPPLIES:
			icon = FontIcon.of(FontAwesomeSolid.TRUCK);
			toggleButton.setText("Nhà cung cấp");
			panel = new SuppliersGUI();
			break;
		case EMPLOYEES:
			icon = FontIcon.of(FontAwesomeSolid.ADDRESS_CARD);
			toggleButton.setText("Nhân viên");
			panel = new EmployeesGUI();
			break;
		case ACOOUNTS:
			icon = FontIcon.of(FontAwesomeSolid.KEY);
			toggleButton.setText("Tài khoản");
			break;
		case STATISTICAL:
			icon = FontIcon.of(FontAwesomeSolid.CHART_LINE);
			toggleButton.setText("Thống kê");
			panel = new StatisticalGUI();
			break;
		case PERMISSION:
			icon = FontIcon.of(FontAwesomeSolid.LIST_ALT);
			toggleButton.setText("Phân quyền");
			break;
		default:
			icon = FontIcon.of(FontAwesome.ANGLE_DOUBLE_DOWN);
			toggleButton.setText("Chưa đặt tên");
		}
		toggleButton.setForeground(Color.white);
		icon.setIconColor(Color.white);
		icon.setIconSize(toggleButton.getFont().getSize());
		setIconTxtGap(15);
		makeHoverEffect();
		changeMetalLooknFeel();
	}
	
	
	private void setIconTxtGap(int gap) {
		int realGap = gap + (icon.getIconHeight() - icon.getIconWidth());
		toggleButton.setIcon(icon);
		toggleButton.setIconTextGap(realGap);
	}

	private void makeHoverEffect() {
		toggleButton.addMouseListener(new MouseAdapter() {
		    public void mouseEntered(MouseEvent e) {
		    	if (!toggleButton.isSelected()) {
		    		toggleButton.setBackground(Color.white);
		    		toggleButton.setForeground(Color.black);
		    		((FontIcon) toggleButton.getIcon()).setIconColor(Color.black);
		    	}
		    }

		    public void mouseExited(MouseEvent e) {
		    	if (!toggleButton.isSelected()) {
		    		toggleButton.setBackground(new Color(42, 62, 80));
		    		toggleButton.setForeground(Color.white);
		    		((FontIcon) toggleButton.getIcon()).setIconColor(Color.white);
		    	}
		    }
		});
	}
	

	private void changeMetalLooknFeel() {
		toggleButton.setUI(new MetalToggleButtonUI() {
			@Override
		    protected Color getSelectColor() {
		        return toggleButton.getBackground();
		    }
		});
		toggleButton.setFocusPainted(false);
	}
	
}
