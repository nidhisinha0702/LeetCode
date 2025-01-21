package LinkedList;

public class DeleteMidNodeLLII {
	public static void main(String args[]) {
		 int[] arr = {1, 2, 3, 4, 5};
	        
	        Node head = new Node(arr[0]);
	        head.next = new Node(arr[1]);
	        head.next.next = new Node(arr[2]);
	        head.next.next.next = new Node(arr[3]);
	        head.next.next.next.next = new Node(arr[4]);
	        head = deleteMiddle(head);
	        Node.printList(head);
	}
	 private static Node deleteMiddle(Node head) {
	        if(head==null || head.next==null)   return null;
	        Node slow = head;
	        Node fast = head;
	       fast = fast.next.next;//skip 1 step for slow
	       while(fast!=null && fast.next!=null){
	        slow = slow.next;
	        fast = fast.next.next;
	       }
	       slow.next = slow.next.next;
	       return head;
	    }
}
