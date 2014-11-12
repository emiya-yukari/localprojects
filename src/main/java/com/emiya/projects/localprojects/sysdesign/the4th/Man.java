package com.emiya.projects.localprojects.sysdesign.the4th;

public class Man {
	
	private int row,column;
	
	public Man(int row, int column){
		this.row=row;
		this.column=column;
	}
	
	public int getRow(){
		return this.row;
	}
	
	public int getColumn(){
		return column;
	}
	
	public void setRow(int row){
		this.row=row;
	}
	
	public void setColumn(int column){
		this.column=column;
	}
	
	@Override
	public Man clone(){
		return new Man(row,column);
	}
	
	public void setCell(PathCell cell){
		this.row=cell.getRow();
		this.column=cell.getColumn();
	}
	
	public PathCell getCell(){
		return new PathCell(this.row,this.column);
	}
	
}
