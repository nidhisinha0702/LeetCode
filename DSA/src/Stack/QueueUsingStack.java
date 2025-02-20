package Stack;

import java.util.Stack;
//if it less less push operation than good
public class QueueUsingStack {
	Stack<Integer> st1 = new Stack<>();
	Stack<Integer> st2 = new Stack<>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		QueueUsingStack s = new QueueUsingStack();
        s.push(6);
        s.push(3);
        System.out.println("Top of the stack before deleting any element " + s.top());
        System.out.println("The element deleted is " + s.pop());
        System.out.println("Top of the stack after deleting an element " + s.top());
		
	}

	void push(int a) {
		while(st1.size() != 0) {
			st2.push(st1.peek());
			st1.pop();
		}
		st1.push(a);
		while(st2.size() != 0) {
			st1.push(st2.peek());
			st2.pop();
		}
	}
	
	int pop() {
		return st1.pop();
	}
	
	int top() {
		return st1.peek();
	}
	
}
