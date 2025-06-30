package Heap;

import java.util.PriorityQueue;

public class PriorityQ {

	public static void main(String[] args) {
		// By default in java pq is min-heap
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		pq.add(10);
		pq.add(5);
		pq.add(20);
		System.out.println(pq.size());
		while(!pq.isEmpty()) {
			System.out.println(pq.peek());
			pq.poll();
		}
	}

}
