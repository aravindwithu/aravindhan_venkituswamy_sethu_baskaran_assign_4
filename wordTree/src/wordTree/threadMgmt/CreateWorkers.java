package wordTree.threadMgmt;

import wordTree.store.Results;
import wordTree.util.FileProcessor;
import wordTree.myTree.TreeBuilder;

public class CreateWorkers{
	private FileProcessor fileProcessor;
	private Results results;
	private TreeBuilder tree;
	// private Runnable[] runnable;

	public CreateWorkers(FileProcessor file,Results results){
		fileProcessor = file;
		results = results;
		tree = new TreeBuilder();
	}

	public void startPopulateWorkers(int NUM_THREADS){
		// Create threads
		/*for(int i = 1; i <= NUM_THREADS; i++ ){
			new PopulateThread("Thread-"+i, fileProcessor);
		}*/
		tree.insertNode("test");
		tree.insertNode("word");
		tree.insertNode("inserted");
		tree.insertNode("and");
		tree.insertNode("printed");

		tree.printNodes();
	}

	public void startDeleteWorkers(int NUM_THREADS){
		// Create threads
	}
}