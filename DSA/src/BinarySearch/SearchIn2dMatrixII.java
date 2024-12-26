package BinarySearch;

public class SearchIn2dMatrixII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = {{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
		int target = 5;
		System.out.println("search element where rows are sorted in ascending order from left to right and columns are sorted in ascending order from top to bottom::"+searchMatrix(matrix,target));

	}
	private static boolean searchMatrix(int[][] matrix, int target) {
		int n = matrix.length;
		int m = matrix[0].length;
		int row = n-1, col = 0;
		while(row >= 0 && col < m) {
			if(matrix[row][col] == target) return true;
			else if(matrix[row][col] < target) col++;
			else row--;
		}return false;
	}

}
