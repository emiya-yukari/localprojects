package com.emiya.projects.localprojects.sysdesign.the4th;

public class Man {
	
	private GameMap gameMap;
	private ManStatus status;
	
	public Man(GameMap gameMap) throws Exception{
		status=this.findMan(gameMap);
		this.gameMap=gameMap;
	}
	
	private ManStatus findMan(GameMap gameMap) throws Exception{
		
		for(int i=0;i<gameMap.getRowsLength();i++){
			for(int j=0;j<gameMap.getColumnsLength();j++){
				if(gameMap.getCell(i, j)==GameMap.MAN){
					return new ManStatus(i,j);
				}
			}
		}
		
		throw new Exception("no man."); 
	}
	
	public ManStatus getStatus(){
		return this.status;
	}
	
	public void setStatus(ManStatus status){
		this.status=status;
	}
	
	
	
}
