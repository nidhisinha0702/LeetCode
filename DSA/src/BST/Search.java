package BST;

public class Search {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(4);
		root.left = new TreeNode(2);
		root.right = new TreeNode(7);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(3);
		
		TreeNode ans = searchBSTIterative(root, 2);
		System.out.println("the val is :"+ans.val);
	}
	private static TreeNode searchBST(TreeNode root, int val) {
        if(root == null) return null;
        if(root.val == val) return root;
        if(val < root.val) return searchBST(root.left, val);
        else return searchBST(root.right, val);
    }
	 private static TreeNode searchBSTIterative(TreeNode root, int val) {
	       while(root != null && root.val != val){
	        root = val < root.val ? root.left : root.right;
	       }return root;
	    }
}
