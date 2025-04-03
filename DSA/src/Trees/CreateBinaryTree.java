package Trees;

import java.util.ArrayList;
import java.util.Arrays;

public class CreateBinaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> l = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7));
		Node root0 = new Node(l.get(0));
		createTree(root0,l);

	}
	   public static void createTree(Node root0, ArrayList<Integer> v ){
	        // Code here
	        root0.left = new Node(v.get(1));
	        root0.right = new Node(v.get(2));
	        root0.left.left = new Node(v.get(3));
	        root0.left.right = new Node(v.get(4));
	        root0.right.left = new Node(v.get(5));
	        root0.right.right = new Node(v.get(6));
	        
	    }
}
