package LinkedList;

public class ReverseLLIterative {

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
		Node temp = head;
		Node prev = null;
		while(temp != null) {
			Node front = temp.next;
			temp.next = prev;
			prev = temp;
			temp = front;
		}return prev;
	}

}
