package LinkedList;

public class DelectLoopLL {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//3->2->0->-4->2
		Node head = new Node(3);
		head.next = new Node(2);
		head.next.next = new Node(0);
		head.next.next.next = new Node(-4,head.next);
		
		System.out.println("There is loop in the LL::"+hasCycle(head));

	}
	 private static boolean hasCycle(Node head) {
		 Node slow = head;
		 Node fast = head;
	        while(fast!=null && fast.next!=null){
	            slow = slow.next;
	            fast = fast.next.next;
	            if(slow == fast) return true;
	        }return false;
	    }
}
