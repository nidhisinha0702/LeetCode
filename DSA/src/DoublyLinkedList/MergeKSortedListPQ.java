package DoublyLinkedList;

import java.util.PriorityQueue;

public class MergeKSortedListPQ {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node[] arr = new Node[3];
	 	arr[0] = new Node(1);
	 	arr[0].next = new Node(2);
	 	arr[0].next.next = new Node(4);
	 	
	 	arr[1] = new Node(1);
	 	arr[1].next = new Node(3);
	 	arr[1].next.next = new Node(5);
        
	 	arr[2] = new Node(3);
	 	arr[2].next = new Node(6);

        Node head = mergeKLists(arr);
        Node.printList(head);
	}
//O(n*k*log k)
	private static Node mergeKLists(Node[] arr) {
		//we will use min-heap to efficiently track the smallest among all the lists at a given time
		PriorityQueue<Node> pq = new PriorityQueue<>((a,b) -> a.data - b.data);
		
		//insert the head nodes of k lists in pq
		for(Node head : arr) {
			if(head != null) pq.add(head);
		}
		
		//initialize a dummy head
		Node dummy = new Node(-1);
		Node temp = dummy;
		
		//iterate untill pq is empty
		while(!pq.isEmpty()) {
			//pop the min node
			Node top = pq.poll();
			
			//connect this with temp
			temp.next = top;
			//move temp
			temp = temp.next;
			
			if(top.next != null)
				pq.add(top.next);
		}
		
		return dummy.next;
	}
}
