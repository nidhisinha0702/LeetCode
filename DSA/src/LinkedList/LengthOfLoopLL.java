package LinkedList;

public class LengthOfLoopLL {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node head = new Node(25);
		head.next = new Node(14);
		head.next.next = new Node(19);
		head.next.next.next = new Node(33);
		head.next.next.next.next = new Node(10,head.next);

		System.out.println("The length of the loop is::"+countNodesinLoop(head));
	}
	 private static int countNodesinLoop(Node head) {
	        // Add your code here.
	        Node slow = head;
	        Node fast = head;
	        while(fast!=null && fast.next!=null){
	            slow = slow.next;
	            fast = fast.next.next;
	            if(slow == fast){
	                return lengthOfLoop(slow,fast);
	            }
	        }return 0;
	        
	    }
	    
	    private static int lengthOfLoop(Node slow, Node fast){
	        int cnt = 1;
	        fast = fast.next;
	        while(slow!=fast){
	            cnt++;
	            fast = fast.next;
	        }return cnt;
	    }
}
