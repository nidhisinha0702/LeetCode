package PartitionDP;

public class EvaluateBooleanExpressionToTrue {
	private static final int mod = 1000000007;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String exp =  "T|T&F";
		System.out.println("The no of ways boolean expression evaluate to true are : "+evaluateExpTabulation(exp));
	}
	
	public static int evaluateExpTabulation(String exp) {
        // Write your code here.
        int n = exp.length();
        long dp[][][] = new long[n][n][2];

        
        for(int i=n-1;i>=0;i--){
            for(int j=0;j<n;j++){
                if(i>j) continue;
                for(int isTrue=0;isTrue<=1;isTrue++){
                    //base case
                    if(i==j){
                        if(isTrue==1) dp[i][j][isTrue] = exp.charAt(i) == 'T'?1:0;
                        else dp[i][j][isTrue] = exp.charAt(i) == 'F'?1:0;
                        continue;
                    }
                    long ways = 0;
                        for(int ind=i+1;ind<=j-1;ind=ind+2){
                            long lT = dp[i][ind-1][1];
                            long lF = dp[i][ind-1][0];
                            long rT = dp[ind+1][j][1];
                            long rF = dp[ind+1][j][0];

                            char operator = exp.charAt(ind);
                            if(operator == '&'){
                                if(isTrue == 1){
                                    ways = (ways + (rT * lT)%mod) % mod;
                                }else{
                                    ways = (ways + (rT * lF)%mod + (rF * lT)%mod + (lF * rF)%mod)%mod;
                                }
                            }else if(operator == '|'){
                                if(isTrue == 1){
                                    ways = (ways + (lT * rT)%mod + (lT * rF)%mod + (lF * rT)%mod)%mod;
                                }else{
                                    ways = (ways + (lF * rF)%mod)%mod;
                                }
                            }else{
                                if(isTrue == 1){
                                    ways = (ways + (lT * rF) % mod + (lF * rT) % mod) % mod;
                                }else{
                                    ways = (ways + (lT * rT) % mod + (lF * rF) % mod) % mod;
                                }
                            }
                        } dp[i][j][isTrue] = ways;
                }
            }
        }
        return (int)dp[0][n-1][1];
    }
	
    private static int evaluateExp(String exp) {
        // Write your code here.
        int n = exp.length();
        Long dp[][][] = new Long[n][n][2];
        return (int)f(0,n-1,1,exp,dp);
    }
     private static long f(int i, int j, int isTrue, String exp, Long[][][] dp){
        if(i>j) return 0;
        //when start and end are same
        if(i==j){
            if(isTrue==1){
                return exp.charAt(i) == 'T'? 1:0;
            }else{
                return exp.charAt(i) == 'F' ? 1:0;
            }
        }
        if(dp[i][j][isTrue] != null) return dp[i][j][isTrue];
        long ways = 0;
        for(int ind=i+1;ind<=j-1;ind=ind+2){
            long lT = f(i, ind-1, 1, exp, dp);
            long lF = f(i, ind-1, 0, exp, dp);
            long rT = f(ind+1, j, 1, exp, dp);
            long rF = f(ind+1, j, 0, exp, dp);

            char operator = exp.charAt(ind);
            if(operator == '&'){
                if(isTrue == 1){
                    ways = (ways + (rT * lT)%mod) % mod;
                }else{
                    ways = (ways + (rT * lF)%mod + (rF * lT)%mod + (lF * rF)%mod)%mod;
                }
            }else if(operator == '|'){
                if(isTrue == 1){
                    ways = (ways + (lT * rT)%mod + (lT * rF)%mod + (lF * rT)%mod)%mod;
                }else{
                    ways = (ways + (lF * rF)%mod)%mod;
                }
            }else{
                if(isTrue == 1){
                    ways = (ways + (lT * rF) % mod + (lF * rT) % mod) % mod;
                }else{
                    ways = (ways + (lT * rT) % mod + (lF * rF) % mod) % mod;
                }
            }
        }return dp[i][j][isTrue] = ways;
    }
}
