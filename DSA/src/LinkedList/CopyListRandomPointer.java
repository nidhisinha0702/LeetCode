package LinkedList;

public class CopyListRandomPointer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedListNode head = new LinkedListNode(7);
		head.next = new LinkedListNode(13);
		head.random = null;
		head.next.random = head;
		head.next.next = new LinkedListNode(11);
		head.next.next.random = null;
		head.next.next.next = new LinkedListNode(10);
		head.next.next.next.random = head.next.next;
		head.next.next.next.next = new LinkedListNode(1);
		head.next.next.next.next.random = head;
		
		CopyListRandomPointer ob = new CopyListRandomPointer();
		head = ob.copyRandomList(head);
		LinkedListNode.printLL(head);
	}
	public LinkedListNode copyRandomList(LinkedListNode head) {
        LinkedListNode temp = head;
        while(temp!=null){
            LinkedListNode copyLinkedListNode = new LinkedListNode(temp.val);
            copyLinkedListNode.next = temp.next;
            temp.next = copyLinkedListNode;
            temp = temp.next.next;
        }
        temp = head;
        while(temp != null){
           LinkedListNode copyLinkedListNode = temp.next;
           if(temp.random != null) copyLinkedListNode.random = temp.random.next;
           else     copyLinkedListNode.random = null;
            temp = temp.next.next;
        }
        LinkedListNode dummyLinkedListNode = new LinkedListNode(-1);
        LinkedListNode res = dummyLinkedListNode;
        temp = head;
        while(temp!=null){
            res.next = temp.next;
            temp.next = temp.next.next;
            res = res.next;
            temp = temp.next;
        }return dummyLinkedListNode.next;
    }
}
