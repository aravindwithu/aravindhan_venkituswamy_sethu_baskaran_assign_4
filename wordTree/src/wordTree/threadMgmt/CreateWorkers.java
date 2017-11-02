package wordTree.threadMgmt;

import wordTree.store.Results;
import wordTree.util.FileProcessor;
import wordTree.myTree.TreeBuilder;
import wordTree.threadMgmt.PopulateThread;
import java.util.ArrayList;

public class CreateWorkers{
	private FileProcessor file;
	private Results results;
	private TreeBuilder tree;
	private Thread thread[];

	public CreateWorkers(FileProcessor fileIn, Results results){
		file = fileIn;
		results = results;
		tree = new TreeBuilder();
	}

	public void startPopulateWorkers(int NUM_THREADS){
		// Create threads
		thread = new Thread[NUM_THREADS];

		for(int i = 0; i < NUM_THREADS; i++ ){
			PopulateThread populateThread = new PopulateThread(file, tree);
			thread[i] = new Thread(populateThread);
		}

		for(int i = 0; i < NUM_THREADS; i++ ){
			thread[i].start();
		}
		
		try{
			for(int i = 0; i < NUM_THREADS; i++ ){
				thread[i].join();
			}
		}catch(Exception ex){
			System.err.println(ex.getMessage());
	    	ex.printStackTrace();
	    	System.exit(0);
		}

		tree.printNodes();
	}

	public void startDeleteWorkers(int NUM_THREADS){
		// Create threads
	}
}