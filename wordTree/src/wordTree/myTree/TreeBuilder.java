package wordTree.myTree;

import java.util.ArrayList;

public class TreeBuilder {
	private Node root;
	private int wordCount;

	/**
	* TreeBuilder constructor to intialize TreeBuilder class.
	* Intializes the root object for original, backup 1 and backup 2 trees to null.
	*/
	public TreeBuilder(){
		root = null;
		wordCount = 0;
	}

	/**
	* insertNode public method.
	* To create and clone respective Nodes and to insert the same in BST structure.
	* BST - Binary Search Tree.
	* @param newWord.
	*/
	public synchronized void insertNode(String newWord){
		try{
			Node newNode = new Node(wordCount,newWord);
			root = insertNode(root, newNode);
			wordCount++;
		}
		catch(Exception ex){
			System.err.println(ex.getMessage());// prints the error message.
	    	ex.printStackTrace();// prints stack trace.
	    	System.exit(0);
		}
	}

	/**
	* insertNode private method.
	* To creates BST structure with given new node the root node.
	* BST - Binary Search Tree.
	* @param root of the respective tree.
	* @param newNode created or cloned node.
	* @see http://www.geeksforgeeks.org/binary-search-tree-set-1-search-and-insertion/
	* @return Node (root);
	*/
	private Node insertNode(Node root, Node newNode){
        if (root == null) {
            root = newNode;
            return root;
        }
        
        if(newNode.getWord() == root.getWord()){
        	root.incrementCount();
        	return root;
        }else{
        	if (newNode.getWordID() < root.getWordID()){
	            root.setLeftChild(insertNode(root.getLeftChild(), newNode));
	        }
	    	else if (newNode.getWordID() > root.getWordID()){
	            root.setRightChild(insertNode(root.getRightChild(), newNode));
	        }
	        return root;
        }
	}

	/**
	* printNodes public method.
	* To write tree data to result array list.
	* @param results_orig.
	* @param backup_Results_1.
	* @param backup_Results_2.
	*/
	public void printNodes(
		//Results results
		){
		printNodes(root
			//, results_orig
			);
	}
	/**
	* printNodes private method.
	* To write tree data to result array list.
	* @param currentNode
	* @param result
	*/
	private void printNodes(Node currentNode
		//, Results result
		){
		if(currentNode != null){
			printNodes(currentNode.getLeftChild()
				//, result
				);
			System.out.println(currentNode.getWordID() + ":" + currentNode.getWord());
			//String resultStr = currentNode.getWordID() + ":" + currentNode.getWord();
			//result.storeNewResult(resultStr);			
			printNodes(currentNode.getRightChild()
				//, result
				);
		}
	}
}