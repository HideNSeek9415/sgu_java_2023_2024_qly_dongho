package gui.dashboard;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTabbedPane;

public class StatisticalGUI extends NewJPanel {

    private static final long serialVersionUID = 1L;
    private JTabbedPane tabbedPane;

    public StatisticalGUI() {
        this.setToolsVisible(false);
        setFilterVisible(false);
        
        pnContent.setLayout(new BorderLayout()); // Đặt layout của pnContent là BorderLayout

        tabbedPane = new JTabbedPane(JTabbedPane.TOP);
        pnContent.add(tabbedPane, BorderLayout.CENTER); // Thêm tabbedPane vào vị trí trung tâm của pnContent

        // Thêm các tab vào tabbedPane
        RevenuePanel revenuePanel = new RevenuePanel();
        tabbedPane.addTab("Doanh thu", null, revenuePanel, null);

        ThongKeKhachHang thongKeKhachHang = new ThongKeKhachHang();
        tabbedPane.addTab("Thống kê khách hàng", null, thongKeKhachHang, null);

        ThongKeLoaiSPBanChay thongKeBrand = new ThongKeLoaiSPBanChay();
        tabbedPane.addTab("Thống kê loại sản phẩm", thongKeBrand);
    }
    
    public void updateCharts() {
    	tabbedPane.setComponentAt(0, new RevenuePanel());
    	tabbedPane.setComponentAt(1, new ThongKeKhachHang());
    	tabbedPane.setComponentAt(2, new ThongKeLoaiSPBanChay());
    }
    
    @Override
    protected void setReloadEvent() {
    	updateCharts();
    }
}
