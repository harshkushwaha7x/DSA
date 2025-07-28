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