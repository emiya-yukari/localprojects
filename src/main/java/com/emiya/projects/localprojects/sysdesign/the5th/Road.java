package com.emiya.projects.localprojects.sysdesign.the5th;

public class Road {

	private City start,end;
	private int row,column;
	
	public Road(int row, int column, City start, City end){
		this.row=row;
		this.column=column;
		this.start=start;
		this.end=end;
	}
	
	public Road(int row, int column){
		this.row=row;
		this.column=column;
	}
	
	public City getStart() {
		return start;
	}

	public City getEnd() {
		return end;
	}
	
	public int getRow() {
		return row;
	}

	public int getColumn() {
		return column;
	}
	
}
