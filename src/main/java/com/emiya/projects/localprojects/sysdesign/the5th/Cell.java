package com.emiya.projects.localprojects.sysdesign.the5th;

public class Cell {
	private int originLength=0;
	private int longestLength=0;
	
	public int getOriginLength() {
		return originLength;
	}
	
	public void setOriginLength(int originLength) {
		this.originLength = originLength;
	}
	
	public int getLongestLength() {
		return longestLength;
	}
	
	public void setLongestLength(int longestLength) {
		this.longestLength = longestLength;
	}
	
	public void addLongestLength(int i){
		this.longestLength+=i;
	}
	
	public int getMaxLength(){
		return originLength>longestLength?originLength:longestLength;
	}
	
	public int getDiff(){
		return this.longestLength-this.originLength;
	}
	
	
}
