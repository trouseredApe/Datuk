package chart;

import java.util.ArrayList;

import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.ui.ApplicationFrame;

import data.Data;

public class PieChart extends ApplicationFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PieChart(String title, Data data, int index) {
		super(title);
		setContentPane(createDemoPanel(data, index));
	}

	private static PieDataset createDataset(Data data, int index) {
		boolean found = false;
		ArrayList<double[]> items = new ArrayList<double[]>();
		DefaultPieDataset dataset = new DefaultPieDataset();
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
			dataset.setValue(String.valueOf(items.get(i)[0]), items.get(i)[1]);
		}

		return dataset;
	}

	private static JFreeChart createChart(PieDataset dataset, String name) {
		JFreeChart chart = ChartFactory.createPieChart(name, // chart
																// title
				dataset, // data
				true, // include legend
				true, false);

		return chart;
	}

	public static JPanel createDemoPanel(Data data, int index) {
		JFreeChart chart = createChart(createDataset(data, index), (String) data.getData().get(0).get(index - 1));
		return new ChartPanel(chart);
	}

}
