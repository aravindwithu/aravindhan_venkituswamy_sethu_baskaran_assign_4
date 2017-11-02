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
	private PopulateThread populateThread[];

	public CreateWorkers(FileProcessor fileIn,Results results){
		file = fileIn;
		results = results;
		tree = new TreeBuilder();
	}

	public void startPopulateWorkers(int NUM_THREADS){
		// Create threads
		populateThread = new PopulateThread[NUM_THREADS];

		for(int i = 0; i < NUM_THREADS; i++ ){
			populateThread[i] = new PopulateThread("Thread_"+ i, tree);
		}

		int temp_Num = 1;
		String line;

	    while ((line = file.readLine(true)) != null)
	    {
	    	if(!line.equals("")){
	    		if(temp_Num > NUM_THREADS){
	    			temp_Num = 1;
	  			}
	    		if(temp_Num <= NUM_THREADS){
	    			 populateThread[temp_Num-1].start(line);
	    		}
	    		temp_Num++;
	    	}
	    }
	    
	}

	public void startDeleteWorkers(int NUM_THREADS){
		// Create threads
	}
}