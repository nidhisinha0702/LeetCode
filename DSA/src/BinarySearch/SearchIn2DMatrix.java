package BinarySearch;

public class SearchIn2DMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [][]matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
		int target = 3;
		System.out.println("Search the target element in 2d matrix::"+searchMatrix(matrix,target));
	}
	 private static boolean searchMatrix(int[][] matrix, int target) {
	        int n = matrix.length;
	        int m = matrix[0].length;
	        int low = 0,high = (n*m) - 1;
	        while(low<=high){
	            int mid = (low + high)/2;
	            int row = mid/m;
	            int col = mid%m;
	            if(matrix[row][col]==target) return true;
	            else if(matrix[row][col]>target)   high = mid - 1;
	            else
	                low = mid + 1;
	        }return false;
	    }

}
