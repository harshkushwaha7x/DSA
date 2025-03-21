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
