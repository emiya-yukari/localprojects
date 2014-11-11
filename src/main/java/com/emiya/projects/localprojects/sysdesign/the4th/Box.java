package com.emiya.projects.localprojects.sysdesign.the4th;

public class Box {
	private GameMap gameMap;
	private BoxStatus status;
	
	public Box(GameMap gameMap) throws Exception{
		
		status=findBox(gameMap);
		
		this.gameMap=gameMap;
	}
	
	private BoxStatus findBox(GameMap gameMap) throws Exception{
		
		for(int i=0;i<gameMap.getRowsLength();i++){
			for(int j=0;j<gameMap.getColumnsLength();j++){
				if(gameMap.getCell(i, j)==GameMap.BOX){
					return new BoxStatus(i,j);
				}
			}
		}
		
		throw new Exception("no box."); 
	}
	
	public BoxStatus getStatus(){
		return status;
	}
	
	public void setBoxStatus(BoxStatus theStatus){
		status=theStatus;
	}
	
	public BoxStatus move(){
		
		return null;
	}
	
	

}
