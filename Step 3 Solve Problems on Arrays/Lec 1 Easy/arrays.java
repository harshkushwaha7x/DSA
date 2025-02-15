import java.util.ArrayList;
import java.util.Arrays;

// Largest Element in Array
class LargestElementInArray {
    public static int findLargest(int[] arr) {
        Arrays.sort(arr);
        int size = arr.length;
        return arr[size - 1];
    }
}

// Second Largest Element in Array (using QuickSort)
class SecondLargestElement {
    static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pIndex = partition(arr, low, high);
            quickSort(arr, low, pIndex - 1);
            quickSort(arr, pIndex + 1, high);
        }
    }

    static int partition(int[] arr, int low, int high) {
        int pivot = arr[low];
        int i = low;
        int j = high;
        while (i < j) {
            while (arr[i] <= pivot && i <= high - 1) {
                i++;
            }
            while (arr[j] > pivot && j >= low + 1) {
                j--;
            }
            if (i < j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[low];
        arr[low] = arr[j];
        arr[j] = temp;
        return j;
    }

    public static int findSecondLargest(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
        return arr[arr.length - 2];
    }
}

// Check if Array Is Sorted and Rotated
class CheckSortedAndRotated {
    public boolean isSortedAndRotated(int[] nums) {
        int count = 0, n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] > nums[(i + 1) % n] && ++count > 1) {
                return false;
            }
        }
        return count <= 1;
    }
}

// Remove Duplicates from Sorted Array
class RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
        int j = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[j] = nums[i];
                j++;
            }
        }
        return j;
    }
}

// Rotate Array (using extra space)
class RotateArray {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        if (k == 0) return;

        int[] temp = new int[k];
        System.arraycopy(nums, n - k, temp, 0, k);

        for (int i = n - k - 1; i >= 0; i--) {
            nums[i + k] = nums[i];
        }

        System.arraycopy(temp, 0, nums, 0, k);
    }
}

// Rotate Array (in-place using reversal)
class RotateArrayInPlace {
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}

// Move Zeroes to the End
class MoveZeroes {
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (nums[i] != 0) {
                nums[count++] = nums[i];
            }
        }

        while (count < n) {
            nums[count++] = 0;
        }
    }
}

// Search in Sorted Array
class SearchInSortedArray {
    static boolean search(int[] arr, int k) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == k) {
                return true;
            }
        }
        return false;
    }
}

// Union of Two Sorted Arrays (with duplicates handled)
class UnionOfSortedArrays {
    public static ArrayList<Integer> findUnion(int[] a, int[] b) {
        int n = a.length;
        int m = b.length;

        ArrayList<Integer> union = new ArrayList<>();

        int i = 0, j = 0;

        while (i < n && j < m) {
            if (i > 0 && a[i] == a[i - 1]) {
                i++;
                continue;
            }

            if (j > 0 && b[j] == b[j - 1]) {
                j++;
                continue;
            }

            if (a[i] < b[j]) {
                union.add(a[i]);
                i++;
            } else if (b[j] < a[i]) {
                union.add(b[j]);
                j++;
            } else {
                union.add(a[i]);
                i++;
                j++;
            }
        }

        while (i < n) {
            if (i == 0 || a[i] != a[i - 1]) {
                union.add(a[i]);
            }
            i++;
        }

        while (j < m) {
            if (j == 0 || b[j] != b[j - 1]) {
                union.add(b[j]);
            }
            j++;
        }

        return union;
    }
}

// Missing Number

class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
       int exp_sum = n*(n + 1)/2;
       int sum=0;
       for(int i =0 ;i < n;i++){
        sum+=nums[i];
       }
       return exp_sum - sum;
    }
}

