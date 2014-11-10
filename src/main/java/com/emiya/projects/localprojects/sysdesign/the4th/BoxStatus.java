package com.emiya.projects.localprojects.sysdesign.the4th;

public class BoxStatus {
	private int column, row;
	
	private BoxStatus(int row,int column){
		this.row=row;
		this.column=column;
	}
	
	public int getColumn(){
		return column;
	}
	
	public int getRow(){
		return row;
	}
	
}
