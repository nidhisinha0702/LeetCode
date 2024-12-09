package BasicMaths;

public class CountDigits {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 12;
		int ans = evenlyDivides(n);
		System.out.println("The total numbers that evenly divides "+n+" are "+ans);

	}
	private static int evenlyDivides(int n) {
        // code here
        int number = n;
        int rem = 0;
        //count digit
        int cnt = 0;
        while(number!=0){
            rem = number % 10;
            number=number/10;
          //if a digit is 0 ignore it and continue
            if(rem != 0){
            	//else check if that digit divides the whole number
                if(n % rem == 0){
                    cnt+=1;
                }
            }
        }return cnt; //return the count of such digits  
       
    }

}
