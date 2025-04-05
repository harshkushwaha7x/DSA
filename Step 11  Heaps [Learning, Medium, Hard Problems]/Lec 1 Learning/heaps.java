// Implementation of Priority Queue using Binary Heap

class PriorityQueueExtractMax {
    public int extractMax() {
        MinHeap obj = new MinHeap(0); 
        int largest = obj.harr[0];
        obj.harr[0] = obj.harr[obj.heap_size];
        obj.heap_size--;
        obj.MinHeapify(0);
        return largest;
    }
};

// Binary Heap Operations

class MinHeap {
    int[] harr;
    int capacity;
    int heap_size;
    
    MinHeap(int cap) {
        heap_size = 0;
        capacity = cap;
        harr = new int[cap];
    }
    
    int parent(int i) { return (i - 1) / 2; }
    int left(int i) { return (2 * i + 1); }
    int right(int i) { return (2 * i + 2); }

    int extractMin() {
        if(heap_size < 1) return -1;
        int largest = harr[0];
        harr[0] = harr[heap_size - 1];
        heap_size--;
        MinHeapify(0);
        return largest;
    }

    void insertKey(int k) {
        if(heap_size == capacity) return;
        heap_size++;
        decreaseKey(heap_size - 1, k);
    }

    void deleteKey(int i) {
        if(i < heap_size) {
            decreaseKey(i, -1);
            extractMin();
        }
    }

    void decreaseKey(int i, int new_val) {
        harr[i] = new_val;
        while (i != 0 && harr[parent(i)] > harr[i]) {
            int temp = harr[i];
            harr[i] = harr[parent(i)];
            harr[parent(i)] = temp;
            i = parent(i);
        }
    }

    void MinHeapify(int i) {
        int l = left(i);
        int r = right(i);
        int smallest = i;
        if (l < heap_size && harr[l] < harr[i]) smallest = l;
        if (r < heap_size && harr[r] < harr[smallest]) smallest = r;
        if (smallest != i) {
            int temp = harr[i];
            harr[i] = harr[smallest];
            harr[smallest] = temp;
            MinHeapify(smallest);
        }
    }
}

// Does array represent Heap

class HeapChecker {
    public boolean countSub(long arr[], long n) {
        for(int i = 0; i < n; i++) {
            int left = 2 * i + 1;
            int right = 2 * i + 2;
            if(left < n && arr[left] > arr[i] || right < n && arr[right] > arr[i]) return false;
        }
        return true;
    }
}

// Convert Min Heap to Max Heap

class HeapConverter {
    static void convertMinToMaxHeap(int n, int arr[]) {
        for (int i = (n - 1) / 2; i >= 0; i--) {
            heapify(arr, i, n);
        }
    }
  
    static void heapify(int[] arr, int index, int n) {
        int largest = index;
        int left = index * 2 + 1;
        int right = index * 2 + 2;
        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }
        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }
        if (index != largest) {
            swap(arr, index, largest);
            heapify(arr, largest, n);
        }
    }
  
    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}