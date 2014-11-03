package com.emiya.projects.localprojects.sysdesign.the3rd;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * the main idea of the program is that
 * when we find the correct path
 * all of the relative path are in the stack
 * then we get them and get the answer.
 * 
 * @author KINGFISH
 *
 */
public class Tree {
	
	private LinkedList<Edge> edgeList=new LinkedList<Edge>();
	private Stack<Edge> edgeStack=new Stack<Edge>();
	private LinkedList<Integer> nodeList=new LinkedList<Integer>();
	private int distance;
	
	public void addEdge(int left, int right, int length){
		edgeList.add(new Edge(left,right,length));
	}
	
	public void addEdge(Edge edge){
		edgeList.add(edge);
	}
	
	public Edge removeEdge(int left,int right){
		for(Edge edge:edgeList){
			if(edge.isTheEdge(left, right)){
				edgeList.remove(edge);
				return edge;
			}
		}
		
		return null;
	}
	
	private Edge findEdge(int node){
		for(Edge edge:edgeList){
			if(edge.hasNode(node))
				return edge;
		}
		
		return null;
	}
		
	public int getDistance(int start, int end){
		this.processCore(start, end);
		
		System.out.println("DIST "+start+" "+end+" = "+distance);
		return this.distance;
	}
	
	public int getKth(int start,int end ,int k){
		this.processCore(start, end);
		
		System.out.println("KTH "+start+" "+end+" "+k+" = "+nodeList.get(k-1));
		return nodeList.get(k-1);
	}
	
	private void processCore(int start,int end){
		clearAll();
		
		try{
			this.findPath(start, end);
		}catch(Exception e){
			
			this.recordDistance();
			this.recordNodePath(start);
			
			while(!edgeStack.isEmpty()){
				edgeList.add(edgeStack.pop());
			}
		}
	}
	
	private void findPath(int start,int end) throws Exception{
		Edge edge=null;
		
		//if there is still path can be find
		while((edge=this.findEdge(start))!=null){
			edgeList.remove(edge);
			edgeStack.push(edge);
			
			//if we find the final node
			if(edge.getOtherPole(start)==end){
				throw new Exception("find the correct path.");
			}
			
			findPath(edge.getOtherPole(start),end);
			
			if(!edgeStack.isEmpty()){
				Edge e=edgeStack.pop();
			}
		}
	}
	
	private void recordNodePath(int start){
		nodeList.clear();
		
		int tempStart=start;
		nodeList.addFirst(tempStart);
		
		for(Edge edge:edgeStack){
			nodeList.add(edge.getOtherPole(tempStart));
			tempStart=edge.getOtherPole(tempStart);
		}
	}
	
	private void recordDistance(){
		for(Edge edge:edgeStack){
			distance+=edge.getLength();
		}
	}
	
	public List<Integer> getNodeList(){
		return this.nodeList;
	}
	
	private void clearAll(){
		this.nodeList.clear();
		this.distance=0;
		this.edgeStack.clear();
	}
	
	
}
