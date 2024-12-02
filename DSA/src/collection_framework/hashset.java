package collection_framework;

import java.util.HashSet;
import java.util.Set;

public class hashset {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Set<Integer> c = new HashSet<>();
		c.add(10);
		c.add(50);
		c.add(100);
		c.add(60);
		c.remove(50);
		//c.clear();
		int d = c.size();
		System.out.println(c);
		System.out.println(d);
		System.out.println(c.contains(70));
	}

}
