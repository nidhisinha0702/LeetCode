package dpOnLIS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class PrintLongestIncreasingSubsequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {40, 31, 22, 77, 42, 91, 41, 63, 64, 49 ,15, 59, 65, 52 ,52 ,14, 51 ,24, 17 ,42 ,50 ,19, 78, 55, 80, 40, 72, 66, 74, 22};
		int n = 30;
		ArrayList<Integer> ans = longestIncreasingSubsequence(n, arr);
		System.out.println("The longest increasing sub sequence is : "+ans);

	}
	 private static ArrayList<Integer> longestIncreasingSubsequence(int n, int arr[]) {
	        // Code here
	        int dp[] = new int[n];
	        Arrays.fill(dp,1);//initialize dp array with 1
	        int hash[] = new int[n];
	        Arrays.fill(hash,1);
	        int maxi = -1;
	        int lastInd = -1;
	        
	        for(int ind=0;ind<n;ind++){
	            hash[ind]=ind; //initialize hash array with ind (to store prev ind)
	            for(int prev=0;prev<ind;prev++){
	                if(arr[ind]>arr[prev] && 1 + dp[prev] > dp[ind]){//compute dp and sequence arrays
	                    dp[ind] =  1 + dp[prev];
	                    hash[ind] = prev;
	                }
	            }
	            
	        }
	      
	    
	        for(int i=0; i<=n-1; i++){
	          if(dp[i]> maxi){
	            maxi = dp[i];
	            lastInd = i;
	           }
	        }
	        
	        //construct the result sequence using hash array
	        ArrayList<Integer> res = new ArrayList<>();
	        res.add(arr[lastInd]);
	        
	        while(hash[lastInd] != lastInd){
	            lastInd = hash[lastInd];
	            res.add(arr[lastInd]);
	        }
	        
	        //reverse the result for correct order
	        Collections.reverse(res);
	        return res;
	    }
}
