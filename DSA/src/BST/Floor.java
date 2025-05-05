package BST;
//max val <=key
public class Floor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(10);
		root.left = new TreeNode(5);
		root.right = new TreeNode(15);
		root.left.left = new TreeNode(2);
		root.left.right = new TreeNode(8);
		root.left.right.left = new TreeNode(6);
		root.right.left = new TreeNode(13);
		root.right.right = new TreeNode(17);
		
		int ans = floor(root, 9);
		System.out.println("the val is :"+ans);
	}
	private static int floor(TreeNode root, int key) {
		int floor = -1;
		while(root != null) {
			if(root.val == key) {
				floor = root.val;
				return floor;
			}else if(root.val < key) {//if the val is less we want to maximize it so move right
				floor = root.val;
				root = root.right;
			}else {
				root = root.left;
			}
		}return floor;
	}

}
