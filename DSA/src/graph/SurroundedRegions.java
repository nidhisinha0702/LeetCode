package graph;

public class SurroundedRegions {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char board[][] = {{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}};
		solve(board);
		for(int i=0;i<board.length;i++) {
			for(int j=0;j<board[0].length;j++) {
				System.out.print(board[i][j]+" ");
			}System.out.println();
		}

	}
	private static void solve(char[][] board) {
        //the algo will be to check the boundary 0's and mark them as they will not be converted
        //convert the remaining 0's to x's
        int n = board.length;
        int m = board[0].length;
        int vis[][] = new int[n][m];
        int delrow[] = {0, -1, 0, 1};
        int delcol[] = {1, 0, -1, 0};

        //traverse in the boundary rows
        for(int j = 0; j < m;j++){
            if(vis[0][j] == 0 && board[0][j] == 'O'){
                dfs(0, j, vis, board, delrow, delcol);
            }
            if(vis[n-1][j] == 0 && board[n-1][j] == 'O'){
                dfs(n-1, j, vis, board, delrow, delcol);
            }
        }
        //traverse in boundary column
        for(int i = 0; i < n; i++){
            if(vis[i][0] == 0 && board[i][0] == 'O'){
                dfs(i, 0, vis, board, delrow, delcol);
            }
            if(vis[i][m-1] == 0 && board[i][m-1] == 'O'){
                dfs(i, m-1, vis, board, delrow, delcol);
            }
        }

        //conert remaining 0's to X's
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(vis[i][j] == 0 && board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
            }
        }
    }

    private static void dfs(int row, int col, int vis[][], char board[][], int delrow[], int delcol[]){
        int n = board.length;
        int m = board[0].length;

        vis[row][col] = 1;

        for(int i=0;i<4;i++){
            int nrow = row + delrow[i];
            int ncol = col + delcol[i];
            if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && vis[nrow][ncol]==0 && board[nrow][ncol] == 'O'){
                dfs(nrow,ncol,vis,board,delrow,delcol);
            }
        }
    }
}
