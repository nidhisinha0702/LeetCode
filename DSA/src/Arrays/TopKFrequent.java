package Arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopKFrequent {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nums[] = {1,2,2,3,3,3};
		int k = 2;
		int[] ans = topKFrequent(nums, k);
		for(int a: ans)
		System.out.print(a+" ");

	}
	//TC->O(nlogn) SC->O(n) - sol1 using sorting
	private static int[] topKFrequent(int[] nums, int k) {
        //create hashmap for count fre
        HashMap<Integer,Integer> mpp = new HashMap<>();
        for(int a : nums){
            mpp.put(a,mpp.getOrDefault(a,0)+1);
        }
        //arralist of array type which can go maxi to array size
        ArrayList<int[]> arr = new ArrayList<>();
        for(Map.Entry<Integer,Integer> entry: mpp.entrySet()){
            arr.add(new int[]{entry.getValue(),entry.getKey()});
        }

        //sort the arraylist on the basis of val to get k frequent
        arr.sort((a,b) -> b[0] - a[0]);

        //create res arr of size k
        int[] res = new int[k];
        for(int i=0;i<k;i++){
            res[i]=arr.get(i)[1];
        }
        return res;
    }
	//TC and SC--O(n) utilizing Bucket sort algorithm
	public int[] topKFrequentOn(int[] nums, int k) {
        Map<Integer,Integer> mpp = new HashMap<>();//to count the freq
        int n = nums.length;
        //we will create in array of list type to store the values at
        //idx of its count (0-n+1 for len n idx)
        List<Integer>[] freq = new List[n+1];

        //iterate over the freqarray
        for(int i=0;i<freq.length;i++){
            //initialize the arrayList for each idx
            freq[i] = new ArrayList<>();
        }

        //iterate over the nums array and count the val
        for(int ele:nums){
            mpp.put(ele,mpp.getOrDefault(ele,0)+1);
        }

        //add the val(idx) and key(list ele)
        for(Map.Entry<Integer,Integer> entry: mpp.entrySet()){
            freq[entry.getValue()].add(entry.getKey());
        }

        //create res array for k ele
        int[] res = new int[k];
        //iterate from back as we want top k ele and go upto k
        int index = 0;
        for(int i = freq.length - 1;i>0 && index<k;i--){
            //for each array idx we extract the list and get its value
            for(int a: freq[i]){
                res[index++] = a;
                if(index == k){
                    //we have found k ele
                    return res;
                }
            }
        }return res;
    }
	
}
