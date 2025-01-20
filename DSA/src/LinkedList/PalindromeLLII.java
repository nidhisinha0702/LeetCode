package LinkedList;

public class PalindromeLLII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(2);
		head.next.next.next = new Node(1);
		
		System.out.println("LL is palindrome:"+isPalindrome(head));
	}
	private static boolean isPalindrome(Node head) {
        //if head is null or there is only one element
        if(head == null || head.next == null) return true;
    //find middle node(m1 in even and m in odd)
    Node slow = head;
    Node fast = head;
    while(fast.next!=null && fast.next.next!=null){
        slow = slow.next;
        fast = fast.next.next;
    }
    //reverse second half
    Node newHead = reverse(slow.next);
    //compare the data 
    Node first = head;
    Node second = newHead;
    while(second != null){
        if(first.data != second.data){
            reverse(newHead);
            return false;
        }
        first = first.next;
        second = second.next;
    }
    //reverse the second half
    reverse(newHead);
    return true;
    }

    private static Node reverse(Node head){
        if(head == null || head.next == null)   return head;
        Node temp = head;
        Node back = null;
        while(temp != null){
            Node front = temp.next;
            temp.next = back;
            back = temp;
            temp = front;
        }return back;
    }

}
