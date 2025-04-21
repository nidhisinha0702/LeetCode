package Strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EncodeDecode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> strs = new ArrayList<>(Arrays.asList("neet","code","love","you"));
		String s = encode(strs);
		System.out.println("the encoded string is : "+s);
		List<String> ans = decode(s);
		System.out.println("the decode of string is "+ans);

	}
	private static String encode(List<String> strs) {
        StringBuilder res = new StringBuilder();
        //4#lint 5#co#de
        for(String s:strs){
            res.append(s.length()).append('#').append(s);
        }
        return res.toString();
    }

    private static List<String> decode(String str) {
        List<String> res = new ArrayList<>();
        int i=0;//at start idx
        while(i<str.length()){
            int j=i;//initialize j at i
            while(str.charAt(j)!='#'){
                j++;//till we find #
            }
            //find the length of that string
            int length = Integer.parseInt(str.substring(i,j));
            i=j+1;//move i to the start of s
            j=i+length;//move j to end of s
            res.add(str.substring(i,j));//substring and add to res
            i=j;//move i to j for next s
        }return res;
    }
}
