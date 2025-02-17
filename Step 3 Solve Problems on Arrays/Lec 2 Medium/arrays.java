// Two Sum

class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++) {
            int val = target - nums[i];
            if(map.containsKey(val)) {
                return new int[]{map.get(val), i};
            }
            map.put(nums[i], i);
        }
        return new int[0];
    }
}

// Sort Colors

class Solution {
    public void sortColors(int[] nums) {
         Arrays.sort(nums);
    }
}

// Majority Element

class Solution {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        return nums[n/2];
    }
}

// Maximum Subarray

class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int max = Integer.MIN_VALUE, sum = 0;
        
        for(int i=0;i<n;i++){
            sum += nums[i];
            max = Math.max(sum,max);
            
            if(sum<0) sum = 0;
        }
        
        return max;
    }
}

// Maximum Score from Subarray Minimums

class Solution {

    public int pairWithMaxSum(int arr[]) {
        int n = arr.length;
        int max = Integer.MIN_VALUE;
     
        for(int i =0 ; i<n-1;i++){
            int sum = arr[i] + arr[i+1];
            if(sum> max){
                max=sum;
            }
        }
        return max;
}
}

// Best Time to Buy and Sell Stock

class Solution {
    public int maxProfit(int[] prices) {
        int lsf = Integer.MAX_VALUE;
        int op = 0;
        int pist = 0;
        
        for(int i = 0; i < prices.length; i++){
            if(prices[i] < lsf){
                lsf = prices[i];
            }
            pist = prices[i] - lsf;
            if(op < pist){
                op = pist;
            }
        }
        return op;
    }
}
