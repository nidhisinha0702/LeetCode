package BinarySearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SingleNonDuplicateII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> l = new ArrayList(Arrays.asList(1,1,2,2,4,5,5));
		int ans = singleNonDuplicate(l);
		System.out.println("The single element is :"+ans);
		

	}
	private static int singleNonDuplicate(List<Integer> arr)
    {
        //    Write your code here.
        int n = arr.size();
        //if the size of the array is 1
        if(n == 1) return arr.get(0);
        //for 0 and n-1 indexes avoid unnecessary edge cases
        if(!arr.get(0).equals(arr.get(1))) return arr.get(0);
        if(!arr.get(n-1).equals(arr.get(n-2))) return arr.get(n-1);
        int low = 1;
        int high = n-2;
        //basic binary search
        while(low<=high){
            int mid = (low + high)/2;
            //if previous element and the next element are different then its the single element
            if((!arr.get(mid).equals(arr.get(mid-1))) && 
            (!arr.get(mid).equals(arr.get(mid + 1))))
                return arr.get(mid);
            //if I am standing on the left then the element is on the right 
            //so eliminate the left
            if((mid % 2 == 1 && arr.get(mid).equals(arr.get(mid - 1)))||
              (mid % 2 == 0 && arr.get(mid).equals(arr.get(mid + 1)))){
                low = mid + 1;
            }
            else{
                //I am on the right half and my element is on the left half
                high = mid - 1;
            }
        }return -1;

    }

}
