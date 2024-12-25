package dynamicProgramming;

import java.util.Arrays;

public class MinimumFallingPathSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int matrix[][] = {{2,1,3},{6,5,4},{7,8,9}};
		int n = matrix.length;
		int m = matrix[0].length;
		System.out.println("The minimum paths with falling path sum is ::"+minFallingPathSum(matrix));

	}
	private static int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
		int m = matrix[0].length;

        int prev[] = new int[m];
        Arrays.fill(prev,0);

        for(int j=0;j<m;j++){
            prev[j]=matrix[0][j];
        }
        for(int i=1;i<n;i++){
            int cur[] = new int[m];
            Arrays.fill(cur,0);
            for(int j=0;j<m;j++){
                int up = matrix[i][j] + prev[j];
                int ld = matrix[i][j];
                if(j-1>=0) ld += prev[j-1];
                else ld += (int)1e9;
                int rd = matrix[i][j];
                if(j+1<m) rd += prev[j+1];
                else rd += (int)1e9;
                cur[j]=Math.min(up,Math.min(ld,rd));
            }prev = cur;
        }
		int mini = Integer.MAX_VALUE;
		for(int j=0;j<m;j++){
			mini = Math.min(mini,prev[j]);
		}return mini;
    }
}
