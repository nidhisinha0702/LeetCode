package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CloneGraph {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node node1 = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node4 = new Node(4);
		List<Node> neigh1 = new ArrayList<>();
		neigh1.add(node2);
		neigh1.add(node3);
		node1.neighbors = neigh1;
		List<Node> neigh2 = new ArrayList<>();
		neigh2.add(node1);
		neigh2.add(node3);
		node2.neighbors = neigh2;
		List<Node> neigh3 = new ArrayList<>();
		neigh3.add(node2);
		neigh3.add(node4);
		List<Node> neigh4 = new ArrayList<>();
		neigh4.add(node1);
		neigh4.add(node3);
		
		Node clone = cloneGraph(node1);
		System.out.println(clone.val);
	}
	private static Node cloneGraph(Node node) {
		//if the node is null
        if(node==null ) return null;
        //create a hashmap to store original and clone nodes
        Map<Node,Node> mpp = new HashMap<>();
        return clone(node,mpp);
    }
    private static Node clone(Node node, Map<Node,Node> mpp){
       //if the map is already cloned, return the clone
    	if(mpp.containsKey(node)) {
    		return mpp.get(node);
    	}
    	//otherwise create copy of that node with exact same val
    	Node copy = new Node(node.val);
    	//put it in the map
    	mpp.put(node, copy);
    	
    	for(Node neigh:node.neighbors) {
    		copy.neighbors.add(clone(neigh,mpp));
    	}
    	return copy;
    }
}
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
