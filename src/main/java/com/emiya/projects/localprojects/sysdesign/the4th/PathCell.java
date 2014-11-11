package com.emiya.projects.localprojects.sysdesign.the4th;

public class PathCell {
	private int row,column;
	
	public PathCell(int row, int column){
		this.row=row;
		this.column=column;
	}
	
	public int getRow(){
		return row;
	}
	
	public int getColumn(){
		return column;
	}
}
