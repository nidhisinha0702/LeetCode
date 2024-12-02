package collection_framework;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class treeset {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Set<Integer> c= new TreeSet<>();
		c.add(10);
		c.add(50);
		c.add(100);
		c.add(60);
		c.add(10);
		c.remove(50);
		//c.clear();
		int d = c.size();
		System.out.println(c);
		System.out.println(d);
		System.out.println(c.contains(70));
	}

}
