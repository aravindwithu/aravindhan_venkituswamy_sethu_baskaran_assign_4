package wordTree.threadMgmt;

import wordTree.myTree.TreeBuilder;

public class PopulateThread implements Runnable{
	
	private String name;
	private Thread thread;
	private String line;
	private TreeBuilder tree;

	public PopulateThread(String nameIn, TreeBuilder treeIn){
		name = nameIn;
		tree = treeIn;
		thread = new Thread(this, name);
		System.out.println("New Thread "+name);
	}

	/*public void assignLine(String lineIn){
		line = lineIn;
	}*/

	public void start(String lineIn){
		line = lineIn;
		thread.start();
	}
	
	public void run(){
		// Read line is split into array of string based on " " charecter.
    	String[] words = line.split(" ");
    	for(String word : words){
    		if(!word.equals("")){
    			tree.insertNode(word);
    		}
    	}
	}
}