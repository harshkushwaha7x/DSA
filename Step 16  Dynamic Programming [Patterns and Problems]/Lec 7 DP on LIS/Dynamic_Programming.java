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

// Longest String Chain
class Solution {
    public int longestStrChain(String[] words) {
        Arrays.sort(words, (a,b)->a.length()-b.length());
        int n = words.length;
        int []len = new int[n];
        Arrays.fill(len,1);
         
        int maxLen = 1;

        for(int i = 0; i<n; i++){
            for(int j=i-1; j>=0; j--){
                int lenDiff = words[i].length() - words[j].length();
                if(lenDiff > 1) break;
                if(lenDiff==0) continue;
                if(len[i] < len[j] + 1  && formChain(words[i], words[j])){
                    len[i] = len[j] + 1;
                }
            }
           maxLen = Math.max(maxLen, len[i]);
        }

        return maxLen;
    }

    private boolean formChain(String a, String b){
        int ai = 0;
        int bi = 0;
        while(ai < a.length() && bi < b.length()){
            if(a.charAt(ai) == b.charAt(bi)) bi++;
            ai++;
            if(ai-bi > 1) return false;
        }
        return true;
    }
}

// Number of Longest Increasing Subsequence
class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        int[] dpLen = new int[n];
        int[] dpCount = new int[n];
        dpLen[0] = 1;
        dpCount[0] = 1;
        int currLen = 1;
        int currCount = 1;
        int overallLen = 1;
        int res = 1;


        for(int i = 1; i < n; i++){
            currLen = 1;
            currCount = 1;
            for(int j = i - 1; j >= 0; j--){
                if(nums[i] > nums[j]){
                    if(dpLen[j] + 1 == currLen){
                        currCount += dpCount[j];
                    }else if(dpLen[j] + 1 > currLen){
                        currLen = dpLen[j] + 1;
                        currCount = dpCount[j];
                    }
                }
            }

            dpLen[i] = currLen;
            dpCount[i] = currCount;

            if(currLen == overallLen){
                res += currCount;
            }else if(currLen > overallLen){
                res = currCount;
                overallLen = currLen;
            }
        }

        return res;
    }
}