package BackTracking;

public class AllPathsForMaze {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean[][] board = {
				{true, true, true},{true, true, true},{true, true, true}
		};
		allPath("",board, 0, 0);
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
		//revert back
		maze[r][c] = true;
	}
}
