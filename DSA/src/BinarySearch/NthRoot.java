package BinarySearch;

public class NthRoot {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 9;
		int m = 1953125;
		int ans = NthRoot(n,m);
		System.out.println("The nth root of m is :" + ans);

	}
	 private static int NthRoot(int n, int m) {
	        // Write your code here.
	         long low = 1;
			 long high = m;
			 while(low<=high){
				 long mid = (high+low)/2;
				 int midN = midPowN(mid,n,m);
				 if(midN == 1){
					 return (int)mid;
				 }else if(midN == 0){
					 low = mid + 1;
				 }else{
	                 high = mid - 1;
	             }
			 }return -1;

	    }

	    private static int midPowN(long mid, int n, int m){
	        //for the edge case as the value might ranges 1<10 to the power 9
	    	 //return 1 if ans == m
	        //return 2 if ans > m
	        //else return 0
	        long ans = 1;
	        for(int i=1;i<=n;i++){
	            ans = ans * mid;
	            if(ans > m) return 2;
	        }
	        if(ans == m) return 1;
	        return 0;
	    }

}
