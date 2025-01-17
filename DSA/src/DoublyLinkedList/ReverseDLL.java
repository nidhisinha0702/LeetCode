package DoublyLinkedList;

public class ReverseDLL {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//null<-4<->2<->3<->1->null
		Node head = new Node(4);
		head.next = new Node(2);
		head.next.prev = head;
		head.next.next = new Node(3);
		head.next.next.prev = head.next;
		head.next.next.next = new Node(1);
		head.next.next.next.prev = head.next.next;
		
		head = reverseDLL(head);
		Node.printList(head);
	}

	private static Node reverseDLL(Node head) {
        // Your code here
        if(head == null || head.next == null){
            return head;
        }
        
        Node prev = null;
        Node curr = head;
        while(curr!=null){
            prev = curr.prev;
            curr.prev = curr.next;
            curr.next = prev;
            curr = curr.prev;
        }return prev.prev;
    }
}
