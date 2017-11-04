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
		thread = new Thread[NUM_THREADS];
		for(int i = 0; i < NUM_THREADS; i++ ){
			Runnable populateThread = new PopulateThread(file, tree);
			thread[i] = new Thread(populateThread,"Thread - "+String.valueOf(i+1));
		}
		// start and join threads
		try{
			for(int i = 0; i < NUM_THREADS; i++ ){
				thread[i].start();
				thread[i].join();
			}
		}catch(Exception ex){
			// prints the error and stack.
			System.err.println(ex.getMessage());
	    	ex.printStackTrace();
	    	System.exit(0);
		}
		file.closeFile();
		// System.out.println("Distinct s " +tree.getdistinctwordCount() +" wrd is = "+tree.getWordCount());
		// prints the stored words(nodes) for testing only.
 		// tree.printNodes();
	}

	public TreeBuilder getTree(){
		return tree;
	}

	public void startDeleteWorkers(int NUM_THREADS,String[] deleteWords){
		// System.out.println(String.join(" ",deleteWords));
		for(int i = 0; i < NUM_THREADS; i++ ){
			Runnable deleteThread = new DeleteThread(tree,deleteWords[i]);
			thread[i] = new Thread(deleteThread,"Thread - "+String.valueOf(i+1));
		}
		// start and join threads
		try{
			for(int i = 0; i < NUM_THREADS; i++ ){
				thread[i].start();
				thread[i].join();
			}
		}catch(Exception ex){
			System.err.println(ex.getMessage());
	    	ex.printStackTrace();
	    	System.exit(0);
		}
	}
}