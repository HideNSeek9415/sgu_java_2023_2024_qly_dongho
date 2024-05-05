package gui.dashboard;

import javax.swing.*;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import bll.ThongKeBLL;
import dto.CustomerRevenue;
import java.awt.*;
import java.sql.SQLException;
import java.util.ArrayList;

public class ThongKeKhachHang extends JPanel {

    private ThongKeBLL thongKeBLL;

    public ThongKeKhachHang() {
        setLayout(new BorderLayout());
        thongKeBLL = ThongKeBLL.getInstance();
        try {
            ArrayList<CustomerRevenue> customerRevenues = thongKeBLL.getCustomerTotalRevenue();
            DefaultPieDataset dataset = createDataset(customerRevenues);
            JFreeChart chart = createChart(dataset);
            ChartPanel chartPanel = new ChartPanel(chart);
            chartPanel.setPreferredSize(new Dimension(600, 400));
            add(chartPanel, BorderLayout.CENTER);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private DefaultPieDataset createDataset(ArrayList<CustomerRevenue> customerRevenues) {
        DefaultPieDataset dataset = new DefaultPieDataset();
        for (CustomerRevenue customerRevenue : customerRevenues) {
            dataset.setValue(customerRevenue.getCustomerName(), customerRevenue.getTotalRevenue());
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
