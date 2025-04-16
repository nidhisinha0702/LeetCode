package Strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String strs[] = {"act","pots","tops","cat","stop","hat"};
		List<List<String>> ans = groupAnagrams(strs);
		System.out.println(ans);

//Output: [["hat"],["act", "cat"],["stop", "pots", "tops"]]
	}
	private static List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> mpp = new HashMap<>();
        for(String s:strs){
            int freq[] = new int[26];
            for(char c : s.toCharArray()){
                freq[c-'a']++;
            }
            String key = Arrays.toString(freq);
            mpp.putIfAbsent(key, new ArrayList<>());
            mpp.get(key).add(s);
        }return new ArrayList<>(mpp.values());
    }
}
