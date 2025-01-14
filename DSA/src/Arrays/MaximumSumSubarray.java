package Arrays;

public class MaximumSumSubarray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {2,3,-8,7,-1,2,3};
		System.out.println("The mximum sum of the subarray is::"+maxSubarraySum(arr));
	}
	
	private static int maxSubarraySum(int[] arr) {

	        // Your code here
	        int sum = arr[0];
	        int currSum = arr[0];
	        
	        //iterate over the array
	        for(int i=1;i<arr.length;i++){
	            //Kadane's algorithm
	            //while adding new element to find current sum check if that element is max or not
	            currSum = Math.max(currSum+arr[i],arr[i]);
	            sum = Math.max(sum,currSum);
	        }return sum;
	    }

}
