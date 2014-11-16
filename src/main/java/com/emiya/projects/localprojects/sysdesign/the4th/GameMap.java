package com.emiya.projects.localprojects.sysdesign.the4th;

public class GameMap {
	
	public final static String BLOCK="#";
	public final static String MAN="S";
	public final static String EMPTY=".";
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
		this.rows=rows;
		this.columns=columns;
		this.gameMap=gameMap;
		this.man=man;
		this.box=box;
		this.target=target;
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
		
		System.out.println("<--------->");
	}
	
	public String getCell(int row, int column){
		String cellContent;
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
				if(this.getCell(i, j).equals(GameMap.BOX)){
					return new Box(i,j);
				}
			}
		}
		
		throw new Exception("no box."); 
	}
	
	
	public Man findMan() throws Exception{
		
		for(int i=0;i<this.getRowsLength();i++){
			for(int j=0;j<this.getColumnsLength();j++){
				if(this.getCell(i, j).equals(GameMap.MAN)){
					return new Man(i,j);
				}
			}
		}
		
		throw new Exception("no man."); 
	}
	
	private Target findTarget() throws Exception{
		for(int i=0;i<this.getRowsLength();i++){
			for(int j=0;j<this.getColumnsLength();j++){
				if(this.getCell(i, j).equals(GameMap.TARGET)){
					return new Target(i,j);
				}
			}
		}
		
		throw new Exception("no target.");
	}
	
	public boolean boxCanStand(int row, int column){
		return this.getCell(row, column).equals(EMPTY)||this.getCell(row, column).equals(TARGET)||this.getCell(row, column).equals(BOX)||this.getCell(row, column).equals(MAN);
	}
	
	public boolean manCanStand(int row, int column){
		return this.getCell(row, column).equals(EMPTY)||this.getCell(row, column).equals(TARGET)||this.getCell(row, column).equals(MAN);
	}
	
	@Override
	public GameMap clone(){
		String[][] cln=new String[rows][];
		for(int i=0;i<rows;i++){
			cln[i]=gameMap[i].clone();
		}
		
		return new GameMap(rows,columns, cln, man.clone(), box.clone(),target.clone());
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
	
	public String[][] getGameMap(){
		return this.gameMap;
	}
	
	
}
