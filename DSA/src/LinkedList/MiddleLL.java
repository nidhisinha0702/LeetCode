package LinkedList;

public class MiddleLL {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(4);
		head.next.next.next.next = new Node(5);
		Node mid = middleNode(head);
		System.out.println("The middle node value is:::"+mid.data);

	}
	 private static Node middleNode(Node head) {
		 Node slow = head;
		 Node fast = head;
	        while(fast!=null && fast.next!=null){
	            slow = slow.next;
	            fast = fast.next.next;
	        }return slow;
	    }
}
