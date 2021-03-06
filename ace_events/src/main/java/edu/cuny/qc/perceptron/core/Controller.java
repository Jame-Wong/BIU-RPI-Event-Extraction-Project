package edu.cuny.qc.perceptron.core;

import java.util.Arrays;
import java.util.Date;

import edu.cuny.qc.util.Utils;

// This is a controller of the settings in percetpron
public class Controller implements java.io.Serializable
{
	private static final long serialVersionUID = -2434003761785667377L;
	
	public int beamSize = 5;
	public int maxIterNum = 30;
	public boolean skipNonEventSent = true;
	public boolean avgArguments = true;
	// skip the features of NON argument link assignment
	public boolean skipNonArgument = false;
	// use global feature
	public boolean useGlobalFeature = true;
	// true if during training, skip arguments expansion for triggers 
	// that are not correct
	public boolean addNeverSeenFeatures = true;
	// whether use crossSent inference 
	public boolean crossSent = false;
	// whether use BeamSearchCluster or BeamSearchClusterSeq
	public boolean crossSentReranking = false;
	
	// the type of evaluator during training 1 is EvaluatorLoose, 0 is evaluatorFinal
	public int evaluatorType = 0;
	
	// order of trigger labeling 0/1 0 stands for unigram, 1 stands for bigram
	public int order = 1;
	
	// standard (1) or early-update (0). Default is early-update
	public int updateType = 0;
	
	// Should labelBigrams be learned from training data. Otherwise, all possible bigrams are considered by default.
	public boolean learnBigrams = true;
	
	/**
	 * 0 - only model file
	 * 1 - model, final weights, performance
	 * 2 - model, final weights, performance, features (only label per token)
	 * 3 - model, final weights, performance, updates, features (only label per token), weights (only vector summary per sentence)
	 * 4 - model, final weights, performance, updates, features, weights (only vector summary per sentence)
	 * 5 - model, final weights, performance, updates, features, weights (only vector summary per sentence), beam (only full assignments)
	 * 6 - model, final weights, performance, updates, features, weights (only vector summary per sentence), beam
	 * 7 - model, final weights, performance, updates, features, weights (vector summary per sentence + all weights only for PostItr), beam
	 * 8 - model, final weights, performance, updates, features, weights, beam
	 */
	public int logLevel = 1;

	public String[] logOnlyTheseSentences = {};
	
	public boolean useArguments = true;
	
	public Controller()
	{
//		System.out.printf("\n[%s] ******** Controller() **********\n", new Date());
//		System.out.printf("******** %s **********\n", this);
	}
	
	/**
	 * set the values according to command line arguments
	 * @param line
	 */
	public void setValueFromArguments(String[] arguments)
	{
		for(String arg : arguments)
		{
			String[] fields = arg.split("=");
			if(fields.length != 2)
			{
				System.out.println("Malform argument: " + arg);
				System.exit(-1);
			}
			else if(fields[0].equalsIgnoreCase("beamSize"))
			{
				beamSize = Integer.parseInt(fields[1]); 
			}
			else if(fields[0].equalsIgnoreCase("maxIterNum"))
			{
				maxIterNum = Integer.parseInt(fields[1]);
			}
			else if(fields[0].equalsIgnoreCase("skipNonEventSent"))
			{
				skipNonEventSent = Boolean.parseBoolean(fields[1]);
			}
			else if(fields[0].equalsIgnoreCase("avgArguments"))
			{
				avgArguments = Boolean.parseBoolean(fields[1]);
			}
			else if(fields[0].equalsIgnoreCase("skipNonArgument"))
			{
				skipNonArgument = Boolean.parseBoolean(fields[1]);
			}
			else if(fields[0].equalsIgnoreCase("useGlobalFeature"))
			{
				useGlobalFeature = Boolean.parseBoolean(fields[1]);
			}
			else if(fields[0].equalsIgnoreCase("addNeverSeenFeatures"))
			{
				addNeverSeenFeatures = Boolean.parseBoolean(fields[1]);
			}
			else if(fields[0].equalsIgnoreCase("crossSent"))
			{
				crossSent = Boolean.parseBoolean(fields[1]);
			}
			else if(fields[0].equalsIgnoreCase("crossSentReranking"))
			{
				crossSentReranking = Boolean.parseBoolean(fields[1]);
			}
			else if(fields[0].equalsIgnoreCase("order"))
			{
				order = Integer.parseInt(fields[1]);
			}
			else if(fields[0].equalsIgnoreCase("evaluatorType"))
			{
				evaluatorType = Integer.parseInt(fields[1]);
			}
			else if(fields[0].equalsIgnoreCase("updateType"))
			{
				updateType = Integer.parseInt(fields[1]);
			}
			else if(fields[0].equalsIgnoreCase("learnBigrams"))
			{
				learnBigrams = Boolean.parseBoolean(fields[1]);
			}
			else if(fields[0].equalsIgnoreCase("logLevel"))
			{
				logLevel = Integer.parseInt(fields[1]);
			}
			else if(fields[0].equalsIgnoreCase("logOnlyTheseSentences"))
			{
				logOnlyTheseSentences = fields[1].split(",");
				Utils.logOnlyTheseSentences = Arrays.asList(logOnlyTheseSentences);
			}
			else if(fields[0].equalsIgnoreCase("useArguments"))
			{
				useArguments = Boolean.parseBoolean(fields[1]);
			}
		}
		System.out.printf("\n[%s] ******** Controller() **********\n", new Date());
		System.out.printf("******** %s **********\n", this);
	}
	
	public String toString()
	{
		String ret = "beam size: " + beamSize + " max iter: " + maxIterNum + " skipNonEventSent: " + skipNonEventSent
		+ " averaged weights: " + avgArguments + " skipNonArgument: " + skipNonArgument
		+ " useGlobalFeature:" + useGlobalFeature + " addNeverSeenFeatures: " + addNeverSeenFeatures
		+ " crossSent:" + crossSent + " crossSentReranking:" + crossSentReranking + " order:" + order +
		" evaluatorType:" + evaluatorType + " learnBigrams: " + learnBigrams + " logLevel: " + logLevel +
		" logOnlyTheseSentences: " + logOnlyTheseSentences + " useArguments: " + useArguments;
		return ret;
	}
	
	public static void main(String[] args)
	{
		Controller controller = new Controller();
		String comm = "maxIterNum=50 useGlobalFeature=false";
		controller.setValueFromArguments(comm.split("\\s+"));
		System.out.println(controller);
	}
}
