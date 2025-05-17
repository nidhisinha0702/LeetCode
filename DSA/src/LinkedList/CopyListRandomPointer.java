package LinkedList;

import java.util.HashMap;

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
	       //insert node in between
	       insertNodeInBetween(head);
	       connectRandomPointer(head);
	       return getDeepCopyList(head);
	    }

	    private void insertNodeInBetween(LinkedListNode head){
	    	LinkedListNode temp = head;
	        while(temp != null){
	        	LinkedListNode newNode = new LinkedListNode(temp.val);
	            newNode.next = temp.next;
	            temp.next = newNode;
	            temp = temp.next.next;
	        }
	    }

	    private void connectRandomPointer(LinkedListNode head){
	    	LinkedListNode temp = head;
	        while(temp != null){
	        	LinkedListNode copy = temp.next;
	            if(temp.random != null)
	                copy.random = temp.random.next;
	            else copy.random = null;
	            temp = temp.next.next;
	        }
	    }

	    private LinkedListNode getDeepCopyList(LinkedListNode head){
	    	LinkedListNode dummyNode = new LinkedListNode(-1);
	    	LinkedListNode res = dummyNode;
	    	LinkedListNode temp = head;
	        while(temp != null){
	            res.next = temp.next;
	            temp.next = temp.next.next;
	            temp = temp.next;
	            res = res.next;
	        }return dummyNode.next;
	    }
	
	public LinkedListNode copyRandomListBF(LinkedListNode head) {
        HashMap<LinkedListNode,LinkedListNode> mpp = new HashMap<>();
        LinkedListNode temp = head;
        //we will create the nodes 1st
        while(temp != null){
        	LinkedListNode newNode = new LinkedListNode(temp.val);
            mpp.put(temp,newNode);
            temp = temp.next;
        }

        temp = head;
        //connect the next and random 
        while(temp != null){
        	LinkedListNode copy = mpp.get(temp);
            copy.next = mpp.get(temp.next);
            copy.random = mpp.get(temp.random);
            temp = temp.next;
        }

        return mpp.get(head);
    }
}
