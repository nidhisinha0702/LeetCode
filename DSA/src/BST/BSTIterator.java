package BST;

import java.util.Stack;

public class BSTIterator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(7);
		root.left = new TreeNode(3);
		root.right = new TreeNode(10);
		root.left.left = new TreeNode(2);
		root.left.right = new TreeNode(6);
		root.left.left.left = new TreeNode(1);
		root.left.right.left = new TreeNode(5);
		root.left.right.left.left = new TreeNode(4);
		root.right.left = new TreeNode(9);
		root.right.left.left = new TreeNode(8);
		
		BSTIterator it = new BSTIterator(root);
		System.out.println(it.next());
		System.out.println(it.next());
		System.out.println(it.next());
		System.out.println(it.hasNext());
		System.out.println(it.next());
		System.out.println(it.next());
		System.out.println(it.next());
		System.out.println(it.next());
		System.out.println(it.next());
		System.out.println(it.next());
		System.out.println(it.next());
		System.out.println(it.hasNext());

	}
	    private Stack<TreeNode> st = new Stack<>();
	    public BSTIterator(TreeNode root) {
	        pushAll(root);//push all the left in the stack
	    }
	    
	    public int next() {
	        //pop the top ele and push its right if exist
	        TreeNode tmp = st.pop();
	        pushAll(tmp.right);
	        return tmp.val;
	    }
	    
	    public boolean hasNext() {
	        //is st is empty no ele is next
	        return !st.isEmpty();
	    }
	    //we will push all the lefts
	    private void pushAll(TreeNode root){
	        while(root != null){
	            st.push(root);
	            root = root.left;
	        }
	    }
}
