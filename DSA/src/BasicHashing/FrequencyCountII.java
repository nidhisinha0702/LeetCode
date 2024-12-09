package BasicHashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FrequencyCountII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []arr = {2,3,2,3,5};
		List<Integer> ans = frequencyCount(arr);
		System.out.println(ans);
		
		

	}
	 private static List<Integer> frequencyCount(int[] arr) {
	        // do modify in the given array
	        int n = arr.length;
	        List<Integer> hash = new ArrayList<>(Collections.nCopies(n, 0));
	        
	        for(int i=0;i<n;i++){
	           //hash[arr[i] - 1] +=  1;
	        	  Integer val = (Integer) hash.get(arr[i] - 1);
	              val++;
	              hash.set(arr[i]-1,val);
	        }
	        
	        return hash;
	 }

}
