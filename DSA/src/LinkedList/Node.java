package LinkedList;

public class Node {
	int data;
	Node next;
	Node(int data,Node next){
		this.data=data;
		this.next=next;
	}
	Node(int data){
		this.data=data;
		this.next=null;
	}
	
	protected static void printList(Node head) {
		Node temp = head;
		while(temp!=null) {
			System.out.print(temp.data+"->");
			temp=temp.next;
		}System.out.println("null");
	}
}
