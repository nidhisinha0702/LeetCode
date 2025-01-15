package DoublyLinkedList;

public class InsertAfterPosition {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//null<-2<->4<->5->null
		Node head = new Node(2);
		head.next = new Node(4);
		head.prev = head;
		head.next.next = new Node(5);
		head.next.next.prev = head.next;
		head = insertAfterGivenPosition(head, 0, 100);
		Node.printList(head);

	}
	
	private static Node insertAfterGivenPosition(Node head,int p,int x) {
		//if there is no node
		if(head == null) {
			return new Node(x);
		}//if there is one node head/tail
		else if(head.next == null) {
			return insertAfterHead(head,x);
		}
		Node temp = head;
		int cnt = -1;
		while(temp!=null) {
			cnt++;
			if(cnt == p)	break;
			temp=temp.next;
		}
		
		Node newNode = new Node(x);
		Node front = temp.next;
		if(front == null) {
			return insertAfterTail(head,x);
		}
		temp.next = newNode;
		newNode.prev = temp;
		newNode.next = front;
		front.prev = newNode;
		return head;
	}
	
	private static Node insertAfterTail(Node head,int x) {
		Node temp = head;
		while(temp.next!=null) {
			temp=temp.next;
		}
		Node newNode = new Node(x);
		newNode.prev = temp;
		temp.next = newNode;
		return head;
	}
	
	private static Node insertAfterHead(Node head,int x) {
		Node temp = head;
			Node newNode = new Node(x);
			newNode.prev = temp;
			temp.next = newNode;
		return head;
	}

}
