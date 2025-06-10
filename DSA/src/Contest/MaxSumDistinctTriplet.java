package Contest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class MaxSumDistinctTriplet {

	private static int macSumDistinctTriplet(int[] x, int[] y) {
		//the idea is to store x[i],y[i] val in map and then try to store max value of y if duplicate occurs in x
		Map<Integer, Integer> mpp = new HashMap<>();
		int n = x.length;
		for(int i=0;i<n;i++) {
			int val = y[i];
			mpp.compute(x[i], (k,v)-> v == null ? val : Math.max(v, val));
		}
		
		if(mpp.size() < 3) return -1;
		//next sort the y val
		ArrayList<Integer> ans = new ArrayList<>();
		for(Map.Entry<Integer, Integer> entry: mpp.entrySet()) {
			ans.add(entry.getValue());
		}
		Collections.reverseOrder(new valComparator());
		return ans.get(0) + ans.get(1) + ans.get(2);
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x[] = {19,15,7,13}, y[] = {13,11,13,11};
		System.out.println("The max sum is : "+macSumDistinctTriplet(x,y));

	}

}

class valComparator implements Comparator<Integer>{
	
	@Override
	public int compare(Integer a, Integer b) {
		if(a<b) return 1;
		else if(a>b) return -1;
		else return 0;
	}
	
}
