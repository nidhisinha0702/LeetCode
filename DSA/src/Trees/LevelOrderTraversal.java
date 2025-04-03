package Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	 public ArrayList<ArrayList<Integer>> levelOrder(Node root) {
	        
	        if(root==null) return null;
	        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
	        Queue<Node> q = new LinkedList<>();
	        q.offer(root);
	        while(!q.isEmpty()){
	            int size = q.size();
	            ArrayList<Integer> level = new ArrayList<>();
	            for(int i=0;i<size;i++){
	                Node node = q.poll();
	                if(node.left!=null) q.offer(node.left);
	                if(node.right!=null) q.offer(node.right);
	                level.add(node.data);
	            }ans.add(level);
	        }return ans;
	    }
}
class Node{
	int data;
	Node left;
	Node right;
	Node(int data){
		this.data = data;
		left=right=null;
	}
}
