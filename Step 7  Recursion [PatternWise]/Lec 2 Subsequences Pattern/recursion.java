// Generate all binary strings without consecutive 1’s

import java.util.*;
import java.lang.*;

public class recursion {

    public static String toString(char[] a) {
        String string = new String(a);
        return string;
    }

    static void generate(int k, char[] ch, int n) {
      
        if (n == k) {
          
            System.out.print(toString(ch)+" ");
            return;

        }
      
        if (ch[n - 1] == '0') {
            ch[n] = '0';
            generate(k, ch, n + 1);
            ch[n] = '1';
            generate(k, ch, n + 1);
        }
     
        if (ch[n - 1] == '1') {

            ch[n] = '0';
          
            generate(k, ch, n + 1);

        }
    }

    static void fun(int k) {

        if (k <= 0) {
            return;
        }

        char[] ch = new char[k];
      
        ch[0] = '0';
      
        generate(k, ch, 1);

        ch[0] = '1';
        generate(k, ch, 1);

    }

    public static void main(String args[]) {

        int k = 3;
      
        fun(k);
    
   
    }
}

// Generate Parentheses

class Solution {
    private void generateAllCombination(List<String> result, int n,  StringBuilder curr, int open, int close){
        if(open == close && open == n){
            result.add(curr.toString());
            return;
        }
        if(open < n){
            generateAllCombination(result, n,  curr.append("("), open + 1, close);
            curr.deleteCharAt(curr.length()-1);
        }
        if(close < open){
            generateAllCombination(result, n,  curr.append(")"), open, close + 1);
            curr.deleteCharAt(curr.length()-1);
        }
    }

    public List<String> generateParenthesis(int n) {
        int open = 0, close = 0;
        List<String> result = new ArrayList<>();
        generateAllCombination(result, n,  new StringBuilder(), open, close);
        return result;
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

// Better String

