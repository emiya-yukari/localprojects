package com.emiya.projects.localprojects.sysdesign.the5th;

import java.util.LinkedList;

public class OutputerFilter {
	
	
	public static LinkedList<Road> getResultRoad(LinkedList<Road> roadList, CityMap map){
		LinkedList<Road> result=new LinkedList<Road>();
		
		if(roadList==null){
			LinkedList<City> startCities=map.getCityList().getFirst().getEveryFederal();
			for(City startCity:startCities){
				Integer[] nextarray=map.getOriginMap().get(startCity.getNo());
				for(int i=0;i<nextarray.length;i++){
					result.add(new Road(startCity.getNo(),nextarray[i]));
				}
			}
			return result;
		}
		
		
		for(Road road:roadList){
			LinkedList<City> startCities=road.getStart().getEveryFederal();
			LinkedList<City> endCities=road.getEnd().getEveryFederal();
			
			for(City startCity:startCities){
				for(City endCity:endCities){
					if(map.getOriginMap().get(startCity.getNo()).equals(endCity.getNo())){
						result.add(new Road(startCity.getNo(), endCity.getNo()));
					}
				}
			}
		}
		return result;
	}
	
	public static int getMaxConnectedCount(LinkedList<Road> roadList, CityMap map){
		if(roadList==null)
			return map.getCityList().getFirst().getCount();
		
		return roadList.getFirst().getStart().getCount()+roadList.getFirst().getEnd().getCount();
	}
}
