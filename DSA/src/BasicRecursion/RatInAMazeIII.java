package BasicRecursion;

import java.util.ArrayList;
import java.util.Arrays;

public class RatInAMazeIII {

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
	       
	        int di[]={+1,0,0,-1};
	        int dj[]={0,-1,1,0};
	      
	        ArrayList<String> ans = new ArrayList<>();
	        if(mat.get(0).get(0) == 1) solve(0,0,mat,m,n,ans,"",di,dj);
	        return ans;
	    }
	    
	    private static void solve(int i,int j,ArrayList<ArrayList<Integer>> mat, int m,int n, ArrayList<String> ans,String move,int di[],int dj[]){
	        //base case
	        if(i == n-1 && j == n-1){
	            ans.add(move);
	            return;
	        }
	        String dir = "DLRU";
	        for(int ind=0;ind<4;ind++){
	            int nexti = i+di[ind];
	            int nextj = j+dj[ind];
	            if(nexti>=0 && nextj>=0 && nexti<n && nextj<n && mat.get(nexti).get(nextj) == 1){
	                mat.get(i).set(j, 0);
	                solve(nexti,nextj,mat,m,n,ans,move+dir.charAt(ind),di,dj);
	                mat.get(i).set(j, 1);
	            }
	        }
	    }
	    
}

