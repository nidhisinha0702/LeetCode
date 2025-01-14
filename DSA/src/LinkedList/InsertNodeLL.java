package LinkedList;

public class InsertNodeLL {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node head = new Node(2);
		head.next = new Node(3);
		head.next.next = new Node(1);
		head.next.next.next = new Node(8);
		head = insertBeforeValue(head,100,2);
		//System.out.println("Insert at the head of the LL::"+head.data);
		//System.out.println("Insert at the end of the LL::"+head.data);
		//System.out.println("Insert at the kth position of the LL::"+head.data);
		System.out.println("Insert at the value before node of the LL::"+head.data);
		Node.printList(head);

	}
	
	private static Node insertHead(Node head,int val) {
		if(head == null) {
			return new Node(val);
		}return new Node(val,head);
	}

	private static Node insertTail(Node head,int val) {
		if(head == null)	return new Node(val);
		Node temp = head;
		while(temp.next != null) {
			temp=temp.next;
		}
		Node newNode = new Node(val);
		temp.next = newNode;
		return head;
	}
	
	private static Node insertK(Node head,int val,int k) {
		//if the ll is empty
		if(head == null) {
			if(k==1) {
				Node newHead = new Node(val,head);
				return newHead;
			}else {
				return head;
			}
		}
		if(k==1) {
			Node newHead = new Node(val,head);
			return newHead;
		}
		int cnt = 0;
		Node temp = head;
		while(temp != null) {
			cnt++;
			if(cnt == (k-1)) {
			Node newNode = new Node(val);
			newNode.next = temp.next;
			temp.next = newNode;
			break;
			}
			temp = temp.next;
		}return head;
	}
	
	private static Node insertBeforeValue(Node head,int el,int val) {
		//if the ll is empty
				if(head == null) {
					
						return head;
				}
				if(head.data==val) {
					Node newHead = new Node(el,head);
					return newHead;
				}
				Node temp = head;
				while(temp.next != null) {
					if(temp.next.data == val) {
					Node newNode = new Node(el);
					newNode.next = temp.next;
					temp.next = newNode;
					break;
					}
					temp = temp.next;
				}
				return head;
	}
}
