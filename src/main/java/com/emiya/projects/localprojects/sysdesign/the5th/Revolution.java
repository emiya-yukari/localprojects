package com.emiya.projects.localprojects.sysdesign.the5th;

import java.util.LinkedList;

public class Revolution {
	
	private Cell[][] cellTable=null;
	private CityMap cityMap=null;
	
	public Revolution(CityMap cityMap){
		this.cityMap=cityMap;
		cellTable=new Cell[cityMap.size()][];
		
		for(int i=0;i<cityMap.size();i++){
			cellTable[i]=new Cell[cityMap.size()];	
			for(int j=0;j<cityMap.size();j++){
				cellTable[i][j]=new Cell();
			}
		}
		
		for(int i=0;i<cityMap.size();i++){
			for(int j=0;j<cityMap.getCity(i).getNextCities().size();j++){
				int k=cityMap.getCityList().indexOf(cityMap.getCity(i).getNextCities().get(j));
				cellTable[i][k].setOriginLength(cityMap.getCity(k).getCount());
			}
		}
	}
	
	public void revolution(){
		
		for(int i=0;i<cityMap.size();i++){
			for(int j=0;j<cityMap.size();j++){
				
				//如果i->j没有路，什么都不做继续循环
				if(cellTable[i][j].getOriginLength()==0)
					continue;
				
				//如果i->j有路，那么
				for(int k=0;k<cityMap.size();k++){
					
					//如果j->k没有路，那么什么都不做继续循环
					if(cellTable[j][k].getOriginLength()==0)
						continue;
					
					//如果本来就有一条更远的路，那么什么都不做继续循环
					if(cellTable[i][k].getMaxLength()>=(cellTable[i][j].getMaxLength()+cellTable[j][k].getMaxLength()))
						continue;
					
					//如果没有的话，更新路径为更远路径
					cellTable[i][k].setLongestLength(cellTable[i][j].getMaxLength()+cellTable[j][k].getMaxLength());
					
					for(int l=0;l<i;l++){
						//对于那些不能到i的l，什么都不做
						if(cellTable[l][i].getMaxLength()==0)
							continue;
						
					
					//	对于那些能到i的l，如果本来的路径更大，那么算了
						if(cellTable[l][k].getMaxLength()>=(cellTable[l][i].getMaxLength()+cellTable[i][k].getMaxLength()))
							continue;
						
						cellTable[l][k].setLongestLength(cellTable[l][i].getMaxLength()+cellTable[i][k].getMaxLength());
					}
				}
			}
		}
	}
	
	public void printCellList(){
		for(int i=0;i<cityMap.size();i++){
			for(int j=0;j<cityMap.size();j++){
				System.out.print(cellTable[i][j].getOriginLength()+"/"+cellTable[i][j].getLongestLength()+" ");
			}
			System.out.println();
		}
	}
	
	public LinkedList<Road> findTheRoad(){
		if(cityMap.size()==1){
			return null;
		}
		
		int diff=0;
		LinkedList<Road> roadList=new LinkedList<Road>();
		
		for(int i=0;i<cityMap.size();i++){
			for(int j=0;j<cityMap.size();j++){
				if(cellTable[i][j].getOriginLength()!=1)
					continue;
				
				
				if(diff>cellTable[i][j].getDiff()){
					continue;
				}
				
				if(diff<cellTable[i][j].getDiff()){
					roadList.clear();
					diff=cellTable[i][j].getDiff();
				}
				
				City start=cityMap.getCity(i);
				City end=cityMap.getCity(j);
				Road road=new Road(i,j,start,end);
				roadList.add(road);
			}
		}
		
		return roadList;
	}
}
