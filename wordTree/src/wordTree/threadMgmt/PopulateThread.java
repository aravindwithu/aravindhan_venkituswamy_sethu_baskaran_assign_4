package wordTree.threadMgmt;

import wordTree.util.FileProcessor;

public class PopulateThread implements Runnable{
	
	private String name;
	private Thread thread;
	private FileProcessor fileProcessor;

	public PopulateThread(String str,FileProcessor file){
		name = str;
		fileProcessor = file;
		thread = new Thread(this,name);
		System.out.println("New Thread "+name);
		thread.start();
	}

	public void start(){
		thread.start();
	}
	
	public void run(){
		
		String line = fileProcessor.readLine(true);
	// 	// Check if line is blank === 
	// 	if(line.isEmpty() || line.trim().equals("") || line.trim().equals("\n")){
	// 		return;
	// 	}
		if(line.trim().length() > 0){
			System.out.println("Runnig thread "+ Thread.currentThread().getName());
			System.out.println("Line is " + line);
		}
	}
}