package DoublyLinkedList;

public class MergeKSortedListDC {

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
	//O(n*log k)
	private static Node mergeKLists(Node[] arr) {
		//base case for 0 lists
		if(arr.length == 0) return null;
		
		return mergeListRecur(0, arr.length - 1, arr);
	}
	
	private static Node mergeListRecur(int start, int end, Node[] arr) {
		//if single list is left
		if(start == end) return arr[start];
		
		//find the mid
		int mid = start + (end - start)/2;
		
		//merge list from start to mid
		Node head1 = mergeListRecur(start, mid, arr);
		
		//merge list from mid+1 to end
		Node head2 = mergeListRecur(mid + 1, end, arr);
		
		//Merge above 2 lists
		Node head = mergeTwo(head1 , head2);
		
		return head;
	}
	
	private static Node mergeTwo(Node head1, Node head2) {
		//Create a dummy node to simplify
		//merging process
		Node dummy = new Node(-1);
		Node curr = dummy;
		
		//iterate through both linked lists
		while(head1 != null && head2 != null) {
			
			//add the smaller node
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
		
		return dummy.next;
	}
}
