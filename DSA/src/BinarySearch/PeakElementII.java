package BinarySearch;

public class PeakElementII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int mat[][] = {{1,4},{3,2}};
		int ans[] = findPeakGrid(mat);
		for(int a: ans) {
		System.out.println("The peak element in a 2d matrix is::"+a);
		}
	}
	 private static int[] findPeakGrid(int[][] mat) {
	        int n = mat.length;
	        int m = mat[0].length;
	        int low = 0;
	        int high = m-1;
	        while(low<=high){
	            int mid = (low + high)/2;
	            int row = maxElementRow(mat,n,mid);
	            int left = mid - 1 >= 0 ? mat[row][mid-1]:-1;
	            int right = mid + 1 < m ? mat[row][mid + 1]:-1;
	            if(mat[row][mid]>left && mat[row][mid]>right) return new int[]{row,mid};
	            else if(mat[row][mid]<left) high = mid - 1;
	            else low = mid + 1;
	        }return new int[]{-1,-1};

	    }
	    private static int maxElementRow(int[][] mat, int n, int col){
	        int maxi = -1;
	        int ind = -1;
	        for(int i = 0;i<n;i++){
	            if(mat[i][col]>maxi){
	                maxi = mat[i][col];
	                ind = i;
	            }
	        }
	        return ind;
	    }
}
