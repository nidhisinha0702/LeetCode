package dynamicProgramming;
//Problem statement
//Ninja is planing this ‘N’ days-long training schedule. Each day, he can perform any one of these three activities. (Running, Fighting Practice or Learning New Moves). Each activity has some merit points on each day. As Ninja has to improve all his skills, he can’t do the same activity in two consecutive days. Can you help Ninja find out the maximum merit points Ninja can earn?
//You are given a 2D array of size N*3 ‘POINTS’ with the points corresponding to each day and activity. Your task is to calculate the maximum number of merit points that Ninja can earn.

import java.util.Arrays;

public class NinjaTraining {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int points[][] = {{1,2,5},{3,1,1},{3,3,3}};
		int n = 3;
		int ans = ninjaTraining(n,points);
		System.out.println("Maximum numbe of merit points that ninja can earn :"+ans);

	}
	public static int ninjaTraining(int n, int points[][]) {

        // Write your code here..
        int[][] dp = new int[n][4];
        for(int[] row:dp)
            Arrays.fill(row, -1);
        return f(n-1,3,points,dp);
    }
	//top-down approach
	private static int f(int day, int last, int[][] points,int dp[][]){
        if(day == 0){
            int maxi = 0;
            for(int task =0;task<3;task++){
                if(task != last){
                    maxi = Math.max(maxi, points[day][task]);
                }
            }return dp[day][last]=maxi;
        }
        if(dp[day][last]!= -1) return dp[day][last];
        int maxi = 0;
        for(int task=0;task<3;task++){
            if(task!=last){
            int point = points[day][task] + f(day - 1,task,points,dp);
            maxi = Math.max(maxi,point);
            }
        }return dp[day][last]=maxi;
    }

}
