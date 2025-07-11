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

// Partition Array Into Two Arrays to Minimize Sum Difference

class Solution {

    int ans=Integer.MAX_VALUE;
    public int minimumDifference(int[] nums) {
        int sum=0;
        for(int num:nums){
            sum+=num;
        }
        call(nums,0,0,sum,0);
       return ans;
    }
public void call(int []nums,int sum,int i,int totalSum,int count){
    int n=nums.length/2;
    
    if( count==n ){
        int x=Math.abs(totalSum-(2*sum));
        ans=Math.min(ans,x);
         return;
    }
     if(i>=nums.length ){
        return;
     }
   
   call(nums,sum+nums[i],i+1,totalSum,count+1);
   call(nums,sum,i+1,totalSum,count);
    
}
}

// Assign Cookies

class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(s);
        Arrays.sort(g);
        int child = 0;
        int cookie =0;
        while(child<g.length && cookie<s.length){
            if(g[child]<=s[cookie]){
                child++;
            }
            cookie++;
        }
        return child;
    }
}

// Coin Change

class Solution {
    public int coinChange(int[] coins, int amount) {
        int dp[] = new int[amount+1];
        Arrays.fill(dp,amount+1);
        dp[0] = 0;
        for(int i=1;i<=amount;i++){
            for(int coin:coins){
                if(coin<=i){
                    dp[i] = Math.min(dp[i],dp[i-coin]+1);
                }
            }
        }
        return dp[amount]>amount?-1:dp[amount];
    }
}