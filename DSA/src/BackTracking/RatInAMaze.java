package BackTracking;

import java.util.ArrayList;

public class RatInAMaze {

	public static void main(String[] args) {
		//WAP to count the number of ways rat reaches other end in a 2-d maze
//		System.out.println(count(3, 3));
//		path("",3, 3);
//		System.out.println(pathRet("",3, 3));
//		System.out.println(pathRetDiagonal("", 3, 3));
		boolean board[][] = {
				{true, true, true},{true, false, true},{true, true, true}
		};
		pathRestrictions("", board, 0, 0);
	}

	private static int count(int r, int c) {
		if(r == 1 || c == 1) return 1;
		
		int left = count(r-1, c);
		int right = count(r, c-1);
		
		return left + right;
	}
	
	private static void path(String p, int r, int c) {
		//base case
		if(r == 1 && c == 1) {
			System.out.println(p);
			return;
		}
		
		if(r > 1) {
			path(p + 'D', r-1, c);
		}
		if(c > 1) {
			path(p + 'R', r, c-1);
		}
	}
	
	private static ArrayList<String> pathRet(String p, int r, int c) {
		//base case
		if(r == 1 && c == 1) {
			ArrayList<String> list = new ArrayList<String>();
			list.add(p);
			return list;
		}
		
		ArrayList<String> l = new ArrayList<String>();
		
		if(r > 1) {
			l.addAll(pathRet(p + 'D', r-1, c));
		}
		if(c > 1) {
			l.addAll(pathRet(p + 'R', r, c-1));
		}
		
		return l;
	}
	//we can go diagonally as well
	private static ArrayList<String> pathRetDiagonal(String p, int r, int c) {
		//base case
		if(r == 1 && c == 1) {
			ArrayList<String> list = new ArrayList<String>();
			list.add(p);
			return list;
		}
		
		ArrayList<String> l = new ArrayList<String>();
		
		if(r > 1 && c > 1) {
			l.addAll(pathRetDiagonal(p + 'D', r-1, c-1));
		}
		if(r > 1) {
			l.addAll(pathRetDiagonal(p + 'V', r-1, c));
		}
		if(c > 1) {
			l.addAll(pathRetDiagonal(p + 'H', r, c-1));
		}
		
		return l;
	}
	
	private static void pathRestrictions(String p, boolean[][] maze, int r, int c) {
		//base case
		if(r == maze.length-1 && c == maze[0].length-1) {
			System.out.println(p);
			return;
		}
		//if there is restriction return
		if(!maze[r][c]){
			return;
		}
		//we cannot go down after last ind
		if(r < maze.length-1) {
			pathRestrictions(p + 'D', maze, r+1, c);
		}
		//we cannot go right after last ind
		if(c < maze[0].length-1) {
			pathRestrictions(p + 'R', maze, r, c+1);
		}
	}
}
