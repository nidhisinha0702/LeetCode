package Collections;

import java.util.ArrayList;
import java.util.Collections;

public class CollectionsClass {

	public static void main(String[] args) {
		//WAP to demo collections class methods
		ArrayList<Integer> l = new ArrayList<>();
		l.add(13); l.add(11); l.add(13); l.add(11);
		//creates a reverse order comparator
		//use the comparator to sort the list
		//(a,b) -> descending order
		Collections.sort(l, Collections.reverseOrder((a,b) -> Integer.compare((int)a, (int)b)));
		//l.sort(Collections.reverseOrder((a,b) -> Integer.compare((int)a, (int)b)));
		//l.sort(Collections.reverseOrder((a,b) -> Integer.compare((int)a, (int)b)));
		System.out.println(l);

	}

}
