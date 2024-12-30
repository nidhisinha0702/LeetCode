package BasicRecursion;

import java.util.ArrayList;
import java.util.Collections;

public class AllPossString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s="gfg";
		ArrayList<String>ans = AllPossibleStrings(s);
		//printint all the subsequence.
		System.out.println("All possible subsequences are ");
		for (String it : ans) {
			System.out.print( it+" ");
		}

	}
	private static ArrayList<String> AllPossibleStrings(String str1) {
		
		ArrayList<String> ans = new ArrayList<>();
		int n = str1.length();
		for(int num=0;num<(1<<n);num++) {
			String sub = "";
			for(int i=0;i<n;i++) {
				if((num & (1 << i)) != 0){ 
                    sub+=str1.charAt(i);
                }
			}
			if(sub.length()>0) ans.add(sub);
		}Collections.sort(ans);
		return ans;
	}

}
