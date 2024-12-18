package dynamicProgramming;

import java.util.Arrays;

public class NinjaTrainingII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int points[][] = {{1,2,5},{3,1,1},{3,3,3}};
		int n = 3;
		//int ans = ninjaTraining(n,points);
		int ans = ninja(n,points);
		System.out.println("Maximum numbe of merit points that ninja can earn :"+ans);

	}
	//TC -> O(n*4*3) SC-> O(n*4)
	 private static int ninjaTraining(int n, int [][]points){
	        int[][] dp = new int[n][4];
	        dp[0][0] = Math.max(points[0][1],points[0][2]);
	        dp[0][1] = Math.max(points[0][0],points[0][2]);
	        dp[0][2] = Math.max(points[0][0],points[0][1]);
	        dp[0][3] = Math.max(Math.max(points[0][0],points[0][1]),points[0][2]);

	        for(int day=1;day<n;day++){
	            for(int last=0;last<4;last++){
	                dp[day][last] = 0;

	                for(int task =0;task<3;task++){
	                    if(task!=last){
	                        int point = points[day][task] + dp[day - 1][task];
	                        dp[day][last] = Math.max(dp[day][last],point);
	                    }
	                }
	            }
	        }return dp[n-1][3];
	    }
	 //space optimization
	 private static int ninja(int n,int [][]points) {
		 int prev[] = new int[4];
		 Arrays.fill(prev,0);
		 prev[0] = Math.max(points[0][1],points[0][2]);
	     prev[1] = Math.max(points[0][0],points[0][2]);
	     prev[2] = Math.max(points[0][0],points[0][1]);
	     prev[3] = Math.max(Math.max(points[0][0],points[0][1]),points[0][2]);
	     
	     for(int day=1;day<n;day++){
	    	 int temp[] = new int[4];
	    	 Arrays.fill(temp, 0);
	            for(int last=0;last<4;last++){
	                temp[last] = 0;

	                for(int task =0;task<3;task++){
	                    if(task!=last){
	                        temp[last]= Math.max(temp[last],points[day][task] + prev[task]);
	                    }
	                }
	            }prev = temp;
	        }return prev[3];

	 }

}
