package greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class JobSequencing {

	public static void main(String[] args) {
		//WAP to job sequencing problem under deadline and maximize the profit
		int deadline[] = {4,1,1,1};
		int profit[] = {20,10,40,30};
		System.out.println("max profit");
		int ans[] = maxJobProfit(deadline, profit);
		System.out.println(Arrays.toString(ans));

	}
	
	private static int[] maxJobProfit(int deadline[], int profit[]) {
		int n = deadline.length;
		int maxi = Arrays.stream(deadline).max().getAsInt();
		List<Pair> job = new ArrayList<>();
		for(int i=0;i<n;i++) {
			job.add(new Pair(deadline[i],profit[i]));
		}
		//sort based on max profit
		//[(1,40),(1,30),(4,20),(1,10)]
		Collections.sort(job, new profitComparator());
		//create an array of size 4 + 1
		int result[] = new int[maxi+1];
		Arrays.fill(result, -1);
		
		int countJobs = 0, jobProfit = 0;
		//pick one by one jobs
		for(int i=0;i<n;i++) {
			//perform job at the last day if filled perform on prev day
			for(int j=job.get(i).deadline;j>0;j--) {
				if(result[j] == -1) {
					result[j] = i;
					countJobs++;
					jobProfit += job.get(i).profit;
					break;//found the position so break
				}
			}
		}
		
		int ans[] = new int[2];
		ans[0] = countJobs;
		ans[1] = jobProfit;
		return ans;
		
	}

	static class Pair{
		int profit, deadline;
		Pair(int deadline, int profit){
			this.profit = profit;
			this.deadline = deadline;
		}
	}
	
	static class profitComparator implements Comparator<Pair>{
		@Override
		public int compare(Pair j1, Pair j2) {
			int p1 = j1.profit;
			int p2 = j2.profit;
			if(p1 < p2) return 1;
			else if(p1 > p2) return -1;
			else return 0;
		}
	}
}
