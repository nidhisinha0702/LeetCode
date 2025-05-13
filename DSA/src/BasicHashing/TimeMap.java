package BasicHashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TimeMap {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TimeMap tm = new TimeMap();
		tm.set("alice", "happy", 1);
		System.out.println(tm.get("alice", 1));
		System.out.println(tm.get("alice", 2));
		tm.set("alice", "sad", 3);
		System.out.println(tm.get("alice", 3));
		
	}
		   Map<String, List<Pair<String,Integer>>> mpp;
		    public TimeMap() {
		        mpp = new HashMap<>();
		    }
		    
		    public void set(String key, String value, int timestamp) {
		       //we will use put pair(val,time)
		       mpp.computeIfAbsent(key, k -> new ArrayList<>()).add(new Pair<>(value,timestamp));
		    }
		    
		    public String get(String key, int timestamp) {
		        String res = "";
		        //below code returns list of pair if exists and empty list if does not
		        List<Pair<String,Integer>> values = mpp.getOrDefault(key, new ArrayList<>());

		        //binary search
		        int l=0,r=values.size() - 1;
		        while(l <= r){
		            int m = (l + r) >> 1;
		            if(values.get(m).getTime() <= timestamp){
		                res = values.get(m).getVal();
		                l = m + 1;
		            }else{
		                r = m - 1;
		            }
		        }return res;
		    }
}

class Pair<K,V>{
	private final K val;
	private final V time;

	public Pair(K _val, V _time) {
		val = _val;
		time = _time;
	}

	public K getVal() {
		return val;
	}

	public V getTime() {
		return time;
	}
}
