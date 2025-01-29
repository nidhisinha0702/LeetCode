package LinkedList;

public class LinkedListNode {
	    int val;
	    LinkedListNode next;
	    LinkedListNode random;

	    public LinkedListNode(int val) {
	        this.val = val;
	        this.next = null;
	        this.random = null;
	}
	    protected static void printLL(LinkedListNode head) {
	    	LinkedListNode temp = head;
	    	while(temp!= null) {
	    		System.out.print(temp.val+"->");
	    		temp=temp.next;
	    	}System.out.println("null");
	    }
}
