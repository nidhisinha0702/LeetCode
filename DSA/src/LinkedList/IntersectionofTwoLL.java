package LinkedList;

public class IntersectionofTwoLL {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node head1 = new Node(1);
		Node head2 = new Node(1);
		int data = findIntersection(head1, head2);
		System.out.println("The data is :"+data);

	}
	 private static int findIntersection(Node firstHead, Node secondHead) {
	        //Write your code here
	        if(firstHead == null || secondHead == null) return -1; 
	        Node t1 = firstHead;
	        Node t2 = secondHead;
	        while(t1 != t2){
	            t1 = t1.next;
	            t2 = t2.next;
	            if(t1 == t2) {
	            	if(t1 == null && t2 == null)	return -1;
 	            	return t1.data;
	            }

	            if(t1 == null) t1 = secondHead;
	            if(t2 == null) t2 = firstHead;
	        }return t1.data;
	    }
}
