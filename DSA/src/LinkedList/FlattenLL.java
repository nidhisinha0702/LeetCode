package LinkedList;

public class FlattenLL {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode head = new ListNode(3);
		head.next = new ListNode(2);
		head.next.child = new ListNode(10);
		head.next.next = new ListNode(1);
		head.next.next.child = new ListNode(7);
		head.next.next.child.child = new ListNode(11);
		head.next.next.child.child.child = new ListNode(12);
		head.next.next.next = new ListNode(4);
		head.next.next.next.child = new ListNode(9);
		head.next.next.next.next = new ListNode(5);
		head.next.next.next.next.child = new ListNode(6);
		head.next.next.next.next.child.child = new ListNode(8);
		ListNode.printOriginalLL(head,0);
		System.out.println("****************");
		head = flatten(head);
		ListNode.print(head);

	}
	private static ListNode flatten(ListNode head) {
	        // code here
	        if(head == null || head.next == null) return head;
	        ListNode mergedHead = flatten(head.next);//recursively call next node and reach end
	        head = merge(head,mergedHead);//backtracking
	        return head;
	    }
	private static ListNode merge(ListNode list1,ListNode list2){
	        ListNode dummyNode = new ListNode(-1);
	        ListNode res = dummyNode;
	        while(list1 != null && list2 != null){
	            if(list1.val < list2.val){//sort
	                res.child = list1;//point res to list1
	                res = list1;//move res to list1
	                list1 = list1.child;//move list1 to next child
	            }else{
	                res.child = list2;
	                res = list2;
	                list2 = list2.next;
	            }res.next = null;
	        }
	        //if list1 has child
	        if(list1 != null) res.child = list1;
	        else res.child = list2;//list2 is remaining
	     // Break the last node's
	        // link to prevent cycles
	        if (dummyNode.child != null) {
	            dummyNode.child.next = null;
	        }
	        return dummyNode.child;
	        
	    }
}
