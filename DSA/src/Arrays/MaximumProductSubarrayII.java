package Arrays;

public class MaximumProductSubarrayII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {-2,6,-3,-10,0,2};
		System.out.println("The maximum product of a subarray is::"+maxProduct(arr));

	}
	private static int maxProduct(int[] arr) {
		int n = arr.length;
		
		int left = 1;
		int right = 1;
		int maxPro = Integer.MIN_VALUE;
		
		for(int i=0;i<n;i++) {
			//if encounter 0 change the left and right to 1
			if(left == 0)	left = 1;
			if(right == 0)	right = 1;
		
			left *= arr[i];
			right *= arr[n-i-1];
			
			maxPro = Math.max(maxPro, Math.max(left, right));
		}return maxPro;
		
	}
}
