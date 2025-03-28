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