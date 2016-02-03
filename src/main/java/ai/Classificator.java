package ai;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import net.sf.javaml.classification.KDtreeKNN;
import net.sf.javaml.classification.Classifier;
import net.sf.javaml.classification.KNearestNeighbors;
import net.sf.javaml.classification.MeanFeatureVotingClassifier;
import net.sf.javaml.classification.NearestMeanClassifier;
import net.sf.javaml.classification.ZeroR;
import net.sf.javaml.classification.SOM;

import net.sf.javaml.classification.tree.RandomForest;
import net.sf.javaml.clustering.SOM.GridType;
import net.sf.javaml.clustering.SOM.LearningType;
import net.sf.javaml.clustering.SOM.NeighbourhoodFunction;
import net.sf.javaml.core.Dataset;
import net.sf.javaml.core.Instance;
import net.sf.javaml.tools.data.FileHandler;


public class Classificator {
	
	public Classificator(){}
	
	public Classifier kDtreeKNN(String path, int key)
			throws IOException, IllegalArgumentException {

		Classifier model = new  KDtreeKNN(key);
		Dataset data = FileHandler.loadDataset(new File(path), key, ",");
		model.buildClassifier(data);

		return model;
	}
	
	public Classifier randomForest(String path, int key, int numberOfTrees)
			throws IOException, IllegalArgumentException {

		Classifier model = new RandomForest(numberOfTrees, false, key,
				new Random(numberOfTrees));
		Dataset data = FileHandler.loadDataset(new File(path), key, ",");
		model.buildClassifier(data);

		return model;
	}

	public Classifier kNearestNeighbors(String path,  int key, int neighbors)
			throws IOException, IllegalArgumentException {

		Classifier model = new KNearestNeighbors(neighbors);
		Dataset data = FileHandler.loadDataset(new File(path), key, ",");
		model.buildClassifier(data);

		return model;
	}

	public Classifier nearestMeanClassifier(String path, int key)
			throws IOException, IllegalArgumentException {

		Classifier model = new NearestMeanClassifier();
		Dataset data = FileHandler.loadDataset(new File(path), key, ",");
		model.buildClassifier(data);

		return model;
	}

	public Classifier meanFeatureVotingClassifier(String path, int key)
			throws IOException, IllegalArgumentException {

		Classifier model = new MeanFeatureVotingClassifier();
		Dataset data = FileHandler.loadDataset(new File(path), key, ",");
		model.buildClassifier(data);

		return model;
	}
	public Classifier som(String path, int key, int xdim, int ydim,GridType grid, int iterations, double learningRate, int initialRadius, LearningType learning, NeighbourhoodFunction nbf)
			throws IOException, IllegalArgumentException {

		Classifier model = new SOM(xdim, ydim, grid, iterations,learningRate, initialRadius, learning, nbf);
		Dataset data = FileHandler.loadDataset(new File(path), key, ",");
		model.buildClassifier(data);
		return model;
	}
	public Classifier zeroR(String path, int key)
			throws IOException, IllegalArgumentException {

		Classifier model = new ZeroR();
		Dataset data = FileHandler.loadDataset(new File(path), key, ",");
		model.buildClassifier(data);

		return model;
	}

	public ArrayList<Object> clasify(String path, int key, Classifier model)
			throws IOException {

		ArrayList<Object> predictedValues = new ArrayList<Object>();
		Dataset dataForClassification = FileHandler.loadDataset(new File(path),
				key, ",");
		for (Instance inst : dataForClassification) {
			predictedValues.add(model.classify(inst));
		}
		return predictedValues;
	}

}
