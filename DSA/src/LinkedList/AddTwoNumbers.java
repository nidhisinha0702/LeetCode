package LinkedList;

public class AddTwoNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node head1 = new Node(4);
		head1.next = new Node(5);
		head1.next.next = new Node(9);
		head1.next.next.next = new Node(9);
		Node head2 = new Node(3);
		head2.next = new Node(5);
	
		Node sumListHead = addTwoNumbers(head1,head2);
		Node.printList(sumListHead);

	}
	  private static Node addTwoNumbers(Node l1, Node l2) {
	        Node dummyNode = new Node(-1);
	        Node curr = dummyNode;
	        Node temp1 = l1;
	        Node temp2 = l2;
	        int carry = 0;
	        while(temp1 != null || temp2 != null){//when both list exhaust
	            int sum = carry;//for each node sum will be new and add carry to it always
	            if(temp1 != null) sum += temp1.data;
	            if(temp2 != null) sum += temp2.data;
	            //create new node for sumList
	            Node newNode = new Node(sum%10);//if sum is >= 10 we will take the unit digit which can be done by % operator
	            carry = sum/10;//similarly carry will be the next digit which we can get by / operator
	            curr.next = newNode;//change the curr.next to newly created node
	            curr = newNode;//move curr
	            //only if temps are not null move them
	            if(temp1 != null) temp1 = temp1.next;
	            if(temp2 != null) temp2 = temp2.next;

	        }
	        //if carry is not zero
	        if(carry != 0){
	            Node newNode = new Node(carry);
	            curr.next = newNode;
	        }
	        return dummyNode.next;
	            
	    }
}
