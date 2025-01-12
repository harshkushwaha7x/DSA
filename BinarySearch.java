//Binary Search to find X in sorted array

import java.util.Stack;

class BinarySearch  {
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

//Implement Lower Bound

class Solution {

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