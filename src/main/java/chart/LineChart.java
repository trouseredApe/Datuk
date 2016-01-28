package chart;

import java.util.ArrayList;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;

import data.Data;

public class LineChart extends ApplicationFrame {
   
	private static final long serialVersionUID = 1L;
	public LineChart( String applicationTitle , String chartTitle, Data data, int index){
      super(applicationTitle);
      JFreeChart lineChart = ChartFactory.createLineChart(
         chartTitle,
         "Years","Number of errors",
         createDataset(data, index),
         PlotOrientation.VERTICAL,
         true,true,false);
         
      ChartPanel chartPanel = new ChartPanel( lineChart );
      chartPanel.setPreferredSize( new java.awt.Dimension( 560 , 367 ) );
     
      setContentPane( chartPanel );
      this.setVisible(true);
   }

   private DefaultCategoryDataset createDataset(Data data , int index)
   {
	   	
	   	boolean found=false;
	   	ArrayList<double[]> items = new ArrayList<double[]>();
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		for (int i = 1; i < data.getData().size(); i++) {
			for(int j=0;j<items.size();j++){
				if(Double.valueOf((String) data.getData().get(i).get(index))==items.get(j)[0]){
					items.get(j)[1]=items.get(j)[1]+1;
					found=true;
				}		
			
			}
			
			if(!found){
				try{
					double[] newElement = new double[2];
					newElement[0]=Double.valueOf((String) data.getData().get(i).get(index));
					newElement[1]=1;
					items.add(0,newElement);
				}catch(ClassCastException e){
					
				}
			}
			found=false;

		}
		for(int i=0;i<items.size();i++){
			dataset.setValue(items.get(i)[1], String.valueOf(items.get(i)[0]), String.valueOf(items.get(i)[0]));
		}
		
		
		return dataset; 
   }

}

