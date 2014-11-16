package com.emiya.projects.localprojects.sysdesign.the4th;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class BoxGameTest extends TestCase{

	public BoxGameTest(String testName){
		super(testName);
	}
	
	public static Test suite(){
        return new TestSuite( BoxGameTest.class );
	}
	
	public void testBoxGameTest(){
		GameMap gameMap=new GameMap(6,6);
        String[] content1={" "," "," "," "," "," "};
        String[] content2={" "," "," "," "," "," "};
        String[] content3={" "," "," "," "," "," "};
        String[] content4={" "," ","#","B","#"," "};
        String[] content5={" "," ","#","S","#"," "};
        String[] content6={" "," ","#","T","#"," "};
        gameMap.addRow(0, content1);
        gameMap.addRow(1, content2);
        gameMap.addRow(2, content3);
        gameMap.addRow(3, content4);
        gameMap.addRow(4, content5);
        gameMap.addRow(5, content6);
        
        BoxGame game=new BoxGame();
        try {
			game.startGame(gameMap);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
