package BackTracking;

import java.util.Arrays;

public class AllPathsForMaze {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean[][] board = {
				{true, true, true},{true, true, true},{true, true, true}
		};
		allPath("",board, 0, 0);
		int[][] path = new int[board.length][board[0].length];
		allPathPrint("", board, 0, 0, path, 1);
	}

	private static void allPath(String p, boolean[][] maze, int r, int c) {
		//base case
		if(r == maze.length-1 && c == maze[0].length-1) {
			System.out.println(p);
			return;
		}
		//if there is restriction return
		if(!maze[r][c]){
			return;
		}
		
		//i am considering this block in my path
		//mark it as visited as false
		maze[r][c] = false;
		
		//we cannot go down after last ind
		if(r < maze.length-1) {
			allPath(p + 'D', maze, r+1, c);
		}
		//we cannot go right after last ind
		if(c < maze[0].length-1) {
			allPath(p + 'R', maze, r, c+1);
		}
		if(r > 0) {
			allPath(p + 'U', maze, r-1, c);
		}
		if(c > 0) {
			allPath(p + 'L', maze, r, c-1);
		}
		
		//this line is where the function will be over
		//so before the function get removed, also remove the changes that were made by that function
		//revert back this is the backtracking step
		maze[r][c] = true;
	}
	
	private static void allPathPrint(String p, boolean[][] maze, int r, int c, int[][] path, int step) {
		//base case
		if(r == maze.length-1 && c == maze[0].length-1) {
			path[r][c] = step;
			for(int arr[]:path)
			System.out.println(Arrays.toString(arr));
			System.out.println(p);
			System.out.println();
			return;
		}
		//if there is restriction return
		if(!maze[r][c]){
			return;
		}
		
		//i am considering this block in my path
		//mark it as visited as false
		maze[r][c] = false;
		path[r][c] = step;
		
		//we cannot go down after last ind
		if(r < maze.length-1) {
			allPathPrint(p + 'D', maze, r+1, c, path, step + 1);
		}
		//we cannot go right after last ind
		if(c < maze[0].length-1) {
			allPathPrint(p + 'R', maze, r, c+1, path, step + 1);
		}
		if(r > 0) {
			allPathPrint(p + 'U', maze, r-1, c, path, step + 1);
		}
		if(c > 0) {
			allPathPrint(p + 'L', maze, r, c-1, path, step + 1);
		}
		
		//this line is where the function will be over
		//so before the function get removed, also remove the changes that were made by that function
		//revert back this is the backtracking step
		maze[r][c] = true;
		path[r][c] = 0;
	}
}
