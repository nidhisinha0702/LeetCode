package Trees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class DFSPreOrderTraversal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> v = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7));
		TreeNode root0 = new TreeNode(v.get(0));
		root0.left = new TreeNode(v.get(1));
        root0.right = new TreeNode(v.get(2));
        root0.left.left = new TreeNode(v.get(3));
        root0.left.right = new TreeNode(v.get(4));
        root0.right.left = new TreeNode(v.get(5));
        root0.right.right = new TreeNode(v.get(6));
        List<Integer> a = preorderTraversal(root0);
        List<Integer> ans = preorderIterative(root0);
        System.out.println(a);
        System.out.println(ans);
	}
	 private static List<Integer> preorderTraversal(TreeNode root) {
	        List<Integer> ans = new ArrayList<>();
	        return preorder(root,ans);
	    }
	    private static List<Integer> preorder(TreeNode root, List<Integer> ans){
	        if(root == null) return ans;

	        ans.add(root.val);
	        preorder(root.left, ans);
	        preorder(root.right, ans);
	        return ans;
	    }
	    
	    private static List<Integer> preorderIterative(TreeNode root){
	    	List<Integer> ans = new ArrayList<>();
	    	if(root == null) return ans;
	    	Stack<TreeNode> st = new Stack<>();
	    	st.push(root);
	    	while(!st.isEmpty()) {
	    		TreeNode node = st.pop();
	    		ans.add(node.val);
	    		if(node.right!=null) st.push(node.right);
	    		if(node.left!=null) st.push(node.left);
	    	}return ans;
	    }
}
