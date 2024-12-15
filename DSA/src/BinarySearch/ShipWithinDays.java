package BinarySearch;
//A conveyor belt has packages that must be shipped from one port to another within days days.
//The ith package on the conveyor belt has a weight of weights[i]. Each day, we load the ship with packages on the conveyor belt (in the order given by weights). We may not load more weight than the maximum weight capacity of the ship.
//Return the least weight capacity of the ship that will result in all the packages on the conveyor belt being shipped within days days.
//Input: weights = [1,2,3,4,5,6,7,8,9,10], days = 5
//Output: 15
public class ShipWithinDays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int weights[] = {10,50,100,100,50,100,100,100};
		int days = 5;
		int ans = shipWithinDays(weights,days);
		System.out.println("The least weight capacity shipped within days days:"+ans);
	}
	  private static int shipWithinDays(int[] weights, int days) {
	        //low will be at max element
	        int n = weights.length;
	        int low = Integer.MIN_VALUE;
	        int high = 0;
	        for(int i =0;i<n;i++){
	            low = Math.max(low,weights[i]);
	            high += weights[i];
	        }
	        while(low<=high){
	            int mid = (low + high)/2;
	            int noOfDays = findDays(weights,mid);
	            if(noOfDays<=days)
	                high = mid - 1;
	            else
	                low = mid + 1;
	        }return low;
	    }
	    private static int findDays(int[] weights, int cap){
	        int load = 0;
	        int days = 1;
	        for(int i=0;i<weights.length;i++){
	            if(weights[i]+load > cap){
	                days += 1;
	                load = weights[i];
	            }else{
	                load += weights[i];
	            }
	        }return days;
	    }

}
