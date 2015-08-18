package org.interview.datastructure.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 1. Pre Order (both recursive and iterative)
 * 2. Post Order (both recursive and iterative)
 * 3. In Order (both recursive and iterative)
 * 
 * 4. Level Order
 * @author shekharagrawal
 *
 */
public class TreeUtil {

	private TreeNode rootNode;
	public TreeNode getInstanceOfTree(){
		if(rootNode == null){
			TreeNode l1 = new TreeNode(60, new TreeNode(40), new TreeNode(70));
			TreeNode l2 = new TreeNode(80, l1, new TreeNode(90));
			TreeNode r1 = new TreeNode(120, new TreeNode(110), new TreeNode(140));
			rootNode = new TreeNode(100, l2, r1);
		}
		return rootNode;
	}
	
	/**
	 * Print all the node level by level
	 */
	public void levelOrder(){
		TreeNode rootNode = getInstanceOfTree();
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.offer(rootNode);
		
		while(!q.isEmpty()){
			TreeNode t = q.poll();
			System.out.print(" "+t.getData());
			if(t.getLeftNode() != null)q.offer(t.getLeftNode());
			if(t.getRightNode() != null)q.offer(t.getRightNode());
		}
		
		System.out.println();
	}
	
	/**
	 * Print the node as would look into Tree
	 */
	public void levelPrinting(){
		TreeNode rootNode = getInstanceOfTree();
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.offer(rootNode);
		ArrayList<TreeNode> list = new ArrayList<TreeNode>();
		int index = 0;
		while(!q.isEmpty()){
			TreeNode t = q.poll();
			list.add(t);
			if(q.isEmpty() && list.size() > 0){
				printList(list, index++);
				for(TreeNode n : list){
					if(n.getLeftNode() != null)q.offer(n.getLeftNode());
					if(n.getRightNode() != null)q.offer(n.getRightNode());
				}
				list.clear();
			}
			
		}
		
		
	}
/**
 * 	
 * @param list
 */
	private void printList(ArrayList<TreeNode> list, int index) {
		System.out.print("|"+index+"|");
		for(TreeNode node : list){
			System.out.print(" "+node.getData()+" |");
		}
		System.out.println();
	}

	public void postOrder(){
		TreeNode rootNode = getInstanceOfTree();
		postOrder(rootNode);
		System.out.println();
	}
	
	private void postOrder(TreeNode node){
		if(node == null)return;
		postOrder(node.getLeftNode());
		postOrder(node.getRightNode());
		System.out.print(" "+node.getData());
	}
	
	public void inOrder(){
		TreeNode rootNode = getInstanceOfTree();
		inOrder(rootNode);
		System.out.println();
	}
	
	
	private void inOrder(TreeNode node) {
		if(node == null)return;
		inOrder(node.getLeftNode());
		System.out.print(" "+node.getData());
		inOrder(node.getRightNode());
	}

/**
 * 
 */
	public void preOrder(){
		TreeNode rootNode = getInstanceOfTree();
		preOrder(rootNode);
		System.out.println();
	}
/**
 * 	
 * @param rootNode2
 */
	private void preOrder(TreeNode node) {
		if(node == null)return;
		System.out.print(" "+node.getData());
		preOrder(node.getLeftNode());
		preOrder(node.getRightNode());
	}
	
	
	public static void main(String[] args) {
		TreeUtil util = new TreeUtil();
		util.preOrder();
		util.inOrder();
		util.postOrder();
		
		util.levelOrder();
		util.levelPrinting();
		
	}

}
