import java.util.Arrays;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

// N meetings in one room

class NMeetingsInOneRoom {
    static class Meeting {
        int start, end;
        Meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
    
    public int maxMeetings(int[] start, int[] end) {
        int n = end.length;
        Meeting[] arr = new Meeting[n];
        for (int i = 0; i < n; i++) arr[i] = new Meeting(start[i], end[i]);
        Arrays.sort(arr, (a, b) -> a.end - b.end);
        int cnt = 1;
        int prevEnd = arr[0].end;
        for (int i = 1; i < n; i++) {
            if (arr[i].start > prevEnd) {
                cnt++;
                prevEnd = arr[i].end;
            }
        }
        return cnt;
    }
}

// Jump Game

class JumpGame {
    public boolean canJump(int[] nums) {
        int reachable = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > reachable) return false;
            reachable = Math.max(reachable, i + nums[i]);
        }
        return true;
    }
}

// Jump Game II

class JumpGameII {
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

class CandyDistribution {
    public int candy(int[] rating) {
        int n = rating.length;
        int candy = n;
        int i = 1;
        while (i < n) {
            if (rating[i] == rating[i - 1]) {
                i++;
                continue;
            }

            int peak = 0;
            while (rating[i] > rating[i - 1]) {
                peak++;
                candy += peak;
                i++;
                if (i == n) return candy;
            }

            int dip = 0;
            while (i < n && rating[i] < rating[i - 1]) {
                dip++;
                candy += dip;
                i++;
            }
            candy -= Math.min(peak, dip);
        }

        return candy;
    }
}

// Insert Interval

class IntervalInserter {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> ans = new ArrayList<>();
        int start = newInterval[0], end = newInterval[1];
        boolean inserted = false;
        
        for (int[] inv : intervals) {
            int cstart = inv[0], cend = inv[1];
            
            if (cend < start || inserted) {
                ans.add(new int[]{cstart, cend});
                continue;
            }
            
            start = Math.min(start, cstart);
            if (end < cstart) {
                ans.add(new int[]{start, end});
                ans.add(new int[]{cstart, cend});
                inserted = true;
                continue;
            }
            
            if (end <= cend) {
                ans.add(new int[]{start, cend});
                inserted = true;
            }
        }
        
        if (!inserted) {
            ans.add(new int[]{start, end});
        }
        
        return ans.toArray(new int[ans.size()][]);
    }
}

// Merge Intervals

class IntervalMerger {
    public int[][] merge(int[][] intervals) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        
        for (int i = 0; i < intervals.length; i++) {
            min = Math.min(min, intervals[i][0]);
            max = Math.max(max, intervals[i][0]);
        }
        
        int[] range = new int[max - min + 1];
        for (int i = 0; i < intervals.length; i++) {
            range[intervals[i][0] - min] = Math.max(intervals[i][1] - min, range[intervals[i][0] - min]); 
        }
        
        int start = 0, end = 0;
        LinkedList<int[]> result = new LinkedList<>();
        for (int i = 0; i < range.length; i++) {
            if (range[i] == 0) {
                continue;
            }
            if (i <= end) {
                end = Math.max(range[i], end);
            } else {
                result.add(new int[] {start + min, end + min});
                start = i;
                end = range[i];
            }
        }
        result.add(new int[] {start + min, end + min});
        return result.toArray(new int[result.size()][]);
    }
}

// Non-overlapping Intervals

class NonOverlappingIntervals {
    public int eraseOverlapIntervals(int[][] intervals) {
        int max = intervals[0][1];
        int min = max;
        for (int i = 1; i < intervals.length; i++) {
            max = Math.max(max, intervals[i][1]);
            min = Math.min(min, intervals[i][1]);
        }
        int shift = 1 - min;
        int[] rightEnds = new int[max - min + 2];
        for (int[] interval : intervals) {
            int left = interval[0] + shift;
            int right = interval[1] + shift;
            if (rightEnds[right] < left) rightEnds[right] = left;
        }
        int count = 0;
        int start = 0;
        for (int i = 1; i < rightEnds.length; i++) {
            if (start <= rightEnds[i]) {
                count++;
                start = i;
            }
        }
        return intervals.length - count;
    }
}