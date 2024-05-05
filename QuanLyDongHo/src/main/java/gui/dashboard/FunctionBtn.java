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
import org.kordamp.ikonli.materialdesign2.MaterialDesignC;
import org.kordamp.ikonli.materialdesign2.MaterialDesignS;
import org.kordamp.ikonli.swing.FontIcon;

import system.ConfigPRJ;


public class FunctionBtn {
	private JToggleButton toggleButton = new JToggleButton();
	private JPanel panel = new JPanel();
	private FontIcon icon;
	
	public final static String HOME = "HOME";
	public final static String PRODUCTS = "PRODUCTS";
	public final static String ORDERS = "ORDERS";
	public final static String RECEIPTS = "RECEIPTS";
	public final static String CUSTOMERS = "CUSTOMERS";
	public final static String SUPPLIERS = "SUPPLIERS";
	public final static String EMPLOYEES = "EMPLOYEES";
	public final static String ACCOUNTS = "ACOOUNTS";
	public final static String STATISTICAL = "STATISTICAL";
	public final static String PERMISSION = "PERMISSION";
	public final static String WARRANTY = "WARRANTY";
	public final static String HISTORY = "HISTORY";
	
	
	public JToggleButton getToggleButton() {
		return toggleButton;
	}

	public JPanel getPanel() {
		return panel;
	}

	public FunctionBtn(String type) {
		toggleButton.setBackground(new Color(42, 62, 80));
		toggleButton.setHorizontalAlignment(SwingConstants.LEFT);
		toggleButton.setBorder(new EmptyBorder(0, 15, 0, 0));
		toggleButton.setFont(new Font("JetBrains Mono", Font.PLAIN, 18));
		toggleButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		switch (type) {
		case HOME:
			icon = FontIcon.of(FontAwesomeSolid.HOME);
			toggleButton.setText("Trang chủ");
			panel = new TmpHomePanel();
			ConfigPRJ.menu.put("HOME", panel);
			break;
		case PRODUCTS:
			icon = FontIcon.of(FontAwesomeSolid.SHOPPING_BAG);
			toggleButton.setText("Sản phẩm");
			panel = new ProductManagerGUI();
			ConfigPRJ.menu.put("PRODUCTS", panel);
			break;
		case ORDERS:
			icon = FontIcon.of(FontAwesomeSolid.INBOX);
			toggleButton.setText("Phiếu xuất");
			panel.setBackground(Color.decode("#939201"));
			panel = new PhieuXuatGUI();
			ConfigPRJ.menu.put("ORDERS", panel);
			break;
		case RECEIPTS:
			icon = FontIcon.of(FontAwesomeSolid.ENVELOPE_OPEN_TEXT);
			toggleButton.setText("Phiếu nhập");
			panel = new PhieuNhapGUI();
			ConfigPRJ.menu.put("RECEIPTS", panel);
			break;
		case CUSTOMERS:
			icon = FontIcon.of(FontAwesomeSolid.USERS);
			toggleButton.setText("Khách hàng");
			panel = new CustomerManagerGUI();
			ConfigPRJ.menu.put("CUSTOMERS", panel);
			break;
		case SUPPLIERS:
			icon = FontIcon.of(FontAwesomeSolid.TRUCK);
			toggleButton.setText("Nhà cung cấp");
			panel = new zSuppliersGUI();
			ConfigPRJ.menu.put("SUPPLIERS", panel);
			break;
		case EMPLOYEES:
			icon = FontIcon.of(FontAwesomeSolid.ADDRESS_CARD);
			toggleButton.setText("Nhân viên");
			panel = new EmployeesGUI();
			ConfigPRJ.menu.put("EMPLOYEES", panel);
			break;
		case ACCOUNTS:
			icon = FontIcon.of(FontAwesomeSolid.KEY);
			toggleButton.setText("Tài khoản");
			panel = new TmpHomePanel();
			ConfigPRJ.menu.put("ACCOUNTS", panel);
			break;
		case STATISTICAL:
			icon = FontIcon.of(FontAwesomeSolid.CHART_LINE);
			toggleButton.setText("Thống kê");
			panel = new StatisticalGUI();
			ConfigPRJ.menu.put("STATISTICAL", panel);
			break;
		case PERMISSION:
			icon = FontIcon.of(FontAwesomeSolid.LIST_ALT);
			toggleButton.setText("Phân quyền");
			panel = new PermissionGUI();
			ConfigPRJ.menu.put("PERMISSION", panel);
			break;
		case WARRANTY:
			icon = FontIcon.of(MaterialDesignS.SHIELD_CHECK);
			toggleButton.setText("Bảo hành");
			ConfigPRJ.menu.put("WARRANTY", panel);
			break;
		case HISTORY:
			icon = FontIcon.of(MaterialDesignC.CLIPBOARD_TEXT_SEARCH_OUTLINE);
			toggleButton.setText("Lịch sử mua hàng");
			ConfigPRJ.menu.put("HISTORY", panel);
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
