package LinkedList;

public class Add1ToLLII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node head = new Node(9);
		head.next = new Node(9);
		head.next.next = new Node(9);
		
		head = addOne(head);
		Node.printList(head);
	}
	 private static Node addOne(Node head) {
	        // code here.
	        int carry = addHelper(head);
	        if(carry == 1){
	            Node newNode = new Node(1);
	            newNode.next = head;
	            return newNode;
	        }return head;
	    }
	    private static int addHelper(Node temp){
	        if(temp == null){
	            return 1;
	        }
	        int carry = addHelper(temp.next);
	        temp.data = temp.data + carry;
	        if(temp.data < 10){
	            return 0;
	        }temp.data = 0;
	        return 1;
	    }
}
