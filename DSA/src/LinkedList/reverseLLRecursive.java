package LinkedList;

public class reverseLLRecursive {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(4);
		head.next.next.next.next = new Node(5);
		head = reverseList(head);
		Node.printList(head);
	}
	private static Node reverseList(Node head) {
		if(head == null || head.next == null) {
			return head;
		}
		
		Node newHead = reverseList(head.next);
		Node front = head.next;
		front.next = head;
		head.next = null;
		
		return newHead;
	}
}
