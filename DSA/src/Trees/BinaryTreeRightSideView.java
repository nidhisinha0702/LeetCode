package Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
//TC->O(n) SC->O(n) 
public class BinaryTreeRightSideView {

	 private static List<Integer> rightSideView(TreeNode root) {
		 //the last node of every level is indeed my right side view
		 //we will use BFS
	        List<Integer> ans = new ArrayList<>();
	        if(root == null) return ans;
	        Queue<TreeNode> q = new LinkedList<>();
	        q.add(root);
	        
	        while(!q.isEmpty()){
	        	TreeNode rightSide = null;
	        	int size = q.size();
	        	for(int i=0;i<size;i++) {
	        		TreeNode node = q.poll();
	        		rightSide = node;
		            if(node.left != null) q.add(node.left);
		            if(node.right != null) q.add(node.right);
	        	}
	            if(rightSide != null) {
	            	ans.add(rightSide.val);
	            }
	            
	        }return ans;
	    }
	 
	private static List<Integer> leftSideView(TreeNode root) {
		//the first node of every level is indeed my left side view
		List<Integer> ans = new ArrayList<>();
        if(root == null) return ans;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        while(!q.isEmpty()){
        	TreeNode leftSide = null;
        	int size = q.size();
        	for(int i=0;i<size;i++) {
        		TreeNode node = q.poll();
        		leftSide = node;
        		if(node.right != null) q.add(node.right);
	            if(node.left != null) q.add(node.left);
        	}
            if(leftSide != null) {
            	ans.add(leftSide.val);
            }
            
        }return ans;
	}
	
	
	public static void main(String[] args) {
		// WAP to demonstrate the right side view of a binary tree
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);

		List<Integer> ansR = rightSideView(root);
		List<Integer> ansL = leftSideView(root);
		System.out.println(ansR); 
		System.out.println(ansL); 
	}

}
