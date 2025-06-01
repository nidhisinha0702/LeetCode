package BasicRecursion;

import java.util.ArrayList;
import java.util.List;

public class Search {

	private static int search(int arr[], int target, int idx) {
		//base condition
		if(idx == arr.length) return -1;
		
		if(arr[idx] == target) return idx;
		
		return search(arr, target, idx + 1);
	}
	
	private static boolean find(int arr[], int tar, int idx) {
		if(idx == arr.length) return false;
		
		return (arr[idx] == tar) || find(arr, tar, idx + 1);
	}
	
	private static int searchBack(int arr[], int target, int idx) {
		//base condition
		if(idx == -1) return -1;
				
		if(arr[idx] == target) return idx;
				
		return searchBack(arr, target, idx - 1);
	}
	
	static ArrayList<Integer> list = new ArrayList<>();
	private static void searchAllIdx(int arr[], int target, int idx) {
		//base condition
		if(idx == arr.length) return;
		
		if(arr[idx] == target) list.add(idx);
		
		searchAllIdx(arr, target, idx + 1);
	}
	
	private static List<Integer> findAll(int arr[], int target, int idx, ArrayList<Integer> list){
		if(idx == arr.length) return list;
		
		if(arr[idx] == target) list.add(idx);
		
		return findAll(arr, target, idx + 1, list);
	}
	
	private static ArrayList<Integer> findAllIdx(int arr[], int target, int idx){
		ArrayList<Integer> list = new ArrayList<>();
		
		if(idx == arr.length) return list;
		
		//this will contain answer for that function call only
		if(arr[idx] == target) list.add(idx);
		
		ArrayList<Integer> ansFromBelowCalls = findAllIdx(arr, target, idx + 1);
		
		list.addAll(ansFromBelowCalls);
		
		return list;
	}
	
	public static void main(String[] args) {
		// WAP to find the target in an array
		//the array is passed as value of the reference so in each function call in recursion a new ref variable 
		//will be created but all will point to the same object
		int arr[] = {1,2,3,3,45,8,9};
		int tar = 3;
		System.out.println(search(arr, tar, 0));
		System.out.println(searchBack(arr, tar, 5));
		System.out.println(find(arr, tar, 0));
		searchAllIdx(arr, tar, 0);
		System.out.println(list);
		System.out.println(findAll(arr, tar, 0, new ArrayList<Integer>()));
		
		System.out.println(findAllIdx(arr, tar, 0));
	}

}
