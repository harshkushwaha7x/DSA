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
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] <= k) low = mid + 1;
            else high = mid - 1;
        }
        return high;
    }
}

// Implement Upper Bound
class ImplementUpperBound {
    static int findCeil(int[] arr, int k) {
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] >= k) high = mid - 1;
            else low = mid + 1;
        }
        return low < arr.length ? low : -1;
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
class FloorAndCeil {
    public static int[] getFloorAndCeil(int[] arr, int x) {
        int floor = -1, ceil = -1;
        int low = 0, high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == x) {
                floor = ceil = arr[mid];
                break;
            } else if (arr[mid] < x) {
                floor = arr[mid];
                low = mid + 1;
            } else {
                ceil = arr[mid];
                high = mid - 1;
            }
        }
        return new int[] {floor, ceil};
    }
}

// Find the first or last occurrence of a given number in a sorted array
class SearchRange {
    public int[] searchRange(int[] nums, int target) {
        return new int[] {search(nums, target, true), search(nums, target, false)};
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
class CountOccurrences {
    public int countFreq(int[] nums, int target) {
        int first = search(nums, target, true);
        if (first == -1) return 0; // Target not found
        int last = search(nums, target, false);
        return last - first + 1;
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

// Search in Rotated Sorted Array
class RotatedArraySearch {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) return mid;
            if (nums[left] <= nums[mid]) {
                if (nums[left] <= target && target < nums[mid]) right = mid - 1;
                else left = mid + 1;
            } else {
                if (nums[mid] < target && target <= nums[right]) left = mid + 1;
                else right = mid - 1;
            }
        }
        return -1;
    }
}

// Find Minimum in Rotated Sorted Array
class FindMinInRotatedArray {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < nums[right]) right = mid;
            else left = mid + 1;
        }
        return nums[left];
    }
}

// Single Element in a Sorted Array
class SingleNonDuplicate {
    public int singleNonDuplicate(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (mid % 2 == 1) mid--; // Ensure we're on the even index
            if (nums[mid] == nums[mid + 1]) left = mid + 2;
            else right = mid;
        }
        return nums[left];
    }
}

// Find Peak Element
class FindPeakElement {
    public int findPeakElement(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < nums[mid + 1]) left = mid + 1;
            else right = mid;
        }
        return left;
    }
}

// Square Root
class SquareRoot {
    public int floorSqrt(int n) {
        int low = 1, high = n / 2, ans = -1;
        if (n == 1) return 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (mid <= n / mid) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }
}

// Find nth Root of m
class NthRoot {
    public int nthRoot(int n, int m) {
        int low = 1, high = m;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            long power = (long) Math.pow(mid, n);
            if (power == m) return mid;
            else if (power < m) low = mid + 1;
            else high = mid - 1;
        }
        return -1;
    }
}

// Koko Eating Bananas

class Solution {
    public int max(int[] arr) {
        int m = -1;
        for (int i = 0; i < arr.length; i++) {
            if (m < arr[i]) {
                m = arr[i];
            }
        }
        return m;
    }

    public int minEatingSpeed(int[] piles, int h) {
        int n = max(piles); 
        int l = 1;          
        int r = n;          
        int ans = Integer.MAX_VALUE;

        while (l <= r) {
            long hr = 0; 
            int mid = (l + r) / 2;

            for (int i = 0; i < piles.length; i++) {
                hr += (long) (piles[i] + mid - 1) / mid; 
            }

            if (hr <= h) {
                ans = Math.min(ans, mid);
                r = mid - 1; 
            } else {
                l = mid + 1; 
            }
        }

        return ans; 
    }
}

// Minimum Number of Days to Make m Bouquets

class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int left = 1, right = 1000000000;
        int result = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (canMakeBouquets(bloomDay, m, k, mid)) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return result;
    }

    private boolean canMakeBouquets(int[] bloomDay, int m, int k, int days) {
        int consecutiveFlowers = 0, bouquetCount = 0;

        for (int bloom : bloomDay) {
            if (bloom <= days) {
                consecutiveFlowers++;
                if (consecutiveFlowers == k) {
                    bouquetCount++;
                    consecutiveFlowers = 0;
                }
            } else {
                consecutiveFlowers = 0;
            }
        }

        return bouquetCount >= m;
    }
}

// Find the Smallest Divisor Given a Threshold

class Solution {
    public int findSum(int[] nums, int div){
        int sum =0;
        for(int n: nums){
            sum+= Math.ceil((double)n/div);
        }
        return sum;
    }
    public int binarySearch(int[]nums, int threshold, int low, int high){

        while(low<= high){
            int mid  = (low+high)/2;
            if(findSum(nums, mid)>threshold){
                low = mid+1;
            }
            else{
                high = mid-1;
            }
        }
        return low;
    }
    public int smallestDivisor(int[] nums, int threshold) {
        int max = Integer.MIN_VALUE;
        for(int n: nums){            
            if(n>max){
                max=n;
            }
        }
        return binarySearch(nums, threshold, 1, max);
    }
}