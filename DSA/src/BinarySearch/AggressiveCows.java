package BinarySearch;
//You are given an array 'arr' consisting of 'n' integers which denote the position of a stall.
//You are also given an integer 'k' which denotes the number of aggressive cows.
//You are given the task of assigning stalls to 'k' cows such that the minimum distance between any two of them is the maximum possible.
//Print the maximum possible minimum distance.

import java.util.Arrays;

public class AggressiveCows {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int stalls[] = {0, 3, 4 ,7, 10, 9};
		int cows = 4;
		int ans = aggressiveCows(stalls, cows);
		System.out.println(" The maximum possible minimum distance will be "+ans);
	}
	private static boolean canWePlace(int arr[],int dist, int cows){
        int cntCows = 1, last = arr[0];
        for(int i =1;i<arr.length;i++){
            if(arr[i] - last >= dist){
                cntCows++;
                last = arr[i];
            }
            if(cntCows>=cows) return true;
        }return false;
    }
    public static int aggressiveCows(int []stalls, int k) {
        //    Write your code here.
        Arrays.sort(stalls);
        int n = stalls.length;
        int low = 1;
        int high = stalls[n-1] - stalls[0];
        while(low<=high){
            int mid = (low + high)/2;
            if(canWePlace(stalls,mid,k))
                low = mid + 1;
            else
                high = mid - 1;
        }return high;

    }

}
