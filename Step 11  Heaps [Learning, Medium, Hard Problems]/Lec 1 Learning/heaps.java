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