// Longest Increasing Subsequence
class Solution {
    public int lengthOfLIS(int[] nums) {
        int res=1;
        int[] arr =new int[nums.length];
        for(int k=0;k<arr.length;k++){
            arr[k]=1;
        }
        for(int i=1;i<nums.length;i++){
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j]&&arr[j]+1>arr[i]){
                    arr[i]=arr[j]+1;
                }
            }
            res=Math.max(res,arr[i]);
        }
        return res;
    }
}

// Largest Divisible Subset

class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        Arrays.sort(nums);
        
        int maxSize = 1, maxIndex = 0;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    if (dp[i] > maxSize) {
                        maxSize = dp[i];
                        maxIndex = i;
                    }
                }
            }
        }
        
        List<Integer> result = new ArrayList<>();
        int num = nums[maxIndex];
        for (int i = maxIndex; i >= 0; i--) {
            if (num % nums[i] == 0 && dp[i] == maxSize) {
                result.add(nums[i]);
                num = nums[i];
                maxSize--;
            }
        }
        
        return result;
    }
}