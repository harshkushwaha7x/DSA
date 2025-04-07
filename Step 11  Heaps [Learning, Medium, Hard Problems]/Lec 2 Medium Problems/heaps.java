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

// Merge k Sorted Lists

class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2)
    {
        ListNode merge = new ListNode(0);
        ListNode curr = merge;

        while(list1 != null && list2 != null)
        {
            if(list1.val < list2.val)
            {
                curr.next = list1;
                list1 = list1.next;
            }
            else if(list1.val > list2.val) 
            {
                curr.next = list2;
                list2 = list2.next;
            }
            else
            {
                curr.next = list1;
                list1 = list1.next;

                curr = curr.next;

                curr.next = list2;
                list2 = list2.next;
            }
            curr = curr.next;
        }
        if (list1 != null) 
        {
            curr.next = list1;
        } 
        else 
        {
            curr.next = list2;
        }
        return merge.next;
    }

    public ListNode mergeKLists(ListNode[] lists)
    {
        if (lists.length == 0) 
        {
            return null;
        }

        return mergeKListsHelper(lists, 0, lists.length - 1);
    }

    private ListNode mergeKListsHelper(ListNode[] lists, int left, int right)
    {
        if (left == right) 
        {
            return lists[left];
        }

        int mid = left + (right - left) / 2;

        ListNode l1 = mergeKListsHelper(lists, left, mid);
        ListNode l2 = mergeKListsHelper(lists, mid + 1, right);

        return mergeTwoLists(l1, l2);
    }
}

// Replace elements by its rank in the array

class Solution {
    static class RankNode{
        int val;
        int ind;
        RankNode(int v,int i){
            val =v;
            ind=i;
        }
    }
    static int[] replaceWithRank(int arr[], int N) {
     PriorityQueue<RankNode> pq = new PriorityQueue<>((x,y)->x.val -y.val);
     for(int i=0;i<N;i++){
         pq.add(new RankNode(arr[i],i));
     }
     int pre =-1;
     int cnt =0;
     while(!pq.isEmpty()){
         RankNode cur = pq.poll();
         if(cur.val != pre){
            cnt++;
            pre =cur.val;
         }
         arr[cur.ind]= cnt;
     }
     return arr;
  }
}

// Task Scheduler

class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] cnt = new int[26];
        for (char ch : tasks) {
            cnt[ch - 'A']++;
        }

        Arrays.sort(cnt);
        int max = cnt[25];
        int idle = (max - 1) * n;

        for (int i = 24; i >= 0; i--) {
            idle -= Math.min(max - 1, cnt[i]);
        }
        return tasks.length + Math.max(idle, 0);
    }
}

// Hand of Straights

class Solution {
    public boolean findsucessors(int[] hand, int groupSize, int i, int n) {
        int f = hand[i] + 1;
        hand[i] = -1;
        int count = 1;
        i += 1;
        while (i < n && count < groupSize) {
            if (hand[i] == f) {
                f = hand[i] + 1;
                hand[i] = -1;
                count++;
            }
            i++;
        }
        if (count != groupSize)
            return false;
        else
            return true;
    }

    public boolean isNStraightHand(int[] hand, int groupSize) {
        int n = hand.length;
        if (n % groupSize != 0)
            return false;
        Arrays.sort(hand);
        int i = 0;
        for (; i < n; i++) {
            if (hand[i] >= 0) {
                if (!findsucessors(hand, groupSize, i, n))
                    return false;
            }
        }
        return true;
    }
}