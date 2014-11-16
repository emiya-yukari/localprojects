package com.emiya.projects.localprojects.sysdesign.the4th;

public class OppositeTool {
	
	public static PathCell getOppositeCell(int targetRow, int targetColumn, int pointRow, int pointColumn, GameMap gameMap){
		int oppositeRow=2*pointRow-targetRow;
		int oppositeColumn=2*pointColumn-targetColumn;
		
		PathCell cell=new PathCell(oppositeRow,oppositeColumn);
		
		//如果人正好在那个地方的话
		if(gameMap.getCell(cell.getRow(), cell.getColumn()).equals(GameMap.MAN))
			return cell;
		
		return gameMap.manCanStand(cell.getRow(), cell.getColumn())==true?cell:null;
	}
	
	public static PathCell getOppositeCell(int targetRow, int targetColumn, int pointRow, int pointColumn){
		int oppositeRow=pointRow-targetRow;
		int oppositeColumn=pointColumn-targetColumn;
		
		return new PathCell(oppositeRow,oppositeColumn);
		
	}
}
