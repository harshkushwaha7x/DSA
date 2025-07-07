// Partition Equal Subset Sum

class Solution {
    public boolean canPartition(int[] nums) {
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
        }
        if(sum%2!=0) return false;
        sum/=2;
        boolean dp[]=new boolean[sum+1];
        dp[0]=true;
        for (int num : nums) {
            for (int currSum = sum; currSum >= num; currSum--) {
                dp[currSum] = dp[currSum] || dp[currSum - num];
                if (dp[sum]) return true;
            }
        }
        return dp[sum];
    }
}