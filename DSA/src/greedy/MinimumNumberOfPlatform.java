package greedy;

import java.util.Arrays;

public class MinimumNumberOfPlatform {

	public static void main(String[] args) {
		//
		int arr[] = {900, 945, 955, 1100, 1500, 1800};
		int dep[] = {920, 1150, 1130, 1200, 1900, 2000};
		System.out.println("Minimum number of platform required to acculmulate all the trains : "+platform(arr, dep));
	}
	
	private static int platform(int arr[], int dep[]) {
		Arrays.sort(arr);
		Arrays.sort(dep);
		int i = 0, j = 0, cnt = 0, maxCnt = 0;
		while(i < arr.length) {
			if(arr[i] <= dep[j]) {
				cnt += 1;
				i++;
			}else {
				cnt -= 1;
				j++;
			}maxCnt = Math.max(maxCnt, cnt);
		}return maxCnt;
	}

}
