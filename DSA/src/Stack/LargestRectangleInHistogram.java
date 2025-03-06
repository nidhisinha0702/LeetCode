package Stack;

import java.util.Stack;

public class LargestRectangleInHistogram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num[] = {3,2,10,11,5,10,6,3};
		System.out.println("The largest rectangle area of the histogram is :"+largestRectangleArea(num));

	}
	 public static int largestRectangleArea(int[] heights) {
	        Stack<Integer> st = new Stack<>();
	        int maxArea = 0;
	        //iterate over the array
	        for(int i=0;i<heights.length;i++){
	            //check if stack has elements
	            while(!st.isEmpty() && heights[st.peek()] > heights[i]){
	                //element on the stack ig greater than the current element which means we found NSE
	                int nsei = i;
	                //st top element will be
	                int elei = st.pop();
	                //st has element than st top is now psei
	                int psei = st.isEmpty() ? -1:st.peek();
	                //calculate maxarea
	                maxArea = Math.max((heights[elei] * (nsei - psei - 1)), maxArea);
	            }//push element ind everytime in the stack
	            st.push(i);
	        }
	        //if element is left in stack
	        while(!st.isEmpty()){
	            int nsei = heights.length;
	            int elei = st.pop();
	            int psei = st.isEmpty()?-1:st.peek();
	            maxArea = Math.max((heights[elei] * (nsei - psei - 1)), maxArea);
	        }return maxArea;
	    }
}
