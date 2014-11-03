package com.emiya.projects.localprojects.sysdesign.the1st;

import java.util.List;

public class Main {
	
	public static void main(String[] args){
		
//		Printer printer=new Printer();
//		
//		Task a=new Task(0,2,2);
//		Task b=new Task(1,3,3);
//		UnknowTask unknow=new UnknowTask(4,3,7);
//		
//		LinkedList<Task> taskList=new LinkedList<Task>();
//		taskList.add(a);
//		taskList.add(b);
//		taskList.add(unknow);
//		
//		printer.registTask(taskList);
//		
//		try{
//		printer.go();
//		}catch(Exception e){
//			e.printStackTrace();
//		}
//		
//		printer.printAll();
		
		try{
		Printer printer=new Printer();
		List<Task> taskList=Inputer.buildTaskList("D:/input.txt");
				
		printer.registTask(taskList);
		PrintQueue queue=printer.go();
		Outputer.output(taskList, queue, printer.getUnknowTask(), "D:/output.txt");
		
		}catch(Exception e){
			System.out.println("输入文件格式有误，请调整输入文件。");
		}
		
	}
}
