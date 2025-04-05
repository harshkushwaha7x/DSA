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

// Merge k Sorted Arrays

class Solution
{
    static class Node{
        int val,row,col;
        Node (int val,int row,int col){
            this.val=val;
            this.row=row;
            this.col=col;
        }
    }
    public static ArrayList<Integer> mergeKArrays(int[][] arr,int k) 
    {
       PriorityQueue<Node> minHeap=new PriorityQueue<>(Comparator.comparingInt(a->a.val));
       ArrayList<Integer> res=new ArrayList<>();
       for(int i=0;i<k;i++){
           minHeap.add(new Node(arr[i][0],i,0));
       }
       while(!minHeap.isEmpty()){
           Node current=minHeap.poll();
           res.add(current.val);
           int nextCol=current.col+1;
           if(nextCol<k){
               minHeap.add(new Node(arr[current.row][nextCol],current.row,nextCol));
           }
       }
       return res;
    }
}