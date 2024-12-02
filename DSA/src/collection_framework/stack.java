package collection_framework;

import java.util.Stack;

public class stack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack<Integer> c = new Stack<>();
		c.push(10);
		c.push(100);
		c.push(200);
		c.push(400);
		System.out.println(c);
		int d = c.peek();
		//c.pop();
		System.out.println(d);
		System.out.println(c);
		int e=c.search(200);
		System.out.println(e);
	}

}
