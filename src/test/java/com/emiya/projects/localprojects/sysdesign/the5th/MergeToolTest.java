package com.emiya.projects.localprojects.sysdesign.the5th;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class MergeToolTest extends TestCase{

	public MergeToolTest(String testName){
		super(testName);
	}
	
	public static Test suite(){
        return new TestSuite( MergeToolTest.class );
	}
	
	public void testMergeToolTest(){
		City one=new City(1);
		City two=new City(2);
		City three=new City(3);
		City four=new City(4);
		City five=new City(5);
		City six=new City(6);
		
		one.addNext(two);
		one.addNext(four);
		one.addNext(five);
		two.addNext(three);
		three.addNext(one);
		four.addNext(three);
		six.addNext(three);
		
		CityMap cityMap=new CityMap();
		cityMap.addCity(one);
		cityMap.addCity(two);
		cityMap.addCity(three);
		cityMap.addCity(four);
		cityMap.addCity(five);
		cityMap.addCity(six);
		
		MergeTool.mergeCycle(cityMap);
		
		cityMap.printAll();
		
	}
}
