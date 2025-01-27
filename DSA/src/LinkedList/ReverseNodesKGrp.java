package LinkedList;

public class ReverseNodesKGrp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node head = new Node(1);
		head.next = new Node(5);
		head.next.next = new Node(9);
		head.next.next.next = new Node(4);
		head.next.next.next.next = new Node(6);
		head.next.next.next.next.next = new Node(2);
		head.next.next.next.next.next.next = new Node(3);
		head.next.next.next.next.next.next.next = new Node(8);
		head.next.next.next.next.next.next.next.next = new Node(7);
		head.next.next.next.next.next.next.next.next.next = new Node(6);
		head.next.next.next.next.next.next.next.next.next.next = new Node(5);
		head.next.next.next.next.next.next.next.next.next.next.next = new Node(4);
		int k = 3;
		ReverseNodesKGrp ob = new ReverseNodesKGrp();
		head = ob.reverseKGroup(head,k);
		Node.printList(head);
	}
	  public Node reverseKGroup(Node head, int k) {
	        Node temp = head;
	        Node prevNode = null;
	        while(temp != null){
	           Node KNode = findKNode(temp,k);//find knode for every ll
	            if(KNode == null){
	                if(prevNode != null) prevNode.next = temp;//connect to next group
	                break;//breaking because group is not found
	            }
	            Node nextNode = KNode.next;//storing next node before detaching the ll
	            KNode.next = null;//detach ll for reversal
	            reverse(temp);//reverse ll with temp
	            if(head == temp){//if it is the first group head will be updated
	                head = KNode;//knode will be the head
	            }else{
	                prevNode.next = KNode;//otherwise connect the prev group with the next
	            }
	            prevNode = temp;//before changing temp store prev node
	            temp = nextNode;//change temp
	        }return head;
	    }
	    private Node findKNode(Node head,int k){
	        Node tmp = head;
	        k-=1;
	        while(tmp != null && k>0){
	            k--;
	            tmp = tmp.next;
	        }return tmp;
	    }
	    private Node reverse(Node head){
	        Node temp = head;
	        Node prev = null;
	        while(temp != null){
	            Node next = temp.next;
	            temp.next = prev;
	            prev = temp;
	            temp = next;
	        }return prev;
	    }

}
