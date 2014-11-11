package com.emiya.projects.localprojects.sysdesign.the4th;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class PathToolTest extends TestCase{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public PathToolTest( String testName ){
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite(){
        return new TestSuite( PathToolTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testPathTool(){
        GameMap gameMap=new GameMap(4,4);
        String[] content1={"T","#"," "," "};
        String[] content2={"#"," "," "," "};
        String[] content3={" "," "," "," "};
        String[] content4={" "," "," ","B"};
        gameMap.addRow(0, content1);
        gameMap.addRow(1, content2);
        gameMap.addRow(2, content3);
        gameMap.addRow(3, content4);
        
        Path path=new Path();
        
        try{
        Box box=new Box(gameMap);
        
        PathTool.hasPath(box.getRow(), box.getColumn(), gameMap.getTarget().getRow(), gameMap.getTarget().getColumn(), gameMap, path);
        
        System.out.println("unable.");
        }catch(Exception e){
        	path.printPath();
        }
        
    }
}
