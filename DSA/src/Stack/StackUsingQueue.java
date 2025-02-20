package Stack;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueue {
	
	Queue<Integer> q = new LinkedList<>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StackUsingQueue s = new StackUsingQueue();
        s.push(16);
        s.push(783);
        s.push(17);
        System.out.println("Top of the stack before deleting any element " + s.top());
        System.out.println("Size of the stack before deleting any element " + s.size());
        System.out.println("The element deleted is " + s.pop());
        System.out.println("Size of the stack after deleting an element " + s.size());
        System.out.println("Top of the stack after deleting an element " + s.top());
		

	}
	
	void push(int x) {
		q.add(x);
		for(int i=0;i<q.size()-1;i++) {
			q.add(q.remove());
		}
	}
	int pop() {
		return q.remove();
	}
	int top() {
		return q.peek();
	}
	int size() {
		return q.size();
	}

}
