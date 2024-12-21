package BinarySearch;

import java.util.PriorityQueue;

public class MinMaxDistGasStation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1, 2, 3, 4, 5};
        int k = 4;
        double ans = MinimiseMaxDistance(arr, k);
        System.out.println("The answer is: " + ans);

	}
	private static double MinimiseMaxDistance(int []arr, int k){
        // Write your code here.
        int n = arr.length;
        int howMany[] = new int[n-1];
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> Double.compare(b.first, a.first));

        //insert the distance into pq
        for(int i=0;i<n-1;i++){
            pq.add(new Pair((arr[i+1]-arr[i]),i));
        }
        //pick and place k gas station
        for(int gasStation=1;gasStation<=k;gasStation++){
            Pair tp = pq.poll();
            int secInd = tp.second;
            //insert the current gas station
            howMany[secInd]++;

            double initDiff = arr[secInd + 1] - arr[secInd];
            double secLen = initDiff/(double)(howMany[secInd]+1);
            pq.add(new Pair(secLen, secInd));


        }return pq.peek().first;
    }
}
class Pair{
    double first;
    int second;
    Pair(double first,int second){
        this.first=first;
        this.second=second;
    }
}