package Stack;

import java.util.Stack;

public class NextGreaterElement {

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
	        for(int i = n-1;i>= 0;i--){
	            while(!st.isEmpty() && st.peek() <= nums[i]){
	                st.pop();
	            }
	            if(st.isEmpty()) nge[i] = -1;
	            else     nge[i] = st.peek();
	            st.push(nums[i]);
	        }return nge;
	    }
}
