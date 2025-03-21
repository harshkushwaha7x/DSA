import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

// Minimum Bit Flips to Convert Number

class BitFlipConverter {
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

class SingleNumberFinder {
    public int singleNumber(int[] nums) {
        int xorr = 0;
        for (int i = 0; i < nums.length; i++) {
            xorr = xorr ^ nums[i];
        }
        return xorr;
    }
}

// Subsets

class SubsetGenerator {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> op = new ArrayList<>();
        solve(nums, 0, op, res);
        return res;
    }

    public void solve(int nums[], int start, List<Integer> op, List<List<Integer>> res) {
        if (nums.length == start) {
            res.add(new ArrayList<>(op));
            return;
        }
        solve(nums, start + 1, op, res);
        op.add(nums[start]);
        solve(nums, start + 1, op, res);
        op.remove(op.size() - 1);
    }
}

// Find XOR of numbers from L to R.

class XORRangeCalculator {
    private static int solve(int n) {
        if (n % 4 == 1) return 1;
        else if (n % 4 == 2) return n + 1;
        else if (n % 4 == 3) return 0;
        return n;
    }

    public static int findXOR(int l, int r) {
        return solve(l - 1) ^ solve(r);
    }
}

// Two numbers with odd occurrences

class OddOccurrenceFinder {
    public int[] twoOddNum(int arr[], int n) {
        // code here
        Arrays.sort(arr);
        int res[] = new int[2];
        int temp = 1;
        int ans = arr[0];
        for (int i = 1; i < n; i++) {
            if (arr[i] != arr[i - 1]) {
                if (ans != 0) {
                    res[temp] = arr[i - 1];
                    temp--;
                }
                ans = arr[i];
            } else {
                ans = ans ^ arr[i];
            }
        }
        if (temp != -1) res[temp] = arr[n - 1];
        return res;
    }
}