package BinarySearch;

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
	        int low = 1, high = findMax(v);
	        while(low<=high){
	            int mid = (low + high)/2;
	            int reqTime = totalHours(v,mid);
	            if(reqTime<=h){
	                high = mid - 1;
	            }else{
	                low = mid + 1;
	            }
	        }return low;

	    }

	    private static int totalHours(int[] a, int h){
	        int ans = 0;
	        for(int i =0;i<a.length;i++){
	            ans += Math.ceil((double)a[i]/(double)h);
	        }return ans;
	    }
	    private static int findMax(int a[]){
	        int maxi = Integer.MIN_VALUE;
	        for(int i=0;i<a.length;i++){
	            if(a[i]>maxi) maxi = Math.max(maxi, a[i]);
	        }return maxi;
	    }
}
