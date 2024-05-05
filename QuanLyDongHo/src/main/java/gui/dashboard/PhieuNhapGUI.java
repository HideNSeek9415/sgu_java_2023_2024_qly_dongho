package gui.dashboard;

import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.text.SimpleDateFormat;

import javax.swing.JComboBox;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.kordamp.ikonli.materialdesign2.MaterialDesignA;
import org.kordamp.ikonli.materialdesign2.MaterialDesignC;
import org.kordamp.ikonli.materialdesign2.MaterialDesignF;
import org.kordamp.ikonli.materialdesign2.MaterialDesignH;
import org.kordamp.ikonli.materialdesign2.MaterialDesignI;
import org.kordamp.ikonli.materialdesign2.MaterialDesignP;
import org.kordamp.ikonli.materialdesign2.MaterialDesignR;
import org.kordamp.ikonli.swing.FontIcon;

import java.awt.FlowLayout;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

import com.itextpdf.text.DocumentException;
import com.toedter.calendar.JDateChooser;

import bll.ImportInvoiceBLL;
import dao.EmployeeDAO;
import dao.ImportInvoiceDAO;
import de.ExportPDF;
import dto.ImportInvoice;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Cursor;
import java.util.ArrayList;
import java.util.List;

public class PhieuNhapGUI extends JPanel {

	private static final long serialVersionUID = 1L;
	private JPanel panel;
	private JPanel panel_1;
	private JPanel panel_2;
	private JPanel panel_3;
	private JPanel panel_4;
	private JLabel lblNewLabel;
	private JComboBox comboBox;
	private JPanel panel_5;
	private JLabel lblNewLabel_1;
	private JComboBox comboBox_1;
	private JPanel panel_6;
	private JLabel lblNewLabel_2;
	private JSpinner comboBox_2;
	private JPanel panel_7;
	private JLabel lblNewLabel_3;
	private JPanel panel_8;
	private JLabel lblNewLabel_4;
	private JPanel panel_9;
	private JLabel lblNewLabel_5;
	private JSpinner comboBox_5;
	private JScrollPane scrollPane;
	private JTable table;
	private JPanel panel_10;
	private JPanel panel_11;
	private JButton btnthem;
	private JButton btnchitiet;
	private JButton btnxuat;
	private JComboBox comboBox_6;
	private JTextField txtTmKim;
	private JButton btnlammoi;
	private JDateChooser dateChooser;
	private JDateChooser dateChooser_1;
	DefaultTableModel model;

