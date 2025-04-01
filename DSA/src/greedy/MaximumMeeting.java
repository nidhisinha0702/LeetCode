package greedy;

import java.util.Arrays;
import java.util.Comparator;

public class MaximumMeeting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] start = {1,3,0,5,8,5};
		int[] end = {2,4,6,7,9,9};
		
		System.out.println("The maximum meetings that can take place in a single meeting room is : "+maxMeetings(start, end));
	}
	private static int maxMeetings(int start[], int end[]) {
		int n = start.length;
		Pair arr[] = new Pair[n];
		for(int i=0;i<n;i++) {
			arr[i] = new Pair(start[i],end[i],i);
		}
		Arrays.sort(arr,new endTimeComparator());
		
		//iterate over the arr
		int cnt = 1;
		int freeTime = arr[0].end;
		int ds[] = new int[arr.length];
		ds[0]=arr[0].pos;
		for(int i=1;i<arr.length;i++) {
			if(arr[i].st>freeTime) {
				cnt += 1;
				freeTime = arr[i].end;
				ds[i]=arr[i].pos;
			}
		}return cnt;
	}
	static class endTimeComparator implements Comparator<Pair>{
		
		@Override
		public int compare(Pair val1, Pair val2) {
			int e1 = val1.end;
			int e2 = val2.end;
			if(e1<e2) return -1;
			else if(e1>e2) return 1;
			else return 0;
		}
	}
	static class Pair{
		int st;
		int end;
		int pos;
		Pair(int _st, int _end, int _pos){
			st=_st;
			end=_end;
			pos=_pos;
		}
	}
}
