package collection_framework;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class hashmap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<Integer, String> c= new HashMap<>();
		c.put(1,"A");
		c.put(2,"B");
		c.put(3,"C");
		c.put(10,"Deepali");
		c.putIfAbsent(7,"f");
		System.out.println(c.isEmpty());
		System.out.println(c);
		c.remove(3);
		System.out.println(c);
		
		for(Integer d: c.keySet()) {
			System.out.print(d+" ");
		}
		System.out.println();
		for(String d: c.values()) {
			System.out.print(d+" ");
		}

	}

}
