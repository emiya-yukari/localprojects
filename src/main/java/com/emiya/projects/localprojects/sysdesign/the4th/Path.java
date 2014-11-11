package com.emiya.projects.localprojects.sysdesign.the4th;

import java.util.LinkedList;


public class Path {
	
	private LinkedList<PathCell> cellList=new LinkedList<PathCell>();
	
	public void addCell(int row, int column){
		cellList.add(new PathCell(row,column));
	}
	
	public void addCell(PathCell cell){
		cellList.add(cell);
	}
	
	public PathCell getCell(int i){
		return cellList.get(i);
	}
	
	public int getCellRow(int i){
		return cellList.get(i).getRow();
	}
	
	public int getCellColumn(int i){
		return cellList.get(i).getColumn();
	}
	
	public PathCell getFirstCell(){
		return cellList.getFirst();
	}
	
	public PathCell getLastCell(){
		return cellList.getLast();
	}
	
	public void removeCell(PathCell cell){
		cellList.remove(cell);
	}
	
	public boolean hasCell(PathCell cell){
		boolean hasCell=false;
		
		for(PathCell tempCell:cellList){
			if(tempCell.getRow()==cell.getRow()&&tempCell.getColumn()==cell.getColumn()){
				hasCell=true;
				break;
			}
		}
		
		return hasCell;
	}
	
	public void printPath(){
		for(PathCell tempCell:cellList)
			System.out.print("( "+(tempCell.getRow()+1)+" , "+(tempCell.getColumn()+1)+" )->");
		System.out.println();
	}
	
}
