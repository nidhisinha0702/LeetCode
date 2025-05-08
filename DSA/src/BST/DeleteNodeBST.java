package BST;

public class DeleteNodeBST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(9);
		root.left = new TreeNode(8);
		root.right = new TreeNode(12);
		root.left.left = new TreeNode(5);
		root.left.left.left = new TreeNode(3);
		root.left.left.right = new TreeNode(7);
		root.left.left.left.left = new TreeNode(2);
		root.left.left.left.right = new TreeNode(4);
		root.left.left.left.left.left = new TreeNode(1);
		root.left.left.right.left = new TreeNode(6);
		root.left.left.right.right = new TreeNode(8);
		root.right.left = new TreeNode(10);
		root.right.right = new TreeNode(13);
		root.right.left.right = new TreeNode(11);
		
		TreeNode ans = deleteNode(root, 5);
		System.out.println("the val is :"+ans.val);

	}
	 private static TreeNode deleteNode(TreeNode root, int key) {
	        if(root == null) return null;
	        //search the node
	        //if it is the root that has to be deleted
	        if(root.val == key){
	            return helper(root);
	        }
	        //delete it
	        //create a dummy to preserve root
	        TreeNode dummy = root;
	        while(root != null){
	            if(key < root.val){
	                if(root.left != null && root.left.val == key){
	                    root.left = helper(root.left);
	                    break;
	                }else{
	                    root = root.left;
	                }
	            }else{
	                if(root.right != null && root.right.val == key){
	                    root.right = helper(root.right);
	                    break;
	                }else{
	                    root = root.right;
	                }
	            }
	        }return dummy;
	    }

	    private static TreeNode helper(TreeNode root){
	        //connect remaining nodes if exist
	        //if either of the node is missing
	        if(root.left == null){
	            return root.right;
	        }else if(root.right == null){
	            return root.left;
	        }
	        //if both are present
	        //find the right child
	        TreeNode rightChild = root.right;
	        //find the last right of the left child
	        TreeNode lastRight = findLastRight(root.left);
	        //connect last right's right to rightchild
	        lastRight.right = rightChild;
	        //return roots left
	        return root.left;
	    }

	    private static TreeNode findLastRight(TreeNode root){
	        if(root.right == null){
	            return root;
	        }
	        return findLastRight(root.right);
	    }
}
