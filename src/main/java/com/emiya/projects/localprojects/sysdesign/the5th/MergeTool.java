package com.emiya.projects.localprojects.sysdesign.the5th;

import java.util.HashMap;
import java.util.LinkedList;

public class MergeTool {
	
	public static CityMap mergeCycle(CityMap cityMap){
		HashMap<Integer, City>  loggedList=new HashMap<Integer, City>();
		
		for(int i=0;i<cityMap.size();i++){
			City city=cityMap.getCity(i);
			if(loggedList.containsKey(city.getNo())){
				continue;
			}
			
				merge(cityMap.getCity(i),loggedList,cityMap);
			}
			
			
			
		
		return null;
		
	}
	
	private static City merge(City city, HashMap<Integer, City>loggedList,CityMap cityMap){
		//如果自己已经出现过的话
		if(loggedList.containsKey(city.getNo())){
			City newCity=new City(cityMap.getNum()+1);
			newCity.addCity(city);
			return newCity;
		}
		
		//如果自己没有出现过的话
		loggedList.put(city.getNo(), city);
		LinkedList<City> nextCities=city.getNextCities();
		
		for(int i=0;i<nextCities.size();i++){
			City nextCity=nextCities.get(i);
			
			City result=merge(nextCity,loggedList,cityMap);
			
			//如果后面的遍历已经完成
			if(result==null){
				continue;
			}
			
			
			//如果找到环(这个result是一个新城市，并没有放到loggedList中)
			if(!loggedList.containsKey(result.getNo())){
				loggedList.remove(city.getNo());
				//如果新城市中并没有自己，也就是说并没有退回到环的最初点
				
				if(!result.hasCity(city)){
					result.addCity(city);
					return result;
				//如果新城市中有自己，也就是说退回了最初点
				}else{
					updateCityMap(result,cityMap);
				}
			}
		}
		
		//这次的循环已经结束了
		loggedList.remove(city.getNo());
		return null;
	}
	
	private static void updateCityMap(City newCity, CityMap cityMap){
		//把环的内部路径清掉
		newCity.clear();
		
		for(int i=0;i<cityMap.size();i++){
			City city=cityMap.getCity(i);
			
			if(newCity.hasCity(city)){
				cityMap.removeCity(i--);
				continue;
			}
			
			for(int j=0;j<city.getNextCities().size();j++){
				City nextCity=city.getNextCities().get(j);
				if(newCity.hasCity(nextCity)){
					city.getNextCities().set(j, newCity);
				}
			}
		}
		
		cityMap.addCity(newCity);
	}
}
