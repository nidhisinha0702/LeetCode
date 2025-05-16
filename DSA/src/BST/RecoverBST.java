package BST;

public class RecoverBST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(1);
		root.right = new TreeNode(4);
		root.right.left = new TreeNode(2);
		recoverTree(root);
		

	}
	 private static void recoverTree(TreeNode root) {
	        //swapped nodes are not adjacent
	        //swapped nodes are adjacent
	        first = middle = last = null;
	        prev = new TreeNode(Integer.MIN_VALUE);
	        inorder(root);
	        //swap the violations
	        if(first != null && last != null){
	            int t = first.val;
	            first.val = last.val;
	            last.val = t;
	        }else if(first != null && middle != null){
	            int t = first.val;
	            first.val = middle.val;
	            middle.val = t;
	        }
	    }

	    private static TreeNode first, prev, middle, last;
	    private static void inorder(TreeNode root){
	        if(root == null) return;
	        inorder(root.left);

	        if(prev != null && (root.val < prev.val)){
	            //if this is 1st violation
	            if(first == null){
	                first = prev;
	                middle = root;
	            }
	            //second violation
	            else
	                last = root;
	        }
	        //mark this node as prev
	        prev = root;
	        inorder(root.right);
	    }

}
