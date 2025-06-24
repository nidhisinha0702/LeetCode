package greedy;

import java.util.ArrayList;
import java.util.Arrays;

public class MergeIntervals {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int intervals[][] = {{1,3},{2,6},{8,10},{8,9},{9,11},{15,18},{2,4},{16,17}};
		int ans[][] = merge(intervals);
		System.out.println(Arrays.deepToString(ans));

	}
	//TC-(n+nlog)
	  public static int[][] merge(int[][] intervals) {
	        //sort in asc order
	        Arrays.sort(intervals, (a,b)->a[0]-b[0]);
	        //a temp var with st and end as the 1st pair
	        int start = intervals[0][0];
	        int end = intervals[0][1];
	        //to store ans 
	        ArrayList<ArrayList<Integer>> res = new ArrayList<>();

	        //iterate over the intervals
	        for(int arr[]:intervals){
	            //merge step
	            if(arr[0] <= end){
	                end = Math.max(arr[1], end);
	            }else{
	                //store ans
	                res.add(new ArrayList<>(Arrays.asList(start,end)));
	                start = arr[0];
	                end = arr[1];
	            }
	        }res.add(new ArrayList<>(Arrays.asList(start,end)));
	        return res.stream().map(innerRes -> innerRes.stream().mapToInt(Integer::intValue).toArray()).toArray(int[][]::new);
	    }
}
