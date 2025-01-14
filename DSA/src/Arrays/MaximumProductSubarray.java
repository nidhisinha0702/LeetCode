package Arrays;

public class MaximumProductSubarray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {-2,6,-3,-10,0,2};
		System.out.println("The maximum product of a subarray is::"+maxProduct(arr));

	}
	private static int maxProduct(int[] arr) {
		int n = arr.length;
		
		int currMax = arr[0];
		int currMin = arr[0];
		int maxPro = arr[0];
		
		for(int i=1;i<n;i++) {
			int temp = Math.max(arr[i],Math.max(currMax*arr[i], currMin*arr[i]) );
			
			currMin = Math.min(arr[i], Math.min(currMin*arr[i], currMax*arr[i]));
			
			currMax = temp;
			
			maxPro = Math.max(maxPro, currMax);
		}return maxPro;
	}

}
