package wordTree.threadMgmt;

import wordTree.store.Results;
import wordTree.util.FileProcessor;

public class CreateWorkers{
	private FileProcessor fileProcessor;
	private Results results;
	// private Runnable[] runnable;

	public CreateWorkers(FileProcessor file,Results results){
		fileProcessor = file;
		results = results;
	}

	public void startPopulateWorkers(int NUM_THREADS){
		// Create threads
		for(int i = 1; i <= NUM_THREADS; i++ ){
			new PopulateThread("Thread-" + String.valueOf(i),fileProcessor);
		}
		
	}

	public void startDeleteWorkers(int NUM_THREADS){
		// Create threads
	}
}