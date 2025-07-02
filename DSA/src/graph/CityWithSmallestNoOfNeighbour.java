package graph;

import java.util.Arrays;

public class CityWithSmallestNoOfNeighbour {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 4, m = 4,
				edges[][] = {{0, 1, 3},
				         {1, 2, 1}, 
				         {1, 3, 4},  
				         {2, 3, 1}},
				distanceThreshold = 4;
		System.out.println("city number is : "+findCity(n, m, edges, distanceThreshold));
	}
	//TC->O(n^3) + O(n^2)
	static int findCity(int n, int m, int[][] edges, int distanceThreshold) {
        // code here
        int dist[][] = new int[n][n];
        for(int d[] : dist)
        Arrays.fill(d, Integer.MAX_VALUE);
        //bidirectional
        for(int edge[] : edges){
            dist[edge[0]][edge[1]] = edge[2];
            dist[edge[1]][edge[0]] = edge[2];
        }
        for(int i=0;i<n;i++) dist[i][i] = 0;
        //floyd-warshall algo
        for(int k=0;k<n;k++){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    if(dist[i][k] == Integer.MAX_VALUE || dist[k][j] == Integer.MAX_VALUE){
                        continue;
                    }
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }
        
        int cntCity = n;
        int cityNo = -1;
        for(int city = 0;city<n;city++){
            int cnt = 0;
            for(int adjCity = 0;adjCity<n;adjCity++){
                if(dist[city][adjCity] <= distanceThreshold){
                    cnt++;
                }
            }
            if(cnt <= cntCity){
                cntCity = cnt;
                cityNo = city;
            }
        }
        return cityNo;
    }
}
