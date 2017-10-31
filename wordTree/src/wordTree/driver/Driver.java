package wordTree.driver;

import wordTree.store.Results;
import wordTree.myTree.TreeBuilder;
import wordTree.threadMgmt.CreateWorkers;
import wordTree.util.FileProcessor;
import java.io.File;
import java.util.ArrayList;
import java.io.IOException;

public class Driver {

	// Command line checks
	private static boolean argCheck(String[] args){
		return true;
	}

	public static void main(String[] args) {
		System.out.println("Hello world");

		if(argCheck(args) == false){
			System.err.println("Please specify arguments.");
			System.exit(1);
		}
				
	}
}
