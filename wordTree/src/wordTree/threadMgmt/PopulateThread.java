package wordTree.threadMgmt;

import wordTree.myTree.TreeBuilder;
import wordTree.util.FileProcessor;
import wordTree.util.MyLogger;

public class PopulateThread implements Runnable{
	
	private FileProcessor file;
	private TreeBuilder tree;

	public PopulateThread(FileProcessor fileIn, TreeBuilder treeIn){
		// The respective file object and tree object are assigned.
		file = fileIn;
		tree = treeIn;
		MyLogger.writeMessage("Inside PopulateThread constructor",MyLogger.DebugLevel.CONSTRUCTOR);
	}
	
	public void run(){	
		MyLogger.writeMessage("PopulateThread run",MyLogger.DebugLevel.THREAD_RUN);
		String line;
	    while ((line = file.readLine(true)) != null)
	    {		    	
    		String[] words = line.split(" ");
    		for(String word : words){
    			if(!word.equals("")){
    				tree.insertNode(word);
    			}
    		}
    	}
	}
}