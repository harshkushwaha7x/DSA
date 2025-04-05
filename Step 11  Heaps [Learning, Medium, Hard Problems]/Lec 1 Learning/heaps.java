// Implementation of Priority Queue using Binary Heap

class Solution {
    public int extractMax() {
          GFG obj=new GFG();
          int largest=obj.H[0];
          obj.H[0]=obj.H[obj.s];
          obj.s--;
          obj.shiftDown(0);
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

    int extractMin()
    {
        if(heap_size<1)return -1;
        int largest=harr[0];
        harr[0]=harr[heap_size-1];
        heap_size--;
        MinHeapify(0);
        return largest;
    }

    void insertKey(int k) 
    {
       if(heap_size==capacity)return;
       heap_size++;
       decreaseKey(heap_size-1,k);
       
    }

    void deleteKey(int i) 
    {
        if(i<heap_size){
            decreaseKey(i,-1);
            extractMin();
        }
    }

    void decreaseKey(int i, int new_val) 
    {
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