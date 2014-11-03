package com.emiya.projects.localprojects.sysdesign.the3rd;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Tree {
	
	private LinkedList<Edge> edgeList=new LinkedList<Edge>();
	private LinkedList<Edge> backupEdgeList=null;
	private Stack<Edge> edgeStack=new Stack<Edge>();
	private LinkedList<Integer> nodeList=new LinkedList<Integer>();
	private int distance;
	
	public void addEdge(int left, int right, int length){
		edgeList.add(new Edge(left,right,length));
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
	
	public void addEdge(Edge edge){
		edgeList.add(edge);
	}
	
	
	public Edge findEdge(int node){
		for(Edge edge:edgeList){
			if(edge.hasNode(node))
				return edge;
		}
		
		return null;
	}
		
	public int getDisance(int start,int end){
		backupEdgeList=(LinkedList<Edge>) edgeList.clone();
		this._getDistance(start, end);
		this.edgeList=backupEdgeList;
		System.out.println("DIST "+start+" "+end+" = "+distance);
		return this.distance;
	}
	
	private void _getDistance(int start,int end){
		Edge edge=null;
		
		//if there is still path can be find
		while((edge=this.findEdge(start))!=null){
			edgeList.remove(edge);
			edgeStack.push(edge);
			//'System.out.println("we push "+edge);
			
			//if we find the final node
			if(edge.getOtherPole(start)==end){
				this.recordDistance();
				this.recordNodePath(end);
				this.edgeList.clear();
				return;
			}
			
			_getDistance(edge.getOtherPole(start),end);
			
			if(!edgeStack.isEmpty()){
				Edge e=edgeStack.pop();
				//System.out.println("we pop "+e);
			}
		}
	}
	
	
	public int getKth(int start,int end ,int k){
		backupEdgeList=(LinkedList<Edge>) edgeList.clone();
		this._getDistance(start, end);
		this.edgeList=backupEdgeList;
		
		System.out.println("KTH "+start+" "+end+" "+k+" = "+nodeList.get(k-1));
		return nodeList.get(k-1);
	}
	
	private void recordNodePath(int end){
		int tempEnd=end;
		nodeList.addFirst(tempEnd);
		
		while(!edgeStack.isEmpty()){
			Edge edge=edgeStack.pop();
			nodeList.addFirst(edge.getOtherPole(tempEnd));
			tempEnd=edge.getOtherPole(tempEnd);
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
	
	
}
