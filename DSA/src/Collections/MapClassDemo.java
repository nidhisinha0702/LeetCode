package Collections;

import java.util.HashMap;
import java.util.Map;

public class MapClassDemo {

	public static void main(String[] args) {
		// WAP to demo MAP new methods
		Map<String, Integer> mpp = new HashMap<>();
		mpp.put("Alice", 80);
		//only update if Alice exists
		mpp.computeIfPresent("Alice",(k,v) -> Math.max(v, 90));
		//This line will do nothing if key is not present
		mpp.computeIfPresent("Bob", (k,v)-> Math.max(v, 75));
		System.out.println(mpp);
		
		Map<String, Integer> scores = new HashMap<>();
		scores.put("Bob", 95);
		//Adds only if Absent
		scores.computeIfAbsent("Bob", k->85);
		System.out.println(scores);
		
		Map<Integer, Integer> map = new HashMap<>();
		int x[] = {19,15,7,13}, y[] = {13,11,13,11};
		for(int i=0;i<x.length;i++) {
			//compute
			int val = y[i];
			map.compute(x[i], (k,v)-> v==null? val:Math.max(v, val));
		}
		System.out.println(map);
	}

}
