package collection_framework;

import java.util.LinkedList;
import java.util.List;

public class Linked_list {

	public static void main(String[] args) {
		 		// TODO Auto-generated method stub
		 		List<Integer> c = new LinkedList<>();
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
		 		for(int i=0;i<c.size();i++) {
		 			System.out.println(c.get(i));
		 		}


	}

}
