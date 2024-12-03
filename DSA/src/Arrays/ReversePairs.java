package Arrays;
//School is organizing a team contest. You are given an array ‘SKILL’ containing the skill level of ‘N’ candidates.
//
//
//
//Two candidates(having index ‘i’ and ‘j’) can pair up to form a team if for index i < j, SKILL[i] > 2*SKILL[j].
//
//Your task is the return the count of all the possible pairs to take part in the contest.
import java.util.ArrayList;

public class ReversePairs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long[] nums = {2147483647,2147483647,2147483647,2147483647,2147483647,2147483647};
		int n = nums.length;
		int count = mergeSort(nums,0,n-1);
		System.out.println("Reverse count pairs are:: "+count);
	}
	private static int countReversePair(long[] arr,int low,int mid,int high){
	int cnt = 0;
	int right = mid + 1;
		for(int i=low;i<=mid;i++){
		    while(right<=high && arr[i]> 2*arr[right]) right++;
		    cnt += (right - (mid+1));
		  }return cnt;
	}
	private static int mergeSort(long[] arr, int low, int high) {
		int cnt = 0;
		   if (low >= high) return cnt;
		   int mid = (low + high) / 2 ;
		   cnt += mergeSort(arr, low, mid);  // left half
		   cnt += mergeSort(arr, mid + 1, high); // right half
		   cnt += countReversePair(arr,low,mid,high);
		   merge(arr, low, mid, high);  // merging sorted halves
		   return cnt;
		 }
	private static void merge(long[] arr, int low, int mid, int high) {
		ArrayList<Long> temp = new ArrayList<>(); // temporary array
		    int left = low;      // starting index of left half of arr
		    int right = mid + 1;   // starting index of right half of arr

		    //storing elements in the temporary array in a sorted manner//

		     while (left <= mid && right <= high) {
		            if (arr[left] <= arr[right]) {
		                temp.add(arr[left]);
		                left++;
		            } else {
		                temp.add(arr[right]);
		                right++;
		            }
		        }

		        // if elements on the left half are still left //

		        while (left <= mid) {
		            temp.add(arr[left]);
		            left++;
		        }

		        //  if elements on the right half are still left //
		        while (right <= high) {
		            temp.add(arr[right]);
		            right++;
		        }

		        // transfering all elements from temporary to arr //
		        for (int i = low; i <= high; i++) {
		            arr[i] = temp.get(i - low);
		        }
		    }

}
