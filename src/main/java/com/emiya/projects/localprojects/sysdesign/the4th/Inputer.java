package com.emiya.projects.localprojects.sysdesign.the4th;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.LinkedList;

public class Inputer {

	public static GameMap getGameMap(String fileURL) throws Exception{
		
		File file = new File("D:/input.txt"); 
		BufferedReader reader = new BufferedReader(new FileReader(file));
			
		int row,column;
		String line=reader.readLine();
		String[] firstLine=line.split(" ");
		row=Integer.parseInt(firstLine[0]);
		column=Integer.parseInt(firstLine[1]);
		
		GameMap gameMap=new GameMap(row,column);
			
		for(int i=0;i<row;i++){
			line=reader.readLine();
			String[] content=line.split("");
			gameMap.addRow(i, content);
		}
			
		
		return gameMap;
	}
}
