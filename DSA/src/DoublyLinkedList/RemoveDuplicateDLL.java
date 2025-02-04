package DoublyLinkedList;

public class RemoveDuplicateDLL {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node head = new Node(1);
		head.next = new Node(2);
		head.next.prev = head;
		head.next.next = new Node(2);
		head.next.next.prev = head.next;
		head.next.next.next = new Node(2);
		head.next.next.next.prev = head.next.next;
		head.next.next.next.next = new Node(3);
		head.next.next.next.next.prev = head.next.next.next;
		
		head = uniqueSortedList(head);
		Node.printList(head);

	}
	 private static Node uniqueSortedList(Node head) {
	        // Write your code here.
	        if(head == null || head.next == null)   return head;
	        Node temp = head;
	        //iterate over the ll
	        while(temp!=null && temp.next!=null){//coz the nextnode will reach null before temp
	            Node nextNode = temp.next;
	            while(nextNode != null && temp.data == nextNode.data){
	                nextNode = nextNode.next;//move to the next node if the values are same
	            }
	            temp.next = nextNode;
	            if(nextNode != null) nextNode.prev = temp; // if the nextNode is null prev of null will fail
	            temp = nextNode;
	        }return head;
	    }

}
