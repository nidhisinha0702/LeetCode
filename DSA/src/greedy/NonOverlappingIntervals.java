package greedy;

import java.util.Arrays;

public class NonOverlappingIntervals {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int intervals[][] = {{1,2},{2,3},{3,4},{1,3}};
		System.out.println("Minimum number of removal is : "+eraseOverlapIntervals(intervals));

	}
	 public static int eraseOverlapIntervals(int[][] intervals) {
	        //it can be solved on the idea of n meeting room
	        //find the cnt by end time and sub with n
	        int n = intervals.length;
	        //sort
	        Arrays.sort(intervals, (a,b) -> a[1] - b[1]);
	        int lastEndTime = intervals[0][1], cnt = 1;
	        //iterate
	        for(int arr[]:intervals){
	            if(arr[0] >= lastEndTime){
	                cnt++;
	                lastEndTime = arr[1];
	            }
	        }return n-cnt;
	    }
}
