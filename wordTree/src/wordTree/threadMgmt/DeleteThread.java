package wordTree.threadMgmt;

import wordTree.myTree.TreeBuilder;

public class DeleteThread implements Runnable{
	
	private TreeBuilder tree;
	private String word;

	public DeleteThread(TreeBuilder treeIn,String wordIn){
		tree = treeIn;
		word = wordIn;
	}
	
	public void run(){
		tree.deleteWord(word);
		// System.out.println("Inside runn");
		// System.out.println("Distinct s " +tree.getdistinctwordCount() +" wrd is = "+tree.getWordCount());
	}

}