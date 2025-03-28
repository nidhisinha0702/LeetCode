package greedy;

public class LemonadeChange {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int bills[] = {5,5,5,10,20};
		System.out.println("Lemonade can be served to all persons with denomination is : "+lemonadeChange(bills));

	}
	 private static boolean lemonadeChange(int[] bills) {
	        int five = 0, ten = 0;//we wont be returning any tewenty so no need to keep variable
	        for(int i=0;i<bills.length;i++){
	            if(bills[i] == 5){
	                five += 1;
	            }else if(bills[i] == 10){
	                if(five >= 1){
	                    five -= 1;
	                    ten += 1;
	                }else return false;
	            }else{
	                if(ten >= 1 && five >= 1){
	                    ten -= 1;
	                    five -= 1;
	                }else if(five >= 3){
	                    five -= 3;
	                }else return false;
	            }
	        }return true;

	    }
}
