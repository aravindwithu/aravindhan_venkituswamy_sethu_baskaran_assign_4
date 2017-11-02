package wordTree.myTree;

public class Node{

	private int wordID;
	private String word;
	private int wordLength;
	private int numOfOccurence;
	private Node leftChild;
	private Node rightChild;

	public Node(int wordIDIn, String newWord){
		wordID = wordIDIn;
		word = newWord;
		wordLength = word.length();
		numOfOccurence = 1;
		leftChild = null;
		rightChild = null;		
	}

	/**
	* getWord method.
	* @return int (word)
	*/
	public String getWord(){
		return word;
	}

	/**
	* getWordID method.
	* @return int (wordID)
	*/
	public int getWordID(){
		return wordID;
	}

	/**
	* getNumOfOccurence method.
	* @return int (numOfOccurence)
	*/
	public int getNumOfOccurence(){
		return numOfOccurence;
	}

	/**
	* getWordLength method.
	* @return int (wordLength)
	*/
	public int getWordLength(){
		return wordLength;
	}

	/**
	* incrementCount method.
	* increments numOfOccurence by 1. 
	*/
	public void incrementCount(){
		numOfOccurence++;
	}

	/**
	* getLeftChild method.
	* @return Node (leftChild node)
	*/
	public Node getLeftChild(){
		return leftChild;
	}

	/**
	* setLeftChild method.
	* @param nodeIn (sets the leftChild)
	*/
	public void setLeftChild(Node nodeIn){
		leftChild = nodeIn;
	}

	/**
	* getRightChild method.
	* @return Node (rightChild node)
	*/
	public Node getRightChild(){
		return rightChild;
	}

	/**
	* setLeftChild method.
	* @param nodeIn (sets the rightChild)
	*/
	public void setRightChild(Node nodeIn){
		rightChild = nodeIn;
	}
}