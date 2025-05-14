package BinarySearch;

public class MedianTwoSortedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 int[] a = {1, 4, 7, 10, 12};
	      int[] b = {2, 3, 6, 15};
	       System.out.println("The median of two sorted arrays is " + findMedianSortedArrays(a, b));
	}
	private static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        //the idea is to apply binary search without merging the arrays
        if(nums1.length > nums2.length) return findMedianSortedArrays(nums2,nums1);
        int n = nums1.length;
        int m = nums2.length;
        //keep the low and high in smaller array
        int lo = 0, hi = n;
        while(lo<=hi){
            //find the mid as cut1 and cut2 for nums1 and nums2
            int cut1 = (lo + hi) >> 1;
            int cut2 = (n + m + 1)/2 - cut1;
            //find l1,l2,r1,r2 where l1 is last ele of nums1 before cut1, l2 is last ele of nums2 before cut2
            //r1 is the first ele of nums1 at cut1, and r2 is the first ele of nums2 at cut2
            int l1 = cut1 == 0 ? Integer.MIN_VALUE : nums1[cut1 - 1];
            int l2 = cut2 == 0 ? Integer.MIN_VALUE : nums2[cut2 - 1];
            int r1 = cut1 == n ? Integer.MAX_VALUE : nums1[cut1];
            int r2 = cut2 == m ? Integer.MAX_VALUE : nums2[cut2];

            //to satisfy the sorted cond l1<r2 and l2<r1 (as the arrays are sorted l1<r1 and l2<r2)
            if(l1 > r2){
                //we need to move cut1 to left
                hi = cut1 - 1;
            }
            else if(l2 > r1){
                //we need to move cut1 to right
                lo = cut1 + 1;
            }else{
                //valid cond 
            	//if odd the median will be (max(l1,l2)+min(r1,r2)/2) for even max(l1,l2) if left has more ele
            	//else min(r1,r2)
                return ((n + m) % 2 == 0 ? (Math.max(l1, l2) + Math.min(r1, r2)) / 2.0 : (double)Math.max(l1, l2));
            }
        }
         return -1;
    }

}
