package Trees;

public class CountGoodNodes {

	 private static int goodNodes(TreeNode root) {
	        int cnt[] = new int[1];

	        if(root == null) return 0;

	        //to count the good nodes
	        countHelper(root, cnt, root.val);

	        return cnt[0];
	    }
	    private static void countHelper(TreeNode root, int[] cnt, int currMax){
	        //base condition
	        if(root == null) return;

	        //if the current node is greater or equal
	        if(root.val >= currMax){
	            cnt[0]++;
	            currMax = root.val;
	        }

	        countHelper(root.left, cnt, currMax);
	        countHelper(root.right, cnt, currMax);
	    }
	
	public static void main(String[] args) {
		// WAP to count the good nodes
		//a node x is called good if all the nodes in the path from root is smaller than node x
		TreeNode root = new TreeNode(2);
		root.left = new TreeNode(1);
		root.right = new TreeNode(1);
		root.left.left = new TreeNode(3);
		root.right.left = new TreeNode(1);
		root.right.right = new TreeNode(5);
		
		System.out.println("The number of good nodes are : "+goodNodes(root));
	}

}
