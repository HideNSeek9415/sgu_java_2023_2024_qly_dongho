package system;

import java.io.IOException;

import javax.swing.JOptionPane;
import javax.swing.JTable;

public class ExportManager {
    public static void exportToExcel(JTable table) {
        try {
            JTableExporter.exportJTableToExcel(table);
            JOptionPane.showMessageDialog(null, "Đã xuất file EXCEL thành công", "Thành công", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Đã xảy ra lỗi khi xuất file Excel!", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }
}