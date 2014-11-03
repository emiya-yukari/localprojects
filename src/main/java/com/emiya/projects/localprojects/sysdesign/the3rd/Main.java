package com.emiya.projects.localprojects.sysdesign.the3rd;


public class Main {

	//we use this to instead the input.txt and use the console
	//to instead the output.txt
	public static void main(String[] args){
		
		Tree tree=new Tree();
		tree.addEdge(1, 3, 1);
		tree.addEdge(2, 4, 1);
		tree.addEdge(2, 5, 1);
		tree.addEdge(1, 2, 1);
		tree.addEdge(3, 6, 2);
		
		tree.getDisance(4, 6);
		tree.getKth(4, 6, 4);
	}
}
