package LinkedList;

public class DeleteMiddleNodeLL {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 int[] arr = {1, 2, 3, 4, 5};
	        
	        Node head = new Node(arr[0]);
	        head.next = new Node(arr[1]);
	        head.next.next = new Node(arr[2]);
	        head.next.next.next = new Node(arr[3]);
	        head.next.next.next.next = new Node(arr[4]);
	        head = deleteMiddle(head);
	        Node.printList(head);
	}
	private static Node deleteMiddle(Node head) {
        if(head==null || head.next==null)   return head;
        //find the length
        Node temp = head;
        int n = 0;
        while(temp!=null){
            n++;
            temp=temp.next;
        }
        //go till n/2 integer val
        int res = (int)n/2;
        temp = head;
        while(temp!=null){
            res--;
            if(res==0) break;
            temp=temp.next;
        }
        //delete node
        temp.next = temp.next.next;
        return head;
    }
}
