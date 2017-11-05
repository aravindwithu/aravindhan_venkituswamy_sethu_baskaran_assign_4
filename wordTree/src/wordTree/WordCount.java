package wordTree;

import wordTree.myTree.TreeBuilder;
import wordTree.myTree.Node;
import wordTree.store.Results;
import wordTree.util.MyLogger;

public class WordCount{

	TreeBuilder tree;
	int words;
	int characters;
	int distinctWords;

	public WordCount(TreeBuilder treeIn){
		tree = treeIn;
		words = 0;
		characters = 0;
		distinctWords = 0;
		MyLogger.writeMessage("Inside WordCount constructor",MyLogger.DebugLevel.CONSTRUCTOR);
	}

	public void getWordCount(){
		Node root = tree.getRoot();
		getWordCount(root);
	}

	private void getWordCount(Node node){
		if(node == null){
			return;
		}
		getWordCount(node.getLeftChild());
		distinctWords++;
		words += node.getNumOfOccurence();
		characters += (node.getWordLength() * node.getNumOfOccurence());
		getWordCount(node.getRightChild());
	}

	public void saveCount(Results results){
		results.storeNewResult("The total number of words: "+words);
		results.storeNewResult("The total number of characters: "+characters);
		results.storeNewResult("The total number of distinct words: "+distinctWords);
	}
}