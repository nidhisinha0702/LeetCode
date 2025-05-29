package Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFSTraversal {

	public static void main(String[] args) {
		// BFS traversal-> level by level traversal
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(3);
		root.right = new TreeNode(2);

	}
	
	private static List<List<Integer>> bfs(TreeNode root){
		if(root == null) return new ArrayList<>();
		
		List<List<Integer>> ans = new ArrayList<>();
		Queue<TreeNode> q = new LinkedList<>();
		
		q.offer(root);
		int currLevel = 0;
		
		while(!q.isEmpty()) {
			int len = q.size();
			ans.add(new ArrayList<>());
			
			for(int i=0;i<len; i++) {
				TreeNode node = q.poll();
				ans.get(currLevel).add(node.val);
			
			if(node.left != null) q.offer(node.left);
			if(node.right != null) q.offer(node.right);
			}
			currLevel++;
		}
		return ans;
	}

}
