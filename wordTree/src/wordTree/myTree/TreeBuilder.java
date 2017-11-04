package wordTree.myTree;

import java.util.ArrayList;

public class TreeBuilder {
	private Node root;

	/**
	* TreeBuilder constructor to intialize TreeBuilder class.
	* Intializes the root object for original, backup 1 and backup 2 trees to null.
	*/
	public TreeBuilder(){
		root = null;
	}

	/**
	* insertNode public method.
	* To create and clone respective Nodes and to insert the same in BST structure.
	* BST - Binary Search Tree.
	* The public insertNode method called by the threads to insert word is synchronized.
	* @param newWord.
	*/
	public synchronized void insertNode(String newWord){
		try{
			root = insertNode(root, newWord);
		}
		catch(Exception ex){
			System.err.println(ex.getMessage());// prints the error message.
	    	ex.printStackTrace();// prints stack trace.
	    	System.exit(0);
		}
	}

	public Node getRoot(){
		return root;
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
	private Node insertNode(Node root, String word){
		if(root == null){
			root = new Node(word);
			return root;
		}

		if(word.equals(root.getWord())){
       		root.incrementCount();
        	return root;
       	}else{
       		int cmpResult =  word.compareTo(root.getWord());
        	if (0 > cmpResult){
	            root.setLeftChild(insertNode(root.getLeftChild(), word));
	        }
	    	else if (0 < cmpResult){
	            root.setRightChild(insertNode(root.getRightChild(), word));
        	}
        	return root;
       	}
	}
	
	/**
	* printNodes public method.
	* To write tree data to result array list.
	* @param results.
	*/
	public void printNodes(){
		printNodes(root);
	}

	/**
	* printNodes private method.
	* To write tree data to result array list.
	* @param currentNode
	* @param result
	*/
	private void printNodes(Node currentNode){
	 	if(currentNode != null){
	 		printNodes(currentNode.getLeftChild());
	 		System.out.println(currentNode.getWord() + "->" + currentNode.getNumOfOccurence());		
	 		printNodes(currentNode.getRightChild());
	 	}
	 }

	public Node getNode(String word){
		Node currentNode = root;
		
		while(currentNode != null)	{
			if(currentNode.getWord().equals(word)){
				return currentNode;
			}
			else if(currentNode.getWord().compareTo(word) < 0){
				currentNode = currentNode.getRightChild();
			}
			else{
				currentNode = currentNode.getLeftChild();
			}
		}
		return null;
	}

	public void deleteWord(String word){
		synchronized(this){
			if(root == null){
				return;
			}
			Node node = getNode(word);
			if(node != null){
				System.out.println("Node is ="+node.getWord() + ":"+node.getNumOfOccurence());
				node.decrementCount();
				System.out.println("Afer delete:" +node.getNumOfOccurence());
			}			
		}
	}
}