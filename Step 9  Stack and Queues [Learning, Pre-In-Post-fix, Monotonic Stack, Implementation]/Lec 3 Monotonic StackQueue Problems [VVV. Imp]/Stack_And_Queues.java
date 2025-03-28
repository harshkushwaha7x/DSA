// Next Greater Element I

class Solution {
    public static int findInd(int arr[],int num){
        for(int i = 0; i<arr.length; i++){
            if(arr[i]==num){
                return i;
            }
        }
        return -1;
    }
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int size = nums1.length;
        int res[] = new int [size];
        int ind = 0;
        for(int i = 0; i<nums1.length; i++){
            int cnt = 0;
            for(int j = findInd(nums2,nums1[i]); j<nums2.length; j++){
                if(nums1[i]<nums2[j]){
                    res[ind++] = nums2[j];
                    cnt++;
                    break;
                   
                }
            }
            if(cnt==0){
                res[ind++] = -1;
            }
        }
        return res;

      
        
    }
}

// Next Greater Element II

class Solution {
    public int[] nextGreaterElements(final int[] nums) {
        final int n = nums.length;
        final int[] res = new int[n];
        final Stack<Integer> stack = new Stack<>();

        Arrays.fill(res, -1);

        for(int i = 0; i < n * 2; ++i) {
            final int idx = i % n;

            while(!stack.isEmpty() && nums[stack.peek()] < nums[idx])
                res[stack.pop()] = nums[idx];

            stack.push(idx);
        }

        return res;
    }
}

// Number of greater elements to the right

class Solution {
    public static int[] count_NGEs(int n, int[] arr, int queries, int[] indices) {
        Stack<Integer> asc = new Stack<>();
        Stack<Integer> desc = new Stack<>();
        int[] v = new int[n];
        int[] ans = new int[queries];

        for (int i = n - 1; i >= 0; i--) {
            int ele = arr[i];
            while (!asc.isEmpty() && ele >= asc.peek()) {
                desc.push(asc.pop());
            }
            desc.push(ele);
            v[i] = asc.size();
            while (!desc.isEmpty()) {
                asc.push(desc.pop());
            }
        }

        for (int i = 0; i < queries; i++) {
            ans[i] = v[indices[i]];
        }

        return ans;
    }
}

// Trapping Rain Water

class Solution {
    public int trap(int[] height) {
        int n = height.length;
        if (n == 0) return 0;
        
        int[] left = new int[n];
        int[] right = new int[n];
        int storedWater = 0;
        
        left[0] = height[0];
        for (int i = 1; i < n; i++) {
            left[i] = Math.max(left[i - 1], height[i]);
        }
        
        right[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            right[i] = Math.max(right[i + 1], height[i]);
        }
        
        for (int i = 0; i < n; i++) {
            int minHeight = Math.min(left[i], right[i]);
            storedWater += minHeight - height[i];
        }
        
        return storedWater;
    }
}

// Sum of Subarray Minimums

class Solution {
    public int sumSubarrayMins(int[] arr) {
        int length = arr.length;
        int[] left = new int[length];
        int[] right = new int[length];
      
        Arrays.fill(left, -1);
        Arrays.fill(right, length);
      
        Deque<Integer> stack = new ArrayDeque<>();
      
        for (int i = 0; i < length; ++i) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                left[i] = stack.peek();
            }
            stack.push(i);
        }
      
        stack.clear();
      
        for (int i = length - 1; i >= 0; --i) {
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                right[i] = stack.peek();
            }
            stack.push(i);
        }
      
        int mod = (int) 1e9 + 7;
        long answer = 0;
      
        for (int i = 0; i < length; ++i) {
            answer += (long) (i - left[i]) * (right[i] - i) % mod * arr[i] % mod;
            answer %= mod;
        }
      
        return (int) answer;
    }
}

// Asteroid Collision

class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();

        int i = 0;
        while (i < asteroids.length){
            
            int val = asteroids[i];
  
            if (stack.isEmpty() || stack.peek() < 0 || val > 0){
                stack.push(val);
                i++;
            }
            else {
                if (stack.peek() > 0 && val < 0){

                    int a = stack.peek();
                    int b = Math.abs(val); 

                    if (a > b){
                        i++;
                    } else if (a == b) {
                        i++;
                        stack.pop();
                    } else {
                        stack.pop();
                    }

                }
            }

        }

        int[] result = new int[stack.size()];
        for (int j = 0; j < stack.size(); j++) {
            result[j] = stack.get(j);
        }

        return result;
    }
}

// Sum of Subarray Ranges

class Solution {
    public long subArrayRanges(int[] nums) {
        int n = nums.length;
        long ans = 0;
        for(int i=0; i<n; i++){
            int max = nums[i];
            int min = nums[i];
            for(int j=i; j<n; j++){
                max = Math.max(nums[j],max);
                min = Math.min(nums[j],min);
                ans += max-min;
            }
        }
        return ans;
    }
}