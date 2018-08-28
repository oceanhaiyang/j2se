package dynamic_programming;

/*
 * You are climbing a stair case. It takes n steps to reach to the top.
 * <p>
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 * <p>
 * Note: Given n will be a positive integer.
 */
public class ClimbingStairs {
    /**
     * Main method
     *
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        System.out.println(new ClimbingStairs().climbStairs(22));
    }

    public int climbStairs(int n) {
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        if(n < 2)
            return dp[n];
        dp[2] = 2;
        for(int i=3; i <= n; i++)
            dp[i] = dp[i-1]+dp[i-2];

        return dp[n];
    }

}

