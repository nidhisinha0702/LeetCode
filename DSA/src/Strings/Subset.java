package Strings;

import java.util.ArrayList;

public class Subset {

	//permutations & combinations
	//non-adjacent collections
	//[3,5,9] = [3],[3,5],[3,9],[3,5,9],[5],[9]
	
	private static void subset(String p, String up) {
		if(up.isEmpty()) {
			System.out.println(p);
			return;
		}
		
		char ch = up.charAt(0);
		subset(p+ch, up.substring(1));
		subset(p, up.substring(1));
	}
	
	private static ArrayList<String> subsetRet(String p, String up) {
		
		if(up.isEmpty()) {
			ArrayList<String> ans = new ArrayList<>();
			ans.add(p);
			return ans;
		}
		
		char ch = up.charAt(0);
		ArrayList<String> left = subsetRet(p+ch, up.substring(1));
		ArrayList<String> right = subsetRet(p, up.substring(1));
		
		left.addAll(right);
		return left;
	}
	
	private static void subsetWithAscii(String p, String up) {
		
		if(up.isEmpty()) {
			System.out.println(p);
			return;
		}
		
		char ch = up.charAt(0);
		subsetWithAscii(p+ch, up.substring(1));
		subsetWithAscii(p, up.substring(1));
		subsetWithAscii(p+(ch + 0), up.substring(1));
		
	}
	
	private static ArrayList<String> subsetAsciiRet(String p, String up) {
		
		if(up.isEmpty()) {
			ArrayList<String> ans = new ArrayList<>();
			ans.add(p);
			return ans;
		}
		
		char ch = up.charAt(0);
		ArrayList<String> first = subsetAsciiRet(p+ch, up.substring(1));
		ArrayList<String> second = subsetAsciiRet(p, up.substring(1));
		ArrayList<String> third = subsetAsciiRet(p+(ch+0), up.substring(1));
		
		first.addAll(second);
		first.addAll(third);
		return first;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		subset("","abc");
		System.out.println("subsets are : "+subsetRet("", "abc"));
		subsetWithAscii("","abc");
		System.out.println("subsets with asii: "+subsetAsciiRet("","abc"));
	}

}
