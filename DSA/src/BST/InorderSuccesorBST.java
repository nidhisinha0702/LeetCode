package BST;

public class InorderSuccesorBST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(3);
		root.right = new TreeNode(7);
		root.left.left = new TreeNode(2);
		root.left.right = new TreeNode(4);
		root.left.left.left = new TreeNode(1);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(9);
		root.right.right.left = new TreeNode(8);
		root.right.right.right = new TreeNode(10);
		
		TreeNode ans = successor(root, root.left);
		System.out.println("the val is :"+ans.val);
		TreeNode ans1 = predecessor(root, root.left);
		System.out.println("the val is :"+ans1.val);
	}
	
	private static TreeNode successor(TreeNode root, TreeNode p) {
		TreeNode successor = null;
		
		while(root != null) {
			if(root.val <= p.val) {
				root = root.right;
			}else {
				successor = root;
				root = root.left;
			}
		}return successor;
	}
	
	private static TreeNode predecessor(TreeNode root, TreeNode p) {
		TreeNode predecessor = null;
		
		while(root != null) {
			if(root.val < p.val) {
				predecessor = root;
				root = root.right;
			}else {
				root = root.left;
			}
		}return predecessor;
	}

}
