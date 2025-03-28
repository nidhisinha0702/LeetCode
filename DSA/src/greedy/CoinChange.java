package greedy;

public class CoinChange {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int coins[] = {5,10,25};
		int sum = 30;
		System.out.println("Minimum number of coin needed to obtain the target sum is : "+minCoins(coins, sum));
		
	}
	private static int minCoins(int coins[], int sum) {
		 int cnt = 0;
	        //iterate over the coins denomination
	        for(int i=coins.length-1;i>=0;i--){
	            //iterate while sum is >= denomination
	            while(sum >= coins[i]){
	               sum -= coins[i];
	               cnt++;
	            }
	        }return cnt;
	}

}
