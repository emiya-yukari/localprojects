package com.emiya.projects.localprojects.sysdesign.the5th;

import java.util.HashMap;
import java.util.LinkedList;

public class CityMap {
	
	private int num=0;
	private HashMap<Integer, Integer[]> originMap=new HashMap<Integer, Integer[]>();
	private LinkedList<City> cityList=new LinkedList<City>();
	
	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public LinkedList<City> getCityList() {
		return cityList;
	}

	public void addCity(City city){
		if(city!=null){
			if(!cityList.contains(city)){
				cityList.add(city);
				num++;
			}
		}
	}
	
	public void initAddCity(City city){
		if(city!=null){
			if(!cityList.contains(city)){
				Integer[] nextarray=new Integer[city.getNextCities().size()];
				for(int i=0;i<city.getNextCities().size();i++){
					nextarray[i]=city.getNextCities().get(i).getNo();
				}
				originMap.put(city.getNo(), nextarray);
			}
		}
	}
	
	public City getCity(int i){
		return cityList.get(i);
	}
	
	public void removeCity(int i){
		cityList.remove(i);
	}
	
	public int size(){
		return cityList.size();
	}
	
	public void printAll(){
		for(City city:cityList){
			city.printSelf();
			city.printAllNext();
		}
	}
	
	public HashMap<Integer,Integer[]> getOriginMap(){
		return this.originMap;
	}
	
}
