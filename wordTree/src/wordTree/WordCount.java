package wordTree;

import wordTree.myTree.TreeBuilder;
import wordTree.myTree.Node;

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
		// tree.printNodes();
		getWordCount(root);
	}

	public void getWordCount(Node node){
		if(node == null){
			return;
		}
		System.out.println(node.getWord());
		getWordCount(node.getLeftChild());
		distinctWords++;
		words += node.getNumOfOccurence();
		characters += (node.getWordLength() * node.getNumOfOccurence());
		getWordCount(node.getRightChild());
	}

	public void display(){
		System.out.println("Words:"+words+", distinct:"+distinctWords+", chars:"+characters);
	}
}