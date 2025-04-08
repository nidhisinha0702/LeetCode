package Amazon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AmazonTransactionLogs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> logs = new ArrayList<>();
		logs.add("9 7 50");
		logs.add("22 7 20");
		logs.add("33 7 50");
		logs.add("22 7 30");
		int threshold = 3;
		List<String> ans = processLogs(logs, threshold);
		System.out.println(ans);

	}
	 public static List<String> processLogs(List<String> logs, int threshold) {
		    // Write your code here
		        Map<String,Integer> mpp = new HashMap<>();
		        List<String> ans = new ArrayList<>();
		        
		        //iterate over the list and extract the strings one by one
		        for(String s:logs){
		        	s=s.trim();//trim any prec or dec spaces
		            //put 1st char with its count
		            String c0 = s.substring(0,s.indexOf(" "));
		            String c1 = s.substring(s.indexOf(" "),s.lastIndexOf(" "));
		            mpp.put(c0, mpp.getOrDefault(c0,0)+1);
		            //if we are dealing with same string and the char not match then only put
		            if(!c0.equals(c1)){
		                mpp.put(c1,mpp.getOrDefault(c1,0)+1);
		                
		            }
		        }
		        
		        //iterate over the mpp and validate the values with threashold
		        for(Map.Entry<String,Integer> m:mpp.entrySet()){
		            String key = m.getKey();
		            Integer value = m.getValue();
		            if(value>=threshold){
		                ans.add(key);
		            }
		        }
		        Collections.sort(ans,new stringComp());
		        return ans;
		    }
}

class stringComp implements Comparator<String>{
	@Override
	public int compare(String s1,String s2) {
		Long a = Long.parseLong(s1);
		Long b = Long.parseLong(s2);
		if(a<b) return -1;
		else if(a>b) return 1;
		else return 0;
	}
}
