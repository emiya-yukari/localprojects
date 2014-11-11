package com.emiya.projects.localprojects.sysdesign.the4th;

public class Man {
	
	private GameMap gameMap;
	private int row,column;
	
	public Man(GameMap gameMap) throws Exception{
		findMan(gameMap);
		this.gameMap=gameMap;
	}
	
	private void findMan(GameMap gameMap) throws Exception{
		
		for(int i=0;i<gameMap.getRowsLength();i++){
			for(int j=0;j<gameMap.getColumnsLength();j++){
				if(gameMap.getCell(i, j)==GameMap.MAN){
					row=i;
					column=j;
				}
			}
		}
		
		throw new Exception("no man."); 
	}
	
	public ManStatus getStatus(){
		return new ManStatus(row,column);
	}
	
	public void setStatus(ManStatus status){
		this.row=status.getRow();
		this.column=status.getColumn();
	}
	
	public int getRow(){
		return this.row;
	}
	
	public int getColumn(){
		return column;
	}
	
	
	
}
