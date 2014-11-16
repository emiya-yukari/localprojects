package com.emiya.projects.localprojects.sysdesign.the5th;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class City{
	private LinkedList<City> nextCities=new LinkedList<City>();
	private Map<Integer,City> federal=new HashMap<Integer,City> ();
	private int no=0;
	private int count=1;
	
	public City(int no){
		this.no=no;
	}
	
	//增加并且合并城市
	public void addCity(City city){
		if(federal.get(city.getNo())==null){
			federal.put(city.getNo(), city);
			count+=city.getCount();
			
			for(City tempCity:city.getNextCities()){
				if(!nextCities.contains(tempCity))
					nextCities.add(tempCity);
				
			}
		}
	}
	
	public int getNo(){
		return this.no;
	}
	
	public void addNext(City city){
		if(!nextCities.contains(city))
			nextCities.add(city);
	}
	
	public void removeNext(City city){
		if(nextCities.contains(city))
			nextCities.remove(city);
	}
	
	public LinkedList<City> getNextCities(){
		return nextCities;
	}
	
	public boolean hasCity(City city){
		return federal.containsKey(city.getNo());
	}
	
	//把内部路全部去掉
	public void clear(){
		for(int i=0;i<nextCities.size();i++){
			if(federal.containsKey(nextCities.get(i).getNo()))
				nextCities.remove(i--);
		}
	}
	
	public void printAllNext(){
		for(City city:nextCities){
			System.out.println(no+"->"+city.getNo());
		}
	}
	
	public void printSelf(){
		System.out.println("no."+no);
		Set<Integer> setList=federal.keySet();
		
		for(Integer i:setList){
			System.out.print(federal.get(i).getNo()+" ");
		}
		System.out.println();
			
	}
	
	public int getCount(){
		if(federal.isEmpty())
			return count;
		return count-1;
	}
	
	public LinkedList<City> getEveryFederal(){
		LinkedList<City> cityList=new LinkedList<City>();
		
		if(federal.isEmpty()){
			cityList.add(this);
			return cityList;
		}
		
		Set<Integer> keyList=federal.keySet();
		for(Integer key:keyList){
			cityList.addAll(federal.get(key).getEveryFederal());
		}
		
		return cityList;
	}
	
	
	
	
}
