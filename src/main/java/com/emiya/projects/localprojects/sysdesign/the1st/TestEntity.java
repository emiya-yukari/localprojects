package com.emiya.projects.localprojects.sysdesign.the1st;

public class TestEntity implements Comparable<TestEntity>{

	private int num;
	
	public TestEntity(int num){
		this.num=num;
	}
	
	public int getNum(){
		return num;
	}
	
	public int compareTo(TestEntity o) {
		return this.getNum()>o.getNum()?-1:1; 
	}
	
}
