package Arrays;

import java.util.HashMap;

public class TwoSumII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1,2,3,4};
		int t = 3;
		int[] ans = twoSumII(arr,t);
		for(int a:ans)
			System.out.print(a+" ");

	}
	 private static int[] twoSum(int[] numbers, int target) {
	        HashMap<Integer,Integer> mpp = new HashMap<>();
	        for(int i=0;i<numbers.length;i++){
	            if(mpp.containsKey(target-numbers[i])){
	                int ind1 = mpp.get(target-numbers[i]);
	                if(ind1<=i)
	                return new int[]{ind1,i+1};
	                return new int[]{i+1,ind1};
	            }mpp.put(numbers[i],i+1);
	        }return new int[]{-1,-1};
	    }
	 
	 private static int[] twoSumII(int[] numbers, int target) {
		    int l = 0, r = numbers.length - 1;

		    while(l < r){
		        int curSum = numbers[l] + numbers[r];

		        if(curSum > target){
		            r--;
		        }
		        else if(curSum < target){
		            l++;
		        }else{
		            return new int[]{l+1,r+1};
		        }
		    }return new int[0];
	 }
}
