package gui.dashboard;

import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.border.EmptyBorder;
import javax.swing.plaf.metal.MetalScrollPaneUI;
import javax.swing.plaf.metal.MetalTabbedPaneUI;

import java.awt.GridLayout;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import javax.swing.JButton;
import javax.swing.JToggleButton;

public class StatisticalGUI extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTabbedPane tabbedPane;
	private JPanel pnContent;
	private JPanel pnChart;
	private JPanel pnBtns;
	private JPanel pnTable;
	private List<LocalDate> dates = new ArrayList<>();
	private List<Integer> renuves = new ArrayList<>();
	private List<Integer> expenses = new ArrayList<>();
	private List<Integer> profits = new ArrayList<>();
	private JTable table;
	private JScrollPane scrollPane;
	private JToggleButton btnRenuve;
	private ChartPanel chartPanel;
	private JToggleButton btnExpense;
	private JToggleButton btnProfit;


	public StatisticalGUI() {
		setBackground(new Color(240, 247, 250));
		setBorder(new EmptyBorder(25, 25, 25, 25));
		setPreferredSize(new Dimension(1150, 800));
		setLayout(new GridLayout(0, 1, 0, 0));
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBackground(new Color(240, 247, 250));
		add(tabbedPane);
		
		pnContent = new JPanel();
		pnContent.setBackground(new Color(240, 247, 250));
		tabbedPane.addTab("New tab", null, pnContent, null);
		pnContent.setLayout(new BorderLayout(12, 12));
		
		pnChart = new JPanel();
		pnChart.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		pnChart.setPreferredSize(new Dimension(10, 340));
		pnContent.add(pnChart, BorderLayout.NORTH);
		pnChart.setLayout(new GridLayout(1, 0, 0, 0));
		
		pnBtns = new JPanel();
		pnBtns.setBackground(new Color(240, 247, 250));
		pnBtns.setPreferredSize(new Dimension(150, 10));
		pnContent.add(pnBtns, BorderLayout.EAST);
		pnBtns.setLayout(new GridLayout(7, 0, 0, 10));
		
		btnRenuve = new JToggleButton("Doanh thu");
		btnRenuve.setSelected(true);
		btnRenuve.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		pnBtns.add(btnRenuve);
		
		btnExpense = new JToggleButton("Chi phí");
		btnExpense.setSelected(true);
		btnExpense.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		pnBtns.add(btnExpense);
		
		btnProfit = new JToggleButton("Lợi nhuận");
		btnProfit.setSelected(true);
		btnProfit.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		pnBtns.add(btnProfit);
		
		pnTable = new JPanel();
		pnContent.add(pnTable, BorderLayout.CENTER);
		pnTable.setLayout(new GridLayout(0, 1, 0, 0));
		
		scrollPane = new JScrollPane();
		pnTable.add(scrollPane);
		
		table = new JTable();

		scrollPane.setViewportView(table);

		designChart();
		changeLooknFeel();
		addEvent();
	}

	private void addEvent() {
		btnRenuve.addItemListener(e -> {
			XYPlot plot = chartPanel.getChart().getXYPlot();
			if (btnRenuve.isSelected()) {
				plot.getRenderer().setSeriesVisible(0, true);
			} else {
				plot.getRenderer().setSeriesVisible(0, false);
			}
		});
		btnExpense.addItemListener(e -> {
			XYPlot plot = chartPanel.getChart().getXYPlot();
			if (btnExpense.isSelected()) {
				plot.getRenderer().setSeriesVisible(1, true);
			} else {
				plot.getRenderer().setSeriesVisible(1, false);
			}
		});	
		btnProfit.addItemListener(e -> {
			XYPlot plot = chartPanel.getChart().getXYPlot();
			if (btnProfit.isSelected()) {
				plot.getRenderer().setSeriesVisible(2, true);
			} else {
				plot.getRenderer().setSeriesVisible(2, false);
			}
		});	
	}

	private void changeLooknFeel() {
		// TODO Auto-generated method stub
//		tabbedPane.setUI(new MetalTabbedPaneUI());
//		scrollPane.setUI(new MetalScrollPaneUI());
	}

	private void designChart() {
		generateData();
		
		String[] title = {"Ngày", "Doanh thu", "Chi phí", "Lợi nhuận"};
        List<Object[]> dataList = new ArrayList<>();
        for (int i = 0; i < dates.size(); i++) {
			String strDate = dates.get(i).format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            Object[] rowdata = {strDate, renuves.get(i) + "đ", expenses.get(i) + "đ", profits.get(i) + "đ"};
            dataList.add(rowdata);
        }
        Object[][] data = dataList.toArray(new Object[0][]);
        DefaultTableModel model = new DefaultTableModel(data, title);
        table.setModel(model);
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(2).setResizable(false);
		table.getColumnModel().getColumn(3).setResizable(false);
		
        XYSeries renuveSeries = new XYSeries("Doanh thu");
        XYSeries expenseSeries = new XYSeries("Chi phí");
        XYSeries profitSeries = new XYSeries("Lợi nhuận");

        for (int i = 0; i < dates.size(); i++) {
        	renuveSeries.add(i, renuves.get(i));
        	expenseSeries.add(i, expenses.get(i));
        	profitSeries.add(i, profits.get(i));
        }
        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(renuveSeries);
        dataset.addSeries(expenseSeries);
        dataset.addSeries(profitSeries);
        JFreeChart chart = ChartFactory.createXYLineChart(
                "Biểu đồ doanh thu",
                "Ngày",
                "Đơn vị VNĐ",
                dataset
        );
        XYPlot plot = chart.getXYPlot();
        plot.getRenderer().setSeriesPaint(0, Color.blue); 
        plot.getRenderer().setSeriesPaint(1, Color.red); 
        plot.getRenderer().setSeriesPaint(2, Color.green);
        
        BasicStroke stroke = new BasicStroke(3, BasicStroke.CAP_SQUARE, BasicStroke.JOIN_MITER);
        plot.getRenderer().setSeriesStroke(0, stroke);
        plot.getRenderer().setSeriesStroke(1, stroke); 
        plot.getRenderer().setSeriesStroke(2, stroke); 


        chart.setBorderPaint(Color.pink);
        chart.setBackgroundPaint(new Color(240, 247, 250));
        chart.getXYPlot().setBackgroundPaint(Color.white);
        setChartFont(chart, pnChart.getFont());
        chartPanel = new ChartPanel(chart);
        pnChart.add(chartPanel);
	}
	
	private void generateData() {
		LocalDate date = LocalDate.of(2024, 1, 1);
		Random random = new Random();
		for (int i = 1; i <= 35; i++) {
			dates.add(date);
			date = date.plusDays(1);
			int nexpense = 100000 * (random.nextInt(90) + 10);
			int nprofit = 100000 * (random.nextInt(25) + 5);
			int nrenuve = nexpense + nprofit;
			expenses.add(nexpense);
			renuves.add(nrenuve);
			profits.add(nprofit);
		}
	}
	
	private void setChartFont(JFreeChart chart, Font font) {
		chart.getTitle().setFont(font);
		
		XYPlot plot = (XYPlot) chart.getPlot();
		NumberAxis domainAxis = (NumberAxis) plot.getDomainAxis();
		NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
		domainAxis.setTickLabelFont(font);
		rangeAxis.setTickLabelFont(font);
		
		XYLineAndShapeRenderer renderer = (XYLineAndShapeRenderer) plot.getRenderer();
        renderer.setSeriesItemLabelFont(1, font);

	}

}
