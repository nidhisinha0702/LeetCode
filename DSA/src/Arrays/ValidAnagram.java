package Arrays;

public class ValidAnagram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Check if the string are anagram: "+isAnagram("xx","bb"));

	}
	private static boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        int freq[] = new int[26];
        for(int i=0;i<s.length();i++){
            freq[s.charAt(i)-'a']++;
            freq[t.charAt(i)-'a']--;
        }
       
        for(int val:freq){
            if(val!=0)
                return false;
        }return true;
    }
}
