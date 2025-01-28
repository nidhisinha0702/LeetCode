package LinkedList;

public class ListNode {
	int val;
	ListNode next;
	ListNode child;
	
	//constructor
	ListNode(){
		this.val = 0;
		this.next = null;
		this.child = null;
	}
	ListNode(int x){
		this.val = x;
		this.next = null;
		this.child = null;
	}
	ListNode(int x,ListNode nextNode,ListNode childNode){
		this.val = x;
		this.next = nextNode;
		this.child = childNode;
	}
	
	protected static void printOriginalLL(ListNode head, int depth) {
		while(head != null) {
			System.out.print(head.val);
			//if child is there
			if(head.child != null) {
				System.out.println("->");
				printOriginalLL(head.child, depth+1);
			}
			//add vertical bards
			if(head.next != null) {
				System.out.println();
				for(int i=0;i<depth;i++) {
					System.out.println("| ");
				}
			}head = head.next;
		}System.out.println();
	}
	
	protected static void print(ListNode root) {
		while(root != null) {
			System.out.print(root.val+"->");
			root = root.child;
		}System.out.println();
	}
}
