package Trees;

public class IsSameTree {

	private static boolean isSameTree(TreeNode p, TreeNode q) {
        //when both roots are null
        if(p == null && q == null) return true;
        // one of then is null or values are different
        if((p == null) ||(q == null) || (p.val != q.val)) return false;
        //otherwise we will check left and right nodes recursively
        //and if both are true then return true
        return (isSameTree(p.left, q.left) &&
        isSameTree(p.right, q.right));
    }
	
	private static boolean isSubtree(TreeNode root, TreeNode subRoot) {
        //if both are null or subRoot is null
        if((root == null && subRoot == null) || (subRoot == null)) return true;

        //if root is null
        if(root == null) return false;

        //once found check same tree
        if(isSameTree(root, subRoot)) return true;

        //either found in left or right subtree
       return (isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot));

    }
	
	public static void main(String[] args) {
		// WAP to check if two trees are same or not
		TreeNode root = new TreeNode(1);
		root.right = new TreeNode(3);
		root.left = new TreeNode(2);
		
		TreeNode root1 = new TreeNode(1);
		root1.right = new TreeNode(3);
		root1.left = new TreeNode(2);
		
		System.out.println("The trees are same : "+isSameTree(root, root1));

		TreeNode root2 = new TreeNode(1);
		root2.right = new TreeNode(3);
		root2.left = new TreeNode(2);
		root2.left.left = new TreeNode(4);
		root2.left.right = new TreeNode(5);
		
		TreeNode root3 = new TreeNode(2);
		root3.right = new TreeNode(5);
		root3.left = new TreeNode(4);
		
		System.out.println("The tree is subtree of another : "+isSubtree(root, root1));
	}

}
