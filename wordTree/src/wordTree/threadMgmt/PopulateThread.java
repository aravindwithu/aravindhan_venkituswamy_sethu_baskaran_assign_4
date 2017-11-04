package wordTree.threadMgmt;

import wordTree.myTree.TreeBuilder;
import wordTree.util.FileProcessor;

public class PopulateThread implements Runnable{
	
	private FileProcessor file;
	private TreeBuilder tree;

	public PopulateThread(FileProcessor fileIn, TreeBuilder treeIn){
		// The respective file object and tree object are assigned.
		file = fileIn;
		tree = treeIn;
	}
	
	public void run(){	
		String line;
	    while ((line = file.readLine(true)) != null)
	    {		    	
	    	// Read line is split into array of string based on " " charecter.
    		String[] words = line.split(" ");
    		for(String word : words){
    			if(!word.equals("")){
    				// Each word is inserted in tree using insertNode(synchronized) method in treeBuilder class.
    				tree.insertNode(word);
    			}
    		}
    	}
	}
}