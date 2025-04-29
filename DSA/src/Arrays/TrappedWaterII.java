package Arrays;

public class TrappedWaterII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {0,1,0,2,1,0,1,3,2,1,2,1};
		System.out.println("The duplicate element is :"+trap(arr));

	}
	//TC->O(n), SC->O(1)
	 private static int trap(int[] height) {
		//to store water at any building left and right must be greater the that
	        //min(lmax,rmax)-height[i]
	        //using this intuition we will use two pointer approach
	        int n = height.length;
	        int total = 0;
	        int lMax = 0;
	        int rMax = 0;
	        int l = 0;
	        int r = n - 1;
	        while(l<r){
	        	//we will always traverse the smaller one first
	            if(height[l] <= height[r]){
	            	 //if we have greater building than curr building
	                if(lMax > height[l])   total += lMax - height[l];
	              //otherwise it is the greater
	                else    lMax = height[l];
	              //move to the next building in both case
	                l ++;
	            }else{
	                if(rMax > height[r])    total += rMax - height[r];
	                else    rMax = height[r];
	                r --;
	            }
	        }return total;

	    }
}
