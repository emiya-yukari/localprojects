package com.emiya.projects.localprojects.sysdesign.the4th;

public class Box {
	private int row,column;
	
	public Box(int row, int column){
		this.row=row;
		this.column=column;
	}
	
	
	public int getRow(){
		return row;
	}
	
	public int getColumn(){
		return column;
	}
	
	@Override
	public Box clone(){
		return new Box(row, column);
	}
	
	public PathCell getCell(){
		return new PathCell(this.row,this.column);
	}
	
	public void setCell(PathCell cell){
		this.row=cell.getRow();
		this.column=cell.getColumn();
	}
	

}
