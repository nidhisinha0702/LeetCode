package Trees;

public class MaxPathSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode node = new TreeNode(1);
		node.left = new TreeNode(2);
		node.right = new TreeNode(3);
		System.out.println("max path sum is "+maxPathSum(node));

	}
	private static int maxPathSum(TreeNode root) {
        int maxSum[] = new int[1];
        maxSum[0] = Integer.MIN_VALUE;
        helper(root,maxSum);
        return maxSum[0];
    }
    private static int helper(TreeNode root, int[] maxSum){
        if(root == null) return 0;

        int leftSum = Math.max(helper(root.left, maxSum), 0);

        int rightSum = Math.max(helper(root.right,maxSum), 0);

        maxSum[0] = Math.max(maxSum[0], leftSum + rightSum + root.val);

        return Math.max(leftSum, rightSum) + root.val;

    }
}
