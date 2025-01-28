package LinkedList;

public class RotateLL {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(4);
		head.next.next.next.next = new Node(5);
		int k = 2;
		
		head = rotate(head,k);
		Node.printList(head);

	}
	 public static Node rotate(Node head, int k) {
	        // Write your code here.
	        if(head == null || k == 0) return head;//if head is null or k=0
	        //find tail node and len of ll
	        Node tail = head;
	        int len = 1;
	        while(tail.next != null){
	            len += 1;
	            tail = tail.next;
	        }
	        //find the edge case if k is larger
	        if(k % len == 0) return head;//its the same ll
	        k = k % len;
	        //connect tail to head
	        tail.next = head;
	        //find newLastNode;
	        Node newLastNode = findLastNode(head,len - k);//new last node will be len-k
	        head = newLastNode.next;//change the head
	        newLastNode.next = null;//make last node.next to null
	        return head;
	    }

	    private static Node findLastNode(Node temp, int k){
	        int cnt = 1;
	        while(temp != null){
	            if(cnt == k) return temp;
	            cnt++;
	            temp = temp.next;
	        }return temp;
	    }

}
