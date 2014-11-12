package com.emiya.projects.localprojects.sysdesign.the4th;

public class OppositeTool {
	
	public static PathCell getOppositeCell(int targetRow, int targetColumn, int pointRow, int pointColumn, GameMap gameMap){
		int oppositeRow=pointRow-targetRow;
		int oppositeColumn=pointColumn-targetColumn;
		
		PathCell cell=new PathCell(oppositeRow,oppositeColumn);
		
		return gameMap.isEmpty(cell.getRow(), cell.getColumn())==true?cell:null;
	}
	
	public static PathCell getOppositeCell(int targetRow, int targetColumn, int pointRow, int pointColumn){
		int oppositeRow=pointRow-targetRow;
		int oppositeColumn=pointColumn-targetColumn;
		
		return new PathCell(oppositeRow,oppositeColumn);
		
	}
}
