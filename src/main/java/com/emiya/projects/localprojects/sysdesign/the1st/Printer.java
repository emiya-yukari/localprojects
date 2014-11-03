package com.emiya.projects.localprojects.sysdesign.the1st;

import java.util.List;
import java.util.PriorityQueue;

public class Printer {
	
	//the unadjusted task queue that will be sorted by priority
	private MySortedList<Task> priorityQueue=new MySortedList<Task>();
	
	// the adjuseted task queue that will be sorted by start print time
	private PrintQueue printQueue=new PrintQueue();
	
	//the task that has an unknow priority
	private UnknowTask unknowTask;
	
	
	public UnknowTask getUnknowTask(){
		return this.unknowTask;
	}
	

	public void registTask(List<Task> taskList){
		
		for(Task task:taskList){
			if(task.getPriority()==UnknowTask.UNKNOW_PRIORITY){
				unknowTask=(UnknowTask)task;
				continue;
			}
			
			priorityQueue.offer(task);
		}
		
	}
	
	
	// the main program of this problem
	public PrintQueue go() throws Exception{
		if(priorityQueue.isEmpty()) return printQueue;
		
		//give the unknowTask the highest priority
		unknowTask.setPriority(priorityQueue.peek().getPriority()+1);
		
		//put unknowTask into printQueue 
		//adjust the startPrintTime and endPrintTime
		PrintTask unknowPrintTask=printQueue.offer(unknowTask);
		
		//if the adjusted time is the same as the preset time
		if(unknowPrintTask.getStartPrintTime()==unknowTask.getStartTime()&&unknowPrintTask.getEndPrintTime()==unknowTask.getEndTime()){
			
			//adjust put the rest task into printQueue
			for(Task task=null;(task=priorityQueue.poll())!=null;)
				printQueue.offer(task);
			
			//the printQueue now is the answer queue
			return printQueue;
		}
		
		//if the adjusted time is not the same as the preset time
		//we need to remove the unknowTask because the priority is not correct
		printQueue.pop();
		
		//then we need to put a highest priority task from the priorityQueue to the printQueue
		printQueue.offer(priorityQueue.poll());
		
		return go();
	}
	
	
	
	public void printAll(){
		this.printQueue.printAll();
	}
	
}
