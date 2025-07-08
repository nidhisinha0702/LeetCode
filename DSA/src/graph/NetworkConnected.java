package graph;

public class NetworkConnected {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 4, connections[][] = {{0,1},{0,2},{1,2}};
		System.out.println("Minimum operation needed to connect the components :"+makeConnected(n, connections));
	}
	 public static int makeConnected(int n, int[][] connections) {
	        DisjointSetSize ds = new DisjointSetSize(n);
	        int cntExtras = 0;
	        for(int edge[] : connections){
	            int u = edge[0];
	            int v = edge[1];
	            //same parent means extra edge
	            if(ds.findUPar(u) == ds.findUPar(v)){
	                cntExtras++;
	            }else{//else cnnect them
	                ds.unionBySize(u,v);
	            }
	        }
	        //count connected components
	        int cntC = 0;
	        for(int i=0;i<n;i++){
	            if(ds.parent.get(i) == i){
	                cntC++;
	            }
	        }
	        //we know the extras are the edge we can use to connect the components
	        int ans = cntC - 1;
	        if(cntExtras >= ans){
	            return ans;
	        }
	        return -1;
	    }
}
