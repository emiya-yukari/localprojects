package com.emiya.projects.localprojects.sysdesign.the4th;

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
			if(isEmpty(cellColumnDirect,gameMap)) nextStepStack.push(cellColumnDirect);
			if(isEmpty(cellRowDirect,gameMap))	nextStepStack.push(cellRowDirect);
			if(isEmpty(cellRowDisDirect, gameMap)) nextStepStack.push(cellRowDisDirect);
			if(isEmpty(cellColumnDisDirect, gameMap)) nextStepStack.push(cellColumnDisDirect);
		}else{
			if(isEmpty(cellRowDirect,gameMap)) nextStepStack.push(cellRowDirect);
			if(isEmpty(cellColumnDirect,gameMap)) nextStepStack.push(cellColumnDirect);
			if(isEmpty(cellColumnDisDirect, gameMap)) nextStepStack.push(cellColumnDisDirect);
			if(isEmpty(cellRowDisDirect, gameMap)) nextStepStack.push(cellRowDisDirect);
		}
		
		return nextStepStack;
	}
	
	private static boolean isEmpty(PathCell cell,GameMap gameMap){
		return gameMap.getCell(cell.getRow(), cell.getColumn()).equals(GameMap.EMPTY)||gameMap.getCell(cell.getRow(), cell.getColumn()).equals(GameMap.TARGET);
	}
}
