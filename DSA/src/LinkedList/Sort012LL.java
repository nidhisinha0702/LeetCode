package LinkedList;

public class Sort012LL {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1, 2, 2, 1, 2,0,2,2};
        
        Node head = new Node(arr[0]);
        head.next = new Node(arr[1]);
        head.next.next = new Node(arr[2]);
        head.next.next.next = new Node(arr[3]);
        head.next.next.next.next = new Node(arr[4]);
        head.next.next.next.next.next = new Node(arr[5]);
        head.next.next.next.next.next.next = new Node(arr[6]);
        head.next.next.next.next.next.next.next = new Node(arr[7]);
        head = segregate(head);
        Node.printList(head);

	}
	 private static Node segregate(Node head) {
	        // add your code here
		  if(head == null || head.next == null)   return head;
	        
	       Node zeroHead = new Node(-1);
	       Node oneHead = new Node(-1);
	       Node twoHead = new Node(-1);
	       
	       Node zero = zeroHead;
	       Node one = oneHead;
	       Node two = twoHead;
	       
	       Node temp = head;
	       
	       while(temp != null){
	           if(temp.data == 0){
	               zero.next = temp;
	               zero = temp;
	           }else if(temp.data == 1){
	               one.next = temp;
	               one = temp;
	           }else{
	               two.next = temp;
	               two = temp;
	           }temp = temp.next;
	       }zero.next = (oneHead.next != null)?oneHead.next:twoHead.next;
	       one.next = twoHead.next;
	       two.next = null;
	       return zeroHead.next;
	    }
}
