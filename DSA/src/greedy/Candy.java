package greedy;

public class Candy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int ratings[] = {1,0,2};
		System.out.println("The minimum number of candies to distribute is : "+candy(ratings));
	}

	private static int candy(int[] ratings) {
        int sum = 1;
        int i = 1;
        int n = ratings.length;
        while(i < n){
            //flat surface
            if(ratings[i] == ratings[i-1]){
                sum += 1;
                i++;
                continue;
            }
            int peak = 1;
            //increasing slope
            while(i < n && ratings[i] > ratings[i-1]){
                peak += 1;
                sum += peak;
                i++;
            }
            int down = 1;
            //decreasing slope
            while(i < n && ratings[i] < ratings[i-1]){
                sum += down;
                i++;
                down++;
            }
            //we have to take max of both so add the remaining which is down - peak
            if(down > peak){
                sum += down - peak;
            }
        }return sum;
    }
}
