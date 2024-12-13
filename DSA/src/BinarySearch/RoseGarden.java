package BinarySearch;
//You are given 'n' roses and you are also given an array 'arr' where 'arr[i]' denotes that the 'ith' rose will bloom on the 'arr[i]th' day.
//You can only pick already bloomed roses that are adjacent to make a bouquet. You are also told that you require exactly 'k' adjacent bloomed roses to make a single bouquet.
//Find the minimum number of days required to make at least 'm' bouquets each containing 'k' roses. Return -1 if it is not possible.
//Example :
//Input: n = 9,  arr = [ 1, 2, 1, 2, 7, 2, 2, 3, 1 ], k = 3, m = 2
//Output: 3. 
public class RoseGarden {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1, 2, 1, 2, 7, 2, 2, 3, 1};
		int k = 3;
		int m = 2;
		int ans = roseGarden(arr,k,m);
		System.out.println("The minimum no of days required to make at least 'm' bouquets each containing 'k' roses. "+ans);

	}
	 public static int roseGarden(int[] arr, int r, int b) {
	        // Write your code here.
	        //if size of the array is lees than r *b 
	        if(arr.length < (r*b)) return -1;
	        //find the range
	        int min = Integer.MAX_VALUE;
	        int max = Integer.MIN_VALUE;
	        for(int i = 0;i<arr.length;i++){
	            min = Math.min(min, arr[i]);
	            max = Math.max(max, arr[i]);
	        }
	        int low = min;
	        int high = max;
	        while(low<=high){
	            int mid = (low + high)/2;
	            if(possible(arr,mid,b,r))
	                high = mid - 1;
	            else
	                low = mid + 1;
	        }return low;

	    }
	    //function that takes possible or not
	   private static boolean possible(int arr[],int day,int m,int k){
	        int cnt = 0;
	        int noOfB = 0;
	        for(int i=0;i<arr.length;i++){
	            if(arr[i]<=day) cnt++;
	            else{
	            noOfB += (cnt/k);
	            cnt = 0;
	            }
	        }noOfB += (cnt/k);
	        return noOfB >= m;
	    }

}
