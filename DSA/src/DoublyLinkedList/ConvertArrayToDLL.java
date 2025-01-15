package DoublyLinkedList;

public class ConvertArrayToDLL {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {1,3,2,4};
		Node head = convertToDLL(arr);
		System.out.println("the head is::"+head.data);
		Node.printList(head);
		
	}
	
	private static Node convertToDLL(int arr[]) {
		Node head = new Node(arr[0]);
		Node prev = head;
		
		for(int i=1;i<arr.length;i++) {
			Node temp = new Node(arr[i],null,prev);
			prev.next = temp;
			prev = temp;
		}return head;
	}

}
