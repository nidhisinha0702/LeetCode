package dpOnLIS;

public class ValidMountainArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {0,1,2,1,2};
		System.out.println("The valid mountain array is : "+validMountainArray(arr));

	}
	 private static  boolean validMountainArray(int[] arr) {
	        if(arr.length<3) return false;
	        int n = arr.length;
	        int left = 0, right = n-1;
	        //if two people climb a mountain they will reach at same point
	        while(left<n-1 && arr[left]<arr[left+1]) left++;
	        while(right>0 && arr[right]<arr[right-1]) right--;
	        return left>0 && left==right && right<n-1;
	       
	    }
}
