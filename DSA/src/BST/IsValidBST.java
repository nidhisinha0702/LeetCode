package BST;

public class IsValidBST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(4);
		root.left = new TreeNode(2);
		root.right = new TreeNode(7);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(3);
		
		boolean ans = isValidBST(root);
		System.out.println("the val is :"+ans);
	}
	 private static boolean isValidBST(TreeNode root) {
	        return isValid(root, Long.MIN_VALUE, Long.MAX_VALUE);
	    }

	    private static boolean isValid(TreeNode root, long min, long max){
	        if(root == null) return true;
	        if(root.val >= max || root.val <= min) return false;
	        return isValid(root.left, min, root.val) && isValid(root.right, root.val, max);
	    }
}
