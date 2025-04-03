package Trees;

public class isBST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node root = new Node(7);
		root.left = new Node(5);
		root.right = new Node(10);
		root.left.left = new Node(3);
		root.left.right = new Node(6);
		root.right.left = new Node(4);
		root.right.right = new Node(15);
		System.out.println("check if the given tree is a BST : "+isBST(root));

	}
	 private static boolean isBST(Node root) {
	        // to check bst roots val should not only be compared with its immediate left and right child but also its entire left
		 //and right subtree. so the intution is to maintain a lower and upper bound and compare it recursively 
	        long min = Long.MIN_VALUE;
	        long max = Long.MAX_VALUE;
	       return f(root,min,max);
	    }
	    private static boolean f(Node root, Long min, Long max){
	        if(root == null) return true;//if root is null return true
	        if(root.data <= min || root.data >= max) return false; //if the val is out of the range return false
	        //go deep into left and right subtree and compare each node's val with its root and a range
	        if(f(root.left,min,(long)root.data) && f(root.right,(long)root.data,max)){
	            return true;
	        }return false;
	    }
}
