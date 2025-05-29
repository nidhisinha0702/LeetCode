package Trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class DepthOfBT {

	public static void main(String[] args) {
		// WAP to find the depth of the binary tree
		//number of nodes along the longest path from root node down to the farthest leaf node
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.right.left = new TreeNode(4);
		
		System.out.println("The depth of tree is : "+maxDepthDFS(root));
		System.out.println("The depth of tree is : "+maxDepthBFS(root));
		System.out.println("The depth of tree is : "+maxDepthIterative(root));
	}
	
	private static int maxDepthDFS(TreeNode root) {
		if(root == null) return 0;
		
		return 1 + Math.max(maxDepthDFS(root.left), maxDepthDFS(root.right));
	}
	
	private static int maxDepthBFS(TreeNode root) {
		if(root == null) return 0;
		
		int level = 0;
		Queue<TreeNode> q = new LinkedList<>();
		
		q.offer(root);
		while(!q.isEmpty()) {
			int len = q.size();
			for(int i=0;i<len;i++) {
				TreeNode node = q.poll();
				if(node.left != null) q.offer(node.left);
				if(node.right != null) q.offer(node.right);
			}level++;
		}return level;
	}
	
	private static int maxDepthIterative(TreeNode root) {
		if(root == null) return 0;
		//push root,1 in stack
		Stack<Pair> st = new Stack<>();
		st.push(new Pair(root, 1));
		//initialize res as 0
		int res = 0;
		
		while(!st.isEmpty()) {
			//pop the top ele
			Pair p = st.pop();
			TreeNode node = p.x();
			int depth = p.y();
			//if it is null push its child nodes in stack with depth + 1
			if(node != null) {
				res = Math.max(res, depth);
				st.push(new Pair(node.left, depth + 1));
				st.push(new Pair(node.right, depth + 1));
			}
		}return res;
		
	}

}
