package greedy;

import java.util.Arrays;
//Shortest Job First (CPU)
public class SJF {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int bt[] = {4,3,7,1,2};
		System.out.println("Smallest execution time first wait time : "+sjf(bt));
	}
	//TC->O(nlogn + n)
	private static int sjf(int bt[]) {
		Arrays.sort(bt);
		int time = 0, wtTime = 0;
		for(int i=0;i<bt.length;i++) {
			wtTime += time;
			time += bt[i];
		}return (wtTime/bt.length);
	}
}
