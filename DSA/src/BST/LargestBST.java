package BST;

public class LargestBST {
	private static int maxSize;
	private static class NodeInfo{
		int maxi;
		int mini;
		boolean isBST;
		int size;
		
		NodeInfo(int _maxi, int _mini, boolean _isBST, int _size){
			maxi = _maxi;
			mini = _mini;
			isBST = _isBST;
			size = _size;
		}
	}
	private static NodeInfo solve(TreeNode root) {
		//base condition
		if(root == null) {
			return new NodeInfo(Integer.MIN_VALUE, Integer.MAX_VALUE, true, 0);
		}
		
		//postorder traversal LRRo
		NodeInfo left = solve(root.left);
		NodeInfo right = solve(root.right);
		
		//node
		if(left.isBST && right.isBST && (root.val > left.maxi && root.val < right.mini)) {
			int maxi = Math.max(root.val, right.maxi);
			int mini = Math.min(root.val, left.mini);
			int size = left.size + right.size + 1;
			maxSize = Math.max(maxSize, size);
			boolean isBST = true;
			return new NodeInfo(maxi, mini, isBST, size);
		}else {
			return new NodeInfo(0, 0, false, 0);
		}
		
	}
	private static int largestBST(TreeNode root) {
		maxSize = 0;
		solve(root);
		return maxSize;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(1);
		root.right = new TreeNode(5);
		root.left.left = new TreeNode(8);
		root.left.right = new TreeNode(0);
		root.right.left = new TreeNode(2);
		root.right.right = new TreeNode(6);
		
		System.out.println("The length of lasrgest BST is : "+largestBST(root));
	}

}
