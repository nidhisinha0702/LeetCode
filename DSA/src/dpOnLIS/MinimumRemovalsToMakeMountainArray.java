package dpOnLIS;

public class MinimumRemovalsToMakeMountainArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[]= {2,1,1,5,6,2,3,1};
		System.out.println("Leetcode 1671 Minimum number of removal to make mountain array is : "+minimumMountainRemovals(arr));
	}
	
	private static int minimumMountainRemovals(int[] nums) {
        int n = nums.length;
        int up[] = new int[n];
        int down[] = new int[n];

        for(int i=0;i<n;i++){
            up[i]=1;
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j] && 1+up[j]>up[i]){
                    up[i]=1+up[j];
                }
            }
        }

        for(int i=n-1;i>=0;i--){
            down[i]=1;
            for(int j=n-1;j>i;j--){
                if(nums[i]>nums[j] && 1+down[j]>down[i]){
                    down[i]=1+down[j];
                }
            }
        }

        int maxi = 0;
        for(int i=0;i<n;i++){
            if(up[i]>1 && down[i]>1)
            maxi = Math.max(maxi,up[i]+down[i]-1);
        }
        return n-maxi;
    }

}
