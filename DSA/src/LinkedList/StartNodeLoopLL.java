package LinkedList;

public class StartNodeLoopLL {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//3->2->0->-4->2
		Node head = new Node(3);
		head.next = new Node(2);
		head.next.next = new Node(0);
		head.next.next.next = new Node(-4,head.next);
		
		System.out.println("There is loop in the LL at node ::"+detectCycle(head).data);
	}
	  private static Node detectCycle(Node head) {
		  Node slow = head;
		  Node fast = head;
	        while(fast!=null && fast.next!=null){
	            slow = slow.next;//move by 1 step
	            fast = fast.next.next;//move by 2 step
	            if(fast == slow){//loop is detected
	                slow = head;//move slow to head
	                while(slow!=fast){//until they meet
	                    slow=slow.next;//move both by 1 step
	                    fast=fast.next;
	                }return slow;//return starting node of loop
	            }
	        }return null;
	    }
}
