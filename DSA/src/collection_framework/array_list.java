 package collection_framework;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class array_list {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> c = new ArrayList<>();
		c.add(10);
		c.add(50);
		c.add(100);
		c.add(60);
		System.out.println(c);
		c.remove(2);
		System.out.println(c);
		int d = c.get(2);
		System.out.println(d);
		//c.clear();
		//System.out.println(c);
		c.set(1, 90);
		System.out.println(c);
		boolean f= c.contains(30);
		System.out.println(f);
		/*
		 * for(int i=0;i<c.size();i++) { System.out.println(c.get(i)); }
		 */
		
		ListIterator<Integer> li = c.listIterator();
		while(li.hasNext()) {
			System.out.println(li.next());
		}
		
		while(li.hasPrevious()) {
			System.out.println(li.previous());
		}
	}

}
