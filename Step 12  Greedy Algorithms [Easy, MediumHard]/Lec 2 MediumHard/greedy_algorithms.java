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