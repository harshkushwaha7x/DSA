// Binary Search to find X in a sorted array

class BinarySearchToFindX {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) return mid;
            else if (nums[mid] > target) right = mid - 1;
            else left = mid + 1;
        }
        return -1;
    }
}

// Implement Lower Bound

class ImplementLowerBound {
    static int findFloor(int[] arr, int k) {
        int low = 0, high = arr.length - 1;
        if (arr[low] > k) return -1; // No floor exists
        if (arr[high] < k) return high; // All values are less than k

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == k) return mid;
            else if (arr[mid] > k) high = mid - 1;
            else low = mid + 1;
        }
        return high; 
    }
}

// Implement Upper Bound

class ImplementUpperBound {
    public int[] getFloorAndCeil(int x, int[] arr) {
        int floor = Integer.MIN_VALUE, ceil = Integer.MAX_VALUE;
        for (int num : arr) {
            if (num <= x) floor = Math.max(floor, num);
            if (num >= x) ceil = Math.min(ceil, num);
        }
        if (floor == Integer.MIN_VALUE) floor = -1;
        if (ceil == Integer.MAX_VALUE) ceil = -1;
        
        return new int[] {floor, ceil};
    }
}

// Search Insert Position

class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) return mid;
            else if (nums[mid] > target) end = mid - 1;
            else start = mid + 1;
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
            int mid = low + (high - low) / 2;
            if (arr[mid] <= x) {
                ans = arr[mid]; 
                low = mid + 1; 
            } else {
                high = mid - 1; 
            }
        }
        return ans;
    }

    static int findCeil(int[] arr, int n, int x) {
        int low = 0, high = n - 1;
        int ans = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] >= x) {
                ans = arr[mid]; 
                high = mid - 1; 
            } else {
                low = mid + 1; 
            }
        }
        return ans;
    }

    public static int[] getFloorAndCeil(int[] arr, int n, int x) {
        int floor = findFloor(arr, n, x);
        int ceil = findCeil(arr, n, x);
        return new int[] {floor, ceil};
    }

    public static void main(String[] args) {
        int[] arr = {3, 4, 4, 7, 8, 10};
        int n = 6, x = 5;
        int[] ans = getFloorAndCeil(arr, n, x);
        System.out.println("The floor and ceil are: " + ans[0] + " " + ans[1]);
    }
}

// Find the first or last occurrence of a given number in a sorted array

class SolutionFirstLast {
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        result[0] = search(nums, target, true);
        result[1] = search(nums, target, false);
        return result;
    }

    private int search(int[] nums, int target, boolean findFirst) {
        int left = 0, right = nums.length - 1, result = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                result = mid;
                if (findFirst) right = mid - 1;
                else left = mid + 1;
            } else if (nums[mid] > target) right = mid - 1;
            else left = mid + 1;
        }
        return result;
    }
}

// Count occurrences of a number in a sorted array with duplicates

class SolutionCountOccurrences {
    public int countFreq(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        int count = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                count++;
                int temp = mid - 1;
                while (temp >= 0 && arr[temp] == target) {
                    count++;
                    temp--;
                }
                temp = mid + 1;
                while (temp < arr.length && arr[temp] == target) {
                    count++;
                    temp++;
                }
                break;
            } else if (arr[mid] > target) right = mid - 1;
            else left = mid + 1;
        }
        return count;
    }
}

// Search in Rotated Sorted Array

class SolutionRotatedArray {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int start = 0, end = n - 1;
        
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) return mid;
            if (nums[start] <= nums[mid]) {
                if (nums[start] <= target && target <= nums[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                if (nums[mid] <= target && target <= nums[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return -1;
    }
}

// Search in Rotated Sorted Array || (with duplicates)

class SolutionRotatedArrayWithDuplicates {
    public boolean search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) return true;

            if (nums[left] == nums[mid] && nums[mid] == nums[right]) {
                left++;
                right--;
            } else if (nums[left] <= nums[mid]) {
                if (nums[left] <= target && target <= nums[mid]) right = mid - 1;
                else left = mid + 1;
            } else {
                if (nums[mid] <= target && target <= nums[right]) left = mid + 1;
                else right = mid - 1;
            }
        }
        return false;
    }
}

// Find Minimum in Rotated Sorted Array

class Solution {
    public int findMin(int[] nums) {
       int n=nums.length;
       int l=0, r=n-1;
       while(l<r){
        int m=l+(r-l)/2;
        if(nums[m]< nums[r]){
            r=m;
        }
        else{
            l=m+1;
        }
       } 
       return nums[l];
    }
}


// Find Kth Rotation

class Solution {
    public int findKRotation(List<Integer> arr) {
        int start = 0;
        int end = arr.size()-1;
        int count =0; 
        while(start<end){
            if(arr.get(start)>arr.get(end)){
                count++;
                start++;
            }else{
                end--;
            }
        }
        return count;
    }  
}

// Single Element in a Sorted Array

class Solution {
    public int singleNonDuplicate(int[] nums) {
        if(nums.length==1){
            return nums[0];
        }
        int si=0,ei=nums.length-1;
        while(si<=ei){
            int mid=si+(ei-si)/2;
            if(mid==0 && nums[mid]!=nums[mid+1]){
                return nums[mid];
            }
            if(mid==nums.length-1 && nums[mid]!=nums[nums.length-2]){
                return nums[mid];
            }

            if(nums[mid-1]!=nums[mid] && nums[mid]!= nums[mid+1]){
                return nums[mid];
            }

            if(mid%2==0){
                if(nums[mid-1]==nums[mid]){
                    ei=mid-1;
                }else{
                    si=mid+1;
                }
            } else{
                if(nums[mid-1]==nums[mid]){
                    si=mid+1;
                }else{
                    ei=mid-1;
                }
            }
        }
         return -1;
    }
}