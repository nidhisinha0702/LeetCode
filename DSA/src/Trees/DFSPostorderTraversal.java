package Trees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class DFSPostorderTraversal {

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
        List<Integer> ans = postorderTraversal(root0);
        List<Integer> a = postorderIterative(root0);
        List<Integer> list = postOrderSingleStack(root0);
        System.out.println(ans);
        System.out.println(a);
        System.out.println(list);

	}
	 private static List<Integer> postorderTraversal(TreeNode root) {
	        List<Integer> ans = new ArrayList<>();
	        return postorder(root,ans);
	    }
	    private static List<Integer> postorder(TreeNode root, List<Integer> ans){
	        if(root == null) return ans;

	        postorder(root.left, ans);
	        postorder(root.right, ans);
	        ans.add(root.val);
	        return ans;
	    }
	    
	    private static List<Integer> postorderIterative(TreeNode root){
	    	List<Integer> postorder = new ArrayList<>();
	    	Stack<TreeNode> st1 = new Stack<>();
	    	Stack<TreeNode> st2 = new Stack<>();
	    	
	    	if(root==null) return postorder;
	    	st1.push(root);
	    	while(!st1.isEmpty()) {
	    		root = st1.pop();
	    		st2.add(root);
	    		if(root.left!=null) st1.push(root.left);
	    		if(root.right!=null) st1.push(root.right);
	    	}
	    	while(!st2.isEmpty()) {
	    		postorder.add(st2.pop().val);
	    	}return postorder;
	    }
	    
	    private static List<Integer> postOrderSingleStack(TreeNode root){
	    	List<Integer> postorder = new ArrayList<>();
	    	Stack<TreeNode> st = new Stack<>();
	    	st.push(root);
	    	TreeNode cur = root;
	    	while(!st.isEmpty() || cur!=null) {
	    		if(cur!=null) {
	    			st.push(cur);
	    			cur=cur.left;
	    		}else {
	    			TreeNode temp = st.peek().right;
	    			if(temp==null) {
	    				temp=st.peek();
	    				st.pop();
	    				postorder.add(temp.val);
	    				while(!st.isEmpty() && temp==st.peek().right) {
	    					temp=st.peek();
	    					st.pop();
	    					postorder.add(temp.val);
	    				}
	    			}else {
	    				cur=temp;
	    			}
	    			
	    		}
	    	}
	    	return postorder;
	    }
}
