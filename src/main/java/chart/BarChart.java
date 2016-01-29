package chart;

import java.util.ArrayList;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;

import data.Data;

public class BarChart extends ApplicationFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BarChart(String applicationTitle, String chartTitle, Data data, int index) {
		super(applicationTitle);
		JFreeChart barChart = ChartFactory.createBarChart((String) data.getData().get(0).get(index - 1), "Category",
				chartTitle, createDataset(data, index), PlotOrientation.VERTICAL, true, true, false);
		ChartPanel chartPanel = new ChartPanel(barChart);
		chartPanel.setPreferredSize(new java.awt.Dimension(560, 367));
	
		
		setContentPane(chartPanel);
	}

	private CategoryDataset createDataset(Data data, int index) {
		boolean found = false;
		ArrayList<double[]> items = new ArrayList<double[]>();
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		for (int i = 1; i < data.getData().size(); i++) {
			try {
				for (int j = 0; j < items.size(); j++) {
					if (Double.valueOf((String) data.getData().get(i).get(index)) == items.get(j)[0]) {
						items.get(j)[1] = items.get(j)[1] + 1;
						found = true;
					}
				}
				if (!found) {
					try {
						double[] newElement = new double[2];
						newElement[0] = Double.valueOf((String) data.getData().get(i).get(index));
						newElement[1] = 1;
						items.add(0, newElement);
					} catch (ClassCastException e) {

					}
				}
			} catch (NumberFormatException e) {

			}
			found = false;
		}
		for (int i = 0; i < items.size(); i++) {
			dataset.setValue(items.get(i)[1], String.valueOf(items.get(i)[0]), "ALL");
		}

		return dataset;
	}

}
