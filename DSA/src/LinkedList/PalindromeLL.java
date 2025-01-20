package LinkedList;

import java.util.Stack;

public class PalindromeLL {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(2);
		head.next.next.next = new Node(1);
		
		System.out.println("LL is palindrome:"+isPalindrome(head));

	}
	 private static boolean isPalindrome(Node head) {
	        Stack<Integer> st = new Stack<>();
	        Node temp = head;
	        while(temp != null){
	            st.push(temp.data);
	            temp = temp.next;
	        }
	        temp = head;
	        while(temp!=null){
	            if(temp.data != st.peek()) return false;
	            temp = temp.next;
	            st.pop();
	        }return true;
	    }
}
