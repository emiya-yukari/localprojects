package com.emiya.projects.localprojects.sysdesign.the1st;

public class PrintTask implements Comparable<PrintTask>{

	private Task task;
	private long startPrintTime;
	private long endPrintTime;

	public PrintTask(Task task){
		this.task=task;
		this.startPrintTime=task.getStartTime();
		this.endPrintTime=task.getStartTime()+task.getDuration();
	}
	
	
	public Task getTask() {
		return task;
	}

	public long getStartPrintTime() {
		return startPrintTime;
	}

	public void setStartPrintTime(long startPrintTime) {
		this.startPrintTime = startPrintTime;
	}

	public long getEndPrintTime() {
		return endPrintTime;
	}

	public void setEndPrintTime(long endPrintTime) {
		this.endPrintTime = endPrintTime;
	}
	
	public void adjustStartPrintTime(long startPrintTime){
		long difference=startPrintTime-this.startPrintTime;
		this.startPrintTime=startPrintTime;
		this.endPrintTime+=difference;
	}
	
	public void adjustEndPrintTime(long duration){
		this.endPrintTime+=duration;
	}
	
	public long getDuration(){
		return this.endPrintTime-this.startPrintTime;
	}


	public int compareTo(PrintTask theOther) {
		return this.getStartPrintTime()>theOther.getStartPrintTime()?1:-1;
	}
	
	public void printDetail(){
		System.out.print("startTime: "+task.getStartTime()+" duration: "+task.getDuration()+" priority: "+task.getPriority());
		System.out.print(" startPrintTime: "+this.startPrintTime+" endPrintTime: "+this.endPrintTime);
		System.out.println();
	}
	
	
	
}
