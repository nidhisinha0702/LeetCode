package BST;

import java.util.Stack;

public class TwoSumIVBST {

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
		
		System.out.println("Two sum exist : "+findTarget(root, 16));

	}
	
	private static boolean findTarget(TreeNode root, int k) {
		if(root == null) return false;
		//create two obj l and r
		BSTIteratorAscDesc l = new BSTIteratorAscDesc(root, false);
		BSTIteratorAscDesc r = new BSTIteratorAscDesc(root, true);
		//assign i at l and j at r by call next
		int i = l.nextOrBefore();
		int j = r.nextOrBefore();
		
		while(i<j) {
			if(i + j == k) return true;
			else if(i + j < k) i = l.nextOrBefore();
			else j = r.nextOrBefore();
		}return false;
	}

}

class BSTIteratorAscDesc{
	Stack<TreeNode> st = new Stack<>();
	//declare a global reverse var to identify if it is for next or before
	boolean reverse = true;
	//reverse->true ->before
	//reverse->false ->next
	public BSTIteratorAscDesc(TreeNode root, boolean isReverse) {
		reverse = isReverse;
		pushAll(root);
	}
	
	public int nextOrBefore() {
		TreeNode temp = st.pop();
		if(!reverse) //next()
			pushAll(temp.right);
		else	pushAll(temp.left);
		return temp.val;
	}
	
	public boolean hasNextOrBefore() {
		return !st.isEmpty();
	}
	
	public void pushAll(TreeNode node) {
		while(node != null) {
			st.push(node);
			if(!reverse)
				node = node.left;
			else
				node = node.right;
		}
	}
}
