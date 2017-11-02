package wordTree.threadMgmt;

import wordTree.myTree.TreeBuilder;
import wordTree.util.FileProcessor;

public class PopulateThread implements Runnable{
	
	private FileProcessor file;
	private TreeBuilder tree;

	public PopulateThread(FileProcessor fileIn, TreeBuilder treeIn){
		file = fileIn;
		tree = treeIn;
		System.out.println("in pt");
	}
	
	public void run(){	
		System.out.println("in pt-run");
		String line;
	    while ((line = file.readLine(true)) != null)
	    {
	    	// Read line is split into array of string based on " " charecter.
    		String[] words = line.split(" ");
    		for(String word : words){
    			if(!word.equals("")){
    				tree.insertNode(word);
    			}
    		}
    	}
	}
}