// Pascal's Triangle

class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(List.of(1));

        for (int i = 0; i < numRows - 1; i++) {
            List<Integer> dummyRow = new ArrayList<>();
            dummyRow.add(0);
            dummyRow.addAll(res.get(res.size() - 1));
            dummyRow.add(0);
            List<Integer> row = new ArrayList<>();

            for (int j = 0; j < dummyRow.size() - 1; j++) {
                row.add(dummyRow.get(j) + dummyRow.get(j + 1));
            }

            res.add(row);
        }

        return res;        
    }
}

// Majority Element II

class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > n / 3) {
                res.add(entry.getKey());
            }
        }
        
        return res;
    }
}

// 3Sum

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result= new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0; i<nums.length; i++){
            if(i>0 && nums[i]== nums[i-1]){
                continue;
            }
            
        int j= i+1;
        int k= nums.length-1;
        while(j<k){
            int total= nums[i]+ nums[j]+ nums[k];

            if(total>0){
                k--;
            }else if(total<0){
                j++;
            }else{
               result.add(Arrays.asList(nums[i], nums[j], nums[k])); 
               j++;

               while(nums[j]== nums[j-1] && j<k){
                 j++;
               }
            }
          }
        }
        return result;
    }
}

// 4Sum

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> li=new ArrayList<>();
        if(nums==null || nums.length<4){
            return li;
        }
        Arrays.sort(nums);
        for(int i=0;i<nums.length-3;i++){
            if(i>0&&nums[i]==nums[i-1]){
                continue;
            }
            for(int j=i+1;j<nums.length-2;j++){
                if(j>i+1&&nums[j]==nums[j-1]){
                    continue;
                }
                int left=j+1; int right=nums.length-1;
                while(left<right){
                    long sum=(long)nums[i]+nums[j]+nums[left]+nums[right];
                    if(sum==target){
                        li.add(Arrays.asList(nums[i],nums[j],nums[left],nums[right]));
                        while(left<right&&nums[left]==nums[left+1]){
                            left++;
                        }
                        while(left<right&&nums[right]==nums[right+-1]){
                            right--;
                        }
                        left++;
                        right--;
                    }else if(sum<target){
                        left++;
                    }else{
                        right--;
                    }
                }
            }
        }
        return li;
    }
}

// Largest subarray with 0 sum

class Solution {
    int maxLen(int arr[]) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int maxlen = 0;
        int Sum = 0;
        for (int i = 0; i < arr.length; i++) {
            Sum += arr[i];
            if (Sum == 0) {
                maxlen = i + 1; 
            }
            if (map.containsKey(Sum)) {
                maxlen = Math.max(maxlen, i -map.get(Sum));
            } else {
                map.put(Sum, i);
            }
        }

        return maxlen;
    }
}

// Merge Intervals

class Solution {
    public int[][] merge(int[][] arr) {
        List<int[]> res = new ArrayList<>();
        Arrays.sort(arr, (a,b) -> Integer.compare(a[0], b[0]));
        int start = arr[0][0], prev_end = arr[0][1];

        for(int i=1; i<arr.length; i++){
            if( arr[i][0]<=prev_end ){
                prev_end = Math.max(prev_end, arr[i][1]);
            } 
            else {
                res.add(new int[]{start, prev_end});
                start = arr[i][0];
                prev_end = arr[i][1];
            }
        }
        res.add(new int[]{start, prev_end});

        return res.toArray(new int[res.size()][]);
    }
}

// Merge Sorted Array

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
         int p1 = m - 1;
         int p2 = n - 1;
         int pMerge = m + n - 1;
         
         while (p2 >= 0) {
             if (p1 >= 0 && nums1[p1] > nums2[p2]) {
                 nums1[pMerge--] = nums1[p1--];
             } else {
                 nums1[pMerge--] = nums2[p2--];
             }
         }
     }
 }


 // Missing And Repeating

 class Solution {
    ArrayList<Integer> findTwoElement(int arr[]) {
        int freq[]=new int [arr.length+1];
        int mis=-1;
        int rep=-1;
        for(int num:arr)
        {
            freq[num]++;
        }
        for(int i=1;i<=arr.length;i++)
        {
            if(freq[i]>=2)
            {
                rep=i;
            }
            if(freq[i]==0)
            {
                mis=i;
            }
        }
        ArrayList<Integer>ans=new ArrayList<>();
        ans.add(rep);
        ans.add(mis);
        return ans;
    }
}

// Count Inversions

class Solution {
    static int inversionCount(int[] arr) {
        if (arr.length < 2) {
            return 0;
        }
        int[] temp = new int[arr.length];
        return mergeSortAndCount(arr, temp, 0, arr.length - 1);
    }

    private static int mergeSortAndCount(int[] arr, int[] temp, int left, int right) {
        int mid, invCount = 0;
        if (left < right) {
            mid = (left + right) / 2;
            invCount += mergeSortAndCount(arr, temp, left, mid);
            invCount += mergeSortAndCount(arr, temp, mid + 1, right);
            invCount += mergeAndCount(arr, temp, left, mid, right);
        }
        return invCount;
    }

    private static int mergeAndCount(int[] arr, int[] temp, int left, int mid, int right) {
        int i = left;
        int j = mid + 1;
        int k = left;
        int invCount = 0;

        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
                invCount += (mid + 1) - i;
            }
        }

        while (i <= mid) {
            temp[k++] = arr[i++];
        }

        while (j <= right) {
            temp[k++] = arr[j++];
        }

        for (i = left; i <= right; i++) {
            arr[i] = temp[i];
        }

        return invCount;
    }
}

// Reverse Pairs

class Solution {
    public  static int mergesort(int nums[],int st, int end){
        int count=0;
        if(st>=end){
            return 0;
        }
        int mid=st+(end-st)/2;
       count+=mergesort(nums,st,mid);
       count+=mergesort(nums,mid+1,end);
        count+=countpair(nums,st,end,mid);
        merge(nums,st,end,mid);
        return count;
    }

    public  static  void merge(int nums[],int st, int end, int mid){
        int temp[]=new int[end-st+1];
        int i=st;
        int j=mid+1;
        int k=0;

        while(i<=mid && j<=end){
          if(nums[i]<=nums[j]){
          temp[k++]=nums[i++];
        }else{
            temp[k++]=nums[j++];
        }
        }

        while(i<=mid){
             temp[k++]=nums[i++];
        }
        
        while(j<=end){
             temp[k++]=nums[j++];
        }

        for(int x=0,y=st;x<temp.length;x++,y++){
            nums[y]=temp[x];
        }
    }

    public static int countpair(int nums[],int st, int end , int mid){
        int right=mid+1;
        int pcount=0;
        for(int i=st;i<=mid;i++){
            while(right<=end && (long)nums[i]>2L*nums[right]){
                right++;
            }
            pcount+=(right-(mid+1));
        }
        return pcount;
    }
    public int reversePairs(int[] nums) {
        return mergesort(nums,0,nums.length-1);
    }   
}

// Maximum Product Subarray

class Solution {
    public int maxProduct(int[] nums) {
        
        int max = nums[0], min = nums[0], ans = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
            
            int temp = max;  // store the max because before updating min your max will already be updated
            
            max = Math.max(Math.max(max * nums[i], min * nums[i]), nums[i]);
            min = Math.min(Math.min(temp * nums[i], min * nums[i]), nums[i]);
            
            if (max > ans) {
                ans = max;
            }
        }
        
        return ans;

    }
}

