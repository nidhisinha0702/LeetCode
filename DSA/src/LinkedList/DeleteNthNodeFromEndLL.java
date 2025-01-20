package LinkedList;

public class DeleteNthNodeFromEndLL {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 int[] arr = {1, 2, 3, 4, 5};
	        int N = 3;
	        Node head = new Node(arr[0]);
	        head.next = new Node(arr[1]);
	        head.next.next = new Node(arr[2]);
	        head.next.next.next = new Node(arr[3]);
	        head.next.next.next.next = new Node(arr[4]);
	        head = removeNthFromEnd(head, N);
	        Node.printList(head);
	}
	 private static Node removeNthFromEnd(Node head, int n) {
	        //create two pointers fast and slow
		 Node fast = head;
		 Node slow = head;
	        //move fast pointer n nodes ahead
	        for(int i=0;i<n;i++){
	            fast = fast.next;
	        }
	        //if fast reaches null ,the nth node from the end is the head
	        if(fast == null)    return head.next;
	       //move both pointers until fast reached end node
	        while(fast.next!=null){
	            fast = fast.next;
	            slow = slow.next;
	        }
	       //delete the nth node from the end
	        slow.next = slow.next.next;
	        return head;
	    }

}
