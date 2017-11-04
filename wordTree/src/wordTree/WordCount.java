package wordTree;

import wordTree.myTree.TreeBuilder;
import wordTree.myTree.Node;
import wordTree.store.Results;

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
	}

	public void getWordCount(){
		Node root = tree.getRoot();
		getWordCount(root);
	}

	public void getWordCount(Node node){
		if(node == null){
			return;
		}
		// System.out.println(node.getWord());
		getWordCount(node.getLeftChild());
		distinctWords++;
		words += node.getNumOfOccurence();
		characters += (node.getWordLength() * node.getNumOfOccurence());
		getWordCount(node.getRightChild());
	}

	public void saveCount(Results results){
		// System.out.println("Words:"+words+", distinct:"+distinctWords+", chars:"+characters);
		results.storeNewResult("The total number of words: "+words);
		results.storeNewResult("The total number of characters: "+characters);
		results.storeNewResult("The total number of distinct words: "+distinctWords);
	}
}