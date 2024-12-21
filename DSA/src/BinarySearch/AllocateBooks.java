package BinarySearch;
//Allocate Books, Painters Partition Problem, Largest Subarray sum is minimized
import java.util.ArrayList;
import java.util.Arrays;

public class AllocateBooks {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(12,34,67,90));
		int n = 4;
		int m = 2;
		int ans = findPages(arr,n,m);
		System.out.println("The maximum number of pages assigned to a student is minimum: "+ans);
	}
	 public static int findPages(ArrayList<Integer> arr, int n, int m) {
	        // Write your code here
	         if(n<m) return -1;
	        int low = 0;
	        int high = 0;
	        for(int i=0;i<n;i++){
	            low = Math.max(low,arr.get(i));
	            high += arr.get(i);
	        }
	        while(low<=high){
	            int mid = (low + high)/2;
	            int noOfStu = allocateStudent(arr,mid);
	            if(noOfStu>m) low = mid + 1;
	            else high = mid - 1;
	        }return low;
	    }

	    private static int allocateStudent(ArrayList<Integer> arr,int pages){
	        int stu = 1;
	        int noOfPages = 0;
	        for(int i=0;i<arr.size();i++){
	            if(noOfPages + arr.get(i) <= pages){
	                noOfPages +=arr.get(i);
	            }else{
	                stu++;
	                noOfPages = arr.get(i);
	            }
	        }return stu;
	    }

}
