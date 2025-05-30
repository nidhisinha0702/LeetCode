package Trees;

public class BalancedBT {

	public static void main(String[] args) {
		// WAP to check the binary tree is balanced or not
		TreeNode root = new TreeNode(3);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);
		root.left = new TreeNode(9);
		
		System.out.println("The diameter is : "+balanceBT(root));

	}

	private static boolean balanceBT(TreeNode root) {
		int ans = height(root);
		return ans == -1? false:true;
	}
	
	private static int height(TreeNode root) {
		//base case
		if(root == null)
			return 0;
		
		int leftHt = height(root.left);
		if(leftHt == -1) return -1;
		int rightHt = height(root.right);
		if(rightHt == -1) return -1;
		if(Math.abs(rightHt - leftHt) > 1) return -1;
		
		return 1 + Math.max(leftHt, rightHt);
	}
}
