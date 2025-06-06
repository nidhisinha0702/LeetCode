package Strings;

import java.util.ArrayList;
import java.util.List;

public class PhonePad {

	private static void pad(String p, String up) {
		//base condition
		if(up.isEmpty()) {
			System.out.print(p+" ");
			return;
		}
		
		//extract the first char and convert it to int
		int digit = up.charAt(0) - '0';
		
		//for loop for variable recursion calls
		//1->(abc)-(0,1,2), 2->(def)-(3,4,5), 3->(ghi)-(6,7,8)
		//its making a set of 3 so multiply by 3
		for(int i=((digit - 1)*3); i< digit * 3;i++) {
			char ch = (char)('a' + i);
			pad(p + ch, up.substring(1));
		}
		
	}
	
	private static ArrayList<String> padRet(String p, String up) {
		//base condition
		if(up.isEmpty()) {
			ArrayList<String> list = new ArrayList<>();
			list.add(p);
			return list;
		}
		
		//extract the first char and convert it to int
		int digit = up.charAt(0) - '0';
		
		ArrayList<String> list = new ArrayList<>();
		//for loop for variable recursion calls
		//1->(abc)-(0,1,2), 2->(def)-(3,4,5), 3->(ghi)-(6,7,8)
		//its making a set of 3 so multiply by 3
		for(int i=((digit - 1)*3); i< digit * 3;i++) {
			char ch = (char)('a' + i);
			list.addAll(padRet(p + ch, up.substring(1)));
		}
		return list;
	}
	
	private static int padCount(String p, String up) {
		//base condition
		if(up.isEmpty()) {
			return 1;
		}
		int count = 0;
		//extract the first char and convert it to int
		int digit = up.charAt(0) - '0';
		
		//for loop for variable recursion calls
		//1->(abc)-(0,1,2), 2->(def)-(3,4,5), 3->(ghi)-(6,7,8)
		//its making a set of 3 so multiply by 3
		for(int i=((digit - 1)*3); i< digit * 3;i++) {
			char ch = (char)('a' + i);
			count = count + padCount(p + ch, up.substring(1));
		}
		return count;
	}
	
	 public static List<String> letterCombinations(String digits) {
	        if(digits.isEmpty()) return new ArrayList<>();
	       return helper("",digits);
	    }
	    private static ArrayList<String> helper(String p, String up) {
	     //base condition
			if(up.isEmpty()) {
				ArrayList<String> list = new ArrayList<>();
				list.add(p);
				return list;
			}
			
			//extract the first char and convert it to int
			int digit = up.charAt(0) - '0';
			
			ArrayList<String> list = new ArrayList<>();
			//for loop for variable recursion calls
			//2->(abc)-(0,1,2), 3->(def)-(3,4,5), 4->(ghi)-(6,7,8)
			//its making a set of 3 so multiply by 3
	        //7->(pqrs)-(15,16,17,18), 8->(tuv)-(19,20,21),9->(22,23,24,25) 

	        int start = ((digit - 2)*3);
	        int end = ((digit-1) * 3);
	        //for 8 and 9 start is 1 greater
	        if(digit > 7){
	            start += 1;
	            end += 1;
	        }
	        //for both 7 and 9 there are 4 letters
	        if(digit == 7 || digit == 9){
	            end += 1;
	        }
			for(int i= start; i<end ;i++) {
				char ch = (char)('a' + i);
				list.addAll(helper(p + ch, up.substring(1)));
			}
			return list;
	    }
	
	public static void main(String[] args) {
		// WAP to return the phone pad combinations
		pad("","12");
		System.out.println();
		System.out.println("subset combinations are : "+padRet("","12"));
		System.out.println("number of combination : "+padCount("","12"));
		System.out.println("Leetcode letter combination : "+letterCombinations("68"));
	}

}
