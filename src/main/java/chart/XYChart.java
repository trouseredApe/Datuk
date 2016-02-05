package chart;
import java.awt.BasicStroke;
import java.awt.Color;

import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import data.Data;


public class XYChart extends JFrame{

	   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JFreeChart xylineChart;
	public XYChart( String applicationTitle, String chartTitle, String seriesName, 
			Data data, int index1, int index2){
		
	      super(applicationTitle);
	      xylineChart = ChartFactory.createXYLineChart(
	         chartTitle ,
	         String.valueOf(data.getData().get(0).get(index1)) ,
	         String.valueOf(data.getData().get(0).get(index2)),
	         createDataset(seriesName, data, index1, index2) ,
	         PlotOrientation.VERTICAL ,
	         true , true , false);
	         
	      ChartPanel chartPanel = new ChartPanel( xylineChart );
	      chartPanel.setPreferredSize( new java.awt.Dimension( 560 , 367 ) );
	      chartPanel.setMouseWheelEnabled(true);
	      final XYPlot plot = xylineChart.getXYPlot( );
	      XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer( );
	      renderer.setSeriesPaint( 0 , Color.RED );
	      renderer.setSeriesStroke( 0 , new BasicStroke( .5f ));
	      plot.setRenderer( renderer ); 
	      setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	      setContentPane( chartPanel ); 
	   }
	   
	   private XYDataset createDataset( String seriesName, Data data, int index1, int index2 )
	   {
	      final XYSeries mySeries = new XYSeries( seriesName ); 
	      final XYSeriesCollection dataset = new XYSeriesCollection( );
	      for(int i=0;i<data.getData().size();i++){
	    	  try{
	    		  mySeries.add(Double.valueOf(String.valueOf(data.getData().get(i).get(index1))), 
		    			  Double.valueOf(String.valueOf(data.getData().get(i).get(index2))));
	    	  }catch(NumberFormatException e){}
	    	  
	      }
	               
	       
	      dataset.addSeries( mySeries );
	      
	      
	      //You can add more than one series at a time.
	      
	      /*final XYSeries chrome = new XYSeries( "Chrome" );          
	      chrome.add( 1.0 , 4.0 );          
	      chrome.add( 2.0 , 5.0 );          
	      chrome.add( 3.0 , 6.0 );          
	      final XYSeries iexplorer = new XYSeries( "InternetExplorer" );          
	      iexplorer.add( 3.0 , 4.0 );          
	      iexplorer.add( 4.0 , 5.0 );          
	      iexplorer.add( 5.0 , 4.0 );         
	              
	      dataset.addSeries( chrome );          
	      dataset.addSeries( iexplorer );*/ 
	      return dataset;
	   }

	 
	  
	   
}



