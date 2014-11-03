package com.emiya.projects.localprojects.sysdesign.the1st;

import java.util.LinkedList;

public class MySortedList <T extends Comparable<T>>{

	private LinkedList<T> list=new LinkedList<T>();
	
	public void offer(T t){
		
		for(int i=0;i<list.size();i++){
			
			//假设1为希望向后走，-1为不希望向后走
			if(t.compareTo(list.get(i))<0){
				list.add(i, t);
				return;
			}
		}
		
		list.addLast(t);
	}
	
	
	public T get(int i){
		return list.get(i);
	}
	
	
	public void remove(int i){
		list.remove(i);
	}
	
	public int getSize(){
		return list.size();
	}
	
	public boolean isEmpty(){
		return list.isEmpty();
	}
	
	public T peek(){
		return list.peekFirst();
	}
	
	public T poll(){
		return list.pollFirst();
	}
	
	public boolean remove(Object o){
		return list.remove(o);
	}
}
