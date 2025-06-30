package graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class MinimumMultiplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {9, 12, 18, 19};
		int start = 5, end = 5;
		System.out.println("The minimum multiplication will be : "+minimumMultiplications(arr, start, end));
	}
	 static int minimumMultiplications(int[] arr, int start, int end) {
		 //edge case
		 if(start == end) return 0;
	        Queue<Pair> q = new LinkedList<>();
	        q.add(new Pair(start, 0));
	        int dist[] = new int[100000];
	        Arrays.fill(dist, (int)1e9);
	        dist[start] = 0;
	        int mod = 100000;
	        while(!q.isEmpty()){
	            int node = q.peek().first;
	            int steps = q.peek().second;
	            q.remove();
	            
	            for(int it : arr){
	                int num = (it * node) % mod;
	                if(steps + 1 < dist[num]){
	                    dist[num] = steps + 1;
	                    if(num == end) return steps + 1;
	                    q.add(new Pair(num, steps + 1));
	                }
	            }
	        }return -1;
	    }
	    static class Pair{
	        int first;
	        int second;
	        Pair(int first, int second){
	            this.first = first;
	            this.second = second;
	        }
	    }
}
