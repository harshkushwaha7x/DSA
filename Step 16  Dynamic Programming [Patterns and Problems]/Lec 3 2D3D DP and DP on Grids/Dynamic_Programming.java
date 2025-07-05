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

// Minimum Path Sum

class Solution {
    public int minPathSum(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int[][] distances = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                distances[i][j] = Integer.MAX_VALUE;
            }
        }

        distances[0][0] = grid[0][0];

        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (j + 1 < cols) {
                    distances[i][j + 1] = Math.min(distances[i][j + 1], distances[i][j] + grid[i][j + 1]);
                }
                if (i + 1 < rows) {
                    distances[i + 1][j] = Math.min(distances[i + 1][j], distances[i][j] + grid[i + 1][j]);
                }
            }
        }

        return distances[rows - 1][cols - 1];
    }
}

// Triangle

class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n= triangle.size();
        int[][] dp = new int[n][n];
        for(int[] itr: dp){
            Arrays.fill(itr, -1);
        }
        return helper(dp, triangle,0,0);

    }
    public int helper(int[][] dp,List<List<Integer>> triangle, int i, int j){
        int n = triangle.size();
        if(i== n-1) return triangle.get(i).get(j);
        
        if(dp[i][j] != -1) return dp[i][j];

        return dp[i][j] = triangle.get(i).get(j) +Math.min(helper(dp,triangle, i+1,j), helper(dp, triangle, i+1, j+1));

    }
}