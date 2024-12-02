package collection_framework;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Priority_Q {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Queue<Integer> c = new PriorityQueue<>(Comparator.reverseOrder());
		c.offer(40);
		c.offer(89);
		c.offer(30);
		c.offer(200);
		c.offer(400);
		System.out.println(c);
		c.poll();
		System.out.println(c);
	}

}
