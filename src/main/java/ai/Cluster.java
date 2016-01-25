package ai;

import java.io.File;
import java.io.IOException;

import net.sf.javaml.clustering.Clusterer;
import net.sf.javaml.clustering.KMeans;
import net.sf.javaml.clustering.MultiKMeans;
import net.sf.javaml.clustering.SOM;
import net.sf.javaml.clustering.Cobweb;
import net.sf.javaml.clustering.evaluation.ClusterEvaluation;
import net.sf.javaml.core.Dataset;
import net.sf.javaml.distance.DistanceMeasure;
import net.sf.javaml.tools.data.FileHandler;
import net.sf.javaml.clustering.FarthestFirst;



public class Cluster {
	
	public Cluster(){}
	
	
	public Dataset[] cobweb(String path, int key) throws IOException{
		Dataset data = FileHandler.loadDataset(new File(path), key, ",");
		Clusterer clusterer = new Cobweb();
		return clusterer.cluster(data);
	}
	public Dataset[] cobweb(String path, int key, double acuity, double cutoff) throws IOException{
		Dataset data = FileHandler.loadDataset(new File(path), key, ",");
		Clusterer clusterer = new Cobweb(acuity, cutoff);
		return clusterer.cluster(data);
	}
	
	public Dataset[] farthestFirst(String path, int key) throws IOException{
		Dataset data = FileHandler.loadDataset(new File(path), key, ",");
		Clusterer clusterer = new FarthestFirst();
		return clusterer.cluster(data);
	}
	public Dataset[] farthestFirst(String path, int key, int numClusters, DistanceMeasure dm) throws IOException{
		Dataset data = FileHandler.loadDataset(new File(path), key, ",");
		Clusterer clusterer = new FarthestFirst(numClusters, dm);
		return clusterer.cluster(data);
	}
	
	public Dataset[] kMeans(String path, int key, int numberOfClusters, int numberOfIterations) throws IOException{
		Dataset data = FileHandler.loadDataset(new File(path), key, ",");
		Clusterer clusterer = new KMeans(numberOfClusters, numberOfIterations);
		return clusterer.cluster(data);
	}
	public Dataset[] multiKMeans(String path, int key, ClusterEvaluation ce) throws IOException{
		Dataset data = FileHandler.loadDataset(new File(path), key, ",");
		Clusterer clusterer = new MultiKMeans(ce);
		return clusterer.cluster(data);
	}
	public Dataset[] multiKMeans(String path, int key, int clusters, int iterations, int repeats, DistanceMeasure dm, ClusterEvaluation ce) throws IOException{
		Dataset data = FileHandler.loadDataset(new File(path), key, ",");
		Clusterer clusterer = new MultiKMeans(clusters, iterations, repeats, dm, ce);
		return clusterer.cluster(data);
	}
	
	public Dataset[] som(String path, int key) throws IOException{
		Dataset data = FileHandler.loadDataset(new File(path), key, ",");
		Clusterer clusterer = new SOM();
		return clusterer.cluster(data);
	}
	public Dataset[] som(String path, int key, int xdim, int ydim, SOM.GridType grid, int iterations, double learningRate, int initialRadius, SOM.LearningType learning, SOM.NeighbourhoodFunction nbf) throws IOException{
		Dataset data = FileHandler.loadDataset(new File(path), key, ",");
		Clusterer clusterer = new SOM(xdim, ydim, grid, iterations, learningRate, initialRadius, learning, nbf);
		return clusterer.cluster(data);
	}
	public Dataset[] som(String path, int key, int xdim, int ydim, SOM.GridType grid, int iterations, double learningRate, int initialRadius, SOM.LearningType learning, SOM.NeighbourhoodFunction nbf, DistanceMeasure dm) throws IOException{
		Dataset data = FileHandler.loadDataset(new File(path), key, ",");
		Clusterer clusterer = new SOM(xdim, ydim, grid, iterations, learningRate, initialRadius, learning, nbf, dm);
		return clusterer.cluster(data);
	}
	
	
	
	
}
