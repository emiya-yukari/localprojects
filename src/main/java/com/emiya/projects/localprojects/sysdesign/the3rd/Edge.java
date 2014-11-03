package com.emiya.projects.localprojects.sysdesign.the3rd;

public class Edge {

	public final static int ERROR=-1;
	private int left,right,length;
	
	public Edge(int left,int right,int length){
		this.left=left;
		this.right=right;
		this.length=length;
	}
	
	public int getOtherPole(int thePole){
		if(thePole==left)
			return right;
		else if(thePole==right)
			return left;
		else return ERROR;
	}
	
	public int getLength(){
		return this.length;
	}
	
	public boolean isTheEdge(int left, int right){
		return this.left==left&&this.right==right;
	}
	
	public boolean hasNode(int node){
		return this.left==node||this.right==node;
	}
	
	public int findSameNode(Edge edge){
		return edge.getOtherPole(this.left)==ERROR?right:left;
	}
	
	public String toString(){
		return "left: "+left+"  right: "+right+"\n";
	}
	
}
