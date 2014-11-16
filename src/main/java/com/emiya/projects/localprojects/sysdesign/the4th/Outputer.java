package com.emiya.projects.localprojects.sysdesign.the4th;

public class Outputer {
	
	public static String getManStepList(Path manPath, Path boxPath){
		String stepList="";
		
		int pointMan=0;
		int pointBox=0;
		
		for(;pointMan<manPath.size()-1;pointMan++){
			boolean isPushingBox=false;
			
			if((isPushingBox=(manPath.getCell(pointMan+1).equals(boxPath.getCell(pointBox))))){
				stepList+=getStep(manPath.getCell(pointMan),boxPath.getCell(pointBox),isPushingBox);
				pointBox++;
			}else{
				stepList+=getStep(manPath.getCell(pointMan),manPath.getCell(pointMan+1),isPushingBox);
			}
		}
		
		return stepList;
	}
	
	private static String getStep(PathCell start, PathCell end,boolean isPushingBox){
		
		if(end.getRow()-start.getRow()<0){
			return isPushingBox?"N":"n";
		}else if(end.getRow()-start.getRow()>0){
			return isPushingBox?"S":"s";
		}
		
		if(end.getColumn()-start.getColumn()<0){
			return isPushingBox?"E":"e";
		}else if(end.getColumn()-start.getColumn()>0){
			return isPushingBox?"W":"w";
		}
		
		return "";
		
		
	}
}
