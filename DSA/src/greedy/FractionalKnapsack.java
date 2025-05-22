package greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class FractionalKnapsack {

	public static void main(String[] args) {
		List<Integer> val = Arrays.asList(8,2,10,1,9,7,2,6,4,9);
		List<Integer> wt = Arrays.asList(10,1,7,7,5,1,8,6,8,7);
		int cap = 21;
		System.out.println("The maximum value is : "+fractionalKnapsack(val, wt, cap));

	}
	private static double fractionalKnapsack(List<Integer> val, List<Integer> wt, int capacity) {
	        // code here
	        //greedy value per weight in decending order
	        Item arr[] = new Item[val.size()];
	        for(int i=0;i<val.size();i++) {
	        arr[i] = new Item(val.get(i),wt.get(i));
	        System.out.print("("+arr[i].value+","+arr[i].weight+")");
	        }
	        System.out.println();
	        Arrays.sort(arr, new itemComparator());
	        System.out.println("_______After sort____");
	        for(int i=0;i<val.size();i++) 
	        System.out.print("("+arr[i].value+","+arr[i].weight+")");
	        System.out.println();
	        double totVal = 0;
	        for(int i=0;i<arr.length;i++){
	            if(arr[i].weight <= capacity){
	            	capacity -= arr[i].weight;
	                totVal += arr[i].value;
	            }else{
	                totVal += (((double)arr[i].value/(double)arr[i].weight) * capacity);
	                break;
	            }
	        }return totVal;
	    }
	}
	class itemComparator implements Comparator<Item>{
	    
	    @Override
	    public int compare(Item a, Item b){
	        double r1 = ((double)a.value/(double)a.weight);
	        double r2 = ((double)b.value/(double)b.weight);
	        if(r1>r2) return -1;
	        else if(r1<r2) return 1;
	        else return 0;
	    }
	}
	class Item{
	    Integer value;
	    Integer weight;
	    Item(Integer val,Integer wt){
	        this.value=val;
	        this.weight=wt;
	    }
}
