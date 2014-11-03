package com.emiya.projects.localprojects.sysdesign.the1st;

public class UnknowTask extends Task{

	public final static long UNKNOW_PRIORITY=-1;
	
	private long endTime;
	
	public UnknowTask(long startTime, long duration, long endTime) {
		super(startTime,duration,UNKNOW_PRIORITY);
		this.endTime=endTime;
	}
	
	public long getEndTime(){
		return this.endTime;
	}
	
	public void setEndTime(long endTime){
		this.endTime=endTime;
	}
	

}
