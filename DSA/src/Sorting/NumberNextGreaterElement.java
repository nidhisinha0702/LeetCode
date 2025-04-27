package Sorting;

import java.util.ArrayList;


public class NumberNextGreaterElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nums[] = {3,4,2,7,5,8,10,6};
		int queries = 2;
		int indices[] = {0,5};
		int cnge[] = count_NGE(nums.length,nums,queries,indices);
		for(int c:cnge)
			System.out.print(c+" ");
	}
	 public static int[] count_NGE(int N, int arr[], int queries, int indices[]) {
		    // store array element and their indexes as pair
		 ArrayList<Pair<Integer, Integer>> vec = new ArrayList<Pair<Integer,Integer>>();
		 for(int i= 0;i<N;i++) {
			 vec.add(new Pair<>(arr[i],i));
		 }
		 //ans array
		 int[] ans = new int[N];
		 mergeSort(vec,ans,0,N-1);
		 
		 //print number of next greater elements for q queries
		 int nge[] = new int[queries];
		 for(int i=0;i<queries;i++) {
			 nge[i] = ans[indices[i]];
		 }return nge;
		}
	 private static void mergeSort(ArrayList<Pair<Integer,Integer>> vec, int[] ans,int low, int high) {
		 int mid;
		 if(low<high) {
			 mid = low+(high-low)/2;
			 mergeSort(vec,ans,low,mid);
			 mergeSort(vec,ans,mid+1,high);
			 merge(vec,ans,low,mid,high);
		 }
	 }
	 private static void merge(ArrayList<Pair<Integer,Integer>> vec, int[] ans,int low, int mid, int high) {
		 int n1 = mid - low + 1;
	        int n2 = high - mid;
	        ArrayList<Pair<Integer, Integer>> arr = new ArrayList<>();
	        ArrayList<Pair<Integer, Integer>> brr = new ArrayList<>();
	        // Copy elements to temporary arrays
	        for (int i = 0; i < n1; i++) {
	            arr.add(vec.get(i + low));
	        }
	        for (int i = 0; i < n2; i++) {
	            brr.add(vec.get(i + mid + 1));
	        }
	        int i = 0;
	        int j = 0;
	        int k = low;
	        while (i < n1 && j < n2) {
	            if (arr.get(i).first < brr.get(j).first) {
	                // Finding number of next greater elements
	                ans[arr.get(i).second] += n2 - j;
	                vec.set(k, arr.get(i));
	                i++;
	                k++;
	            } else {
	                vec.set(k, brr.get(j));
	                j++;
	                k++;
	            }
	        }
	        while (i < n1) {
	            vec.set(k, arr.get(i));
	            i++;
	            k++;
	        }
	        while (j < n2) {
	            vec.set(k, brr.get(j));
	            j++;
	            k++;
	        }
	 }

	 static class Pair<K,V>{
		K first;
		V second;
		Pair(K first,V second){
			this.first = first;
			this.second = second;
		}
		}
}