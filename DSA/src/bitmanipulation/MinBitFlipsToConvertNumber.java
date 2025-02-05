package bitmanipulation;

public class MinBitFlipsToConvertNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("minuimum bits to convert the number::"+minBitFlips(10,7));
	}
	 private static int minBitFlips(int start, int goal) {
	        int num = (start ^ goal);
	        int cnt = 0;
	        while(num>1){
	            cnt += (num & 1); //check if odd
	            num = num >> 1; //divide by 2
	        }
	        if(num == 1) cnt += 1;
	        return cnt;
	    }
}
