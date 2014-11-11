package com.emiya.projects.localprojects.sysdesign.the4th;

import java.util.Stack;

public class BoxGame {
	
	private Box box;
	private GameMap gameMap;
	private Man man;
	private Stack<GameStatus> gameStack=new Stack<GameStatus>();
	
	public BoxGame(GameMap gameMap) throws Exception{
		box=new Box(gameMap);
		man=new Man(gameMap);
		
		this.gameMap=gameMap;
	}
	
	private void saveStatus(){
		gameStack.push(new GameStatus(gameMap.getStatus(),box.getStatus(),man.getStatus()));
	}
	
	private void loadStatus(){
		GameStatus gameStatus=gameStack.pop();
		
		box.setBoxStatus(gameStatus.getBoxStatus());
		man.setStatus(gameStatus.getManStatus());
		gameMap.setStatus(gameStatus.getMapStatus());
	}
	
	public Object go(){
		
		
		return null;
	}
	
}
