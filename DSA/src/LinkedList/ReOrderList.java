package LinkedList;

public class ReOrderList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1, 2, 3, 4, 5};
        
        Node head = new Node(arr[0]);
        head.next = new Node(arr[1]);
        head.next.next = new Node(arr[2]);
        head.next.next.next = new Node(arr[3]);
        head.next.next.next.next = new Node(arr[4]);
        reorderList(head);
        Node.printList(head);

	}

	private static void reorderList(Node head) {
		
		//the idea is to divide the linked list in two halves by finding the mid
		Node slow = head;
		Node fast = head.next; //to find the 1st mid (even) we are keeping fast on head.next
		//hare and tortoise algo
		while(fast != null && fast.next != null) {
			slow = slow.next;//tortoise
			fast = fast.next.next;//hare
		}
		//slow will point to mid or 1st mid
		//slow next will be the head of second list
		 Node second = slow.next;
		 
		 //reverse second list
		 //break the links b/n first and second
		 Node prev = slow.next = null;
		 Node first = head;
		 
		 while(second != null) {
			 Node temp = second.next;
			 second.next = prev;
			 prev = second;
			 second = temp;
		 }
		 
		 //prev is the new head of 2nd list
		 second = prev;
		 //now merge the two list
		 while(second != null) {//as second is the smaller list
			 Node t1 = first.next;
			 Node t2 = second.next;
			 first.next = second;
			 second.next = t1;
			 first = t1;
			 second = t2;
		 }
		 
	}
}
