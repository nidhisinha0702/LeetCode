package BinarySearch;

import java.util.ArrayList;
import java.util.Arrays;

public class RowWithMax1s {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<ArrayList<Integer>> mat = new ArrayList<>();
		mat.add(new ArrayList<>(Arrays.asList(1,1,1)));
		mat.add(new ArrayList<>(Arrays.asList(0,0,1)));
		mat.add(new ArrayList<>(Arrays.asList(0,0,0)));
		System.out.println("The row with max 1s are:: "+rowMaxOnes(mat,3,3));

	}
	public static int rowMaxOnes(ArrayList<ArrayList<Integer>> mat, int n, int m) {
        int cnt_max = 0;
        int ind = -1;
        for(int i=0;i<n;i++){
            int cnt_ones = m - lowerBound(mat.get(i),m,1);
            if(cnt_ones>cnt_max){
                cnt_max = cnt_ones;
                ind = i;
            }
        }return ind;
    }
     private static int lowerBound(ArrayList<Integer> arr,int m, int x){
        int low = 0;
        int high = m-1;
        while(low<=high){
            int mid = (low+ high)/2;
            if(arr.get(mid) >= x){
                high = mid - 1;
            }else
            low = mid + 1;
        }return low;
    }
}
