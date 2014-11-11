package com.emiya.projects.localprojects.sysdesign.the4th;

import java.util.Stack;

public class PathTool {
	public static void hasPath(int startRow, int startColumn, int endRow, int endColumn, GameMap gameMap, Path path) throws Exception{
		
		if(path==null){
			return;
		}

		PathCell cellThisPlace=new PathCell(startRow,startColumn);
		path.addCell(cellThisPlace);
		
		if(startRow==endRow&&startColumn==endColumn){
			throw new Exception("found");
		}
		
		Stack<PathCell> nextStepStack=StepTool.getNextStep(startRow, startColumn, endRow, endColumn,gameMap);
		
		PathCell cell=null;
		while(!nextStepStack.isEmpty()){
			cell=nextStepStack.pop();
			if(!path.hasCell(cell))
				hasPath(cell.getRow(),cell.getColumn(),endRow,endColumn,gameMap,path);
		}
		
		path.removeCell(cellThisPlace);
	}
}
