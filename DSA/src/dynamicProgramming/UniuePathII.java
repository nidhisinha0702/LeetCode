package dynamicProgramming;

import java.util.Arrays;

public class UniuePathII {
		// TODO Auto-generated method stub
    public static void main(String args[]) {
        // Define the maze
        int[][] maze = {
            {0,1}
        };

        int n = maze.length;
        int m = maze[0].length;

        // Calculate and print the number of paths through the maze
        System.out.println(uniquePathsWithObstacles(maze));
    }
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;

        int prev[] = new int[m];
        Arrays.fill(prev,-1);
        for(int i=0;i<n;i++){
            int curr[] = new int[m];
            // Arrays.fill(prev,0);
            for(int j=0;j<m;j++){
                if(obstacleGrid[i][j] == 1) curr[j]=0;
                else if (i == 0 && j==0) curr[j]=1;
                else{
                    int up =0;
                    int left = 0;
                    if(i>0) up = prev[j];
                    if(j>0) left = curr[j-1];
                    curr[j] = (up + left);
                }
            }prev = curr;
        }return prev[m-1];
    }
}

