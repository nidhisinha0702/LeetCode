package collection_framework;

import java.util.LinkedList;
import java.util.Queue;

public class Queue_LL {

	public static void main(String[] args) {
		Queue<Integer> c = new LinkedList<>();
		c.offer(10);
		c.offer(20);
		c.offer(30);
		c.offer(60);
		c.offer(100);//[10,20,30,60,100]
		
		System.out.println(c.peek());
		System.out.println(c);
		c.poll();
		c.poll();
		System.out.println(c);
		
	}

}
