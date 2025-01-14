package LinkedList;

public class LengthOfLL {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node head = new Node(1);
		Node temp = head;
		for(int i=2;i<6;i++) {
			Node newNode = new Node(i);
			temp.next = newNode;
			temp=newNode;
		}
		
		System.out.println("The length of the given linkedlist is::"+getCount(head));
		 
	}
	
	 private static int getCount(Node head) {
	        // code here
	        Node temp = head;
	        int cnt = 0;
	        while(temp!=null){
	            cnt++;
	            temp=temp.next;
	        }return cnt;
	    }

}
