package Arrays;
//Given an array arr[] denoting heights of N towers and a positive integer K.
//
//For each tower, you must perform exactly one of the following operations exactly once.
//
//Increase the height of the tower by K
//Decrease the height of the tower by K
//Find out the minimum possible difference between the height of the shortest and tallest towers after you have modified each tower.
//
//Note: It is compulsory to increase or decrease the height by K for each tower. After the operation, the resultant array should not contain any negative integers.

import java.util.Arrays;

public class MinimizeHeightII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {1,5,8,10};
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
            if(arr[i]-k < 0) continue;
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
