package com.emiya.projects.localprojects.sysdesign.the1st;

public class Task implements Comparable<Task>{
	
	long priority;
	long startTime;
	long duration;
	
	public Task(long startTime, long duration, long priority){
		this.priority=priority;
		this.startTime=startTime;
		this.duration=duration;
	}
	
	
	public long getPriority() {
		return priority;
	}
	public void setPriority(long priority) {
		this.priority = priority;
	}
	public long getStartTime() {
		return startTime;
	}
	public void setStartTime(long startTime) {
		this.startTime = startTime;
	}
	public long getDuration() {
		return duration;
	}
	public void setDuration(long duration) {
		this.duration = duration;
	}

	public int compareTo(Task theOther) {
		return this.getPriority()>theOther.getPriority()?-1:1;
	}

}
