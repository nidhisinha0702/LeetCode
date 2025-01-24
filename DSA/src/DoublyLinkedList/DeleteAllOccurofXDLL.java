package DoublyLinkedList;

public class DeleteAllOccurofXDLL {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node head = new Node(2);
		head.next = new Node(2);
		head.next.prev = head;
		head.next.next = new Node(10);
		head.next.next.prev = head.next;
		head.next.next.next = new Node(8);
		head.next.next.next.prev = head.next.next;
	
		head = deleteAllOccurOfX(head,10);
		Node.printList(head);
		

	}
	 static Node deleteAllOccurOfX(Node head, int x) {
	        // Write your code here
	        Node temp = head;
	        while(temp != null){
	            if(temp.data == x){
	                //if it is head
	                if(temp == head)    head = temp.next;
	                
	                Node nextNode = temp.next;
	                Node prevNode = temp.prev;
	                
	                if(nextNode != null) nextNode.prev = prevNode;
	                if(prevNode != null) prevNode.next = nextNode;
	                //move temp
	                temp = temp.next;
	            }else{
	                temp = temp.next;
	            }
	        }return head;
	    }
}
