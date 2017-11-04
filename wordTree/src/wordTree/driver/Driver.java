package wordTree.driver;

import wordTree.WordCount;
import wordTree.store.Results;
import wordTree.myTree.TreeBuilder;
import wordTree.threadMgmt.CreateWorkers;
import wordTree.util.FileProcessor;
import wordTree.util.MyLogger;
import java.io.PrintWriter;


public class Driver {

	public static void main(String[] args) 
	{
		// Object declared for TreeBuilder class.
	    TreeBuilder treeBuilder;
	    // Object declared for Results class (Original).
	    Results results;
	    // Object declared for FileProcessor class.
	    FileProcessor file;
	    // Object declared for PrintWriter class.
	    PrintWriter writer;
	   	// Object declared for MyLogger class.
	    MyLogger myLogger;

	    try{
	    	// command line validation for input file and output file respectively.
	    	String inputFile = "", outputFile = "";
	    	String[] deleteStr;
	    	int NUM_THREADS= 0;
		    if(5 == args.length){// validates given arguments array length to 5.
		    	if(!args[0].equals("${arg0}") && !args[0].equals("")){// validates 1st input file argument value.
		    		inputFile = args[0];
		    	}
		    	else{
		    		throw new Exception("Please provide input file.");
		    	}

		    	if(!args[1].equals("${arg1}") && !args[1].equals("")){// validates 2nd output file argument value.
					outputFile = args[1];
		    	}
		    	else{
		    		throw new Exception("Please provide output file.");
		    	}

		    	String threadCheck = "123";
		    	if(!args[2].equals("${arg2}") && !args[2].equals("") && (threadCheck.contains(args[2]))){// validates 3rd number of threads argument value.
					try{
						NUM_THREADS = Integer.parseInt(args[2]);
					}catch(Exception ex){
				    	System.err.println("Number of threads should be a number");// prints the error message.
				    	ex.printStackTrace();// prints stack trace.
				    	System.exit(0);
				    }
		    	}
		    	else{
		    		throw new Exception("Please provide number of threads.");
		    	}
		    	// CHeck if empty???
		    	if(!args[3].equals("${arg3}") && !args[3].equals("")){// validates 4th delete words argument value.
					String[] arg3 = args[3].split(" ");
					if(arg3.length == NUM_THREADS){
						// deleteStr = String.join(" ",args[3]);
						deleteStr = arg3;
					}else{
						throw new Exception("Number of threads not equal to delete words.");
					}					
		    	}
		    	else{
		    		throw new Exception("Please provide delete words.");
		    	}

		    	String arg4 = "01234";
				if(args[4].equals("${arg4}") || args[4].equals("") || args[4].length() != 1 || (!arg4.contains(args[4]))){
					throw new Exception("Logger value is incorrect");
				}
				else{
					MyLogger logger = new MyLogger();
				}
		    }
		    else{
		    	throw new Exception("Please pass exactly 5 arguments one for input and another for output files.");
		    }

		    file = new FileProcessor(inputFile);				 
			results = new Results(outputFile);
			CreateWorkers workers = new CreateWorkers(file,results);
			workers.startPopulateWorkers(NUM_THREADS);
			workers.startDeleteWorkers(NUM_THREADS,deleteStr);
		 	WordCount wordCount = new WordCount(workers.getTree());
		 	wordCount.getWordCount();
		 	wordCount.display();
		    // System.out.println("Output files generated successfully.");
	    }
	    catch(Exception ex){
	    	System.err.println(ex.getMessage());// prints the error message.
	    	ex.printStackTrace();// prints stack trace.
	    	System.exit(0);
	    }
	    finally{// Clears all the objects created.
		    treeBuilder = null;
		    results = null;
		    file = null;
		    writer = null;
	    }
	}
}