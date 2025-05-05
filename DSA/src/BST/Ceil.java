package BST;
//min val>=key
public class Ceil {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(10);
		root.left = new TreeNode(5);
		root.right = new TreeNode(13);
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(6);
		root.left.left.left = new TreeNode(2);
		root.left.left.right = new TreeNode(4);
		root.left.right.right = new TreeNode(9);
		root.right.left = new TreeNode(11);
		root.right.right = new TreeNode(14);
		
		int ans = ceil(root, 8);
		System.out.println("the val is :"+ans);
	}
	private static int ceil(TreeNode root, int key) {
		int ceil = -1;
		//traverse the tree untill null
		while(root != null) {
			//if found return ceil
			if(root.val == key) {
				ceil = root.val;
				return ceil;
			}//if the val < key move to right we want greater or equal value
			else if(root.val < key) {
				root = root.right;
			}else {
				//since we got a greater value update it and then look for equal
				ceil = root.val;
				root = root.left;
			}
		}return ceil;
	}
}
