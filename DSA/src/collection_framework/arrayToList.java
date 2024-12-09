package collection_framework;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class arrayToList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {2,1,5,5,5,5,6,6,6,6,6};
		 int n = arr.length;
	     
		List<Integer> list = IntStream.of(arr).boxed().collect(Collectors.toCollection(ArrayList::new));
		System.out.println(list);
	}

}
