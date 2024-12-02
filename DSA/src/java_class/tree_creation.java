package java_class;

import java.util.Scanner;

public class tree_creation {

	static Node create() {
		Scanner sc = new Scanner(System.in);
		Node root = null;
		System.out.println("enter value");
		int data = sc.nextInt();
		if(data==-1)
			return null;
		root= new Node(data);
		System.out.println("enter left child of"+root.data);
		root.left=create();
		System.out.println("enter right child of"+root.data);
		root.right=create();
		return root;
	}
	
	static void inorder(Node root) { //LNR
		if(root==null)
			return;
		inorder(root.left);
		System.out.print(root.data+" ");
		inorder(root.right);
	}
	
	static void preorder(Node root) { //NLR
		if(root==null)
			return;
		System.out.print(root.data+" ");
		preorder(root.left);
		preorder(root.right);
	}
	
	static void postorder(Node root) { //LRN
		if(root==null)
			return;
		postorder(root.left);
		postorder(root.right);
		System.out.print(root.data+" ");
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node root = create();
		preorder(root);
		System.out.println();
		inorder(root);
		System.out.println();
		postorder(root);
		System.out.println();
	}

}

class Node{
	Node left,right;
	int data;
	public Node(int data) {
		this.data = data;
		left=null;
		right=null;
	}
}
