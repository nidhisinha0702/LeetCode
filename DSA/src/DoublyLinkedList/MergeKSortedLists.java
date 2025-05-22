package DoublyLinkedList;

public class MergeKSortedLists {

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

	private static Node mergeKLists(Node[] lists) {
		//initialize result as empty
		Node res = null;
		
		//one by one all lists O(n*k)
		for(Node node:lists) {
			res = mergeTwo(res, node);
		}
		
		return res;
	}
	//O(1+2+3+....+k)n = O(n*k*k)
	private static Node mergeTwo(Node head1, Node head2) {
		//create a dummy node to simplify the process
		Node dummy = new Node(-1);
		Node curr = dummy;
		
		//iterate through both list
		while(head1 != null && head2 != null) {
			//add smaller to the merged list
			if(head1.data <= head2.data) {
				curr.next = head1;
				head1 = head1.next;
			}else {
				curr.next = head2;
				head2 = head2.next;
			}
			curr = curr.next;
		}
		//if any list is left
		if(head1 != null) {
			curr.next = head1;
		}else {
			curr.next = head2;
		}
		//return the merged list
		return dummy.next;
	}
	
}
