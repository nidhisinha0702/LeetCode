package BasicRecursion;

import java.util.ArrayList;
import java.util.Arrays;

public class RatInAMazeII {

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
	        int di[]={+1,0,0,-1};
	        int dj[]={0,-1,1,0};
	      
	        ArrayList<String> ans = new ArrayList<>();
	        if(mat.get(0).get(0) == 1) solve(0,0,mat,m,n,ans,"",vis,di,dj);
	        return ans;
	    }
	    
	    private static void solve(int i,int j,ArrayList<ArrayList<Integer>> mat, int m,int n, ArrayList<String> ans,String move,int vis[][],int di[],int dj[]){
	        //base case
	        if(i == n-1 && j == n-1){
	            ans.add(move);
	            return;
	        }
	        String dir = "DLRU";
	        for(int ind=0;ind<4;ind++){
	            int nexti = i+di[ind];
	            int nextj = j+dj[ind];
	            if(nexti>=0 && nextj>=0 && nexti<n && nextj<n && vis[nexti][nextj] == 0 && mat.get(nexti).get(nextj) == 1){
	                vis[i][j]=1;
	                solve(nexti,nextj,mat,m,n,ans,move+dir.charAt(ind),vis,di,dj);
	                vis[i][j]=0;
	            }
	        }
	    }
	    
}
