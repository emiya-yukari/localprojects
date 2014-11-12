package com.emiya.projects.localprojects.sysdesign.the4th;

import java.util.LinkedList;
import java.util.Queue;
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
	
	
	public static Path getMiniPath(int startRow, int startColumn, int endRow, int endColumn, GameMap gameMap){
		GameMap theMap=gameMap.clone();
		theMap.set(startRow, startColumn, "0");
		
		Queue<PathCell> queue=new LinkedList<PathCell>();
		queue.offer((new PathCell(startRow,startColumn)));
		PathCell cell=null;
		
		while(!queue.isEmpty()){
			cell=queue.poll();
			
			//如果到达终点
			if(cell.getRow()==theMap.getTarget().getRow()&&cell.getColumn()==theMap.getTarget().getColumn()){
				return searchMiniPath(theMap);
			}
			
			updateCellAround(cell,queue,theMap);
			theMap.printMap();
		}
		
		return null;
	}
	
	
	private static void updateCell(PathCell pointCell, PathCell targetCell, Queue<PathCell> queue, GameMap gameMap){
		int level=Integer.valueOf(gameMap.getCell(pointCell.getRow(), pointCell.getColumn()));
		level++;
		
		//如果是数字的话，当且只当它比现在的值大（说明找到一条更优先路径）的时候直接写，否则退出
		try{
			int targetValue=Integer.valueOf(gameMap.getCell(targetCell.getRow(), targetCell.getColumn()));
			if(targetValue>level){
				gameMap.set(targetCell.getRow(), targetCell.getColumn(), String.valueOf(level));
				queue.offer(targetCell);
			}
			
		//如果不是数字的话，当且只当它是空的时候直接写，否则退出
		}catch(Exception e){
			if(gameMap.isEmpty(targetCell.getRow(), targetCell.getColumn())){
				gameMap.set(targetCell.getRow(), targetCell.getColumn(), String.valueOf(level));
				queue.offer(targetCell);
			}
		}
	}
	
	private static void updateCellAround(PathCell point, Queue<PathCell> queue, GameMap gameMap){
		updateCell(point, point.getLeft(), queue, gameMap);
		updateCell(point, point.getUp(), queue, gameMap);
		updateCell(point, point.getRight(), queue, gameMap);
		updateCell(point, point.getDown(), queue, gameMap);
	}
	
	private static Path searchMiniPath(GameMap theMap){
		
		Path miniPath=new Path();
		PathCell currentCell=new PathCell(theMap.getTarget().getRow(),theMap.getTarget().getColumn());
		
		
		if(theMap.getCell(currentCell.getRow(), currentCell.getColumn()).equals("0")){
			miniPath.addCell(currentCell);
			return miniPath;
		}
			
		PathCell lowerCell=null;
		
		while((lowerCell=getLowerCellAround(currentCell,theMap))!=null){
			if(theMap.getCell(lowerCell.getRow(), lowerCell.getColumn()).equals("0")){
				miniPath.addCell(lowerCell);
				return miniPath;
			}
			
			miniPath.addCell(lowerCell);
			currentCell=lowerCell;
		}
		
		return null;
	}
	
	private static PathCell getLowerCellAround(PathCell cell, GameMap theMap){
		int pointValue=Integer.parseInt(theMap.getCell(cell.getRow(), cell.getColumn()));
		LinkedList<PathCell> cellAround=new LinkedList<PathCell>();
		
		cellAround.add(cell.getUp());
		cellAround.add(cell.getDown());
		cellAround.add(cell.getLeft());
		cellAround.add(cell.getRight());
		
		for(PathCell targetCell:cellAround){
			try{
				int targetValue=Integer.parseInt(theMap.getCell(targetCell.getRow(), targetCell.getColumn()));
				if(targetValue==pointValue-1){
					return targetCell;
				}
			}catch(Exception e){
				continue;
			}
		}
		
		return null;
	}
}
