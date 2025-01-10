package BasicRecursion;

import java.util.ArrayList;
import java.util.Arrays;

public class RatInAMaze {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<ArrayList<Integer>> mat = new ArrayList<>();
		mat.add(new ArrayList<>(Arrays.asList(1,0,0,0)));
		mat.add(new ArrayList<>(Arrays.asList(1,1,0,1)));
		mat.add(new ArrayList<>(Arrays.asList(1,1,0,0)));
		mat.add(new ArrayList<>(Arrays.asList(0,1,1,1)));
		
		ArrayList<String> ans = findPath(mat);
		System.out.println("The the rat can do in these directions::"+ans);

	}
	  private static ArrayList<String> findPath(ArrayList<ArrayList<Integer>> mat) {
	        // code here
	        int m = mat.size();
	        int n = mat.get(0).size();
	        int vis[][] = new int[n][n];
	        for(int i=0;i<n;i++){
	            for(int j=0;j<n;j++){
	                vis[i][j]=0;
	            }
	        }
	      
	        ArrayList<String> ans = new ArrayList<>();
	        if(mat.get(0).get(0) == 1) solve(0,0,mat,m,n,ans,"",vis);
	        return ans;
	    }
	    
	    private static void solve(int i,int j,ArrayList<ArrayList<Integer>> mat, int m,int n, ArrayList<String> ans,String move,int vis[][]){
	        //base case
	        if(i == n-1 && j == n-1){
	            ans.add(move);
	            return;
	        }
	        
	        //downward
	        if(i+1<n && vis[i+1][j]==0 && mat.get(i+1).get(j) == 1){
	            vis[i][j]=1;
	            solve(i+1,j,mat,m,n,ans,move+"D",vis);
	            vis[i][j]=0;
	        }
	        //left
	        if(j-1>=0 && vis[i][j-1]==0 && mat.get(i).get(j-1) == 1){
	            vis[i][j]=1;
	            solve(i,j-1,mat,m,n,ans,move+"L",vis);
	            vis[i][j]=0;
	        }
	        //right
	        if(j+1<n && vis[i][j+1]==0 && mat.get(i).get(j+1) == 1){
	            vis[i][j]=1;
	            solve(i,j+1,mat,m,n,ans,move+"R",vis);
	            vis[i][j]=0;
	        }
	        //upward
	        if(i-1>=0 && vis[i-1][j]==0 && mat.get(i-1).get(j) == 1){
	            vis[i][j]=1;
	            solve(i-1,j,mat,m,n,ans,move+"U",vis);
	            vis[i][j]=0;
	        }
	    }
}
