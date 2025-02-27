package Stack;

import java.util.Stack;

public class MiniumsSubarraySum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {3,1,2,4};
		System.out.println("the sum of minimums in a subarray is: "+sumSubarrayMins(arr));

	}
	 private static int sumSubarrayMins(int[] arr) {
	        int nsei[] = findNSI(arr);//find the next smaller element index array
	        int psei[] = findPSEI(arr);//find the previous smaller element index array
	        int total = 0;
	        int mod = (int)1e9 + 7;
	        for(int i = 0 ;i < arr.length;i++){
	            int left = i - psei[i];
	            int right = nsei[i] - i;
	            total = (int)(total + (left * right * 1L * arr[i]) % mod) % mod;
	        }return total;
	    }

	    private static int[] findNSI(int arr[]){
	        int n = arr.length;
	        int nsi[] = new int[n];
	        Stack<Integer> st = new Stack<>();
	        for(int i = n-1;i >= 0;i--){
	            while(!st.isEmpty() && arr[st.peek()] >= arr[i])
	                st.pop();
	            nsi[i] = st.isEmpty() ? n : st.peek();
	            st.push(i);
	        }return nsi;
	    }
	    private static int[] findPSEI(int arr[]){
	        int n = arr.length;
	        int psi[] = new int[n];
	        Stack<Integer> st = new Stack<>();
	        for(int i = 0;i < n;i++){
	            while(!st.isEmpty() && arr[st.peek()] > arr[i])
	                st.pop();
	            psi[i] = st.isEmpty() ? -1 : st.peek();
	            st.push(i);
	        }return psi;
	    }
}
