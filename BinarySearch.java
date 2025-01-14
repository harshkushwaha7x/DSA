//1 Binary Search to find X in sorted array

import java.util.Stack;

class Binary_Search_to_find_X_in_sorted_array  {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int left = 0, right = n-1;
        while(left <= right){
            int mid = (left + right)/2;
            if(nums[mid] == target) return mid;
            else if(nums[mid] > target) right = mid - 1;
            else left = mid + 1;
        }
        return -1;
    }
}

//2 Implement Lower Bound

class Implement_Lower_Bound {

    static int findFloor(int[] arr, int k) {
        // write code here
        int low = 0;
        int high = arr.length - 1;
        if(arr[low]>k){
            return -1;
        }
        if(arr[high]<k){
            return high;
        }
        while(low <= high){
            int mid = (low + high)/2;
            if(arr[mid] == k){
                return mid;
            }else if(arr[mid]>k){
                if(mid==0){
                    return -1;
                }else if(arr[mid - 1]>k){
                    high = mid-1;
                }else{
                    return mid-1;
                }
            }
            else if(arr[mid]>k){
                high = mid-1;
            }else{
                low = mid + 1;
            }
        }
        return -1;
    }
}

//3 Implement Upper Bound

class Implement_Upper_Bound {
    public int[] getFloorAndCeil(int x, int[] arr) {
      int floor = Integer.MIN_VALUE,ceil = Integer.MAX_VALUE;
      for(int num : arr){
          if(num<=x){
              floor = Math.max(floor,num);
          }
          if(num>=x){
             ceil = Math.min(ceil,num);
          }
      }
      if(floor == Integer.MIN_VALUE)floor = -1;
      if(ceil == Integer.MAX_VALUE) ceil= -1;
      
      return new int[] {floor,ceil};
    }
}

//4 Search Insert Position

class Search_Insert_Position {
    public int searchInsert(int[] nums, int target) {
        int start = 0;
        int end = nums.length-1;

        while (start <= end) {
            int mid = start + (end-start)/2;
            if (nums[mid] == target) return mid;
            else if (nums[mid] > target) end = mid-1;
            else start = mid+1;
        }

        return start;
    }
}