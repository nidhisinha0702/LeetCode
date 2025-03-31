package graph;

public class FloodFill {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] image = {{1,1,1},{1,1,0},{1,0,1}};
		int sr = 1, sc = 1, color = 2;
		int[][] ans = floodFill(image, sr, sc, color);
		for(int i=0;i<ans.length;i++) {
			for(int j=0;j<ans[0].length;j++) {
				System.out.print(ans[i][j]+" ");
			}
		}
		/*
		 * for(int row[]:ans) { for(int r:row) { System.out.print(r+" "); } }
		 */
	}
	
	private static int[][] floodFill(int[][] image, int sr, int sc, int color){
		//check the initial color of the box
		int iniColor = image[sr][sc];
		//create a new and mat for returning result
		int[][] ans = image;
		//create delrow and delcol for movements
		int delrow[] = {0,0,-1,1};
		int delcol[] = {-1,1,0,0};
		dfs(sr,sc,ans,image,color,delrow,delcol,iniColor);
		return ans;
	}
	
	private static void dfs(int row, int col,int[][] ans, int[][] image,  int newColor, int[] delrow, int[] delcol, int iniColor) {
		//color the initial box with newColor
		ans[row][col] = newColor;
		int n = image.length;
		int m = image[0].length;
		//iterate for 4 directions
		for(int i=0;i<4;i++) {
			//calculate the new adjacent nodes
			int nrow = row + delrow[i];
			int ncol = row + delcol[i];
			//check for boundary conditions, if the imagebox is filled with initialColor, and ans box is not colored with newColor
			if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && image[nrow][ncol]==iniColor && ans[nrow][ncol]!= newColor)
				dfs(nrow,ncol,ans,image,newColor,delrow,delcol,iniColor);
		}
	}
}
