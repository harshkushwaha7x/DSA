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

// Floor and Ceil in Sorted Array

public class BinarySearch {
    static int findFloor(int[] arr, int n, int x) {
        int low = 0, high = n - 1;
        int ans = -1;

        while (low <= high) {
            int mid = (low + high) / 2;
            // maybe an answer
            if (arr[mid] <= x) {
                ans = arr[mid];
                //look for smaller index on the left
                low = mid + 1;
            } else {
                high = mid - 1; // look on the right
            }
        }
        return ans;
    }

    static int findCeil(int[] arr, int n, int x) {
        int low = 0, high = n - 1;
        int ans = -1;

        while (low <= high) {
            int mid = (low + high) / 2;
            // maybe an answer
            if (arr[mid] >= x) {
                ans = arr[mid];
                //look for smaller index on the left
                high = mid - 1;
            } else {
                low = mid + 1; // look on the right
            }
        }
        return ans;
    }
    public static int[] getFloorAndCeil(int[] arr, int n, int x) {
        int f = findFloor(arr, n, x);
        int c = findCeil(arr, n, x);
        return new int[] {f, c};
    }
    public static void main(String[] args) {
        int[] arr = {3, 4, 4, 7, 8, 10};
        int n = 6, x = 5;
        int[] ans = getFloorAndCeil(arr, n, x);
        System.out.println("The floor and ceil are: " + ans[0]
                           + " " + ans[1]);
    }
} 

// Find the first or last occurrence of a given number in a sorted array

class Solution {
    public int[] searchRange(int[] nums, int t) {
        int[] a = new int[2];
        a[0] = search(nums, t, true);
        a[1] = search(nums, t, false);
        return a;
    }

    public int search(int[] nums, int t, boolean b) {
        int s = 0;
        int e = nums.length - 1;
        int m;
        int a = -1;
        while (s <= e) {
            m = s + (e - s) / 2;
            if (nums[m] == t) {
                a = m;
                if (b) {
                    e = m - 1;
                } else {
                    s = m + 1;
                }
            } else if (nums[m] > t) {
                e = m - 1;
            } else {
                s = m + 1;
            }
        }
        return a;
    }
}

