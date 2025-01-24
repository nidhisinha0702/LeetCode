package LinkedList;

public class Add1toLL {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node head = new Node(9);
		head.next = new Node(9);
		head.next.next = new Node(9);
		
		head = addOne(head);
		Node.printList(head);

	}
	private static Node addOne(Node head) {
		//reverse the ll and get new head
		head = reverse(head);
		Node temp = head;
		int carry = 1;//add 1 to ll
		while(temp!=null) {
			temp.data = temp.data + carry;
			if(temp.data < 10) {//if data is less than 10
				carry = 0;//carry will become 0
				break;//we are done with adding hence break;
			}else{
				temp.data = 0;//make data to 0
				carry = 1;//continue with carry 1
			}
			temp=temp.next;//move temp
		}
		if(carry==1) {
			Node newNode = new Node(1);
			head = reverse(head);
			newNode.next = head;
			return newNode;
		}
		head = reverse(head);
		return head;
	}
	private static Node reverse(Node head) {
		if(head == null || head.next == null)	return head;
		Node temp = head;
		Node back = null;
		while(temp != null) {
			Node front = temp.next;
			temp.next = back;
			back = temp;
			temp = front;
		}return back;
	}

}
