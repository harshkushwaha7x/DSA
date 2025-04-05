import java.util.PriorityQueue;

// Kth Largest Element in an Array

class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int num:nums){
            minHeap.add(num);
                if(minHeap.size()>k){
                    minHeap.poll();
                }
            }
            return minHeap.peek();
    }
}

// Kth Smallest

class Solution {
    public static int kthSmallest(int[] arr, int k) {
        PriorityQueue<Integer> q=new PriorityQueue<>(Collections.reverseOrder());
        for(int num:arr){
            q.add(num);
            if(q.size()>k){
                q.poll();
            }
        }
        return q.poll();
    }
}