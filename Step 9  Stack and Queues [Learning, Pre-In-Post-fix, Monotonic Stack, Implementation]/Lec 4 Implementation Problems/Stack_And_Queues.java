import java.util.Stack;

// Sliding Window Maximum

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] lmax = new int[n];
        int[] rmax = new int[n];
        int[] ans = new int[n - k + 1];
        for (int i = 0; i < n; i++) {
            if (i % k == 0)
                lmax[i] = nums[i];
            else
                lmax[i] = Math.max(lmax[i - 1], nums[i]);
        }

        for (int i = n - 1; i >= 0; i--) {
            if (i == n - 1 || (i + 1) % k == 0)
                rmax[i] = nums[i];
            else
                rmax[i] = Math.max(rmax[i + 1], nums[i]);
        }

        for (int i = 0; i <= n - k; i++) {
            ans[i] = Math.max(rmax[i], lmax[i + k - 1]);
        }

        return ans;
    }
}

// Online Stock Span

class StockSpanner {
    Stack<Integer> prices;
    Stack<Integer> days; 
    public StockSpanner() {
        prices=new Stack<>();
        days=new Stack<>();
    }
    
    public int next(int price) {
        int ans=1;
        while(!prices.isEmpty() && prices.peek()<=price){
            prices.pop();
            ans+=days.pop();
        }
        prices.push(price);
        days.push(ans);
        return ans;
    }
}