package Stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NextGreaterElementIII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nums1[] = {4,1,2};
		int nums2[] = {1,3,4,2};
		int ans[] = nextGreaterElement(nums1,nums2);
		for(int a:ans)
			System.out.print(a+" ");

	}
	 private static int[] nextGreaterElement(int[] nums1, int[] nums2) {
	        int n1 = nums1.length;
	        int n2 = nums2.length;
	        int nge[] = new int [n1];
	        Stack<Integer> st = new Stack<>();
		    Map<Integer,Integer> hm = new HashMap<>();
		    for(int i=n2-1;i>=0;i--) {
		    	while(!st.isEmpty() && st.peek()<=nums2[i]) {
		    		st.pop();
		    	}if(st.isEmpty()) {
		    		hm.put(nums2[i], -1);
		    	}else	hm.put(nums2[i], st.peek());
		    	st.push(nums2[i]);
		    }
		    
		    for(int j=0;j<n1;j++) {
		    	if(hm.containsKey(nums1[j])) {
		    		nge[j]=hm.getOrDefault(nums1[j], -1);
		    	}
		    }
		    return nge;
	 }
}