	/**
	 * Create the panel.
	 */
	public PhieuNhapGUI() {
		setBackground(new Color(240, 247, 250));
		setBorder(new EmptyBorder(25, 25, 25, 25));
		setPreferredSize(new Dimension(1150, 800));
		setLayout(new BorderLayout(0, 0));
		
		panel = new JPanel();
		panel.setOpaque(false);
		add(panel);
		panel.setLayout(new BorderLayout(25, 25));
		
		panel_1 = new JPanel();
		panel_1.setOpaque(false);
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setPreferredSize(new Dimension(770, 100));
		panel.add(panel_1, BorderLayout.NORTH);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		panel_10 = new JPanel();
		panel_10.setOpaque(false);
		panel_10.setBackground(new Color(255, 255, 255));
		panel_10.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_10.setPreferredSize(new Dimension(500, 10));
		panel_1.add(panel_10, BorderLayout.WEST);
		panel_10.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 8));
		
		btnthem = new JButton("Thêm");
		btnthem.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnthem.setBackground(new Color(255, 255, 255));
		btnthem.setFocusPainted(false);
		btnthem.setHorizontalTextPosition(SwingConstants.CENTER);
		btnthem.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnthem.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnthem.setPreferredSize(new Dimension(90, 85));
		panel_10.add(btnthem);
		
		btnchitiet = new JButton("Chi tiết");
		btnchitiet.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnchitiet.setBackground(new Color(255, 255, 255));
		btnchitiet.setFocusPainted(false);
		btnchitiet.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnchitiet.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnchitiet.setHorizontalTextPosition(SwingConstants.CENTER);
		btnchitiet.setPreferredSize(new Dimension(90, 85));
		panel_10.add(btnchitiet);
		
		btnxuat = new JButton("PDF");
		btnxuat.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnxuat.setBackground(new Color(255, 255, 255));
		btnxuat.setHorizontalTextPosition(SwingConstants.CENTER);
		btnxuat.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnxuat.setFocusPainted(false);
		btnxuat.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnxuat.setPreferredSize(new Dimension(90, 85));
		panel_10.add(btnxuat);
		
		
		//Thay thế với data của phiếu nhập
		
		
		btnxuat.addActionListener(e -> {
            try {
                // Lấy chỉ mục hàng được chọn từ table
                int selectedRow = table.getSelectedRow();

                // Kiểm tra xem có hàng được chọn không
                if (selectedRow != -1) {
                    // Lấy số lượng dòng trong bảng ChiTietLichSuMuaHang.reloadTable()
                    int rowCount = ChiTietLichSuMuaHang.reloadTable().getRowCount();

                    // Tạo danh sách để lưu các hàng từ ChiTietLichSuMuaHang.reloadTable()
                    List<List<Object>> allRows = new ArrayList<>();

                    // Lặp qua tất cả các hàng trong ChiTietLichSuMuaHang.reloadTable()
                    for (int row = 0; row < rowCount; row++) {
                        // Lấy dữ liệu từ bảng cho mỗi dòng
                        Integer detailsId = (Integer) ChiTietLichSuMuaHang.reloadTable().getValueAt(row, 0);
                        String exportInvoiceId = ChiTietLichSuMuaHang.reloadTable().getValueAt(row, 1).toString();
                        String productName = (String) ChiTietLichSuMuaHang.reloadTable().getValueAt(row, 2);
                        String sellPrice = ChiTietLichSuMuaHang.reloadTable().getValueAt(row, 3).toString();
                        int columnIndex = 1;
                        String fullName = table.getValueAt(selectedRow, columnIndex).toString();
                        
                        // Thêm dòng hiện tại vào danh sách hàng
                        List<Object> rowData = new ArrayList<>();
                        rowData.add(detailsId.toString());
                        rowData.add(exportInvoiceId);
                        rowData.add(productName);
                        rowData.add(sellPrice);
                        rowData.add(fullName);
                        allRows.add(rowData);
                    }

                    // Xuất tất cả các hàng vào PDF
                    ExportPDF.exportRowsToPDF1(allRows);
                    JOptionPane.showMessageDialog(this, "Xuất PDF thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this, "Vui lòng chọn một hàng để xuất PDF!", "Thông báo", JOptionPane.WARNING_MESSAGE);
                }
            } catch (IOException | DocumentException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "Đã xảy ra lỗi khi xuất file PDF!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
        });
		
		panel_11 = new JPanel();
		panel_11.setOpaque(false);
		panel_11.setBackground(new Color(255, 255, 255));
		panel_11.setBorder(new EmptyBorder(30, 20, 40, 20));
		panel_1.add(panel_11, BorderLayout.CENTER);
		panel_11.setLayout(new GridLayout(1, 3, 10, 0));
		
		comboBox_6 = new JComboBox();
		comboBox_6.setBackground(new Color(255, 255, 255));
		comboBox_6.setPreferredSize(new Dimension(120, 30));
		panel_11.add(comboBox_6);
		
		txtTmKim = new JTextField();
		txtTmKim.setForeground(new Color(0, 0, 0));
		txtTmKim.setText("tìm kiếm ...");
		txtTmKim.setSize(new Dimension(200, 0));
		txtTmKim.setPreferredSize(new Dimension(250, 30));
		panel_11.add(txtTmKim);
		txtTmKim.setColumns(10);
		
		btnlammoi = new JButton("Làm mới");
		btnlammoi.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnlammoi.setForeground(new Color(255, 255, 255));
		btnlammoi.setBackground(new Color(64, 128, 128));
		btnlammoi.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnlammoi.setPreferredSize(new Dimension(100, 30));
		panel_11.add(btnlammoi);
		
		panel_2 = new JPanel();
		panel_2.setOpaque(false);
		panel_2.setBackground(new Color(255, 255, 255));
		panel_2.setPreferredSize(new Dimension(250, 10));
		panel.add(panel_2, BorderLayout.WEST);
		panel_2.setLayout(new GridLayout(8, 0, 0, 0));
		
		panel_4 = new JPanel();
		panel_4.setOpaque(false);
		panel_4.setBorder(new EmptyBorder(5, 20, 5, 20));
		panel_2.add(panel_4);
		panel_4.setLayout(new GridLayout(2, 0, 0, 0));
		
		lblNewLabel = new JLabel("Nhà cung cấp");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		panel_4.add(lblNewLabel);
		
		comboBox = new JComboBox();
		comboBox.setBackground(new Color(255, 255, 255));
		panel_4.add(comboBox);
		
		panel_5 = new JPanel();
		panel_5.setOpaque(false);
		panel_5.setBorder(new EmptyBorder(5, 20, 5, 20));
		panel_2.add(panel_5);
		panel_5.setLayout(new GridLayout(2, 0, 0, 0));
		
		lblNewLabel_1 = new JLabel("Nhân viên nhập");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		panel_5.add(lblNewLabel_1);
		
		comboBox_1 = new JComboBox();
		comboBox_1.setBackground(new Color(255, 255, 255));
		panel_5.add(comboBox_1);
		
		panel_7 = new JPanel();
		panel_7.setOpaque(false);
		panel_7.setBorder(new EmptyBorder(5, 20, 5, 20));
		panel_2.add(panel_7);
		panel_7.setLayout(new GridLayout(2, 0, 0, 0));
		
		lblNewLabel_3 = new JLabel("Từ ngày");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		panel_7.add(lblNewLabel_3);
		
		dateChooser = new JDateChooser();
		dateChooser.setOpaque(false);
		dateChooser.setDateFormatString("dd/MM/yyyy");
		dateChooser.setBackground(new Color(240, 247, 250));
		panel_7.add(dateChooser);
		
		panel_8 = new JPanel();
		panel_8.setOpaque(false);
		panel_8.setBorder(new EmptyBorder(5, 20, 5, 20));
		panel_2.add(panel_8);
		panel_8.setLayout(new GridLayout(2, 0, 0, 0));
		
		lblNewLabel_4 = new JLabel("Đến ngày");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 15));
		panel_8.add(lblNewLabel_4);
		
		dateChooser_1 = new JDateChooser();
		dateChooser_1.setOpaque(false);
		dateChooser_1.setDateFormatString("dd/MM/yyyy");
		dateChooser_1.setBackground(new Color(240, 247, 250));
		panel_8.add(dateChooser_1);
		
		panel_9 = new JPanel();
		panel_9.setOpaque(false);
		panel_9.setBorder(new EmptyBorder(5, 20, 5, 20));
		panel_2.add(panel_9);
		panel_9.setLayout(new GridLayout(2, 0, 0, 0));
		
		lblNewLabel_5 = new JLabel("Từ số tiền (VND)");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 15));
		panel_9.add(lblNewLabel_5);
		
		comboBox_5 = new JSpinner();
		comboBox_5.setModel(new SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(100000)));
		panel_9.add(comboBox_5);
		
		panel_6 = new JPanel();
		panel_6.setOpaque(false);
		panel_6.setBorder(new EmptyBorder(5, 20, 5, 20));
		panel_2.add(panel_6);
		panel_6.setLayout(new GridLayout(2, 0, 0, 0));
		
		lblNewLabel_2 = new JLabel("Đến số tiền (VND)");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		panel_6.add(lblNewLabel_2);
		
		comboBox_2 = new JSpinner();
		comboBox_2.setModel(new SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(100000)));
		panel_6.add(comboBox_2);
		
		panel_3 = new JPanel();
		panel_3.setBackground(new Color(255, 255, 255));
		panel.add(panel_3, BorderLayout.CENTER);
		panel_3.setLayout(new BorderLayout(0, 0));
		
		scrollPane = new JScrollPane();
		scrollPane.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		scrollPane.setBackground(new Color(240, 247, 250));
		scrollPane.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_3.add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		table.setRowHeight(20);
		table.setFont(new Font("Tahoma", Font.PLAIN, 15));
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"1", "001", "ho chi minh", "a"},
			},
			new String[] {
				"M\u00E3 phi\u1EBFu nh\u1EADp", "Nh\u00E0 cung c\u1EA5p", "Nh\u00E2n vi\u00EAn nh\u1EADp", "Ng\u00E0y nh\u1EADp"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(51);
		table.getColumnModel().getColumn(1).setPreferredWidth(81);
		table.getColumnModel().getColumn(2).setPreferredWidth(164);
		table.getColumnModel().getColumn(3).setPreferredWidth(85);
		scrollPane.setViewportView(table);
		
		model = (DefaultTableModel) table.getModel();
		
		addIcon();
		makeHoverEff(btnchitiet);
		makeHoverEff(btnxuat);
		makeHoverEff(btnthem);
		makeHoverEff(btnlammoi);
		addStuff();
        reloadTable();
	}

	public void reloadTable() {
	    DefaultTableModel model = (DefaultTableModel) table.getModel();
	    model.setRowCount(0);
	    ArrayList<ImportInvoice> importInvoices = ImportInvoiceDAO.getInstance().readAllData();
	
	    for (ImportInvoice importInvoice : importInvoices) {
	        Object[] data = {
	            importInvoice.getImportInvoiceId(),
	            importInvoice.supplier.getSupplierName(),
	            importInvoice.employee.getFullName(),
	            (new SimpleDateFormat("dd/MM/yyyy")).format(importInvoice.getInvoiceDate())
	        };
	        model.addRow(data);
	    }
	}
	private void addStuff() {
		btnthem.addActionListener(e -> {
			JFrame fr = new ThemPhieuNhap();
			fr.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			fr.setLocationRelativeTo(null);
			fr.setVisible(true);
		});
		btnchitiet.addActionListener(e -> {
			int id = (Integer) table.getValueAt(table.getSelectedRow(), 0);
			JFrame fr = new ChiTietPhieuNhap(ImportInvoiceBLL.getImportInvoiceById(id));
			fr.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			fr.setLocationRelativeTo(null);
			fr.setVisible(true);
		});
	}

	private void addIcon() {
		// TODO Auto-generated method stub
		btnthem.setIcon(FontIcon.of(MaterialDesignP.PLUS_CIRCLE, 50, Color.decode("#2ecc71")));
		btnchitiet.setIcon(FontIcon.of(MaterialDesignI.INFORMATION,50,Color.decode("#2196f3")));
		btnxuat.setIcon(FontIcon.of(MaterialDesignP.PDF_BOX,50,Color.decode("#fe231b")));
		btnlammoi.setIcon(FontIcon.of(MaterialDesignR.RELOAD,20,Color.white));
		
	}
	
	private void makeHoverEff(AbstractButton btn) {
        Color iconColor = ((FontIcon) btn.getIcon()).getIconColor();
        Color bg = btn.getBackground();
        Color fore = btn.getForeground();
        if (!btn.isEnabled()) {
                ((FontIcon) btn.getIcon()).setIconColor(Color.decode("#999999"));
                return;
        }
        btn.removeActionListener(null);
        btn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                if (btn.isEnabled()) {
                    btn.setBackground(Color.decode("#4b545b"));
                    btn.setForeground(Color.white);
                    ((FontIcon) btn.getIcon()).setIconColor(Color.white);
                } 
            }

            @Override
            public void mouseExited(MouseEvent e) {
                if (btn.isEnabled()) {
                        btn.setBackground(bg);
                        btn.setForeground(fore);
                        ((FontIcon) btn.getIcon()).setIconColor(iconColor);
                }
            }
        });
    }


}
