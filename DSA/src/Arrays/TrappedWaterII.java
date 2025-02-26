package Arrays;

public class TrappedWaterII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {0,1,0,2,1,0,1,3,2,1,2,1};
		System.out.println("The duplicate element is :"+trap(arr));

	}
	 private static int trap(int[] height) {
	        int n = height.length;
	        int total = 0;
	        int lMax = 0;
	        int rMax = 0;
	        int l = 0;
	        int r = n - 1;
	        while(l<r){
	            if(height[l] <= height[r]){
	                if(lMax > height[l])   total += lMax - height[l];
	                else    lMax = height[l];
	                l ++;
	            }else{
	                if(rMax > height[r])    total += rMax - height[r];
	                else    rMax = height[r];
	                r --;
	            }
	        }return total;

	    }
}
