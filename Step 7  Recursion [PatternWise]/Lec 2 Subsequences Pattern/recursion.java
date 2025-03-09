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

class Solution {
    public static String betterString(String str1, String str2) {
       HashMap<Character,Integer>mpp1=new HashMap<>();
       HashMap<Character,Integer>mpp2=new HashMap<>();
       int dp1[]=new int [str1.length()+1];
       int dp2[]=new int [str2.length()+1];
       dp1[0]=1;
       dp2[0]=1;
       for (int i=0;i<str1.length();i++){
           if (mpp1.containsKey(str1.charAt(i))){
               dp1[i+1]=(2*dp1[i])-dp1[mpp1.get(str1.charAt(i))-1];
           }else{
               dp1[i+1]=dp1[i]*2;
           }
            mpp1.put(str1.charAt(i),i+1);
       }
       for (int i=0;i<str2.length();i++){
           if (mpp2.containsKey(str2.charAt(i))){
               dp2[i+1]=(2*dp2[i])-dp2[mpp2.get(str2.charAt(i))-1];
           }else{
               dp2[i+1]=dp2[i]*2;
           }
           mpp2.put(str2.charAt(i),i+1);
       }
       int len1=str1.length();
       int len2=str2.length();
       if (dp1[len1]>=dp2[len2]){
           return str1;
       }
       return str2;
    }
}

// Perfect Sum Problem

class Solution {
    public int perfectSum(int[] nums, int target) {
         Map<String, Integer> memo = new HashMap<>();
        return solve(nums,target,0,0,memo);
    }
    
    public static int solve(int[] nums,int target,int sum,int index, Map<String, Integer> memo){
       if (index == nums.length) {
            return sum == target ? 1 : 0;
        }
        
        String key = index + "," + sum;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        int pick=solve(nums,target,sum+nums[index],index+1,memo);
        int notPick=solve(nums,target,sum,index+1,memo);
        int result= pick+notPick;
        memo.put(key,result);
        return result;
        
    }
}