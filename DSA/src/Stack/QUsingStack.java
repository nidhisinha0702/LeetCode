package Stack;

import java.util.Stack;
//if push operation is more
public class QUsingStack {
	Stack<Integer> s1 = new Stack<>();
	Stack<Integer> s2 = new Stack<>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		QUsingStack queue = new QUsingStack();
		queue.push(44);
		queue.push(83);
		queue.push(39);
		System.out.println("Top of the queue before deleting any element:"+queue.top());
		System.out.println("The element deleted is:"+queue.pop());
		System.out.println("Top of the queue after deleting an element:"+queue.top());
		System.out.println("Queue is empty: "+queue.empty());

	}
	void push(int x) {
		s1.push(x);
	}
	int pop() {
		if(s2.size() != 0) {
			return s2.pop();
		}else {
			while(s1.size() != 0) {
				s2.push(s1.peek());
				s1.pop();
			}return s2.pop();
		}
	}

	int top() {
		if(s2.size() != 0) return s2.peek();
		else {
			while(s1.size() != 0) {
				s2.push(s1.peek());
				s1.pop();
			}return s2.peek();
		}
	}
	
	boolean empty() {
		return (s1.isEmpty() && s2.isEmpty());
	}
}
