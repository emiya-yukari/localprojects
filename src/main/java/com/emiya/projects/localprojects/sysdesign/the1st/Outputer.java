package com.emiya.projects.localprojects.sysdesign.the1st;

import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;

public class Outputer {

	public static void output(List<Task> taskList, PrintQueue queue,UnknowTask unknow, String fileURL) throws Exception{
		
		HashMap<Long, PrintTask> map=new HashMap<Long, PrintTask>();
		
		for(int i=0;i<queue.getSize();i++){
			PrintTask task=queue.getTask(i);
			
			map.put(task.getTask().getStartTime(), task);
		}
		
		 PrintWriter writer = new PrintWriter(new OutputStreamWriter(new FileOutputStream(fileURL)),true);
		 
		 writer.println(unknow.getPriority());
		 for(Task task: taskList){
			 System.out.print("startTime:"+task.getStartTime()+" endTime:"+map.get(task.getStartTime()).getEndPrintTime());
			 System.out.println();
			 writer.print(map.get(task.getStartTime()).getEndPrintTime()+" ");
		 }
		 
		 writer.close();
		
		
		
	}
}
