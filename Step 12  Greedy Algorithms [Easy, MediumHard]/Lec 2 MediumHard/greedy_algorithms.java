import java.util.Arrays;

// N meetings in one room

class Solution {
    static class Meetings{
        int start,end;
        Meetings(int start,int end){
            this.start=start;
            this.end=end;
        }
    }
    public int maxMeetings(int start[], int end[]) {
        int n=end.length;
        Meetings[] arr=new Meetings[n];
        for(int i=0;i<n;i++)arr[i]=new Meetings(start[i],end[i]);
        Arrays.sort(arr,(a,b)->a.end-b.end);
        int cnt=1;
        int prevEnd=arr[0].end;
        for(int i=1;i<n;i++){
            if(arr[i].start>prevEnd){
                cnt++;
                prevEnd=arr[i].end;
            }
        }
        return cnt;
    }
}

// Jump Game

class Solution {
    public boolean canJump(int[] nums) {
       int reachable = 0;
       for(int i = 0; i < nums.length; i ++) {
           if(i > reachable) return false;
           reachable = Math.max(reachable, i + nums[i]);
       } 
       return true;
    }
}

// Jump Game II

class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int jumps = 0, currentEnd = 0, farthest = 0;

        for (int i = 0; i < n - 1; i++) {
            farthest = Math.max(farthest, i + nums[i]);
            if (i == currentEnd) {
                jumps++;
                currentEnd = farthest;
            }
        }
        return jumps;
    }
}

// Candy

class Solution {
    public int candy(int[] rating) {
        int n = rating.length;
        int candy = n;
        int i = 1;
        while(i<n){
            if(rating[i] == rating[i-1]){
                i++;
                continue;
            }

            int peak = 0;
            while(rating[i] > rating[i-1]){
                peak++;
                candy+= peak;
                i++;
                if(i==n) return candy;
            }

            int dip = 0;
            while(i<n && rating[i] < rating[i-1]){
                dip++;
                candy += dip;
                i++;
            }
            candy -= Math.min(peak,dip);
        }

        return candy;
    }
}