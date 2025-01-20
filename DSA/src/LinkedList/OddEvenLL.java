package LinkedList;

public class OddEvenLL {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(4);
		head.next.next.next.next = new Node(5);
		
		head = oddEvenList(head);
		Node.printList(head);
	}
	 private static Node oddEvenList(Node head) {
	        if(head == null || head.next == null) return head;
	        Node odd = head;
	        Node even = head.next;
	        Node evenHead = even;
	        while(even != null && even.next != null){
	            odd.next = odd.next.next;
	            even.next = even.next.next;
	            odd = odd.next;
	            even = even.next;
	        }
	        odd.next = evenHead;
	        return head;
	    }

}
