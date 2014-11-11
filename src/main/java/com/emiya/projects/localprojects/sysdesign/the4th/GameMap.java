package com.emiya.projects.localprojects.sysdesign.the4th;

public class GameMap {
	
	public final static String BLOCK="#";
	public final static String MAN="C";
	public final static String EMPTY=" ";
	public final static String BOX="B";
	public final static String TARGET="T";
	public final static String ERROR="R";
	
	private int rows, columns;
	private String[][] gameMap;
	private Target target;
	
	
	public GameMap(int rows, int columns){
		this.rows=rows;
		this.columns=columns;
		
		gameMap=new String[rows][];
	}
	
	public MapStatus getStatus(){
		return new MapStatus(gameMap.clone());
	}
	
	public void addRow(int row,String[] rowContent){
		gameMap[row]=rowContent;
	}
	
	public int getRowsLength(){
		return rows;
	}
	
	public int getColumnsLength(){
		return columns;
	}
	
	public void set(int rows, int columns, String content){
		this.gameMap[rows][columns]=content;
	}
	
	public void printMap(){
		for(String[] rowContent:gameMap){
			for(String rowCell:rowContent){
				System.out.print(rowCell+" ");
			}
			
			System.out.println();
		}
	}
	
	public String getCell(int row, int column){
		String cellContent=null;
		try{
			cellContent=gameMap[row][column];
		}catch(Exception e){
			cellContent=ERROR;
		}
		return cellContent;
	}
	
	public void setStatus(MapStatus status){
		this.gameMap=status.getGameMap();
	}
	
	public Target getTarget() throws Exception{
		if(target==null){
			target=findTarget();
		}
		
		return target;
	}
	
	private Target findTarget() throws Exception{
		for(int i=0;i<this.getRowsLength();i++){
			for(int j=0;j<this.getColumnsLength();j++){
				if(this.getCell(i, j)==GameMap.TARGET){
					return new Target(i,j);
				}
			}
		}
		
		throw new Exception("no target.");
	}
	
	
}
