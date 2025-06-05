package Trees;

import java.util.ArrayList;
import java.util.List;
//TC-> O(n), SC-> O(H)
public class BinaryTreeRightSideViewII {

	//DFS -> Preorder Reverse (N->R->L)
	private static void rightSideView(TreeNode root, int level, List<Integer> ans) {
		if(root == null) return;
		
		if(level == ans.size()) ans.add(root.val);
		rightSideView(root.right, level+1, ans);
		rightSideView(root.left, level+1, ans);
	}
	
	//DFS -> Preorder (N->L->R)
		private static void leftSideView(TreeNode root, int level, List<Integer> ans) {
			if(root == null) return;
			
			if(level == ans.size()) ans.add(root.val);
			leftSideView(root.left, level+1, ans);
			leftSideView(root.right, level+1, ans);
		}
	
	public static void main(String[] args) {
		// WAP to demo right side view
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		List<Integer> ansR = new ArrayList<>();
		rightSideView(root, 0, ansR);
		List<Integer> ansL = new ArrayList<>();
		leftSideView(root, 0, ansL);
		System.out.println(ansR); 
		System.out.println(ansL); 
	}

}
