import java.util.Arrays;

// Climbing Stairs
class ClimbingStairs {
    public int climbStairs(int n) {
        if (n <= 1) return 1;
        int[] dp = new int[n + 1];
        dp[0] = dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }    
}

// House Robber
class HouseRobber {
    public int rob(int[] nums) {
        int rob = 0;
        int norob = 0;
        for (int num : nums) {
            int newRob = norob + num;
            int newNoRob = Math.max(norob, rob);
            rob = newRob;
            norob = newNoRob;
        }
        return Math.max(rob, norob);
    }
}

// House Robber II
class HouseRobberII {
    private int solve(int[] nums, int n, int[] dp) {
        if (n >= nums.length)
            return 0;
        if (dp[n] != -1)
            return dp[n];
        int include = nums[n] + solve(nums, n + 2, dp);
        int exclude = solve(nums, n + 1, dp);
        dp[n] = Math.max(include, exclude);
        return dp[n];
    }

    public int rob(int[] nums) {
        if (nums.length == 1)
            return nums[0];

        int[] arr = new int[nums.length - 1];
        System.arraycopy(nums, 0, arr, 0, nums.length - 1);

        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        int[] dp2 = new int[nums.length];
        Arrays.fill(dp2, -1);

        return Math.max(solve(nums, 1, dp), solve(arr, 0, dp2));
    }
}