package Strings;

import java.util.ArrayList;

public class Permutations {

	private static void perm(String p, String up) {
		//base condition
		if(up.isEmpty()) {
			System.out.println(p);
			return;
		}
		
		char ch = up.charAt(0);
		
		int size = p.length() + 1;
		
		for(int i=0;i<size;i++) {
			String first = p.substring(0,i);
			String second = p.substring(i, p.length());
			perm(first+ch+second, up.substring(1));
		}
	}
	
	private static ArrayList<String> permutation(String p, String up) {
		//base condition
		if(up.isEmpty()) {
			ArrayList<String> list = new ArrayList<>();
			list.add(p);
			return list;
		}
		
		char ch = up.charAt(0);
		
		ArrayList<String> ans = new ArrayList<>();
		
		int size = p.length() + 1;
		
		for(int i=0;i<size;i++) {
			String first = p.substring(0,i);
			String second = p.substring(i, p.length());
			ans.addAll(permutation(first+ch+second, up.substring(1)));
		}
		return ans;
	}
	
	private static int permCount(String p, String up) {
		//base condition
		if(up.isEmpty()) {
			return 1;
		}
		
		char ch = up.charAt(0);
		
		int size = p.length() + 1;
		
		int count = 0;
		
		for(int i=0;i<size;i++) {
			String first = p.substring(0,i);
			String second = p.substring(i, p.length());
			count = count + permCount(first+ch+second, up.substring(1));
		}
		return count;
	}
	
	public static void main(String[] args) {
		// WAP to find the permutation of a string
		String s = "abc";
		perm("",s);
		System.out.println("permutations are : "+permutation("",s));
		System.out.println("number of permutations are : "+permCount("","abcd"));
	}

}
