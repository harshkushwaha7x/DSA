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
