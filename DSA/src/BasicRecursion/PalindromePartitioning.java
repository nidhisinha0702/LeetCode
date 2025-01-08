package BasicRecursion;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s="aabb";
		List<List<String>> ans = partition(s);
		System.out.println("The the palindrome partitions are: "+ans);

	}
	private static List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> path = new ArrayList<>();
        func(0,s,res,path);
        return res;
    }
    private static void func(int ind,String s,List<List<String>> res,List<String> path ){
        //base case
        if(ind == s.length()){
            res.add(new ArrayList<>(path));
            return;
        }
        //we can start partitioning from ind 0 to size
        for(int i=ind;i<s.length();i++){
            //the substring is palindrom
            if(isPalindrome(s,ind,i)){
                path.add(s.substring(ind,i+1));
                func(i+1,s,res,path);
                path.remove(path.size()-1);
            }
        }
    }

    private static boolean isPalindrome(String s,int start,int end){
        while(start<=end){
            if(s.charAt(start++) != s.charAt(end--))
                return false;
        }return true;
    }
}
