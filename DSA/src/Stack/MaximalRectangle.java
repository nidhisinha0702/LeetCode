package Stack;

import java.util.Arrays;
import java.util.Stack;

public class MaximalRectangle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] matrix = {{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
		System.out.println("The maximal rectangle area is :"+maximalRectangle(matrix));

	}
	 private static int maximalRectangle(char[][] matrix) {
	        int n = matrix.length;//rows
	        int m = matrix[0].length;//column
	        int maxArea = 0;
	        int prefixSum[][] = new int[n][m];
	        for(int[] rows:prefixSum)
	            Arrays.fill(rows,0);
	        //calculate prefix sum array 
	        for(int j= 0;j<m;j++){
	            int sum = 0;
	            for(int i=0;i<n;i++){
	                sum += (matrix[i][j] - '0');
	                if(matrix[i][j] == '0') sum = 0;
	                prefixSum[i][j] = sum;
	            }
	        }
	        //find largest rectangle
	        for(int i=0;i<n;i++){
	            maxArea = Math.max(maxArea,largestHistogram(prefixSum[i]));
	        }return maxArea;
	    }
	    private static int largestHistogram(int[] arr){
	        int n = arr.length;
	        Stack<Integer> st = new Stack<>();
	        int maxi = 0;
	        for(int i=0;i<n;i++){
	            while(!st.isEmpty() && arr[st.peek()] > arr[i]){
	                int eleI = st.pop();
	                int nseI = i;
	                int pseI = st.isEmpty()? -1:st.peek();
	                maxi = Math.max(maxi, ((nseI - pseI - 1) * arr[eleI]));
	            }st.push(i);
	        }
	        while(!st.isEmpty()){
	            int eleI = st.pop();
	            int nseI = n;
	            int pseI = st.isEmpty()? -1:st.peek();
	            maxi = Math.max(maxi, ((nseI - pseI - 1) * arr[eleI]));
	        }return maxi;
	    }
}
