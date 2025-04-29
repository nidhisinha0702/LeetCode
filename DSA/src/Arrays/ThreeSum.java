package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ThreeSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nums[] = {-1,0,1,2,-1,4};
		List<List<Integer>> ans = threeSumOptimal(nums);
		System.out.println("Unique triplets are "+ans);

	}
	//TC->O(n^3) SC->O(n)+ O(no.of tri)*2
	private static List<List<Integer>> threeSumBF(int[] nums){
		//sort the array
		Set<List<Integer>> res = new HashSet<>();
		Arrays.sort(nums);
		int n = nums.length;
		for(int i=0;i<n;i++) {
			for(int j=i+1;j<n;j++) {
				for(int k=j+1;k<n;k++) {
					if(nums[i]+nums[j]+nums[k]==0) {
						res.add(new ArrayList<>(Arrays.asList(nums[i],nums[j],nums[k])));
					}
				}
			}
		}
		return new ArrayList<>(res);
	}
	//TC->O(n^2 * logM) SC-> O(n) + O(no.of tri)*2
	private static List<List<Integer>> threeSumBetter(int[] nums){
		//for unique triplets
		Set<List<Integer>> res = new HashSet<>();
		int n = nums.length;
		//1st loop
		for(int i=0;i<n;i++) {
			//empty the set every time we pick new ele
			Set<Integer> set = new HashSet<>();
			for(int j=i+1;j<n;j++) {
				//find third ele a+b+c = 0, c = -(a+b);
				int third = -(nums[i]+nums[j]);
				//check if the ele is in set
				if(set.contains(third)) {
					//create the triplet list
					List<Integer> list = new ArrayList<>(Arrays.asList(nums[i],nums[j],third));
					//sort it to avoid duplicates
					Collections.sort(list);
					//add to res
					res.add(list);
				}
				//keep adding b in in set
				set.add(nums[j]);
			}
		}
		return new ArrayList<>(res);
	}
	//TC->O(nlogn)+O(n^2) SC-> O(1)
	private static List<List<Integer>> threeSumOptimal(int[] nums){
		//store ans
		List<List<Integer>> ans = new ArrayList<>();
		//sort the array
		Arrays.sort(nums);
		int n = nums.length;
		//-2,-2,-2,-1,-1,-1,0,0,0,2,2,2,2
		for(int i=0;i<n;i++) {
			//if its not first element and the prev and curr are same we will skip to avoid duplicates
			if(i>0 && nums[i] == nums[i-1]) continue;
			//two pointer approach j & k 
			int j = i+1;//after i
			int k = n-1;//at end
			while(j<k) {//j not crosses k
				int sum = nums[i]+nums[j]+nums[k];
				//if the sum is less we need to increase it
				if(sum < 0) {
					j++;
				}////if the sum is more we need to decrease it
				else if(sum > 0) {
					k--;
				}else {
					//this is my triplet
					List<Integer> temp = new ArrayList<>(Arrays.asList(nums[i],nums[j],nums[k]));
					ans.add(temp);
					j++;
					k--;
					//skip all the similar values until we get new value
					while(j<k && nums[j]==nums[j-1]) j++;
					while(j<k && nums[k]==nums[k+1])k--;
				}
			}
		}return ans;
		
	}
}
