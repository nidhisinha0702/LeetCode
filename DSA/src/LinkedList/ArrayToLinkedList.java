package LinkedList;

public class ArrayToLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {1,3,2,5};
		System.out.println("The head node is::"+constructLL(arr).data);

	}
	 static Node constructLL(int arr[]) {
	        // code here
	        //create a head node and assign first element to it
	        Node head = new Node(arr[0]);
	        //create a mover node and assign head to it;
	        Node mover = head;
	        //iterate over the array
	        for(int i=1;i<arr.length;i++){
	            //now create node for each element
	            Node temp = new Node(arr[i]);
	            //point mover to newly created node
	            mover.next = temp;
	            //change mover to next node
	            mover=temp;
	        }//return head
	        return head;
	    }
}
