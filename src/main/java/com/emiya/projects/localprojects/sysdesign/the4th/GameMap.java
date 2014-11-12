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
	private Box box;
	private Man man;
	
	
	public GameMap(int rows, int columns){
		this.rows=rows;
		this.columns=columns;
		
		gameMap=new String[rows][];
	}
	
	public GameMap(int rows, int columns, String[][] gameMap, Man man, Box box, Target target){
		
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
	
	public Target getTarget(){		
		return target;
	}
	
	private Box findBox() throws Exception{
		
		for(int i=0;i<this.getRowsLength();i++){
			for(int j=0;j<this.getColumnsLength();j++){
				if(this.getCell(i, j)==GameMap.MAN){
					return new Box(i,j);
				}
			}
		}
		
		throw new Exception("no box."); 
	}
	
	
	public Man findMan() throws Exception{
		
		for(int i=0;i<this.getRowsLength();i++){
			for(int j=0;j<this.getColumnsLength();j++){
				if(this.getCell(i, j)==GameMap.MAN){
					return new Man(i,j);
				}
			}
		}
		
		throw new Exception("no man."); 
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
	
	public boolean isEmpty(int row, int column){
		return this.getCell(row, column).equals(EMPTY)||this.getCell(row, column).equals(TARGET);
	}
	
	@Override
	public GameMap clone(){
		return new GameMap(rows,columns, gameMap.clone(), man.clone(), box.clone(),target.clone());
	}
	
	public boolean hasArrived() throws Exception{
		return this.getBox().getRow()==this.getTarget().getRow()&&this.getBox().getColumn()==this.getTarget().getColumn();
	}
	
	public void init() throws Exception{
		this.box=this.findBox();
		this.target=this.findTarget();
		this.man=this.findMan();
	}
	
	public Box getBox(){
		return this.box;
	}
	
	public Man getMan(){
		return this.man;
	}
	
	
}
