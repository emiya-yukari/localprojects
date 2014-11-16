package com.emiya.projects.localprojects.sysdesign.the4th;

public class Main {
	
	public static void main(String[] args){
		GameMap gameMap=null;
		
		try {
			gameMap=Inputer.getGameMap("D:/input.txt");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		BoxGame game=new BoxGame();
		try{
		game.startGame(gameMap);
		}catch(SuccessException e){
			String list=Outputer.getManStepList(game.getManPath(), game.getBoxPath());
			System.out.println(list);
		}catch(Exception e){
			System.out.println("Imporsible.");
		}
		
		
	}
}
