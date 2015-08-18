package org.interview.datastructure.graph;

public class TreeNode {
	
	private int data;
	private TreeNode left;
	private TreeNode right;
	
	public TreeNode(int data){
		this.data = data;
	}
	
	public TreeNode(int data, TreeNode left, TreeNode right){
		this.data = data;
		this.left = left;
		this.right = right;
	}
	
	public int getData(){
		return this.data;
	}
	
	public TreeNode getLeftNode(){
		return this.left;
	}
	
	public TreeNode getRightNode(){
		return this.right;
	}
	
	public void setLeftNode(TreeNode t){
		this.left = t;
	}
	
	public void setRightNode(TreeNode t){
		this.right = t;
	}

}
