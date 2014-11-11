package com.emiya.projects.localprojects.sysdesign.the4th;

public class GameMap {
	
	public final static String BLOCK="#";
	public final static String MAN="c";
	public final static String EMPTY=" ";
	public final static String BOX="b";
	
	private int rows, columns;
	private String[][] gameMap;
	
	public GameMap(int rows, int columns){
		this.rows=rows;
		this.columns=columns;
		
		gameMap=new String[rows][];
	}
	
	public String[][] getStatus(){
		return gameMap.clone();
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
		return gameMap[row][column];
	}
	
	
}
