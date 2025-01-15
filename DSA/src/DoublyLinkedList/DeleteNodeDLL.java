package DoublyLinkedList;

public class DeleteNodeDLL {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//2->3->4->1->null
		int arr[] = {2,3,4,1};
		Node head = new Node(arr[0]);
		Node prev = head;
		
		for(int i=1;i<arr.length;i++) {
			Node temp = new Node(arr[i],null,prev);
			prev.next = temp;
			prev = temp;
		}
		
		//head = removeKthElement(head,4);
		removeNodeBefore(head.next.next.next);
		Node.printList(head);
	}
	
	private static Node deleteHead(Node head) {
		if(head == null || head.next == null)	return null;
		Node prev = head;
		head = head.next;
		head.prev = null;
		prev.next = null;
		return head;
	}
	
	private static Node deleteTail(Node head) {
		if(head == null || head.next == null)	return null;
		Node tail = head;
		while(tail.next!=null) {
			tail=tail.next;
		}
		Node newTail = tail.prev;
		newTail.next = null;
		tail.prev = null;
		return head;
		
	}
	
	private static Node removeKthElement(Node head,int k) {
		if(head == null)	return null;
		int cnt = 0;
		Node KNode = head;
		while(KNode!=null) {
			cnt++;
			if(cnt == k) {
				break;
			}KNode=KNode.next;
		}
		Node back = KNode.prev;
		Node front = KNode.next;
		if(back == null && front == null) {//it has just one node
			return null;
		}else if(back == null) {//it is the 1st node
			return deleteHead(head);
		}else if(front == null) {//it is last node
			return deleteTail(head);
		}
		back.next = front;
		front.prev = back;
		KNode.prev = KNode.next = null;
		return head;
	}
	//we cannot delete head
	private static void removeNodeBefore(Node temp) {
		Node back = temp.prev;
		Node front = temp.next;
		
		if(front == null) {
			back.next = null;
			temp.prev = null;
			return;
		}
		back.next = front;
		front.prev = back;
		temp.prev=temp.next=null;
	}

}
