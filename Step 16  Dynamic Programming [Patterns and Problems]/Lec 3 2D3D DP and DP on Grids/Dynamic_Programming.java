// Unique Paths

class Solution {
    public int uniquePaths(int m, int n) {
        int dp[][] = new int[m+1][n+1];
        dp[0][0] = 1;
        for(int i=0;i<m;i++){
            dp[i][0] = 1;
        }
        for(int j=0;j<n;j++){
            dp[0][j] = 1;
        }
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }
}

// Unique Paths II

class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m= obstacleGrid.length;
        int n= obstacleGrid[0].length;
        int[][] dp= new int [m][n];

        int set= 1;
        for(int i=0; i<m; i++){
            if(obstacleGrid[i][0] == 1) {
                set= 0;
                dp[i][0]=set;
            }else{
                dp[i][0]=set;
            }
        }

        set= 1;
        for(int i=0; i<n; i++){
            if(obstacleGrid[0][i] == 1) {
                set= 0;
                dp[0][i]=set;
            }else{
                dp[0][i]=set;
            }
        }

        for(int i=1 ; i<m; i++){
            for(int j= 1; j<n; j++){
                if(obstacleGrid[i][j] == 1){
                    dp[i][j] = 0;
                }else{
                    dp[i][j] = dp[i-1][j]+ dp[i][j-1];
                }
            }
        }

        return dp[m-1][n-1];
    }
}