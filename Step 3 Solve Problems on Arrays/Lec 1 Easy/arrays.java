// Largest Element in Array

class Solution {
    public static int largest(int[] arr) {
        // code here
        
        Arrays.sort(arr);
        int size = arr.length;
        return arr[size-1];
    }
}

// Second Largest

class Solution {
    static void quickSort(int arr[], int low, int high) {
        if(low<high){
            int pIndex=partition(arr,low,high);
            quickSort(arr,low,pIndex-1);
            quickSort(arr,pIndex+1,high);
        }
        return;
    }

    static int partition(int arr[], int low, int high) {
        int pivot=arr[low];
        int i=low;
        int j=high;
        while(i<j){
            while(arr[i]<=pivot && i<=high-1){
                i++;
            }
            while(arr[j]>pivot && j>=low+1){
                j--;
            }
            if(i<j){
                int temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
            }
        }
        int temp=arr[low];
        arr[low]=arr[j];
        arr[j]=temp;
        return j;
    }
}

// Check if Array Is Sorted and Rotated

class Solution {
    public boolean check(int[] nums) {
        int count = 0, n = nums.length;
        for (int i = 0; i < n; i++) 
            if (nums[i] > nums[(i+1) % n] && ++count > 1) return false;
        return count <= 1;
    }
}

// Remove Duplicates from Sorted Array

class Solution {
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