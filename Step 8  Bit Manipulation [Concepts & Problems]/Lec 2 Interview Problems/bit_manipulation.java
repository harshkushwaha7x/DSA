// Minimum Bit Flips to Convert Number

class Solution {
    public int minBitFlips(int start, int goal) {
      var res = 0;
  
      while (start > 0 || goal > 0) {
        res += (start & 1) == (goal & 1) ? 0 : 1;
  
        start >>= 1;
        goal >>= 1;
      }
      return res;
    }
  }

  // Single Number

  class Solution {
    public int singleNumber(int[] nums) {
        int xorr = 0;
        for(int i=0; i<nums.length; i++){
            xorr = xorr ^ nums[i];
        }
        return xorr;
    }
}

// Subsets

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> op = new ArrayList<>();
        solve(nums, 0, op, res);
        return res;
    }
    public void solve(int nums[], int start, List<Integer> op, List<List<Integer>> res){
        if(nums.length == start){
            res.add(new ArrayList<>(op));
            return;
        }
        solve(nums, start + 1, op, res);
        op.add(nums[start]);
        solve(nums, start + 1, op, res);
        op.remove(op.size() - 1);
    }
}