package gui.dashboard;

import javax.swing.JPanel;


import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;

import bll.ThongKeBLL;

import java.awt.*;
import java.sql.SQLException;

public class RevenuePanel extends JPanel {

    private ThongKeBLL thongKeBLL;
    private DefaultCategoryDataset dataset;
    private JFreeChart chart;

    public RevenuePanel() {
        setLayout(new BorderLayout());

        thongKeBLL = ThongKeBLL.getInstance();

        dataset = createDataset();

        chart = ChartFactory.createBarChart(
                "Biểu đồ doanh thu theo năm",
                "Năm",
                "Doanh thu (VND)",
                dataset
        );

        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new Dimension(600, 300));
        add(chartPanel, BorderLayout.CENTER);
    }

    private DefaultCategoryDataset createDataset() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        try {
            // Lấy dữ liệu từ BLL cho mỗi năm
            for (int year = 2020; year <= 2026; year++) {
                int revenue = thongKeBLL.getTotalRevenue(year);
                dataset.addValue(revenue, "Doanh thu", Integer.toString(year));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dataset;
    }
    
    
}
