package Stack;

public class QueueUsingLL {
	Node front = null;
	Node rear = null;
	int size = 0;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyQueue queue = new MyQueue();
		queue.push(44);
		queue.push(83);
		queue.push(39);
		System.out.println("Top of the queue before deleting any element:"+queue.top());
		System.out.println("Size of the queue before deleting any element:"+queue.size());
		System.out.println("The element deleted is:"+queue.pop());
		System.out.println("Size of the queue after deleting an element:"+queue.size());
		System.out.println("Top of the queue after deleting an element:"+queue.top());

	}
	
	void push(int a) {
		Node temp = new Node(a);
		if(front == null) {
			front = rear = temp;
		}else	rear.next = temp;
		rear = temp;
		size += 1;
	}
	
	int pop() {
		if(front == null) return -1;
		Node temp = front;
		front = front.next;
		size -= 1;
		return temp.data;
	}
	
	int top() {
		return front.data;
	}
	
	int size() {
		return size;
	}
}
