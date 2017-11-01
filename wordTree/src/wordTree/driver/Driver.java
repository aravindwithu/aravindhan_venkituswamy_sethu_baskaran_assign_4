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
		if(args[0].equals("${arg0}") || args[0].equals("") || args[1].equals("${arg1}") || args[1].equals("") || args.length != 5){
			return false;
		}
		String threadCheck = "123";
		if(args[2].equals("${arg2}") || args[2].equals("") || args[2].length() != 1 || (!threadCheck.contains(args[2])) ){
			return false;
		}
		// Can delete words be empty???????
		if(args[3].equals("${arg3}") || args[3].equals("")){
			return false;
		}
		String[] arg3 = args[3].split(" ");
		if(arg3.length != Integer.parseInt(args[2])){
			return false;
		}
		String arg4 = "01234";
		if(args[4].equals("${arg4}") || args[4].equals("") || args[4].length() != 1 || (!arg4.contains(args[4]))){
			return false;
		}
		return true;
	}

	public static void main(String[] args) {
		System.out.println("Hello world");

		if(argCheck(args) == false){
			System.err.println("Please specify arguments.");
			System.exit(1);
		}
		String inputFile = args[0];
		String outputFile = args[1];
		final int NUM_THREADS = Integer.parseInt(args[2]);
		
		FileProcessor fileProcessor = new FileProcessor(inputFile);				 
		Results results = new Results(outputFile);
		CreateWorkers workers = new CreateWorkers(fileProcessor,results);
		workers.startPopulateWorkers(NUM_THREADS);
	}
}
