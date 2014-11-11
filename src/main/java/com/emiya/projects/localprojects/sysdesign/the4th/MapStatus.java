package com.emiya.projects.localprojects.sysdesign.the4th;

public class MapStatus {
	
	private String[][] gameMap;
	
	public MapStatus(String[][] gameMap){
		this.gameMap=gameMap;
	}
	
	
	public void printMap(){
		for(String[] rowContent:gameMap){
			for(String rowCell:rowContent){
				System.out.print(rowCell+" ");
			}
			
			System.out.println();
		}
	}
	
	public String getCell(int row, int column){
		return gameMap[row][column];
	}
	
	public String[][] getGameMap(){
		return gameMap;
	}
}
