package gui.dashboard;

import javax.swing.*;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import bll.ThongKeBLL;
import dto.BrandRevenue;
import java.awt.*;
import java.sql.SQLException;
import java.util.ArrayList;

public class ThongKeLoaiSPBanChay extends JPanel {

    private ThongKeBLL thongKeBLL;

    public ThongKeLoaiSPBanChay() {
        setLayout(new BorderLayout());
        thongKeBLL = ThongKeBLL.getInstance();
        try {
            ArrayList<BrandRevenue> brandRevenues = thongKeBLL.getBrandTotalRevenue();
            DefaultPieDataset dataset = createDataset(brandRevenues);
            JFreeChart chart = createChart(dataset);
            ChartPanel chartPanel = new ChartPanel(chart);
            chartPanel.setPreferredSize(new Dimension(600, 400));
            add(chartPanel, BorderLayout.CENTER);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private DefaultPieDataset createDataset(ArrayList<BrandRevenue> brandRevenues) {
        DefaultPieDataset dataset = new DefaultPieDataset();
        for (BrandRevenue brandRevenue : brandRevenues) {
            dataset.setValue(brandRevenue.getBrandName(), brandRevenue.getTotal_sold());
        }
        return dataset;
    }


    private JFreeChart createChart(DefaultPieDataset dataset) {
        return ChartFactory.createPieChart(
                "Doanh thu theo từng khách hàng (VNĐ)",
                dataset,
                true, 
                true,
                false);
    }
}
