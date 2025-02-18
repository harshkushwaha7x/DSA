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

// Rearrange Array Elements by Sign

class Solution {
    public int[] rearrangeArray(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        int pos = 0, neg = 1;
        for(int i=0;i<n;i++) {
            if(nums[i] >= 0) {
                ans[pos] = nums[i];
                pos += 2;
            }
            else {
                ans[neg] = nums[i];
                neg += 2;
            }
        }
        return ans;
    }
}

// Next Permutation

class Solution {
    public void nextPermutation(int[] nums) {
        int len = nums.length;
        int i = len - 2;
        while(i >= 0 && nums[i] >= nums[i+1]){
            i--;
        }

        if(i >= 0){
            int j = len - 1;
            while(nums[j] <= nums[i])
                j--;
            
            swap(nums, i, j);
        }
        reverse(nums, i+1, len-1);
    }

    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    private void reverse(int[] nums, int st, int end){
        while(st < end){
            swap(nums, st, end);
            st++; 
            end--;
        }
    }
}

// Array Leaders

class Solution {
    static ArrayList<Integer> leaders(int arr[]) {
        ArrayList<Integer> leaders = new ArrayList<>();
        int n = arr.length;

        int currentLeader = arr[n - 1];
        leaders.add(currentLeader);

        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] >= currentLeader) {
                currentLeader = arr[i];
                leaders.add(currentLeader);
            }
        }
        Collections.reverse(leaders);
        return leaders;
    }
}

// Set Matrix Zeroes 

import java.util.HashSet;

class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        HashSet<Integer> zeroRows = new HashSet<>();
        HashSet<Integer> zeroCols = new HashSet<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    zeroRows.add(i);
                    zeroCols.add(j);
                }
            }
        }

        for (int row : zeroRows) {
            for (int j = 0; j < n; j++) {
                matrix[row][j] = 0;
            }
        }

        for (int col : zeroCols) {
            for (int i = 0; i < m; i++) {
                matrix[i][col] = 0;
            }
        }
    }
}

// Rotate Image

class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n - 1 - j];
                matrix[i][n - 1 - j] = temp;
            }
        }
    }
}

// Spiral Matrix

class Solution {
    public List<Integer> spiralOrder(int[][] mat) {
        int m = mat.length, n=mat[0].length;
        int srow=0, scol = 0,erow = m-1 , ecol=n-1;
        ArrayList<Integer> ans= new ArrayList<>();
        while(srow<=erow && scol<=ecol){
            for (int j =scol; j<=ecol;j++){
                ans.add(mat[srow][j]);
            }

            for(int i =srow+1; i<=erow; i++){
                ans.add(mat[i][ecol]);
            }
            for(int j = ecol-1; j>=scol; j--){
                if(srow==erow){
                    break;
                }
                ans.add(mat[erow][j]);
            }
            for(int i =erow-1; i>=srow+1;i--){
                if(scol==ecol){
                    break;
                }

                ans.add(mat[i][scol]);
            }
            srow++; erow--; scol++; ecol--;
        } 
        return ans;
    }
}

