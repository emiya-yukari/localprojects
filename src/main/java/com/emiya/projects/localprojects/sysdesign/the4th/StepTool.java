package com.emiya.projects.localprojects.sysdesign.the4th;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Stack;

public class StepTool {
	
	public static Stack<PathCell> getNextStep(int startRow, int startColumn, int endRow, int endColumn, GameMap gameMap){
		Stack<PathCell> nextStepStack=new Stack<PathCell>();
		
		int rowDirect=endRow-startRow;
		int columnDirect=endColumn-startColumn;
		
		int rowStep=(rowDirect==0?1:(rowDirect/Math.abs(rowDirect)));
		int columnStep=(columnDirect==0?1:(columnDirect/Math.abs(columnDirect)));
		
		PathCell cellColumnDirect=new PathCell(startRow,startColumn+columnStep);
		PathCell cellRowDirect=new PathCell(startRow+rowStep,startColumn);
		PathCell cellColumnDisDirect=new PathCell(startRow,startColumn-columnStep);
		PathCell cellRowDisDirect=new PathCell(startRow-rowStep,startColumn);
		
		//假如横着(column)比竖着(row)差得多，那就优先横着走
		if(Math.abs(rowDirect)<=Math.abs(columnDirect)){
			if(isEmpty(cellColumnDisDirect, gameMap)) nextStepStack.push(cellColumnDisDirect);
			if(isEmpty(cellRowDisDirect, gameMap)) nextStepStack.push(cellRowDisDirect);
			if(isEmpty(cellRowDirect,gameMap))	nextStepStack.push(cellRowDirect);
			if(isEmpty(cellColumnDirect,gameMap)) nextStepStack.push(cellColumnDirect);
		}else{
			if(isEmpty(cellRowDisDirect, gameMap)) nextStepStack.push(cellRowDisDirect);
			if(isEmpty(cellColumnDisDirect, gameMap)) nextStepStack.push(cellColumnDisDirect);
			if(isEmpty(cellColumnDirect,gameMap)) nextStepStack.push(cellColumnDirect);
			if(isEmpty(cellRowDirect,gameMap)) nextStepStack.push(cellRowDirect);
		}
		
		return nextStepStack;
	}
	
	private static boolean isEmpty(PathCell cell,GameMap gameMap){
		return gameMap.manCanStand(cell.getRow(), cell.getColumn());
	}
	
	public static Stack<PathCell> getMiniNextStep(int startRow, int startColumn, int endRow, int endColumn, GameMap gameMap){
		
		LinkedList<Path> pathList=new LinkedList<Path>();
		LinkedList<PathCell> cellList=new LinkedList<PathCell>();
		Stack<PathCell> stack=new Stack<PathCell>();
		
		PathCell pointCell=new PathCell(startRow,startColumn);
		
		cellList.add(pointCell.getUp());
		cellList.add(pointCell.getDown());
		cellList.add(pointCell.getLeft());
		cellList.add(pointCell.getRight());
		
		//排除不能直接走的
		for(int i=0;i<cellList.size();i++){
			PathCell cell=cellList.get(i);
			if(!gameMap.boxCanStand(cell.getRow(), cell.getColumn())){
				cellList.remove(i);
				i--;
			}
		}
		
		//加入走得到的并且排序
		for(PathCell cell:cellList){
			Path path=PathTool.getMiniPath(cell.getRow(), cell.getColumn(), endRow, endColumn, gameMap);
			if(path!=null){
				pathList.add(path);
				Collections.sort(pathList);
			}
				
		}
		
		//加入下一步
		for(Path tempPath:pathList)
			stack.push(tempPath.getLastCell());
		
		return stack;
	}
}
