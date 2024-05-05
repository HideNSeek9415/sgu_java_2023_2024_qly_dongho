package gui.dashboard;

import javax.swing.JPanel;

import com.itextpdf.text.DocumentException;
import de.ExportPDF;

import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ItemEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
import com.toedter.calendar.JDateChooser;

import bll.ExportInvoiceBLL;
import dao.CustomerDAO;
import dao.EmployeeDAO;
import dao.ExportInvoiceDAO;
import dao.ProductDAO;
import de.ExportPDF;
import dto.ExportInvoice;
import dto.Product;
import system.JTableExporter;

import java.awt.Cursor;
import javax.swing.JFrame;
import javax.swing.DefaultComboBoxModel;

public class LichSuMuaHangGUI extends JPanel {

    private static final long serialVersionUID = 1L;
    private JPanel panel;
    private JPanel panel_1;
    private JPanel panel_2;
    private JPanel panel_3;
    private JPanel panel_7;
    private JLabel lblNewLabel_3;
    private JPanel panel_8;
    private JLabel lblNewLabel_4;
    private JScrollPane scrollPane;
    private JTable table;
    private JPanel panel_10;
    private JPanel panel_11;
    private JButton btnchitiet;
    private JButton btnhuy;
    private JButton btnxuat;
    private JComboBox comboBox_6;
    private JTextField txtTmKim;
    private JButton btnlammoi;
    private JDateChooser dateChooser;
    private JDateChooser dateChooser_1;
    private JButton btnTimKiem;
    private JPanel panel_4;
    private JLabel lblStatus;
    private JComboBox comboBoxStatus;

