// Largest Element in Array

class Solution {
    public static int largest(int[] arr) {
        // code here
        
        Arrays.sort(arr);
        int size = arr.length;
        return arr[size-1];
    }
}

// 