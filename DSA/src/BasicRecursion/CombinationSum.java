package BasicRecursion;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 int arr[] = {2,3,6,7};
	        int target = 7;
	        List < List < Integer >> ls = combinationSum(arr, target);
	        System.out.println("Combinations are: ");
	        for (int i = 0; i < ls.size(); i++) {
	            for (int j = 0; j < ls.get(i).size(); j++) {
	                System.out.print(ls.get(i).get(j) + " ");
	            }
	            System.out.println();
	        }

	}
	 private static List<List<Integer>> combinationSum(int[] candidates, int target) {
	        List<List<Integer>> ans = new ArrayList<>();
	        List<Integer> ds = new ArrayList<>();
	        f(0,target,ans,candidates,ds);
	        return ans;
	    }
	    private static void f(int ind,int target,List<List<Integer>> ans,int arr[], List<Integer> ds){
	        if(ind == arr.length){
	            if(target == 0)  ans.add(new ArrayList<>(ds));
	            return;
	        }

	        if(arr[ind] <= target){
	            ds.add(arr[ind]);
	            f(ind,target-arr[ind],ans,arr,ds);
	            ds.remove(ds.size()-1);
	        }f(ind+1,target,ans,arr,ds);

	    }
}
