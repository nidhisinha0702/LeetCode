package LinkedList;

public class DeleteNodeLLII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//4->5->1->9->null
				Node head = new Node(4);
				head.next = new Node(5);
				Node node = head.next;
				head.next.next = new Node(1);
				head.next.next.next = new Node(9);
				deleteNode(node);
				Node.printList(head);
				
	}
	//delete a node when head is not given
		private static void deleteNode(Node node) {
			Node temp = node;
			node.data = node.next.data;
			node.next = node.next.next;
		}
}
