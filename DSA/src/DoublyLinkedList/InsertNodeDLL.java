package DoublyLinkedList;

public class InsertNodeDLL {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {12,5,8,7};
		Node head = new Node(arr[0]);
		Node prev = head;
		
		for(int i=1;i<arr.length;i++) {
			Node temp = new Node(arr[i],null,prev);
			prev.next = temp;
			prev = temp;
		}
		
		//head = insertBeforeKthNode(head,4 ,200);
		insertBeforeGivenNode(head.next.next.next, 200);
		Node.printList(head);
	}
	
	private static Node insertBeforeHead(Node head,int val) {
		Node newHead = new Node(val,head,null);
		head.prev=newHead;
		return newHead;
	}
	
	private static Node insertBeforeTail(Node head,int val) {
		if(head.next == null) {
			return insertBeforeHead(head, val);
		}
		
		Node tail = head;
		while(tail.next != null) {
			tail=tail.next;
		}
		Node back = tail.prev;
		Node newNode = new Node(val,tail,back);
		back.next = newNode;
		tail.prev = newNode;
		return head;
	}
	
	private static Node insertBeforeKthNode(Node head,int k,int val) {
		if(k==1)	return insertBeforeHead(head, val);
		Node temp = head;
		int cnt = 0;
		while(temp!=null) {
			cnt++;
			if(cnt == k)	break;
			temp = temp.next;
		}
		Node back = temp.prev;
		Node newNode = new Node(val,temp,back);
		back.next = newNode;
		temp.prev = newNode;
		return head;
	}

	private static void insertBeforeGivenNode(Node node,int val) {
		Node back = node.prev;
		Node newNode = new Node(val,node,back);
		back.next = newNode;
		node.prev = newNode;
	}
}
