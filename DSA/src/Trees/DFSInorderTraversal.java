package Trees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class DFSInorderTraversal {

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
        List<Integer> ans = inorderTraversal(root0);
        List<Integer> a = inorderIterative(root0);
        System.out.println(ans);
        System.out.println(a);

	}
	private static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        return inorder(root,ans);
    }
    private static List<Integer> inorder(TreeNode root, List<Integer> ans){
        if(root == null) return ans;

        inorder(root.left,ans);
        ans.add(root.val);
        inorder(root.right,ans);
        return ans;
    }
    
    private static List<Integer> inorderIterative(TreeNode root){
    	List<Integer> inorder = new ArrayList<>();
    	
    	Stack<TreeNode> st = new Stack<>();
    	while(true) {
    		if(root != null) {
    			st.push(root);
    			root=root.left;
    		}else {
    			//if root is null
    			if(st.isEmpty()) {
    				break;
    			}root = st.pop();
    			inorder.add(root.val);
    			root=root.right;
    			
    		}
    	}return inorder;
    }
}
