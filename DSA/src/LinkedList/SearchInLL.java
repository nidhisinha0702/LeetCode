package LinkedList;

public class SearchInLL {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node head = new Node(1);
		Node temp = head;
		for(int i=2;i<6;i++) {
			Node newNode = new Node(i);
			temp.next = newNode;
			temp=newNode;
		}
		int key = 4;
		System.out.println("The length of the given linkedlist is::"+searchKey(head,key));

	}

	 private static boolean searchKey(Node head, int key) {
	        // Code here
	         Node temp = head;
		        while(temp!=null){
		            if(temp.data == key)    return true;
		            temp=temp.next;
		        }return false;
	    }
}
