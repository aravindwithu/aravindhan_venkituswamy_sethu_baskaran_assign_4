package wordTree.threadMgmt;

import wordTree.util.FileProcessor;

public class PopulateThread implements Runnable{
	
	private String name;
	private Thread thread;
	private FileProcessor fileProcessor;

	public PopulateThread(String nameIn, FileProcessor file){
		name = nameIn;
		fileProcessor = file;
		thread = new Thread(this, name);
		System.out.println("New Thread "+name);
		thread.start();
	}
	
	public void run(){
	}
}