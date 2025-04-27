package Trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


public class PreInPostOrderTraversal {

	 public static void printList(List<Integer> list) {
	        // Iterate through the list
	        // and print each element
	        for (int num : list) {
	            System.out.print(num + " ");
	        }
	        System.out.println();
	    }

	    // Main function
	    public static void main(String[] args) {
	        // Creating a sample binary tree
	        TreeNode root = new TreeNode(1);
	        root.left = new TreeNode(2);
	        root.right = new TreeNode(3);
	        root.left.left = new TreeNode(4);
	        root.left.right = new TreeNode(5);

	        // Getting the pre-order, in-order,
	        // and post-order traversals
	        List<Integer> pre, in, post;
	        List<List<Integer>> traversals = preInPostTraversal(root);

	        // Extracting the traversals
	        // from the result
	        pre = traversals.get(0);
	        in = traversals.get(1);
	        post = traversals.get(2);

	        // Printing the traversals
	        System.out.print("Preorder traversal: ");
	        printList(pre);

	        System.out.print("Inorder traversal: ");
	        printList(in);

	        System.out.print("Postorder traversal: ");
	        printList(post);
	    }
	
	private static List<List<Integer>> preInPostTraversal(TreeNode root){
		
		//list to store the traversal
		List<Integer> pre = new ArrayList<>();
		List<Integer> in = new ArrayList<>();
		List<Integer> post = new ArrayList<>();
		
		//if the tree is empty
		if(root == null) {
			return new ArrayList<>();
		}
		
		//stack to maintain node and their traversal(node,num)
		Stack<Pair> st = new Stack<>();
		
		//start with the root node
		st.push(new Pair(root,1));
		
		while(!st.isEmpty()) {
			//pop the node
			Pair it = st.pop();
			
			//this is part of pre(num==1)
			if(it.y() == 1) {
				//store the node data in in pre
				pre.add(it.x().val);
				//move to state 2 (num++)
				it = new Pair(it.x(),2);
				//push the new pair to stack
				st.push(it);
				//push the left child onto the stack
				if(it.x().left != null) {
					st.push(new Pair(it.x().left, 1));
				}
			}
			
			//this is part of in(num==2)
			else if(it.y() == 2) {
				//store the node data into in
				in.add(it.x().val);
				//move to state 3 (num++)
				it = new Pair(it.x(), 3);
				//push the updated state
				st.push(it);
				//push right child onto
				if(it.x().right != null) {
					st.push(new Pair(it.x().right, 1));
				}
			}
			//this is part of post(num==3)
			else {
				post.add(it.x().val);
			}
		}
		List<List<Integer>> result = new ArrayList<>();
		result.add(pre);
		result.add(in);
		result.add(post);
		return result;
	}

}
