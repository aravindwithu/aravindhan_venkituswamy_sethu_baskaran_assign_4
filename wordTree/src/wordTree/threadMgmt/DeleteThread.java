package wordTree.threadMgmt;

import wordTree.myTree.TreeBuilder;
import wordTree.util.MyLogger;

public class DeleteThread implements Runnable{
	
	private TreeBuilder tree;
	private String word;

	public DeleteThread(TreeBuilder treeIn,String wordIn){
		tree = treeIn;
		word = wordIn;
		MyLogger.writeMessage("Inside DeleteThread constructor",MyLogger.DebugLevel.CONSTRUCTOR);
	}
	
	public void run(){
		tree.deleteWord(word);
		MyLogger.writeMessage("DeleteThread run",MyLogger.DebugLevel.THREAD_RUN);
	}

}