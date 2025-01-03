package greedy;

import java.util.Arrays;

public class AssignCookies {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int greedy[] = {1,2,3};
		int cookie[] = {1,1};
		System.out.println("The minimum size of a cookie that the child will be content with::"+findContentChildren(greedy,cookie));

	}
	private static int findContentChildren(int[] g, int[] s) {
        int n = g.length;
        int m = s.length;
        Arrays.sort(g);
        Arrays.sort(s);
        int l=0,r=0;
        while(l<m && r<n){
            if(g[r]<=s[l]) r=r+1;
            l += 1;
        }return r;
    }

}
