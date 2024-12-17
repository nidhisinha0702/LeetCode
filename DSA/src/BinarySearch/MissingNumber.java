package BinarySearch;

public class MissingNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []arr = {2,3,4,7,11}; int k = 5;
		int ans = findKthPositive(arr,k);
		System.out.println("The kth missing number here is :"+ans);
	}
	  private static int findKthPositive(int[] vec, int k) {
	        int n = vec.length;
	         int low = 0, high = n-1;
	        while(low<=high){
	            int mid = (low+high)/2;
	            int missing = vec[mid] - (mid + 1);
	            if(missing < k) low = mid + 1;
	            else    high = mid - 1;
	        }return high+1+k;
	    }
}
