/*
There is a robot on an m x n grid. The robot is initially located at the top-left corner (i.e., grid[0][0]). The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]). The robot can only move either down or right at any point in time.

Given the two integers m and n, return the number of possible unique paths that the robot can take to reach the bottom-right corner.

The test cases are generated so that the answer will be less than or equal to 2 * 109.

 

Example 1:


Input: m = 3, n = 7
Output: 28
Example 2:

Input: m = 3, n = 2
Output: 3
Explanation: From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
1. Right -> Down -> Down
2. Down -> Down -> Right
3. Down -> Right -> Down
 

Constraints:

1 <= m, n <= 100

*/


class Solution1 {

    int M, N;
    Integer[][] memo;
   
    public int uniquePaths(int m, int n) {
        this.M = m;
        this.N = n;
        memo = new Integer[m][n];
        return dp(0, 0);
    }

    public int dp(int i, int j){ 
        if(i >= M || j >= N) return 0;
        if(i == M-1 && j == N-1) return 1;
        if(memo[i][j] != null) return memo[i][j];
        //what are the choices we have? 
        return memo[i][j] =  dp(i+1, j) + dp(i, j+1);
    }
}

class Solution {

   
    public int uniquePaths(int m, int n) {
       

       //dp[i][j] -> number of ways to reach dp[m-1][n-1] from grid[i][j]
       int[][] dp = new int[m][n];
       for(int i = m-1; i>=0; i--){
        for(int j = n-1; j>=0; j--){
            //we can also compress this dp[i][j] = 1 part for last row and last column
            if(i == m-1 && j == n-1){
                dp[i][j] = 1;
            }else if(i == m-1){
                dp[i][j] = 1;
            }else if(j == n-1){
                dp[i][j] = 1;
            }else{
                dp[i][j] = dp[i+1][j] + dp[i][j+1];
            }
        }
       }

       return dp[0][0];
    }

    
}
