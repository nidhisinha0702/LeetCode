package BasicRecursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UniqueCombinationSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int candidates[] = {10,1,2,7,6,1,5};
		int target = 8;
		 List<List<Integer>> ans = combinationSum2(candidates,target);
		 System.out.println(ans);

	}
	 private static List<List<Integer>> combinationSum2(int[] candidates, int target) {
	        List<List<Integer>> ans = new ArrayList<>();
	        List<Integer> ds = new ArrayList<>();
	        Arrays.sort(candidates);
	        f(0,candidates,target,ans,ds);
	        return ans;
	    }
	    private static void f(int ind,int arr[],int target, List<List<Integer>> ans,List<Integer> ds){
	        if(target == 0){
	            ans.add(new ArrayList<>(ds));
	            return;
	        }

	        for(int i=ind;i<arr.length;i++){
	            //not possible case
	            if(i>ind && arr[i] == arr[i-1]) continue;
	            if(arr[i]>target) break;

	            //possible case
	            ds.add(arr[i]);
	            f(i+1,arr,target-arr[i],ans,ds);
	            ds.remove(ds.size()-1);
	        }
	    }

}
