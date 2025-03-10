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

// Combination Sum

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res=new ArrayList<>();
        makecomb(candidates,target,res,0,new ArrayList<>(),0);
        return res;
    }
    public static void makecomb(int[] arr,int target,List<List<Integer>>res,int ind,List<Integer>comb,int total){
        if(total==target){
            res.add(new ArrayList<>(comb));
            return;
        }
        if(total>target || ind>=arr.length){
            return;
        }
        comb.add(arr[ind]);
        makecomb(arr,target,res,ind,comb,total+arr[ind]);
        comb.remove(comb.size()-1);
        makecomb(arr,target,res,ind+1,comb,total);
    }
}

// Combination Sum II

class Solution {
    private void solveRecBacktracking(int idx, int[] candidates, int target, List<List<Integer>> res, List<Integer> l) {
        if (target < 0)
            return;
        if (target == 0) {
            res.add(new ArrayList<>(l));
            return;
        }

        // Backtracking.....
        for (int i = idx; i < candidates.length; i++) {
            if (i > idx && candidates[i] == candidates[i - 1]) {
                continue;
            }

            l.add(candidates[i]);
            solveRecBacktracking(i + 1, candidates, target - candidates[i], res, l);
            l.remove(l.size() - 1);
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        solveRecBacktracking(0, candidates, target, res, new ArrayList<>());

        return res;
    }
}

// Subset Sum

class Solution {
    public ArrayList<Integer> subsetSums(int[] arr) {
        ArrayList<Integer> subsetList = new ArrayList<>();
        pick(0, 0, arr, subsetList, arr.length);
        Collections.sort(subsetList);
        return subsetList;
    }
    
    public void pick(int index, int sum, int[] arr, ArrayList<Integer> subsetList, int n) {
        if (index == n) {
            subsetList.add(sum);
            return;
        }
        
        pick(index + 1, sum + arr[index], arr, subsetList, n);
        
        pick(index + 1, sum, arr, subsetList, n);
    }
}

