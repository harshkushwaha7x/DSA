// Selection Sort
class SelectionSort {
    void selectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {  
            int min = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            if (min != i) {  
                int temp = arr[i];
                arr[i] = arr[min];
                arr[min] = temp;
            }
        }
    }
}

// Merge Sort
class MergeSort {
    void mergeSort(int arr[], int low, int high) {
        if (low < high) {  
            int mid = (low + high) / 2;
            mergeSort(arr, low, mid);
            mergeSort(arr, mid + 1, high);
            merge(arr, low, mid, high);
        }
    }

    void merge(int[] arr, int low, int mid, int high) {
        int left = low;
        int right = mid + 1;
        int[] temp = new int[high - low + 1];
        int i = 0;

        while (left <= mid && right <= high) {
            if (arr[left] <= arr[right]) {
                temp[i++] = arr[left++];
            } else {
                temp[i++] = arr[right++];
            }
        }

        while (left <= mid) {
            temp[i++] = arr[left++];
        }

        while (right <= high) {
            temp[i++] = arr[right++];
        }

        for (i = 0; i < temp.length; i++) {
            arr[low + i] = temp[i];
        }
    }
}

// Bubble Sort
class BubbleSort {
    void bubbleSort(int arr[]) {
        int n = arr.length;
        for (int i = n - 1; i >= 1; i--) {
            boolean swapped = false;  
            for (int j = 0; j <= i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                    swapped = true;
                }
            }
            if (!swapped) break;  
        }
    }
}

// Insertion Sort
class InsertionSort {
    void insertionSort(int arr[]) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {  
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;  
        }
    }
}

// Quick Sort
class QuickSort {
    void quickSort(int arr[], int low, int high) {
        if (low < high) { 
            int part = partition(arr, low, high);
            quickSort(arr, low, part - 1);
            quickSort(arr, part + 1, high);
        }
    }

    int partition(int arr[], int low, int high) {
        int pivot = arr[low];
        int i = low + 1;
        int j = high;
        while (i <= j) {
            while (i <= high && arr[i] <= pivot) i++;
            while (j >= low && arr[j] > pivot) j--;
            if (i < j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[j];
        arr[j] = arr[low];
        arr[low] = temp;

        return j;
    }
}