package com.emiya.projects.localprojects.sysdesign.the1st;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.LinkedList;

public class Inputer {

	public static LinkedList<Task> buildTaskList(String fileURL) throws Exception{
		LinkedList<Task> list=new LinkedList<Task>();
		String unknowEndTime=null;
		UnknowTask unknow=null;
		
		File file = new File("D:/input.txt"); 
		BufferedReader reader = new BufferedReader(new FileReader(file));
			
		int lineCnt=0;
		String line=reader.readLine();
			
		lineCnt=Integer.parseInt(line);
			
		for(int i=0;i<lineCnt;i++){
			line=reader.readLine();
			String[] temp=line.split(" ");
			
			if(!temp[2].equals("-1"))
				list.add(new Task(Long.valueOf(temp[0]),Long.valueOf(temp[1]),Long.valueOf(temp[2])));
			else{
				unknow=new UnknowTask(Long.valueOf(temp[0]),Long.valueOf(temp[1]),-1);
				list.add(unknow);
			}
		}
			
		line=reader.readLine();
		unknowEndTime=line;
		unknow.setEndTime(Long.valueOf(unknowEndTime));
		
		return list;
	}
}