    /**
     * Create the panel.
     */
    public LichSuMuaHangGUI() {
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

        btnchitiet = new JButton("Chi tiết");
        btnchitiet.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnchitiet.setBackground(new Color(255, 255, 255));
        btnchitiet.setFocusPainted(false);
        btnchitiet.setFont(new Font("Tahoma", Font.BOLD, 14));
        btnchitiet.setVerticalTextPosition(SwingConstants.BOTTOM);
        btnchitiet.setHorizontalTextPosition(SwingConstants.CENTER);
        btnchitiet.setPreferredSize(new Dimension(90, 85));
        panel_10.add(btnchitiet);

        btnxuat = new JButton("Excel");
        btnxuat.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnxuat.setBackground(new Color(255, 255, 255));
        btnxuat.setHorizontalTextPosition(SwingConstants.CENTER);
        btnxuat.setVerticalTextPosition(SwingConstants.BOTTOM);
        btnxuat.setFocusPainted(false);
        btnxuat.setFont(new Font("Tahoma", Font.BOLD, 14));
        btnxuat.setPreferredSize(new Dimension(90, 85));
        panel_10.add(btnxuat);
        
     
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
                        Date date = (Date) table.getValueAt(selectedRow, 3);
                        
                        // Thêm dòng hiện tại vào danh sách hàng
                        List<Object> rowData = new ArrayList<>();
                        rowData.add(detailsId.toString());
                        rowData.add(exportInvoiceId);
                        rowData.add(productName);
                        rowData.add(sellPrice);
                        rowData.add(fullName);
                        rowData.add(date);                      
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
        
                btnTimKiem = new JButton("Tìm kiếm");
                panel_11.add(btnTimKiem);
                btnTimKiem.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                btnTimKiem.setBackground(new Color(255, 255, 255));
                btnTimKiem.setHorizontalTextPosition(SwingConstants.CENTER);
                btnTimKiem.setVerticalTextPosition(SwingConstants.BOTTOM);
                btnTimKiem.setFocusPainted(false);
                btnTimKiem.setFont(new Font("Tahoma", Font.BOLD, 14));
                btnTimKiem.setPreferredSize(new Dimension(90, 85));
                
                        btnTimKiem.addActionListener(e -> {
                            performSearch();
                        });

        

        txtTmKim = new JTextField();
        txtTmKim.setForeground(new Color(0, 0, 0));
        txtTmKim.setSize(new Dimension(200, 0));
        txtTmKim.setPreferredSize(new Dimension(250, 30));
        panel_11.add(txtTmKim);
        txtTmKim.setColumns(10);

        /*txtTmKim.getDocument().addDocumentListener((DocumentListener) new DocumentListener() {
            public void insertUpdate(DocumentEvent e) {
                // Lấy từ khóa tìm kiếm từ text field
                String keyword = txtTmKim.getText().trim().toLowerCase();
                ;
                // Lấy giá trị hiện tại của comboBox_6
                String selectedOption = (String) comboBox_6.getSelectedItem();
                // Thực hiện tìm kiếm dựa trên lựa chọn của comboBox_6 và từ khóa tìm kiếm
                if (selectedOption.equals("Tên Nhân viên")) {
                    searchByName(keyword);
                } else if (selectedOption.equals("Tên Khách hàng")) {
                    searchByCustomerName(keyword);
                }
            }

            public void removeUpdate(DocumentEvent e) {
                insertUpdate(e);
            }

            public void changedUpdate(DocumentEvent e) {
                // Do nothing
            }
        });*/

        btnlammoi = new JButton("Làm mới");
        btnlammoi.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnlammoi.setForeground(new Color(255, 255, 255));
        btnlammoi.setBackground(new Color(64, 128, 128));
        btnlammoi.setFont(new Font("Tahoma", Font.BOLD, 14));
        btnlammoi.setPreferredSize(new Dimension(100, 30));
        panel_11.add(btnlammoi);

        btnlammoi.addActionListener(e -> {
            // Gọi phương thức làm mới
            refresh();
        });

        panel_2 = new JPanel();
        panel_2.setOpaque(false);
        panel_2.setBackground(new Color(255, 255, 255));
        panel_2.setPreferredSize(new Dimension(250, 10));
        panel.add(panel_2, BorderLayout.WEST);
        panel_2.setLayout(new GridLayout(8, 0, 0, 0));

        panel_7 = new JPanel();
        panel_7.setOpaque(false);
        panel_7.setBorder(new EmptyBorder(5, 20, 5, 20));
        panel_2.add(panel_7);
        panel_7.setLayout(new GridLayout(2, 0, 0, 0));

        lblNewLabel_3 = new JLabel("Từ ngày");
        lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 15));
        panel_7.add(lblNewLabel_3);

        dateChooser = new JDateChooser();
        dateChooser.setDateFormatString("dd/MM/yyyy");
        dateChooser.setOpaque(false);
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
        dateChooser_1.setDateFormatString("dd/MM/yyyy");
        dateChooser_1.setOpaque(false);
        panel_8.add(dateChooser_1);

        panel_4 = new JPanel();
        panel_4.setOpaque(false);
        panel_4.setBorder(new EmptyBorder(5, 20, 5, 20));
        panel_2.add(panel_4);
        panel_4.setLayout(new GridLayout(2, 0, 0, 0));

        lblStatus = new JLabel("Trạng thái");
        lblStatus.setFont(new Font("Tahoma", Font.BOLD, 15));
        panel_4.add(lblStatus);

        comboBoxStatus = new JComboBox();
        comboBoxStatus.setModel(new DefaultComboBoxModel(new String[] {"Chưa duyệt ⚠️", "Đã duyệt ✅"}));
        panel_4.add(comboBoxStatus);

        panel_3 = new JPanel();
        panel_3.setBackground(new Color(255, 255, 255));
        panel.add(panel_3, BorderLayout.CENTER);
        panel_3.setLayout(new BorderLayout(0, 0));

        scrollPane = new JScrollPane();
        scrollPane.setFont(new Font("Tahoma", Font.PLAIN, 15));
        panel_3.add(scrollPane, BorderLayout.CENTER);

        // Moved here to ensure initialization before calling displayHistory
        table = new JTable();
        table.setRowHeight(20);
        table.setFont(new Font("Tahoma", Font.PLAIN, 15));
        table.setModel(new DefaultTableModel(
                new Object[][]{},
                new String[]{"Mã phiếu xuất", "Khách hàng", "Nhân viên nhập", "Thời gian", "Trạng thái"}
        ) {
            boolean[] columnEditables = new boolean[]{
                false, true, true, true
            };

            public boolean isCellEditable(int row, int column) {
                return columnEditables[column];
            }
        });

        table.getColumnModel().getColumn(0).setResizable(false);
        table.getColumnModel().getColumn(0).setPreferredWidth(51);
        table.getColumnModel().getColumn(1).setPreferredWidth(81);
        table.getColumnModel().getColumn(2).setPreferredWidth(164);
        table.getColumnModel().getColumn(3).setPreferredWidth(85);
        scrollPane.setViewportView(table);

        ExportInvoiceDAO historyDAO = ExportInvoiceDAO.getInstance();
        ArrayList<ExportInvoice> historylist = historyDAO.readAllDataByCustomerId(1);

        displayHistory(historylist);

        addIcon();
        makeHoverEff(btnchitiet);
        makeHoverEff(btnxuat);
        makeHoverEff(btnlammoi);
        addStuff();
    }

    private void addStuff() {
		btnchitiet.addActionListener(e -> {
                        int Sid = (Integer) table.getValueAt(table.getSelectedRow(), 0);
                        ChiTietLichSuMuaHang.selectedExport = ExportInvoiceBLL.getByID(Sid);
			JFrame fr = new ChiTietLichSuMuaHang();
			fr.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			fr.setLocationRelativeTo(null);
			fr.setVisible(true);
		});
	}

    private void displayHistory(ArrayList<ExportInvoice> invoiceList) {
        DefaultTableModel model = new DefaultTableModel(
            new Object[][]{},
            new String[]{"Mã hóa đơn", "Tên nhân viên", "Tên khách hàng", "Ngày mua hàng", "Trạng thái"}
        );

        EmployeeDAO employeeDAO = EmployeeDAO.getInstance();
        CustomerDAO customerDAO = CustomerDAO.getInstance();

        for (ExportInvoice invoice : invoiceList) {
            int employeeId = invoice.getEmployeeId();
            int customerId = invoice.getCustomerId();

            String fullNameCus = customerDAO.getFullNameByCustomerId(customerId);
            String fullName = employeeDAO.getFullNameByEmployeeId(employeeId);

            String status = "";
            if (invoice.getExportInvoiceStatus() == 1) {
                status = "Đã duyệt";
            } else if (invoice.getExportInvoiceStatus() == 0) {
                status = "Chưa duyệt";
            }

            Object[] rowData = {
                invoice.getExportInvoiceId(),
                fullName, // Thêm full_name vào rowData
                fullNameCus,
                invoice.getInvoiceDate(),
                status // Sử dụng chuỗi status thay vì giá trị số
            };
            model.addRow(rowData);
        }

        // Set the model to the table
        table.setModel(model);
    }


    public int getRow() {
        return table.getSelectedRow();
    }

    private void refresh() {
        // Lấy lại toàn bộ dữ liệu lịch sử mua hàng
        ArrayList<ExportInvoice> historyList = ExportInvoiceDAO.getInstance().readAllDataByCustomerId(1);      
        displayHistory(historyList);
        dateChooser.setDate(null);
        dateChooser_1.setDate(null);
        txtTmKim.setText("");
    }

    private void searchByName(String keyword) {

        ArrayList<ExportInvoice> historyList = ExportInvoiceDAO.getInstance().readAllData();
        ArrayList<ExportInvoice> searchResult = new ArrayList<>();
        for (ExportInvoice invoice : historyList) {
            int employeeId = invoice.getEmployeeId();

            String employeeName = EmployeeDAO.getInstance().getFullNameByEmployeeId(employeeId).toLowerCase();

            if (employeeName.contains(keyword)) {

                searchResult.add(invoice);
            }
        }
        displayHistory(searchResult);
    }

    private void searchByCustomerName(String keyword) {
        ArrayList<ExportInvoice> historyList = ExportInvoiceDAO.getInstance().readAllData();
        ArrayList<ExportInvoice> searchResult = new ArrayList<>();
        for (ExportInvoice invoice : historyList) {
            int customerId = invoice.getCustomerId();
            String customerName = CustomerDAO.getInstance().getFullNameByCustomerId(customerId).toLowerCase();
            if (customerName.contains(keyword)) {
                searchResult.add(invoice);
            }
        }
        displayHistory(searchResult);
    }

    private void performSearch() {
        // Lấy thông tin từ txtTimKiem
        String searchKeyword = txtTmKim.getText().trim().toLowerCase();
        
        // Kiểm tra xem dateChooser và dateChooser_1 đã được khởi tạo hay chưa
        if (dateChooser.getDate() == null || dateChooser_1.getDate() == null) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn cả ngày bắt đầu và ngày kết thúc!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Get start date from dateChooser
        Date startDateUtil = dateChooser.getDate();
        java.sql.Date startDateSql = new java.sql.Date(startDateUtil.getTime());

        // Get end date from dateChooser_1
        Date endDateUtil = dateChooser_1.getDate();
        java.sql.Date endDateSql = new java.sql.Date(endDateUtil.getTime());

        // Get status from comboBoxStatus
        int status = comboBoxStatus.getSelectedIndex();

        // Call the search method from the BLL class and pass the converted dates, status, and search keyword
        ArrayList<ExportInvoice> resultList = ExportInvoiceBLL.getInstance().search(startDateSql, endDateSql, status, searchKeyword,1);

        // Create a table model with column names
        DefaultTableModel model = new DefaultTableModel(
                new Object[][]{},
                new String[]{"Mã hóa đơn", "Tên nhân viên", "Tên khách hàng", "Ngày mua hàng", "Trạng thái"}
        );

        // Initialize DAO objects
        EmployeeDAO employeeDAO = EmployeeDAO.getInstance();
        CustomerDAO customerDAO = CustomerDAO.getInstance();

        // Fill the table model with search results
        for (ExportInvoice invoice : resultList) {
            // Lấy employee_id từ ExportInvoice
            int employeeId = invoice.getEmployeeId();
            int customerId = invoice.getCustomerId();

            String fullNameCus = customerDAO.getFullNameByCustomerId(customerId);
            String fullName = employeeDAO.getFullNameByEmployeeId(employeeId);

            String statusStr = "";
            if (invoice.getExportInvoiceStatus() == 1) {
                statusStr = "Đã duyệt";
            } else if (invoice.getExportInvoiceStatus() == 0) {
                statusStr = "Chưa duyệt";
            }

            Object[] rowData = {
                invoice.getExportInvoiceId(),
                fullName, 
                fullNameCus,
                invoice.getInvoiceDate(),
                statusStr 
            };
            model.addRow(rowData);
        }

        // Set the model to the table
        table.setModel(model);
    }




    private void addIcon() {
        btnchitiet.setIcon(FontIcon.of(MaterialDesignI.INFORMATION, 50, Color.decode("#2196f3")));
        btnxuat.setIcon(FontIcon.of(MaterialDesignF.FILE_EXCEL, 50, Color.decode("#147943")));
        btnlammoi.setIcon(FontIcon.of(MaterialDesignR.RELOAD, 20, Color.white));

    }

    private void makeHoverEff(AbstractButton btn) {
        Color iconColor = ((FontIcon) btn.getIcon()).getIconColor();
        Color bg = btn.getBackground();
        Color fore = btn.getForeground();
        if (!btn.isEnabled()) {
            ((FontIcon) btn.getIcon()).setIconColor(new Color(153, 153, 153));
        }
        btn.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent arg0) {
                btn.setBackground(new Color(53, 140, 230));
                btn.setForeground(Color.white);
            }

            public void mouseExited(MouseEvent e) {
                btn.setBackground(bg);
                btn.setForeground(fore);
            }
        });
    }
}
