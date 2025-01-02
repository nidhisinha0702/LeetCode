package Sorting;

import java.util.ArrayList;

public class MergeSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {3,1,2,4,1,5,2,6,4};
		int n = arr.length;
		mergeSort(arr,n);
		for(int a:arr) {
			System.out.print(a+" ");
		}
	}
	public static void mergeSort(int[] arr, int n) {
		// Write your code here.
		mS(arr,0,n-1);
	}
	static void mS(int[] arr,int low,int high){
		if(low>=high) return;
		int mid=(low+high)/2;
		mS(arr,low,mid);
		mS(arr,mid+1,high);
		merge(arr,low,mid,high);
	}
	static void merge(int[] arr,int low,int mid,int high){
		ArrayList<Integer> temp=new ArrayList<>();
		int left=low;
		int right=mid+1;
		while(left<=mid && right <= high){
			if(arr[left]<=arr[right]){
				temp.add(arr[left]);
				left++;
			}else{
				temp.add(arr[right]);
				right++;
			}
		}
		while(left<=mid){
			temp.add(arr[left]);
			left++;
		}
		while(right<=high){
			temp.add(arr[right]);
			right++;
		}

		for(int i=low;i<=high;i++){
			arr[i]=temp.get(i-low);
		}
	}

}
