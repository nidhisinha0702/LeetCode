package Stack;

import java.util.Stack;

public class NextGreaterElementII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nums[] = {4,12,5,3,1,2,5,3,1,2,4,6};
		int ans[] = nextGreaterElements(nums);
		for(int n:ans)
		System.out.print(n+" ");
	}
	private static int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int nge[] = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i = 2*n-1;i>= 0;i--){
            while(!st.isEmpty() && st.peek() <= nums[i % n]){
                st.pop();
            }
            if(i < n ) nge[i] = st.isEmpty() ? -1 : st.peek();
            st.push(nums[i % n]);
        }return nge;
    }
}
