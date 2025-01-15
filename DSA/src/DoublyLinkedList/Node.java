package DoublyLinkedList;

public class Node {
	int data;
	Node next;
	Node prev;
	
	Node(int data,Node next,Node prev){
		this.data=data;
		this.next=next;
		this.prev=prev;
	}
	
	Node(int data){
		this.data=data;
		next=null;
		prev=null;
	}
	
	protected static void printList(Node head) {
		Node temp = head;
		while(temp!=null) {
			System.out.print(temp.data+"->");
			temp=temp.next;
		}System.out.println("null");
	}
}
