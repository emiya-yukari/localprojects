package com.emiya.projects.localprojects.sysdesign.the5th;

import java.util.LinkedList;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class RevolutionTest extends TestCase{

	public RevolutionTest(String testName){
		super(testName);
	}
	
	public static Test suite(){
        return new TestSuite( RevolutionTest.class );
	}
	
	public void testRevolution(){
		City one=new City(1);
		City two=new City(2);
		City three=new City(3);
		City four=new City(4);
		City five=new City(5);
//		City six=new City(6);
		
		one.addNext(two);
		one.addNext(four);
		
		two.addNext(three);
		
		three.addNext(four);
		three.addNext(five);
		
		four.addNext(five);
//		six.addNext(three);
		
		CityMap cityMap=new CityMap();
		cityMap.addCity(one);
		cityMap.addCity(two);
		cityMap.addCity(three);
		cityMap.addCity(four);
		cityMap.addCity(five);
//		cityMap.addCity(six);
		
		Revolution re=new Revolution(cityMap);
		re.printCellList();
		System.out.println();
		re.revolution();
		re.printCellList();
		LinkedList<Road> roadList=re.findTheRoad();
		
		
		for(int i=0;i<roadList.size();i++){
			System.out.println("("+roadList.get(i).getRow()+","+roadList.get(i).getColumn()+")");
		}
	}
}
