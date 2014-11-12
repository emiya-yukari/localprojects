package com.emiya.projects.localprojects.sysdesign.the4th;

import java.util.Stack;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class GetMiniStepTest extends TestCase{
	
	public GetMiniStepTest(String testName){
		super(testName);
	}
	
	public static Test suite(){
	        return new TestSuite( GetMiniStepTest.class );
	}
	 
	public void testGetMiniStepTest(){
		GameMap gameMap=new GameMap(4,4);
        String[] content1={"T","#"," ","C"};
        String[] content2={" ","#"," "," "};
        String[] content3={" "," ","B"," "};
        String[] content4={" "," "," "," "};
        gameMap.addRow(0, content1);
        gameMap.addRow(1, content2);
        gameMap.addRow(2, content3);
        gameMap.addRow(3, content4);
        try {
			gameMap.init();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        Stack<PathCell> nextPath=StepTool.getMiniNextStep(0, 2, 0, 0, gameMap);
        System.out.println(nextPath.size());
	}
	
}
