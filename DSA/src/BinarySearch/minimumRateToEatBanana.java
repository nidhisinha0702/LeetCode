package BinarySearch;

import java.util.Arrays;

public class minimumRateToEatBanana {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nums[] = {3,6,7,11};
		int h = 8;
		int ans = minimumRateToEatBananas(nums,h);
		System.out.println("The minimum rate at which koko can eat banana is : "+ans);

	}
	 private static int minimumRateToEatBananas(int []v, int h) {
	        // Write Your Code Here
	        int low = 1, high = Arrays.stream(v).max().getAsInt();
	        while(low<=high){
	            int mid = (low + high)/2;
	            long reqTime = totalHours(v,mid);
	            if(reqTime<=h){
	                high = mid - 1;
	            }else{
	                low = mid + 1;
	            }
	        }return low;

	    }

	    private static long totalHours(int[] a, int h){
	        long ans = 0;
	        for(int ele:a){
	            ans += Math.ceil((double)ele/h);
	        }return ans;
	    }
}
