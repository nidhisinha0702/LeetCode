package Trees;

public class DiameterOfBT {

	public static void main(String[] args) {
		// WAP to calculate the diameter of a BT
		//a diameter of a binary tree is the length of longest path between any two nodes within the tree
		
		TreeNode root = new TreeNode(1);
		root.right = new TreeNode(2);
		root.right.left = new TreeNode(3);
		root.right.right = new TreeNode(4);
		root.right.left.left = new TreeNode(5);
		
		System.out.println("The diameter is : "+diameterOfBinaryTree(root));
	}
	private static int diameterOfBinaryTree(TreeNode root) {
        int ans[] = new int[1];
        height(root, ans);
        return ans[0];
    }
    private static int height(TreeNode root, int ans[]){
        if(root == null) return 0;

        int leftHt = height(root.left, ans);
        int rightHt = height(root.right, ans);

        ans[0] = Math.max(ans[0], leftHt + rightHt);

        return Math.max(leftHt, rightHt) + 1;
    }
}
