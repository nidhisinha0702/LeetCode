package Arrays;

import java.util.ArrayList;

public class MinimumPairRemovalToSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nums[] = {5,2,3,1};
		System.out.println("The minimum pair removal to sort array in operation is : "+minimumPairRemoval(nums));

	}
	 private static int minimumPairRemoval(int[] nums) {
	        //we will copy the array elements to arraylist for the sake of easy modification
	        ArrayList<Integer> ans = new ArrayList<>();
	        for(int i=0;i<nums.length;i++){
	            ans.add(nums[i]);
	        }
	        int n = ans.size();
	        int op = 0;
	        //check if the array is sorted
	        while(!isSorted(ans)){
	            int i=0;
	            int mini = Integer.MAX_VALUE;
	            int idx = 0;
	            
	            while(i<(ans.size()-1)){
	                int sum = ans.get(i) + ans.get(i+1);
	                if(sum<mini){
	                    mini = sum;
	                    idx=i;
	                }i++;
	            }
	            //merge the min sum ind and ind+1
	            int merged = ans.get(idx) + ans.get(idx+1);
	            ans.set(idx,merged);//replace the idx vale with merged value
	            ans.remove(idx+1);//remove the idx+1 value;
	            op++;
	        }return op;
	    }

	    private static boolean isSorted(ArrayList<Integer> arr){

	        for(int i=0;i<arr.size()-1;i++){
	            if(arr.get(i)>arr.get(i+1)){
	                return false;
	            }
	        }return true;
	    }
}
