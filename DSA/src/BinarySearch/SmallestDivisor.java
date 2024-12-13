package BinarySearch;
//You are given an array of integers 'arr' and an integer 'limit'.
//Your task is to find the smallest positive integer divisor, such that upon dividing all the elements of the given array by it, the sum of the division's result is less than or equal to the given integer's limit.
//Note:
//Each result of the division is rounded to the nearest integer greater than or equal to that element. For Example, 7/3 = 3.

public class SmallestDivisor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {1,2,3,4,5};
		int limit = 8;
		int ans = smallestDivisor(arr, limit);
		System.out.println("The smallest positive integer divisor: "+ans);

	}
	 private static int sumByD(int arr[], int div) {
	        // Write your coder here
	        int n = arr.length;
	        int sum = 0;
	        for(int i=0;i<n;i++){
	            sum += Math.ceil((double)(arr[i])/(double)(div));
	        }
	        return sum;
	    }

	    public static int smallestDivisor(int arr[],int limit){
	        
	        int low = 1;
	        int max = Integer.MIN_VALUE;
	        for(int i=0;i<arr.length;i++){
	            max = Math.max(max, arr[i]);
	        }
	        int high = max;
	        while(low<=high){
	            int mid = (low+high)/2;
	            if(sumByD(arr, mid) <= limit)
	                high = mid - 1;
	            else
	                low = mid + 1;
	        }return low;
	    }
}
