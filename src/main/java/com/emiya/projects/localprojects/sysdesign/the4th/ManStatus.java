package com.emiya.projects.localprojects.sysdesign.the4th;

public class ManStatus {
	private int column, row;
	
	public ManStatus(int row,int column){
		this.row=row;
		this.column=column;
	}
	
	public int getColumn(){
		return column;
	}
	
	public int getRow(){
		return row;
	}
	
	public void addColumn(int i){
		column+=i;
	}
	
	public void addRow(int i){
		row+=i;
	}
}
