package LinkedList;

public class SortLL {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 int[] arr = {2, 9, 4, 1, 5};
	        
	        Node head = new Node(arr[0]);
	        head.next = new Node(arr[1]);
	        head.next.next = new Node(arr[2]);
	        head.next.next.next = new Node(arr[3]);
	        head.next.next.next.next = new Node(arr[4]);
	        head = sortList(head);
	        Node.printList(head);
	}
	private static Node sortList(Node head) {
        //we will use mergesort
        if(head == null || head.next == null) return head;

        //find mid node
        Node middle = findMiddle(head);
        //left ll head
        Node lefthead = head;
        //right ll head
        Node righthead = middle.next;
        //separate the ll
        middle.next = null;
        //call sort ll recursively on both left and right ll
        lefthead = sortList(lefthead);
        righthead = sortList(righthead);
        //call merge function
        return merge(lefthead,righthead);
    }

    private static Node findMiddle(Node head){
        if(head == null || head.next == null) return head;
        Node slow = head;
        Node fast = head.next;//we need the 1st middle in case of even nodes
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }return slow;
    }

    private static Node merge(Node list1,Node list2){
        //create a dummy node with any value
        Node dummyNode = new Node(-1);
        Node temp = dummyNode;
        //iterate over the list
        while(list1!=null && list2!=null){
            if(list1.data<list2.data){
                temp.next = list1;
                temp = list1;
                list1 = list1.next;
            }else{
                temp.next=list2;
                temp=list2;
                list2=list2.next;
            }
        }
        //if list1 still has element
       while(list1!=null){
        temp.next = list1;
        temp=list1;
        list1=list1.next;
       }
       //if list2 still has element
       while(list2!=null){
         temp.next = list2;
         temp=list2;
         list2=list2.next;
       }
        return dummyNode.next;
    }
}
