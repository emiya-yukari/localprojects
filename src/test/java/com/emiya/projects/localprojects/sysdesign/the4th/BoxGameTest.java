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
		GameMap gameMap=new GameMap(1,4);
        String[] content1={"T"," ","B","C"};
//        String[] content2={" ","#"," "," "};
//        String[] content3={" "," ","B"," "};
//        String[] content4={" "," "," "," "};
        gameMap.addRow(0, content1);
//        gameMap.addRow(1, content2);
//        gameMap.addRow(2, content3);
//        gameMap.addRow(3, content4);
        
        BoxGame game=new BoxGame();
        game.startGame(gameMap);
	}
}
