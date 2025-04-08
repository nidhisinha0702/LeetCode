package dpOnLIS;

import java.util.ArrayList;
import java.util.Collections;

public class LISUsingBinarySearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {5, 8, 3, 7, 9, 1};
		System.out.println("The length of the LIS is : "+lis(arr));
	}
	static int lis(int arr[]) {
        // code here
        ArrayList<Integer> temp = new ArrayList<>();
        temp.add(arr[0]);
        int len = 1;
        for(int i=0;i<arr.length;i++){
            if(arr[i] > temp.get(temp.size()-1))
            {
                temp.add(arr[i]);
                len++;
            }else{
                int ind = Collections.binarySearch(temp, arr[i]);
                if(ind<0) ind = -(ind + 1);
                temp.set(ind,arr[i]);
               
            }
        }return len;
    }
}
