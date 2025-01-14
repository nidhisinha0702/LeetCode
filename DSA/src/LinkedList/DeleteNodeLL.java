package LinkedList;

public class DeleteNodeLL {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//1->2->3->4->5->null
		Node head = new Node(1);
		Node temp = head;
		for(int i=2;i<6;i++) {
			Node newNode = new Node(i);
			temp.next = newNode;
			temp=newNode;
		}
		int k = 2;
		//System.out.println("Delete head node::"+deleteHead(head).data);
		//System.out.println("Delete tail node::"+deleteTail(head).data);
		//System.out.println("Delete kth node::"+deleteK(head,k).data);
		System.out.println("Delete an element node::"+deleteEl(head,k).data);
		Node.printList(head);
		
	}
//	private static void printList(Node head) {
//		Node temp = head;
//		while(temp!=null) {
//			System.out.print(temp.data+"->");
//			temp=temp.next;
//		}System.out.println("null");
//	}
	//delete head
	private static Node deleteHead(Node head) {
		if(head == null) {
			return head;
		}
		Node temp = head;
		head = head.next;
		return head;
	}
	//delete tail
	private static Node deleteTail(Node head) {
		if(head == null || head.next == null) {
			return null;
		}
		Node temp = head;
		while(temp.next.next != null) {
			temp=temp.next;
		}
		temp.next=null;
		return head;
	}
	//delete kth element
	private static Node deleteK(Node head,int k) {
		//if there is no element in ll
		if(head==null) return head;
		//1st element
		if(k==1) {
			Node temp = head;
			head = head.next;
			return head;
		}
		//for other cases
		int cnt = 0;
		Node temp = head;
		Node prev = null;
		while(temp!=null) {
			cnt++;
			if(cnt == k) {
				prev.next = prev.next.next;
				break;
			}
			prev = temp;
			temp = temp.next;
		}return head;
	}
	
	//delete particular element
	private static Node deleteEl(Node head,int el) {
		//if there is no element in ll
				if(head==null) return head;
				//1st element
				if(head.data==el) {
					Node temp = head;
					head = head.next;
					return head;
				}
				//for other cases
				Node temp = head;
				Node prev = null;
				while(temp!=null) {
					if(temp.data == el) {
						prev.next = prev.next.next;
						break;
					}
					prev = temp;
					temp = temp.next;
				}return head;
	}

}
