package java_class;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _2DArrayList {

	public static void main(String[] args) {
		//create 2d arraylist
		//immutable if created as below
		List<Integer> list1 = Arrays.asList(1,3);
		List<Integer> list2 = Arrays.asList(0,2);
		List<Integer> list3 = Arrays.asList(1,6);
		List<Integer> list4 = Arrays.asList(0,4);
		
		List<List<Integer>> listOfList = Arrays.asList(list1,list2,list3,list4);
		System.out.println(listOfList);

	}

}
