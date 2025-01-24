package DoublyLinkedList;

import java.util.ArrayList;

public class FindPairWithGivenSumDLL {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node head = new Node(1);
		head.next = new Node(2);
		head.next.prev = head;
		head.next.next = new Node(3);
		head.next.next.prev = head.next;
		head.next.next.next = new Node(4);
		head.next.next.next.prev = head.next.next;
		head.next.next.next.next = new Node(9);
		head.next.next.next.next.prev = head.next.next.next;
		ArrayList<ArrayList<Integer>> ans = findPairsWithGivenSum(5, head);
		System.out.println(ans);
		
	}
	 public static ArrayList<ArrayList<Integer>> findPairsWithGivenSum(int target, Node head) {
	        // code here
	        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
	        if(head == null) return ans;
	        Node left = head;
	        Node right = findTail(head);
	        
	        while(left.data < right.data){
	            if(left.data + right.data == target){
	            	ArrayList<Integer> ds = new ArrayList<>();
	                ds.add(left.data);
	                ds.add(right.data);
	                ans.add(ds);
	                left = left.next;
                    right = right.prev;
	            }else if(left.data + right.data < target){
	                left = left.next;
	            }else right = right.prev;
	        }return ans;
	    }
	    private static Node findTail(Node head){
	        Node tail = head;
	        while(tail.next != null){
	            tail = tail.next;
	        }return tail;
	    }
}
