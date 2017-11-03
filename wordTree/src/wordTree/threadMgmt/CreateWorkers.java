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
		// Required objects are assigned/intialized in the costructor.
		file = fileIn;
		results = results;
		tree = new TreeBuilder();
	}

	public void startPopulateWorkers(int NUM_THREADS){
		// Intialize threads array
		thread = new Thread[NUM_THREADS];
		// Create threads
		for(int i = 0; i < NUM_THREADS; i++ ){
			// populateThread is created with respective file processoe amd tree objects.
			Runnable populateThread = new PopulateThread(file, tree);
			// Thread is created with populateThread object.
			thread[i] = new Thread(populateThread,"Thread - "+String.valueOf(i+1));
		}
		// starts threads
			for(int i = 0; i < NUM_THREADS; i++ ){
				thread[i].start();
			}
		
		// joins threads
		try{// exception should be catched for join operation
			for(int i = 0; i < NUM_THREADS; i++ ){
				thread[i].join();
			}
		}catch(Exception ex){
			// prints the error and stack.
			System.err.println(ex.getMessage());
	    	ex.printStackTrace();
	    	System.exit(0);
		}

		file.closeFile();
		// prints the stored words(nodes) for testing only.
 		tree.printNodes();
	}

	public void startDeleteWorkers(int NUM_THREADS,String[] deleteWords){
		// Create threads
		// System.out.println(String.join(" ",deleteWords));
		for(int i = 0; i < NUM_THREADS; i++ ){
			Runnable deleteThread = new DeleteThread(tree,deleteWords[i]);
			thread[i] = new Thread(deleteThread,"Thread - "+String.valueOf(i+1));
		}
		// starts threads
			for(int i = 0; i < NUM_THREADS; i++ ){
				thread[i].start();
			}
		
		// joins threads
		try{// exception should be catched for join operation
			for(int i = 0; i < NUM_THREADS; i++ ){
				thread[i].join();
			}
		}catch(Exception ex){
			System.err.println(ex.getMessage());
	    	ex.printStackTrace();
	    	System.exit(0);
		}
	}
}