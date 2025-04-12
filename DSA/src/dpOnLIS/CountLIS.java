package dpOnLIS;

public class CountLIS {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nums[] = {1,3,5,4,7};
		System.out.println("The number of LIS are : "+findNumberOfLIS(nums));

	}
	private static int findNumberOfLIS(int[] nums) {
        int n= nums.length;
        //the intuition is cnt the lis on each step
        int dp[] = new int[n];
        int cnt[] = new int[n];

        int maxi=1;
        //iterate through the array and intialize everything with 1
        for(int i=0;i<n;i++){
            dp[i]=1;
            cnt[i]=1;
            for(int j=0;j<i;j++){
                //if the LIs is continuing with previous values copy the cnt
                if(nums[i]>nums[j] && 1+dp[j]>dp[i]){
                    dp[i]=1+dp[j];
                    cnt[i]=cnt[j];
                }//if its says i am a new one then increase the cnt
                else if(nums[i]>nums[j] && 1+dp[j]==dp[i]){
                    cnt[i] += cnt[j];
                }
            }
            maxi = Math.max(maxi,dp[i]);
        }

        //cnt the nos of LIS
        int nos=0;
        for(int i=0;i<n;i++){
            if(dp[i]==maxi) nos += cnt[i];
        }
        return nos;
    }
}
