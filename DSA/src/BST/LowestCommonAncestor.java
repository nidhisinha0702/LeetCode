package BST;

public class LowestCommonAncestor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(6);
		root.left = new TreeNode(2);
		root.right = new TreeNode(8);
		root.left.left = new TreeNode(0);
		root.left.right = new TreeNode(4);
		root.left.right.left = new TreeNode(3);
		root.left.right.right = new TreeNode(5);
		root.right.left = new TreeNode(7);
		root.right.right = new TreeNode(9);
		
		TreeNode ans = lca(root,root.left,root.left.right);
		System.out.println("the val is :"+ans.val);

	}
	private static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while(root != null){
            if(p.val > root.val && q.val > root.val){
                root = root.right;
            }else if(p.val < root.val && q.val < root.val){
                root = root.left;
            }else{
                return root;
            }
        }return null;
    }
	
	private static TreeNode lca(TreeNode root, TreeNode p, TreeNode q) {
		if(root == null) return null;
		//if both are greater go to right
		if(p.val > root.val && q.val > root.val)
			return lca(root.right, p,q);
		//if both are smaller go to left
		else if(p.val < root.val && q.val < root.val)
			return lca(root.left, p , q);
		else 
			return root;
	}
}
