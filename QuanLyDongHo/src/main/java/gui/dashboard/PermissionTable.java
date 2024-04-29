package gui.dashboard;

import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.BorderLayout;
import java.awt.Insets;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;

import org.kordamp.ikonli.materialdesign2.MaterialDesignC;
import org.kordamp.ikonli.materialdesign2.MaterialDesignR;
import org.kordamp.ikonli.swing.FontIcon;

import dao.PermissionDAO;
import system.ConfigPRJ;

import java.awt.GridLayout;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.FlowLayout;
import javax.swing.border.EmptyBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Cursor;

public class PermissionTable extends JPanel {

	private static final long serialVersionUID = 1L;
	private JPanel panel;
	private JLabel lblNewLabel;
	private JPanel panel_1;
	private JPanel panel_5;
	private JPanel panel_6;
	private JPanel panel_7;
	private JPanel panel_8;
	private JPanel panel_9;
	private JLabel lblQunLNhn;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_7;
	private JLabel lblNewLabel_8;
	private JPanel panel_10;
	private JPanel panel_11;
	private JLabel lblNewLabel_4;
	private JCheckBox cbNVS;
	private JPanel panel_12;
	private JLabel lblNewLabel_9;
	private JCheckBox cbNVX;
	private JPanel panel_14;
	private JPanel panel_15;
	private JLabel lblNewLabel_11;
	private JCheckBox cbKHS;
	private JPanel panel_16;
	private JLabel lblNewLabel_12;
	private JCheckBox cbKHX;
	private JPanel panel_18;
	private JPanel panel_19;
	private JLabel lblNewLabel_14;
	private JCheckBox cbPXT;
	private JPanel panel_20;
	private JLabel cscsccaw;
	private JCheckBox cbPXS;
	private JPanel panel_22;
	private JPanel panel_23;
	private JLabel lblNewLabel_17;
	private JCheckBox cbPNT;
	private JPanel panel_24;
	private JLabel lblNewLabel_18;
	private JCheckBox cbPNS;
	private JPanel panel_26;
	private JPanel panel_30;
	private JLabel lblNewLabel_23;
	private JCheckBox cbNVT;
	private JPanel panel_21;
	private JButton btnSave;
	private JButton btnReload;
	
	public static final String SLR = "SLR";
	public static final String WHM = "WHM";
	private String role;
	private JPanel panel_13;
	private JPanel panel_17;
	private JPanel panel_25;
	private JPanel panel_27;
	private JPanel panel_28;
	private JLabel lblNewLabel_3;
	private JCheckBox cbBHO;
	private JPanel panel_29;
	private JLabel lblNewLabel_10;
	private JPanel panel_31;
	private JPanel panel_32;
	private JLabel lblNewLabel_13;
	private JCheckBox cbNCCT;
	private JPanel panel_33;
	private JLabel lblNewLabel_16;
	private JCheckBox cbNCCS;
	private JPanel panel_34;
	private JLabel lblNewLabel_19;
	private JCheckBox cbNCCX;
	private JPanel panel_35;
	private JLabel lblNewLabel_20;
	private JCheckBox cbNCCO;
	private JPanel panel_4;
	private JLabel lblNewLabel_21;
	private JCheckBox cbSPT;
	private JPanel panel_2;
	private JLabel lblNewLabel_1;
	private JCheckBox cbSPS;
	private JPanel panel_3;
	private JLabel lblNewLabel_2;
	private JCheckBox cbSPX;

