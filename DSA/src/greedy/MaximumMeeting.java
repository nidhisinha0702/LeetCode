package greedy;

import java.util.Arrays;
import java.util.Comparator;

public class MaximumMeeting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] start = {0,3,1,5,5,8};
		int[] end = {5,4,2,9,7,9};
		
		System.out.println("The maximum meetings that can take place in a single meeting room is : "+maxMeetings(start, end));
	}
	private static int maxMeetings(int start[], int end[]) {
		int n = start.length;
		Pair arr[] = new Pair[n];
		for(int i=0;i<n;i++) {
			arr[i] = new Pair(start[i],end[i],i);
		}
		//faster meetings first
		Arrays.sort(arr,new endTimeComparator());
		
		//iterate over the pair array
		int cnt = 1;//st meeting can be performed always
		int freeTime = arr[0].end;//when 1st meeting ends
		//store the order of meetings
		int ds[] = new int[arr.length];
		ds[0] = arr[0].pos;
		//start with 1st index
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
