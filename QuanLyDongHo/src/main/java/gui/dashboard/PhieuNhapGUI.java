package gui.dashboard;

import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;
import java.text.SimpleDateFormat;

import javax.swing.JComboBox;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

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
import dao.SupplierDAO;
import de.ExportPDF;
import dto.Employee;
import dto.ImportInvoice;
import dto.Supplier;
import system.ConfigPRJ;

import java.awt.Cursor;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class PhieuNhapGUI extends JPanel {

	private static final long serialVersionUID = 1L;
	private JPanel panel;
	private JPanel panel_1;
	private JPanel panel_2;
	private JPanel panel_3;
	private JPanel panel_4;
	private JLabel lblNewLabel;
	private JComboBox supplierSelection;
	private JPanel panel_5;
	private JLabel lblNewLabel_1;
	private JComboBox staffSelection;
	private JPanel panel_7;
	private JLabel lblNewLabel_3;
	private JPanel panel_8;
	private JLabel lblNewLabel_4;
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
	private JDateChooser dateBegin;
	private JDateChooser dateEnd;
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
		
		supplierSelection = new JComboBox();
		supplierSelection.setBackground(new Color(255, 255, 255));
		panel_4.add(supplierSelection);
		
		panel_5 = new JPanel();
		panel_5.setOpaque(false);
		panel_5.setBorder(new EmptyBorder(5, 20, 5, 20));
		panel_2.add(panel_5);
		panel_5.setLayout(new GridLayout(2, 0, 0, 0));
		
		lblNewLabel_1 = new JLabel("Nhân viên nhập");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		panel_5.add(lblNewLabel_1);
		
		staffSelection = new JComboBox();
		staffSelection.setBackground(new Color(255, 255, 255));
		panel_5.add(staffSelection);
		
		panel_7 = new JPanel();
		panel_7.setOpaque(false);
		panel_7.setBorder(new EmptyBorder(5, 20, 5, 20));
		panel_2.add(panel_7);
		panel_7.setLayout(new GridLayout(2, 0, 0, 0));
		
		lblNewLabel_3 = new JLabel("Từ ngày");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		panel_7.add(lblNewLabel_3);
		
		dateBegin = new JDateChooser();
		dateBegin.setOpaque(false);
		dateBegin.setDateFormatString("dd/MM/yyyy");
		dateBegin.setBackground(new Color(240, 247, 250));
		panel_7.add(dateBegin);
		
		panel_8 = new JPanel();
		panel_8.setOpaque(false);
		panel_8.setBorder(new EmptyBorder(5, 20, 5, 20));
		panel_2.add(panel_8);
		panel_8.setLayout(new GridLayout(2, 0, 0, 0));
		
		lblNewLabel_4 = new JLabel("Đến ngày");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 15));
		panel_8.add(lblNewLabel_4);
		
		dateEnd = new JDateChooser();
		dateEnd.setOpaque(false);
		dateEnd.setDateFormatString("dd/MM/yyyy");
		dateEnd.setBackground(new Color(240, 247, 250));
		panel_8.add(dateEnd);
		
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
		addComboBox(); 
        reloadTable();
        addEvent();
	}
	
	private void addEvent() {
		// TODO Auto-generated method stub
        supplierSelection.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                reloadTableAfterFiltered();
            }
        });
        
        staffSelection.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	reloadTableAfterFiltered();
            }
        });
   
        
        dateBegin.getDateEditor().addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
            	// Thuộc tính date của JDateChooser sẽ bị thay đổi khi set giá trị ngày mới
                if ("date".equals(evt.getPropertyName())) {
                    reloadTableAfterFiltered();
                }
            }
        });
        
        dateEnd.getDateEditor().addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
            	// Thuộc tính date của JDateChooser sẽ bị thay đổi khi set giá trị ngày mới
                if ("date".equals(evt.getPropertyName())) {
                    reloadTableAfterFiltered();
                }
            }
        });
	}



	private void addComboBox() {
//		ArrayList<ImportInvoice> suppliersID = ImportInvoiceBLL.getAllSuppliers();
//		ArrayList<ImportInvoice> staffsID = ImportInvoiceBLL.getAllStaffs();
		
		//Add họ và tên nhà cung cấp vào comboBox
		supplierSelection.addItem(" ");
		for(Supplier s : SupplierDAO.getInstance().readAllData()) {
			supplierSelection.addItem(s.getSupplierName());
		}
		
		//Add họ và tên nhân viên vào comboBox
		staffSelection.addItem(" ");
		for(Employee e : EmployeeDAO.getInstance().readAllData()) {
			staffSelection.addItem(e.getFullName());
		}
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
			if (!ConfigPRJ.shwMsg(ConfigPRJ.receipt.get("add"))) return; 
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
	
	private void reloadTableAfterFiltered() {
		Long minPrice = 0L;
		Long maxPrice = 10000000000L;
		String supplierName = supplierSelection.getSelectedItem().toString();
		String staffName = staffSelection.getSelectedItem().toString();
		
		if(supplierSelection.getSelectedIndex() == 0 && staffSelection.getSelectedIndex() != 0
		&& dateBegin == null && dateEnd == null
		&& minPrice == 0 && maxPrice == 0) {
			reloadTable();
		}
		
		else{
			// Tạo ngày 1/1/1
			Calendar calBegin = Calendar.getInstance();
	        calBegin.set(1, Calendar.JANUARY, 1);
	        Date defDateBegin = calBegin.getTime();

	        // Tạo ngày 5/8/2024
	        Calendar calEnd = Calendar.getInstance();
	        calEnd.set(2024, Calendar.AUGUST, 5); // Năm 2024, tháng 8 (lưu ý tháng bắt đầu từ 0)
	        Date defDateEnd = calEnd.getTime();
			
			if (dateBegin.getDate() != null) {
				defDateBegin = dateBegin.getDate();
			}
			
			if (dateEnd.getDate() != null) {
				defDateEnd = dateEnd.getDate();
			}
			
				
				// Kiểm tra điều kiện ngày bắt đầu <= ngày kết thúc
				if (defDateBegin.compareTo(defDateEnd) > 0) {
					JOptionPane.showMessageDialog(getRootPane(), "Vui lòng không nhập ngày bắt đầu lớn hơn ngày kết thúc");
				}
				
				// Kiểm tra giá tối thiếu <= giá tối đa
				if (minPrice > maxPrice ) {
					JOptionPane.showMessageDialog(getRootPane(), "Vui lòng không nhập giá tối đa lớn hơn giá tối thiểu");
				}
				
			    DefaultTableModel model = (DefaultTableModel) table.getModel();
			    model.setRowCount(0);
			    ArrayList<ImportInvoice> importInvoices = ImportInvoiceBLL.readAllData();
			
			    for (ImportInvoice importInvoice : importInvoices) {
			        String ename = importInvoice.employee.getFullName(); // Cập nhật fullNameEmployee
			        String sname = importInvoice.supplier.getSupplierName(); // Cập nhật fullNameEmployee
			        java.sql.Date sqlDefDateBegin = new java.sql.Date(defDateBegin.getTime());
			        java.sql.Date sqlDefDateEnd = new java.sql.Date(defDateEnd.getTime());
			        
			        if(ename.contains(staffName)
			        && sname.contains(supplierName)
			        && sqlDefDateBegin.compareTo(importInvoice.getInvoiceDate()) <= 0
			        && importInvoice.getInvoiceDate().compareTo(sqlDefDateEnd) <= 0
			        // Thêm so sánh giá tiền sau này 
			        )
			        {	
				        Object[] data = {
				            importInvoice.getImportInvoiceId(),
				            ename,
				            sname, // Sử dụng fullNameEmployee
				            (new SimpleDateFormat("dd/MM/yyyy")).format(importInvoice.getInvoiceDate()),
				        };
				        model.addRow(data);
			        }
			    }
		}
	}


}
