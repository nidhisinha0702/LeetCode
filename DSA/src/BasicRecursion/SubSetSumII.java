package BasicRecursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubSetSumII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {1,2,2,2,3,3};
		List<List<Integer>> ans = subsetsWithDup(arr);
		System.out.println(ans);

	}
	public static List<List<Integer>> subsetsWithDup(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> subSet = new ArrayList<>();
        func(0,nums,n,subSet,new ArrayList<Integer>());
        return subSet;
    }

    private static void func(int ind,int[] arr,int n,List<List<Integer>> subSet,List<Integer> ds){
        subSet.add(new ArrayList<>(ds));
        for(int i=ind;i<n;i++){
            if(i!=ind && arr[i] == arr[i-1]) continue;
            ds.add(arr[i]);
            func(i+1,arr,n,subSet,ds);
            ds.remove(ds.size()-1);
        }
    }
}