	/**
	 * Create the panel.
	 */
	public PermissionTable(String roleID) {
		role = roleID;
		setBackground(new Color(255, 255, 255));
		setPreferredSize(new Dimension(1110, 700));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 1052, 0, 0};
		gridBagLayout.rowHeights = new int[] {32, 85, 85, 85, 85, 85, 85, 85, 57, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel.setBackground(new Color(255, 255, 255));
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 5, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 1;
		gbc_panel.gridy = 1;
		add(panel, gbc_panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		lblNewLabel = new JLabel("Quản lý sản phẩm");
		lblNewLabel.setBorder(new EmptyBorder(0, 12, 0, 0));
		lblNewLabel.setForeground(new Color(150, 150, 150));
		lblNewLabel.setPreferredSize(new Dimension(265, 16));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		panel.add(lblNewLabel, BorderLayout.WEST);
		
		panel_1 = new JPanel();
		panel_1.setOpaque(false);
		panel.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new GridLayout(0, 4, 0, 0));
		
		panel_4 = new JPanel();
		panel_4.setOpaque(false);
		panel_1.add(panel_4);
		panel_4.setLayout(new GridLayout(2, 0, 0, 0));
		
		lblNewLabel_21 = new JLabel("Thêm mới (NCC)");
		lblNewLabel_21.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_21.setForeground(new Color(77, 77, 77));
		lblNewLabel_21.setFont(new Font("Tahoma", Font.BOLD, 17));
		panel_4.add(lblNewLabel_21);
		
		cbSPT = new JCheckBox("");
		cbSPT.setHorizontalAlignment(SwingConstants.CENTER);
		panel_4.add(cbSPT);
		
		panel_2 = new JPanel();
		panel_2.setOpaque(false);
		panel_1.add(panel_2);
		panel_2.setLayout(new GridLayout(2, 0, 0, 0));
		
		lblNewLabel_1 = new JLabel("Chỉnh sửa");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(new Color(77, 77, 77));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		panel_2.add(lblNewLabel_1);
		
		cbSPS = new JCheckBox("");
		cbSPS.setHorizontalAlignment(SwingConstants.CENTER);
		panel_2.add(cbSPS);
		
		panel_3 = new JPanel();
		panel_3.setOpaque(false);
		panel_1.add(panel_3);
		panel_3.setLayout(new GridLayout(2, 0, 0, 0));
		
		lblNewLabel_2 = new JLabel("Xóa/Khôi phục");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setForeground(new Color(77, 77, 77));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 17));
		panel_3.add(lblNewLabel_2);
		
		cbSPX = new JCheckBox("");
		cbSPX.setHorizontalAlignment(SwingConstants.CENTER);
		panel_3.add(cbSPX);
		
		panel_5 = new JPanel();
		panel_5.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_5.setBackground(new Color(255, 255, 255));
		GridBagConstraints gbc_panel_5 = new GridBagConstraints();
		gbc_panel_5.insets = new Insets(0, 0, 5, 5);
		gbc_panel_5.fill = GridBagConstraints.BOTH;
		gbc_panel_5.gridx = 1;
		gbc_panel_5.gridy = 2;
		add(panel_5, gbc_panel_5);
		panel_5.setLayout(new BorderLayout(0, 0));
		
		lblQunLNhn = new JLabel("Quản lý nhân viên");
		lblQunLNhn.setBorder(new EmptyBorder(0, 12, 0, 0));
		lblQunLNhn.setPreferredSize(new Dimension(265, 16));
		lblQunLNhn.setForeground(new Color(150, 150, 150));
		lblQunLNhn.setFont(new Font("Tahoma", Font.PLAIN, 25));
		panel_5.add(lblQunLNhn, BorderLayout.WEST);
		
		panel_10 = new JPanel();
		panel_10.setOpaque(false);
		panel_5.add(panel_10, BorderLayout.CENTER);
		panel_10.setLayout(new GridLayout(0, 4, 0, 0));
		
		panel_30 = new JPanel();
		panel_30.setOpaque(false);
		panel_10.add(panel_30);
		panel_30.setLayout(new GridLayout(2, 0, 0, 0));
		
		lblNewLabel_23 = new JLabel("Thêm");
		lblNewLabel_23.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_23.setForeground(new Color(77, 77, 77));
		lblNewLabel_23.setFont(new Font("Tahoma", Font.BOLD, 17));
		panel_30.add(lblNewLabel_23);
		
		cbNVT = new JCheckBox("");
		cbNVT.setHorizontalAlignment(SwingConstants.CENTER);
		panel_30.add(cbNVT);
		
		panel_11 = new JPanel();
		panel_11.setOpaque(false);
		panel_10.add(panel_11);
		panel_11.setLayout(new GridLayout(2, 0, 0, 0));
		
		lblNewLabel_4 = new JLabel("Chỉnh sửa");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setForeground(new Color(77, 77, 77));
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 17));
		panel_11.add(lblNewLabel_4);
		
		cbNVS = new JCheckBox("");
		cbNVS.setHorizontalAlignment(SwingConstants.CENTER);
		panel_11.add(cbNVS);
		
		panel_12 = new JPanel();
		panel_12.setOpaque(false);
		panel_10.add(panel_12);
		panel_12.setLayout(new GridLayout(2, 0, 0, 0));
		
		lblNewLabel_9 = new JLabel("Xóa/Khôi phục");
		lblNewLabel_9.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_9.setForeground(new Color(77, 77, 77));
		lblNewLabel_9.setFont(new Font("Tahoma", Font.BOLD, 17));
		panel_12.add(lblNewLabel_9);
		
		cbNVX = new JCheckBox("");
		cbNVX.setHorizontalAlignment(SwingConstants.CENTER);
		panel_12.add(cbNVX);
		
		panel_6 = new JPanel();
		panel_6.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_6.setBackground(new Color(255, 255, 255));
		GridBagConstraints gbc_panel_6 = new GridBagConstraints();
		gbc_panel_6.insets = new Insets(0, 0, 5, 5);
		gbc_panel_6.fill = GridBagConstraints.BOTH;
		gbc_panel_6.gridx = 1;
		gbc_panel_6.gridy = 3;
		add(panel_6, gbc_panel_6);
		panel_6.setLayout(new BorderLayout(0, 0));
		
		lblNewLabel_5 = new JLabel("Quản lý khách hàng");
		lblNewLabel_5.setBorder(new EmptyBorder(0, 12, 0, 0));
		lblNewLabel_5.setPreferredSize(new Dimension(265, 16));
		lblNewLabel_5.setForeground(new Color(150, 150, 150));
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 25));
		panel_6.add(lblNewLabel_5, BorderLayout.WEST);
		
		panel_14 = new JPanel();
		panel_14.setOpaque(false);
		panel_6.add(panel_14, BorderLayout.CENTER);
		panel_14.setLayout(new GridLayout(0, 4, 0, 0));
		
		panel_13 = new JPanel();
		panel_13.setOpaque(false);
		panel_14.add(panel_13);
		
		panel_15 = new JPanel();
		panel_15.setOpaque(false);
		panel_14.add(panel_15);
		panel_15.setLayout(new GridLayout(2, 0, 0, 0));
		
		lblNewLabel_11 = new JLabel("Chỉnh sửa");
		lblNewLabel_11.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_11.setForeground(new Color(77, 77, 77));
		lblNewLabel_11.setFont(new Font("Tahoma", Font.BOLD, 17));
		panel_15.add(lblNewLabel_11);
		
		cbKHS = new JCheckBox("");
		cbKHS.setHorizontalAlignment(SwingConstants.CENTER);
		panel_15.add(cbKHS);
		
		panel_16 = new JPanel();
		panel_16.setOpaque(false);
		panel_14.add(panel_16);
		panel_16.setLayout(new GridLayout(2, 0, 0, 0));
		
		lblNewLabel_12 = new JLabel("Xóa/Khôi phục");
		lblNewLabel_12.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_12.setForeground(new Color(77, 77, 77));
		lblNewLabel_12.setFont(new Font("Tahoma", Font.BOLD, 17));
		panel_16.add(lblNewLabel_12);
		
		cbKHX = new JCheckBox("");
		cbKHX.setHorizontalAlignment(SwingConstants.CENTER);
		panel_16.add(cbKHX);
		
		panel_7 = new JPanel();
		panel_7.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_7.setBackground(new Color(255, 255, 255));
		GridBagConstraints gbc_panel_7 = new GridBagConstraints();
		gbc_panel_7.insets = new Insets(0, 0, 5, 5);
		gbc_panel_7.fill = GridBagConstraints.BOTH;
		gbc_panel_7.gridx = 1;
		gbc_panel_7.gridy = 4;
		add(panel_7, gbc_panel_7);
		panel_7.setLayout(new BorderLayout(0, 0));
		
		lblNewLabel_6 = new JLabel("Quản lý phiếu xuất");
		lblNewLabel_6.setBorder(new EmptyBorder(0, 12, 0, 0));
		lblNewLabel_6.setPreferredSize(new Dimension(265, 16));
		lblNewLabel_6.setForeground(new Color(150, 150, 150));
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 25));
		panel_7.add(lblNewLabel_6, BorderLayout.WEST);
		
		panel_18 = new JPanel();
		panel_18.setOpaque(false);
		panel_7.add(panel_18, BorderLayout.CENTER);
		panel_18.setLayout(new GridLayout(0, 4, 0, 0));
		
		panel_19 = new JPanel();
		panel_19.setOpaque(false);
		panel_18.add(panel_19);
		panel_19.setLayout(new GridLayout(2, 0, 0, 0));
		
		lblNewLabel_14 = new JLabel("Thêm");
		lblNewLabel_14.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_14.setForeground(new Color(77, 77, 77));
		lblNewLabel_14.setFont(new Font("Tahoma", Font.BOLD, 17));
		panel_19.add(lblNewLabel_14);
		
		cbPXT = new JCheckBox("");
		cbPXT.setHorizontalAlignment(SwingConstants.CENTER);
		panel_19.add(cbPXT);
		
		panel_20 = new JPanel();
		panel_20.setOpaque(false);
		panel_18.add(panel_20);
		panel_20.setLayout(new GridLayout(2, 0, 0, 0));
		
		cscsccaw = new JLabel("Chỉnh sửa");
		cscsccaw.setHorizontalAlignment(SwingConstants.CENTER);
		cscsccaw.setForeground(new Color(77, 77, 77));
		cscsccaw.setFont(new Font("Tahoma", Font.BOLD, 17));
		panel_20.add(cscsccaw);
		
		cbPXS = new JCheckBox("");
		cbPXS.setHorizontalAlignment(SwingConstants.CENTER);
		panel_20.add(cbPXS);
		
		panel_8 = new JPanel();
		panel_8.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_8.setBackground(new Color(255, 255, 255));
		GridBagConstraints gbc_panel_8 = new GridBagConstraints();
		gbc_panel_8.insets = new Insets(0, 0, 5, 5);
		gbc_panel_8.fill = GridBagConstraints.BOTH;
		gbc_panel_8.gridx = 1;
		gbc_panel_8.gridy = 5;
		add(panel_8, gbc_panel_8);
		panel_8.setLayout(new BorderLayout(0, 0));
		
		lblNewLabel_7 = new JLabel("Quản lý phiếu nhập");
		lblNewLabel_7.setBorder(new EmptyBorder(0, 12, 0, 0));
		lblNewLabel_7.setPreferredSize(new Dimension(265, 16));
		lblNewLabel_7.setForeground(new Color(150, 150, 150));
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 25));
		panel_8.add(lblNewLabel_7, BorderLayout.WEST);
		
		panel_22 = new JPanel();
		panel_22.setOpaque(false);
		panel_8.add(panel_22, BorderLayout.CENTER);
		panel_22.setLayout(new GridLayout(0, 4, 0, 0));
		
		panel_23 = new JPanel();
		panel_23.setOpaque(false);
		panel_22.add(panel_23);
		panel_23.setLayout(new GridLayout(2, 0, 0, 0));
		
		lblNewLabel_17 = new JLabel("Thêm");
		lblNewLabel_17.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_17.setForeground(new Color(77, 77, 77));
		lblNewLabel_17.setFont(new Font("Tahoma", Font.BOLD, 17));
		panel_23.add(lblNewLabel_17);
		
		cbPNT = new JCheckBox("");
		cbPNT.setHorizontalAlignment(SwingConstants.CENTER);
		panel_23.add(cbPNT);
		
		panel_24 = new JPanel();
		panel_24.setOpaque(false);
		panel_22.add(panel_24);
		panel_24.setLayout(new GridLayout(2, 0, 0, 0));
		
		lblNewLabel_18 = new JLabel("Chỉnh sửa");
		lblNewLabel_18.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_18.setForeground(new Color(77, 77, 77));
		lblNewLabel_18.setFont(new Font("Tahoma", Font.BOLD, 17));
		panel_24.add(lblNewLabel_18);
		
		cbPNS = new JCheckBox("");
		cbPNS.setHorizontalAlignment(SwingConstants.CENTER);
		panel_24.add(cbPNS);
		
		panel_9 = new JPanel();
		panel_9.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_9.setBackground(new Color(255, 255, 255));
		GridBagConstraints gbc_panel_9 = new GridBagConstraints();
		gbc_panel_9.insets = new Insets(0, 0, 5, 5);
		gbc_panel_9.fill = GridBagConstraints.BOTH;
		gbc_panel_9.gridx = 1;
		gbc_panel_9.gridy = 6;
		add(panel_9, gbc_panel_9);
		panel_9.setLayout(new BorderLayout(0, 0));
		
		lblNewLabel_8 = new JLabel("Quản lý bảo hành");
		lblNewLabel_8.setBorder(new EmptyBorder(0, 12, 0, 0));
		lblNewLabel_8.setPreferredSize(new Dimension(265, 16));
		lblNewLabel_8.setForeground(new Color(150, 150, 150));
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 25));
		panel_9.add(lblNewLabel_8, BorderLayout.WEST);
		
		panel_26 = new JPanel();
		panel_26.setOpaque(false);
		panel_9.add(panel_26, BorderLayout.CENTER);
		panel_26.setLayout(new GridLayout(0, 4, 0, 0));
		
		panel_17 = new JPanel();
		panel_17.setOpaque(false);
		panel_26.add(panel_17);
		
		panel_25 = new JPanel();
		panel_25.setOpaque(false);
		panel_26.add(panel_25);
		
		panel_27 = new JPanel();
		panel_27.setOpaque(false);
		panel_26.add(panel_27);
		
		panel_28 = new JPanel();
		panel_28.setOpaque(false);
		panel_26.add(panel_28);
		panel_28.setLayout(new GridLayout(2, 0, 0, 0));
		
		lblNewLabel_3 = new JLabel("Duyệt phiếu");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setForeground(new Color(77, 77, 77));
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 17));
		panel_28.add(lblNewLabel_3);
		
		cbBHO = new JCheckBox("");
		cbBHO.setHorizontalAlignment(SwingConstants.CENTER);
		panel_28.add(cbBHO);
		
		panel_29 = new JPanel();
		panel_29.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_29.setBackground(Color.WHITE);
		GridBagConstraints gbc_panel_29 = new GridBagConstraints();
		gbc_panel_29.insets = new Insets(0, 0, 5, 5);
		gbc_panel_29.fill = GridBagConstraints.BOTH;
		gbc_panel_29.gridx = 1;
		gbc_panel_29.gridy = 7;
		add(panel_29, gbc_panel_29);
		panel_29.setLayout(new BorderLayout(0, 0));
		
		lblNewLabel_10 = new JLabel("Quản lý nhà cung cấp");
		lblNewLabel_10.setPreferredSize(new Dimension(265, 16));
		lblNewLabel_10.setForeground(new Color(150, 150, 150));
		lblNewLabel_10.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_10.setBorder(new EmptyBorder(0, 12, 0, 0));
		panel_29.add(lblNewLabel_10, BorderLayout.WEST);
		
		panel_31 = new JPanel();
		panel_31.setOpaque(false);
		panel_29.add(panel_31, BorderLayout.CENTER);
		panel_31.setLayout(new GridLayout(0, 4, 0, 0));
		
		panel_32 = new JPanel();
		panel_32.setOpaque(false);
		panel_31.add(panel_32);
		panel_32.setLayout(new GridLayout(2, 0, 0, 0));
		
		lblNewLabel_13 = new JLabel("Thêm");
		lblNewLabel_13.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_13.setForeground(new Color(77, 77, 77));
		lblNewLabel_13.setFont(new Font("Tahoma", Font.BOLD, 17));
		panel_32.add(lblNewLabel_13);
		
		cbNCCT = new JCheckBox("");
		cbNCCT.setHorizontalAlignment(SwingConstants.CENTER);
		panel_32.add(cbNCCT);
		
		panel_33 = new JPanel();
		panel_33.setOpaque(false);
		panel_31.add(panel_33);
		panel_33.setLayout(new GridLayout(2, 0, 0, 0));
		
		lblNewLabel_16 = new JLabel("Chỉnh sửa");
		lblNewLabel_16.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_16.setForeground(new Color(77, 77, 77));
		lblNewLabel_16.setFont(new Font("Tahoma", Font.BOLD, 17));
		panel_33.add(lblNewLabel_16);
		
		cbNCCS = new JCheckBox("");
		cbNCCS.setHorizontalAlignment(SwingConstants.CENTER);
		panel_33.add(cbNCCS);
		
		panel_34 = new JPanel();
		panel_34.setOpaque(false);
		panel_31.add(panel_34);
		panel_34.setLayout(new GridLayout(2, 0, 0, 0));
		
		lblNewLabel_19 = new JLabel("Xóa/Khôi phục");
		lblNewLabel_19.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_19.setForeground(new Color(77, 77, 77));
		lblNewLabel_19.setFont(new Font("Tahoma", Font.BOLD, 17));
		panel_34.add(lblNewLabel_19);
		
		cbNCCX = new JCheckBox("");
		cbNCCX.setHorizontalAlignment(SwingConstants.CENTER);
		panel_34.add(cbNCCX);
		
		panel_35 = new JPanel();
		panel_35.setOpaque(false);
		panel_31.add(panel_35);
		panel_35.setLayout(new GridLayout(2, 0, 0, 0));
		
		lblNewLabel_20 = new JLabel("Sửa SP cung cấp");
		lblNewLabel_20.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_20.setForeground(new Color(77, 77, 77));
		lblNewLabel_20.setFont(new Font("Tahoma", Font.BOLD, 17));
		panel_35.add(lblNewLabel_20);
		
		cbNCCO = new JCheckBox("");
		cbNCCO.setHorizontalAlignment(SwingConstants.CENTER);
		panel_35.add(cbNCCO);
		
		panel_21 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_21.getLayout();
		flowLayout.setAlignment(FlowLayout.TRAILING);
		panel_21.setOpaque(false);
		GridBagConstraints gbc_panel_21 = new GridBagConstraints();
		gbc_panel_21.insets = new Insets(0, 0, 0, 5);
		gbc_panel_21.fill = GridBagConstraints.BOTH;
		gbc_panel_21.gridx = 1;
		gbc_panel_21.gridy = 8;
		add(panel_21, gbc_panel_21);
		
		btnSave = new JButton("Lưu");
		btnSave.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSave.setBorderPainted(false);
		btnSave.setFocusPainted(false);
		btnSave.setForeground(new Color(255, 255, 255));
		btnSave.setFont(new Font("SansSerif", Font.BOLD, 17));
		btnSave.setPreferredSize(new Dimension(90, 40));
		btnSave.setBackground(new Color(67, 174, 15));
		btnSave.setIcon(FontIcon.of(MaterialDesignC.CHECK, btnSave.getFont().getSize() + 7, btnSave.getForeground()));
		panel_21.add(btnSave);
		
		btnReload = new JButton("Quay lại");
		btnReload.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnReload.setBorderPainted(false);
		btnReload.setFocusPainted(false);
		btnReload.setPreferredSize(new Dimension(120, 40));
		btnReload.setForeground(Color.WHITE);
		btnReload.setFont(new Font("SansSerif", Font.BOLD, 17));
		btnReload.setBackground(new Color(142, 32, 32));
		btnReload.setIcon(FontIcon.of(MaterialDesignR.RELOAD, btnSave.getFont().getSize() + 7, btnSave.getForeground()));
		panel_21.add(btnReload);
		
		loadEvent();

	}

	private void loadEvent() {
		btnSave.addActionListener(e -> {			
			ConfigPRJ.product.put("add", cbSPT.isSelected());
			ConfigPRJ.product.put("delete", cbSPX.isSelected());
			ConfigPRJ.product.put("edit", cbSPS.isSelected());
						
			ConfigPRJ.employee.put("add", cbNVT.isSelected());
			ConfigPRJ.employee.put("delete", cbNVX.isSelected());
			ConfigPRJ.employee.put("edit", cbNVS.isSelected());
						
			ConfigPRJ.customer.put("delete", cbKHX.isSelected());
			ConfigPRJ.customer.put("edit", cbKHS.isSelected());
						
			ConfigPRJ.order.put("add", cbPNT.isSelected());
			ConfigPRJ.order.put("edit", cbPNS.isSelected());
						
			ConfigPRJ.receipt.put("add", cbPXT.isSelected());
			ConfigPRJ.receipt.put("edit", cbPXS.isSelected());
						
			ConfigPRJ.warranty.put("other", cbBHO.isSelected());
						
			ConfigPRJ.supplier.put("add", cbNCCT.isSelected());
			ConfigPRJ.supplier.put("delete", cbNCCX.isSelected());
			ConfigPRJ.supplier.put("edit", cbNCCS.isSelected());
			ConfigPRJ.supplier.put("other", cbNCCO.isSelected());
			PermissionDAO.instance.savePermission(role);
		});
		btnReload.addActionListener(e -> {
			PermissionDAO.instance.loadPermission(role);
			cbSPT.setSelected(ConfigPRJ.product.get("add"));
			cbSPX.setSelected(ConfigPRJ.product.get("delete"));
			cbSPS.setSelected(ConfigPRJ.product.get("edit"));
			
			cbNVT.setSelected(ConfigPRJ.employee.get("add"));
			cbNVX.setSelected(ConfigPRJ.employee.get("delete"));
			cbNVS.setSelected(ConfigPRJ.employee.get("edit"));
			
			cbKHX.setSelected(ConfigPRJ.customer.get("delete"));
			cbKHS.setSelected(ConfigPRJ.customer.get("edit"));
			
			cbPNT.setSelected(ConfigPRJ.order.get("add"));
			cbPNS.setSelected(ConfigPRJ.order.get("edit"));
			
			cbPXT.setSelected(ConfigPRJ.receipt.get("add"));
			cbPXS.setSelected(ConfigPRJ.receipt.get("edit"));
			
			cbBHO.setSelected(ConfigPRJ.warranty.get("other"));
			
			cbNCCT.setSelected(ConfigPRJ.supplier.get("add"));
			cbNCCX.setSelected(ConfigPRJ.supplier.get("delete"));
			cbNCCS.setSelected(ConfigPRJ.supplier.get("edit"));
			cbNCCO.setSelected(ConfigPRJ.supplier.get("other"));
		});
		btnReload.doClick();
	}
}

