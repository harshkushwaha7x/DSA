import java.util.Map;
import java.util.HashMap;

// Longest Substring Without Repeating Characters

class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int i = 0;
        int j = 0;
        int max = 0;
        while(j < s.length()){
            map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0) + 1);
            if(map.size() == j - i + 1){
                max = Math.max(max, j - i + 1);
                j++;
            }
            else if(map.size() < j - i + 1){
                while(map.size() < j - i + 1){
                    map.put(s.charAt(i), map.get(s.charAt(i)) - 1);
                    if(map.get(s.charAt(i)) == 0) map.remove(s.charAt(i));
                    i++;
                }
                j++;
            }
        }
        return max;
    }
}

// Max Consecutive Ones III

class Solution {
    public int longestOnes(int[] nums, int k) {
        int start=0;
        int end=0;
        int zeros=0;

        while(end<nums.length){
            if(nums[end] == 0){
                zeros++;
            }
            end++;
            if(zeros>k){
                if(nums[start] == 0){
                    zeros--;
                }
                start++;
            }
        }
        return end-start;
    }
}

// Find length of the longest subarray containing atmost two distinct integers

class Solution {
    public static int totalElements(Integer[] arr) {
        int l=0,r=0,maxlen=1;
        HashMap<Integer,Integer> map=new HashMap<>();
        while(r<arr.length){
            map.put(arr[r],map.getOrDefault(arr[r],0)+1);
            if(map.size()>2){
                map.put(arr[l],map.get(arr[l])-1);
                if(map.get(arr[l])==0)map.remove(arr[l]);
                l++;
            }
            if(map.size()<=2){
                int len=r-l+1;
                maxlen=Math.max(len,maxlen);
            }
            r++;
        }
        return maxlen;
    }
}

// Longest Repeating Character Replacement

class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length();
        int[] count = new int[26];
        int maxCount = 0;
        int maxLength = 0;
        int start = 0;

        for (int end = 0; end < n; end++) {
            char currentChar = s.charAt(end);
            count[currentChar - 'A']++;
            maxCount = Math.max(maxCount, count[currentChar - 'A']);

            if (end - start + 1 - maxCount > k) {
                count[s.charAt(start) - 'A']--;
                start++;
            }

            maxLength = Math.max(maxLength, end - start + 1);
        }

        return maxLength;
    }
}

// Binary Subarrays With Sum

class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        return atMost(nums, goal) - atMost(nums, goal - 1);
    }
    private int atMost(int[] nums, int goal) {
        int head, tail = 0, sum = 0, result = 0;
        for (head = 0; head < nums.length; head++) {
            sum += nums[head];
            while (sum > goal && tail <= head) {
                sum -= nums[tail];
                tail++;
            }
            result += head - tail + 1;
        }
        return result;
    }
}

// Count Number of Nice Subarrays

class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int n = nums.length;
        int[] count = new int[n + 1];
        count[0] = 1;
        int result = 0, oddCount = 0;
        for (int num : nums) {
            oddCount += num & 1;
            if (oddCount - k >= 0) {
                result += count[oddCount - k];
            }
            count[oddCount]++;
        }
        return result;
    }
}

// Number of Substrings Containing All Three Characters

class Solution {
    public int numberOfSubstrings(String s) {
        int n=s.length();
        int cnt=0;
        int[] arr=new int[3];

        int i=n-1, j=n-1;
        while(i>=0 && j>=0){
            arr[s.charAt(i)-'a']++;

            while(arr[0]>0 && arr[1]>0 && arr[2]>0){                  
                    cnt+=i+1;  
                    arr[s.charAt(j)-'a']--;
                    j--;                
            }
            i--;
        }

        return cnt;
    }

}

// Maximum Points You Can Obtain from Cards

class Solution {
    public int maxScore(int[] cardPoints, int k) {
      
        int lSum = 0;
        int rSum = 0;
        int maxSum =0;

        for(int i=0; i<k; i++){
            lSum += cardPoints[i];
        }
        maxSum = lSum;

        int idx = cardPoints.length-1;
        for(int i=k-1; i>=0; i--){
            lSum -= cardPoints[i];
            rSum += cardPoints[idx];
            idx--;

            maxSum = Math.max(maxSum,lSum+rSum);
        }

        return maxSum;
    }
}