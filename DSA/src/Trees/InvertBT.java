package Trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class InvertBT {

	public static void main(String[] args) {
		//WAP to invert a binary tree
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);
		
		System.out.println(" root is : "+invertBTDFS(root).val);
		System.out.println(" root is : "+invertBTBFS(root).val);
		System.out.println(" root is : "+invertBTIterative(root).val);

	}
	
	//DFS->NLR(PreOrer)
	private static TreeNode invertBTDFS(TreeNode root) {
		if(root == null) return null;
		
		//swap
		TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        
        invertBTDFS(root.left);
        invertBTDFS(root.right);
        
        return root;
		
	}
	
	private static TreeNode invertBTBFS(TreeNode root) {
		if(root == null) return root;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            TreeNode node = q.peek();
            q.remove();
            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;
            if(node.right != null) q.add(node.right);
            if(node.left != null) q.add(node.left);

        }return root;
	}
	
	private static TreeNode invertBTIterative(TreeNode root) {
		if(root == null) return root;
		
		Stack<TreeNode> st = new Stack<>();
		st.push(root);
		while(!st.isEmpty()) {
			TreeNode node = st.pop();
			//swap
			TreeNode temp = node.left;
			node.left = node.right;
			node.right = temp;
			
			if(node.left != null) st.push(node.left);
			if(node.right != null) st.push(node.right);
		}
		return root;
	}
}
