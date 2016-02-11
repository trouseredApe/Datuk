package chart;

import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

import data.Data;

public class BarChart extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public JFreeChart barChart;
	public BarChart(String applicationTitle, Data data, int index) {
		super(applicationTitle);
		
		if(index>0){
			barChart = ChartFactory.createBarChart((String) data.getData().get(0).get(index - 1), "Category",
					"Value", createDataset(data, index), PlotOrientation.VERTICAL, true, true, false);
			
		}else{
			barChart = ChartFactory.createBarChart((String) data.getData().get(0).get(0), "Category",
					"Value", createDataset(data, index), PlotOrientation.VERTICAL, true, true, false);
			
		}
		createChart();
	}
	public BarChart(String applicationTitle, String chartTitle, Data data, int index){
		super(applicationTitle);

		barChart = ChartFactory.createBarChart(chartTitle, "Category",
				"Value", createDataset(data, index), PlotOrientation.VERTICAL, true, true, false);
		createChart();
		
	}
	private void createChart(){
		ChartPanel cp = new ChartPanel(barChart) {
			
            /**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
            public Dimension getPreferredSize() {
                return new Dimension(320, 240);
            }
        };
        cp.setMouseWheelEnabled(true);
        
        
        add(cp);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        pack();
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
