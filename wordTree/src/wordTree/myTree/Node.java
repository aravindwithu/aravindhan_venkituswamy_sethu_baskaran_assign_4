package wordTree.myTree;

import java.util.Collections;
import java.util.ArrayList;
import java.util.Arrays;

public class Node{

	private String word;
	private int wordLength;
	private int numOfOccurence;
	private Node leftChild;
	private Node rightChild;

	public Node(String newWord){
		word = newWord;
		wordLength = word.length();
		numOfOccurence = 1;
		leftChild = null;
		rightChild = null;		
	}

		
}