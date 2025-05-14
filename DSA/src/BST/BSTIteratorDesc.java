package BST;

import java.util.Stack;

public class BSTIteratorDesc {

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
		
		BSTIteratorDesc it = new BSTIteratorDesc(root);
		System.out.println(it.before());
		System.out.println(it.before());
		System.out.println(it.before());
		System.out.println(it.hasBefore());
		System.out.println(it.before());
		System.out.println(it.before());
		System.out.println(it.before());
		System.out.println(it.before());
		System.out.println(it.before());
		System.out.println(it.before());
		System.out.println(it.before());
		System.out.println(it.hasBefore());
	}

	private Stack<TreeNode> st = new Stack<>();
	public BSTIteratorDesc(TreeNode root){
		pushAll(root);
	}
	
	public int before() {
		//pop the top ele and push the left if exist
		TreeNode tmp = st.pop();
		pushAll(tmp.left);
		return tmp.val;
	}
	
	public boolean hasBefore() {
		return !st.isEmpty();
	}
	
	public void pushAll(TreeNode node) {
		//we will push all the right
		while(node != null) {
			st.push(node);
			node = node.right;
		}
	}
	
}
