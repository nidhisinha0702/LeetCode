package Heap;

import java.util.PriorityQueue;

public class KthLargest {

	 private PriorityQueue<Integer> minHeap;
	    private int k;

	    public KthLargest(int k, int[] nums) {
	        this.k = k;
	        this.minHeap = new PriorityQueue<>();
	        for(int num:nums){
	            minHeap.offer(num);
	            if(minHeap.size() > k) {
	            	minHeap.poll();
	            }
	        }
	    }
	    
	    public int add(int val) {
	        minHeap.offer(val);
	        if(minHeap.size() > k){
	            minHeap.poll();
	        }return minHeap.peek();
	    }
	    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int k = 3;
		int arr[] = {1,2,3,3};
		KthLargest obj = new KthLargest(k, arr);
		System.out.println(obj.add(3));
		System.out.println(obj.add(5));
		System.out.println(obj.add(6));
		System.out.println(obj.add(7));
		System.out.println(obj.add(8));
	}

	
}
