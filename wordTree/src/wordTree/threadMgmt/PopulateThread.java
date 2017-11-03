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
		// System.out.println("in pt-run");
		String line;
		// System.out.println("thread start: "+Thread.currentThread().getName());
		// File is read using fileProcessor class readLine method(synchronized)
		// synchronized(this){
	    while ((line = file.readLine(true)) != null)
	    {		    	
	    	// System.out.println(line);
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