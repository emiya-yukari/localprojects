package com.emiya.projects.localprojects.sysdesign.the4th;

public class Box {
	private GameMap gameMap;
	private int row,column;
	
	public Box(GameMap gameMap) throws Exception{
		
		findBox(gameMap);
		
		this.gameMap=gameMap;
	}
	
	private void findBox(GameMap gameMap) throws Exception{
		
		for(int i=0;i<gameMap.getRowsLength();i++){
			for(int j=0;j<gameMap.getColumnsLength();j++){
				if(gameMap.getCell(i, j)==GameMap.BOX){
					row=i;
					column=j;
					return;
				}
			}
		}
		
		throw new Exception("no box."); 
	}
	
	public BoxStatus getStatus(){
		return new BoxStatus(row,column);
	}
	
	public void setBoxStatus(BoxStatus status){
		this.row=status.getRow();
		this.column=status.getColumn();
	}
	
	public BoxStatus move(){
		
		return null;
	}
	
	public int getRow(){
		return row;
	}
	
	public int getColumn(){
		return column;
	}
	
	

}
