package Stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class SlidingWindowMaximum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nums[] = {1,3,-1,-3,5,3,6,7};
		int k = 3;
		int ans[] = maxSlidingWindow(nums, k);
		for(int a:ans)
			System.out.print(a+" ");

	}
	private static int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        //initialize an array to store the ans as per the k
        int r[] = new int[n-k+1];
        int ri = 0;
        //storing indexes in deque
        Deque<Integer> q = new ArrayDeque<>();
        //iterate over the array
        for(int i = 0;i<n;i++){
            //remove any out of bounds for out of range of k
            if(!q.isEmpty() && q.peek() == i-k)
                q.poll();
            //removes all smaller element from the deque
            while(!q.isEmpty() && (nums[q.peekLast()] <= nums[i]))
                q.pollLast();
            //push indexes
            q.offer(i);
            //if the window size is k
            if(i >= k-1){
                r[ri++] = nums[q.peek()];
            }
        }return r;
    }
}
