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
	* The public insertNode method called by the threads to insert word is synchronized.
	* @param newWord.
	*/
	public void insertNode(String newWord){
		try{
			synchronized(this){
				Node newNode = getNode(newWord);
				if(newNode == null){
					System.out.println("New word is "+newWord);
					newNode = insertNode(root, newWord);	
				}
				newNode.incrementCount();
				wordCount++;
			}
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
	private Node insertNode(Node root, String word){        
		// System.out.println("INSIDE INSERT");
		if(root == null){
			root = new Node(wordCount,word);
			return root;
		}

    	if (word.compareTo(root.getWord()) < 0){
            root.setLeftChild(insertNode(root.getLeftChild(), word));
        }
    	else if (word.compareTo(root.getWord()) > 0){
            root.setRightChild(insertNode(root.getRightChild(), word));
        }
        return root;
	}

	/**
	* printNodes public method.
	* To write tree data to result array list.
	* @param results_orig.
	* @param backup_Results_1.
	* @param backup_Results_2.
	*/
	public void printNodes(){
		printTree(root);
		System.out.println("Inside pritn");
	}


	public void printTree(Node node){
		if(node == null){
			return;
		}
		printTree(node.getLeftChild());
		System.out.println("Node is "+node.getWord());
		printTree(node.getRightChild());
	}

	/**
	* printNodes private method.
	* To write tree data to result array list.
	* @param currentNode
	* @param result
	*/
	// private void printNodes(Node currentNode
	// 	//, Results result
	// 	){
	// 	if(currentNode != null){
	// 		printNodes(currentNode.getLeftChild()
	// 			//, result
	// 			);
	// 		System.out.println(currentNode.getWord() + "->" + currentNode.getNumOfOccurence());
	// 		//String resultStr = currentNode.getWordID() + ":" + currentNode.getWord();
	// 		//result.storeNewResult(resultStr);			
	// 		printNodes(currentNode.getRightChild()
	// 			//, result
	// 			);
	// 	}
	// }

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