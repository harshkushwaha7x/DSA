// Minimum Cost to Cut a Stick
class Solution {

    int dfs(int[] newArr, int i, int j, Integer[][] memo) {
        if (i + 1 >= j) {
            return 0;
        }
        if (memo[i][j] != null)
            return memo[i][j];
        int min = Integer.MAX_VALUE;
        for (int k = i + 1; k < j; k++) {
            int cost = dfs(newArr, i, k, memo) + dfs(newArr, k, j, memo) + (newArr[j] - newArr[i]);
            min = Math.min(cost, min);
        }
        memo[i][j] = min;
        return min;

    }

    public int minCost(int n, int[] cuts) {
        int size = cuts.length;
        int newArr[] = new int[size + 2];

        newArr[0] = 0;
        newArr[size+1] = n;

        for (int i = 0; i < size; i++) {
            newArr[i+1] = cuts[i];
        }
        Arrays.sort(newArr);
        Integer[][] memo = new Integer[size + 2][size + 2];

        return dfs(newArr, 0, size+1, memo);
    }
}

// Burst Balloons
class Solution {
    int [][] dp ;
    public int maxCoins(int[] nums) {
        dp = new int[nums.length][nums.length];
        for(int[] row : dp)
            Arrays.fill(row,-1);
        return solve(nums,0,nums.length-1);
    }
    public int solve(int [] nums,int i,int j)
    {
        if(i>j) return 0;
        if(dp[i][j]!=-1)
            return dp[i][j];
        int max = 0;
        for(int k = i;k<=j;k++)
        {
            int temp = solve(nums,i,k-1) + solve(nums,k+1,j)+nums[k]*(i-1<0?1:nums[i-1])*(j+1>=nums.length?1:nums[j+1]);
            max = Math.max(max,temp);
        }
        return dp[i][j] = max;
    }
}