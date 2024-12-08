package Arrays;

import java.util.Arrays;

//Given a array arr[] and positive integer k denoting heights of towers, you have to modify the height of each tower either by increasing or decreasing them by k only once.
//
//Find out what could be the possible minimum difference of the height of shortest and longest towers after you have modified each tower.
public class MinimizeHeightI {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {1, 5, 8, 10};
		int k = 2;
		int ans = getMinDiff(arr,k);
		System.out.println("The minimum difference between the longest and the shortest tower is :"+ans);
		

	}
	
	private static int getMinDiff(int[] arr, int k) {
        // code here
        int n = arr.length;
        //we dont know if the array is sorted
        Arrays.sort(arr);
        int ans = arr[n-1] - arr[0];
        //To minimize the distance we have to go + k from start and -k from end
        int minH = 0;
        int maxH = 0;
        for(int i=1;i<n;i++){
            
            //find the minimum between 1st and new minimum after -k
            minH = Math.min(arr[0]+k, arr[i]-k);
            //find the maximum between last and the new maximum which happens to be at i-1
            maxH = Math.max(arr[i-1]+k,arr[n-1]-k);
            //find the minimum among previous and new min
            ans = Math.min(ans,maxH-minH);
            
        }
        return ans;
        

	}
}
