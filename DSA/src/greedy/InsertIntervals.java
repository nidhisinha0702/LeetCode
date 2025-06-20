package greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InsertIntervals {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int inter[][] = {{1,2},{3,5},{6,7},{8,10},{12,16}};
		int newInter[] = {4,8};
		int arr[][] = insert(inter, newInter);
		System.out.println("The final interval is : "+Arrays.deepToString(arr));
	}
	 private static int[][] insert(int[][] intervals, int[] newInterval) {
	        int n = intervals.length;
	        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
	        int start = 0;
	        int end = 1;
	        int i = 0;
	        //left without overlap
	        while(i < n && intervals[i][end] < newInterval[start]){
	            res.add(new ArrayList<>(Arrays.asList(intervals[i][start], intervals[i][end])));
	            i++;
	        }
	        //overlap part
	        while(i < n && intervals[i][start] <= newInterval[end]){
	            newInterval[start] = Math.min(intervals[i][start], newInterval[start]);
	            newInterval[end] = Math.max(intervals[i][end], newInterval[end]);
	            i++;
	        }
	        //add the final new interval
	        res.add(new ArrayList<>(Arrays.asList( newInterval[start],  newInterval[end])));
	        //right part
	        while(i < n){
	            res.add(new ArrayList<>(Arrays.asList(intervals[i][start], intervals[i][end])));
	            i++;
	        }
	        
	        int ans[][] = new int[res.size()][2];
	        for(int idx=0;idx < res.size();idx++) {
	        	ans[idx][0] = res.get(idx).get(0);
	        	ans[idx][1] = res.get(idx).get(1);
	        }
	        return ans;
	        //conve 2d list to 2d arr
	        //return res.stream().map(ans -> ans.stream().mapToInt(Integer::intValue).toArray()).toArray(int[][]::new);

	    }
	
	

}
