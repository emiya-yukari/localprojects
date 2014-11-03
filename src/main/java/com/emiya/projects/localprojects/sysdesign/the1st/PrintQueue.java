package com.emiya.projects.localprojects.sysdesign.the1st;

import java.util.Stack;

public class PrintQueue {
	
	private MySortedList<PrintTask> queue=new MySortedList<PrintTask>();
	private Stack<PrintTask> stack=new Stack<PrintTask>();
	
	public PrintTask offer(Task task){
		PrintTask printTask=new PrintTask(task);
		
		
		if(queue.isEmpty()){
			queue.offer(printTask);
			stack.push(printTask);
			return printTask;
		}
		
		
		
		//for(PrintTask queueTask:queue){
			for(int i=0;i<queue.getSize();i++){
				PrintTask queueTask=queue.get(i);

				
			//不重合的第一种情况
			if(printTask.getEndPrintTime()<=queueTask.getStartPrintTime()){
				break;
			}
			
			
			//不重合的第二种情况
			if(printTask.getStartPrintTime()>=queueTask.getEndPrintTime()){
				;
			} 
			
			//重合的第一种情况
			else if(printTask.getStartPrintTime()<queueTask.getStartPrintTime()&&printTask.getEndPrintTime()>queueTask.getStartPrintTime()&&printTask.getEndPrintTime()<=queueTask.getEndPrintTime()){
				printTask.adjustEndPrintTime(queueTask.getDuration());
			}
			
			//重合的第二种情况——完全被包含（包括重合）
			else if(printTask.getStartPrintTime()>=queueTask.getStartPrintTime()&&printTask.getEndPrintTime()<=queueTask.getEndPrintTime()){
				printTask.adjustStartPrintTime(queueTask.getEndPrintTime());
			}
			
			//重合第三种情况——完全包含
			else if(printTask.getStartPrintTime()<=queueTask.getStartPrintTime()&&printTask.getEndPrintTime()>=queueTask.getEndPrintTime()){
				printTask.adjustEndPrintTime(queueTask.getDuration());
				
			}
			
			//重合的第四种情况
			else if(printTask.getStartPrintTime()>=queueTask.getStartPrintTime()&&printTask.getStartPrintTime()<=queueTask.getEndPrintTime()&&printTask.getEndPrintTime()>queueTask.getEndPrintTime()){
				printTask.adjustStartPrintTime(queueTask.getEndPrintTime());
			}
		}
		
		queue.offer(printTask);
		stack.push(printTask);
		
		return printTask;
	}
	
	public PrintTask pop(){
		if(stack.isEmpty())
			return null;
		
		PrintTask temp=stack.pop();
		queue.remove(temp);
		
		return temp;
	}
	
	public void printAll(){
		for(int i=0;i<queue.getSize();i++){
			PrintTask printTask=queue.get(i);
			printTask.printDetail();
		}
			
		//for(PrintTask printTask: queue){
		//	printTask.printDetail();
		//}
	}
	
	public long getSize(){
		return queue.getSize();
	}
	
	public PrintTask getTask(int i){
		return queue.get(i);
	}
	
	
}
