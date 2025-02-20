package Stack;

public class StackUsingLL {
	Node top = null;
	int size = 0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StackUsingLL s = new StackUsingLL();
        s.push(60);
        s.push(35);
        s.push(71);
        System.out.println("Top of the stack before deleting any element " + s.top());
        System.out.println("Size of the stack before deleting any element " + s.size());
        System.out.println("The element deleted is " + s.pop());
        System.out.println("Size of the stack after deleting an element " + s.size());
        System.out.println("Top of the stack after deleting an element " + s.top());
		

	}
	void push(int x) {
		Node temp = new Node(x);
		temp.next = top;
		top = temp;
		size += 1;
	}
	int pop() {
		Node temp = top;
		top = top.next;
		size -= 1;
		return temp.data;
		
	}
	int top() {
		return top.data;
	}
	int size() {
		return size;
	}

}
