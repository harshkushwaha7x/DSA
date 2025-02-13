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