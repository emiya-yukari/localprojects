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
	
	public PathCell getUp(){
		return new PathCell(row-1,column);
	}
	
	public PathCell getDown(){
		return new PathCell(row+1, column);
	}
	
	public PathCell getLeft(){
		return new PathCell(row, column-1);
	}
	
	public PathCell getRight(){
		return new PathCell(row, column+1);
	}
	
	public boolean equals(PathCell cell){
		return this.getRow()==cell.getRow()&&this.getColumn()==cell.getColumn();
	}
}
