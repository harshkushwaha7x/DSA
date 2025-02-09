import java.util.*;

// TrieNode for AutoCompleteSystem
class TrieNode {
    Map<Character, TrieNode> children;
    Map<String, Integer> frequencies;

    public TrieNode() {
        children = new HashMap<>();
        frequencies = new HashMap<>();
    }
}

public class basics {
    private TrieNode root;
    private TrieNode current;
    private StringBuilder currentQuery;

    public basics(String[] sentences, int[] times) {
        root = new TrieNode();
        current = root;
        currentQuery = new StringBuilder();

        for (int i = 0; i < sentences.length; i++) {
            insert(sentences[i], times[i]);
        }
    }

    private void insert(String sentence, int time) {
        TrieNode node = root;
        for (char c : sentence.toCharArray()) {
            node.children.putIfAbsent(c, new TrieNode());
            node = node.children.get(c);
        }
        node.frequencies.put(sentence, node.frequencies.getOrDefault(sentence, 0) + time);
    }

    public List<String> input(char c) {
        if (c == '#') {
            insert(currentQuery.toString(), 1);
            currentQuery.setLength(0);
            current = root;
            return new ArrayList<>();
        }

        currentQuery.append(c);
        if (!current.children.containsKey(c)) {
            current.children.put(c, new TrieNode());
            current = current.children.get(c);
            return new ArrayList<>();
        }

        current = current.children.get(c);
        List<Map.Entry<String, Integer>> suggestions = new ArrayList<>(current.frequencies.entrySet());

        suggestions.sort((a, b) -> {
            int freqCompare = b.getValue().compareTo(a.getValue());
            return freqCompare != 0 ? freqCompare : a.getKey().compareTo(b.getKey());
        });

        List<String> result = new ArrayList<>();
        for (int i = 0; i < Math.min(3, suggestions.size()); i++) {
            result.add(suggestions.get(i).getKey());
        }

        return result;
    }
}

// Data Type Size
class DataTypeSize {
    static int dataTypeSize(String str) {
        switch (str) {
            case "Character":
                return 2;
            case "Integer":
            case "Float":
                return 4;
            case "Long":
            case "Double":
                return 8;
            default:
                throw new IllegalArgumentException("Unsupported data type: " + str);
        }
    }
}

// Decision Making
class DecisionMaking {
    public static String compareNM(int n, int m) {
        if (n < m) return "lesser";
        if (n > m) return "greater";
        return "equal";
    }
}

// Switch Case
class SwitchCase {
    static double switchCase(int choice, List<Double> arr) {
        switch (choice) {
            case 1:
                if (arr.size() < 1) {
                    throw new IllegalArgumentException("Circle requires exactly one value: radius.");
                }
                return Math.PI * arr.get(0) * arr.get(0);
            case 2:
                if (arr.size() < 2) {
                    throw new IllegalArgumentException("Rectangle requires exactly two values: length and breadth.");
                }
                return arr.get(0) * arr.get(1);
            default:
                throw new IllegalArgumentException("Invalid choice: " + choice);
        }
    }
}

// While Loop
class WhileLoop {
    public static void printTable(int n) {
        int i = 10;
        while (i > 0) {
            System.out.print(i * n + " ");
            i--;
        }
        System.out.println();
    }
}

// Pass by Reference and Value
class PassByValue {
    static int[] passedBy(int a, int b) {
        return new int[]{a + 1, b + 2};
    }
}

// Main Class
class Main {
    public static void main(String[] args) {
        String[] sentences = {"hello world", "hello there", "hello java"};
        int[] times = {3, 1, 2};
        AutoCompleteSystem autoComplete = new AutoCompleteSystem(sentences, times);

        System.out.println(autoComplete.input('h'));
        System.out.println(autoComplete.input('e'));

        System.out.println(DataTypeSize.dataTypeSize("Integer"));

        System.out.println(DecisionMaking.compareNM(5, 10));

        List<Double> arr = Arrays.asList(5.0, 10.0);
        System.out.println(SwitchCase.switchCase(2, arr));

        WhileLoop.printTable(5);

        int[] result = PassByValue.passedBy(5, 10);
        System.out.println(Arrays.toString(result));
    }
}

// Count Digits

class Solution {
    static int evenlyDivides(int n) {
        int count=0;
        int num = n;
        
        while(n>0){
            int value = n%10;
            if(value != 0 && num % value == 0){
                count++;
            }
            n = n/10;
        }
        return count;
    }
}

// Reverse Integer

class Solution {
    public int reverse(int x) {
        long i,digit,sum=0;
        if(x<0)
        {
            x=Math.abs(x);
            while(x>0)
            {
                digit=x%10;
                x=x/10;
                sum=sum*10+digit;
            }
            sum=sum*-1;
        }
        else if(x>0)
        {
            while(x>0)
            {
                digit=x%10;
                x=x/10;
                sum=sum*10+digit;
            }
        }
        if(sum<Integer.MIN_VALUE || sum >Integer.MAX_VALUE)
        return 0;

        return (int)sum;
    }
}

// Palindrome Number

class Solution {
    public boolean isPalindrome(int x) {

        int n=x;
        int rev=0;
        if(x<0) return false; 

        for(int i=x;i>0;i/=10){
            int lastDigit=i%10;
            rev = rev*10+lastDigit;
        }

        return (n==rev)? true:false;
    }
}

// LCM And GCD

class Solution {
    public static int[] lcmAndGcd(int a, int b) {
        int[] res=new int[2];
        res[0]=lcm(a,b);
        res[1]=gcd(a,b);
        return res;
    }
    static int gcd(int a,int b){
        if(b==0)return a;
        return gcd(b,a%b);
    }
    static int lcm(int a,int b){
        return a*b/gcd(a,b);
    }
}

// Sum 1 to n Divisors

class Solution {
    public static int sumOfDivisors(int n) {
        int sum = 0;
        for(int i=1;i<=n;i++){
            sum += (n/i)*i;
        }
        return sum;
    }
}

// Print 1 To N Without Loop

class Solution {

    public void printNos(int n) {
        // Your code here
        if(n<1)
         return;
        printNos(n-1);
        System.out.print(n+" ");
     
    }
}

//Print GFG n times

class Solution {

    void printGfg(int N) {
        // code here
        if(N<=0)
            return;
        printGfg(N-1);
        System.out.print("GFG ");
    }
}

// Print 1 To N Without Loop

class Solution {

    public void printNos(int n) {
        // Your code here
        if(n<1)
         return;
        printNos(n-1);
        System.out.print(n+" ");
     
    }
}

// Print N to 1 without loop

class Solution {

    void printNos(int N) {
        // code here
        if(N<1)
            return;
        System.out.print(N+" ");
        printNos(N-1);
    }
}

// Sum of first n terms

class Solution {
    int sumOfSeries(int n) {
        // code here
         if(n==1){
            return 1 ; 
        }
        return n*n*n+sumOfSeries(n-1);
    }
}

// Factorials Less than or Equal to n

class Solution {
    static ArrayList<Long> factorialNumbers(long n) {
        // code here
        long val = 1;
        int i=1;
        ArrayList<Long> res = new ArrayList<>();
        while(val<=n){
            res.add(val);
            i++;
            val=val*i;
        }
        return res;
        
    }
} 


// Reverse an Array

class Solution {
    public void reverseArray(int arr[]) {
        Solution obj = new Solution();
        int n = arr.length;
        obj.reverse(arr, 0, n-1, n/2);
    }
    public void reverse(int arr[], int start, int end, int mid){
        if(start == mid){
            return;
        }
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
        reverse(arr, start + 1, end - 1, mid);
    }
}

// Valid Palindrome

class Solution {
    public boolean isPalindrome(String s) {
        if (s.isEmpty()) {
        	return true;
        }
        int start = 0;
        int last = s.length() - 1;
        while(start <= last) {
        	char currFirst = s.charAt(start);
        	char currLast = s.charAt(last);
        	if (!Character.isLetterOrDigit(currFirst )) {
        		start++;
        	} else if(!Character.isLetterOrDigit(currLast)) {
        		last--;
        	} else {
        		if (Character.toLowerCase(currFirst) != Character.toLowerCase(currLast)) {
        			return false;
        		}
        		start++;
        		last--;
        	}
        }
        return true;
    }
}

// Fibonacci Number

class Solution 
{
    public int fib(int N)
    {
        if(N <= 1)
            return N;
        
		int a = 0, b = 1;
		
		while(N-- > 1)
		{
			int sum = a + b;
			a = b;
			b = sum;
		}
        return b;
    }
} 

// Frequencies in a Limited Array

class Solution {
    // Function to count the frequency of all elements from 1 to N in the array.
    public List<Integer> frequencyCount(int[] arr) {
        // do modify in the given array
        ArrayList<Integer> ar=new ArrayList<>();
        
        HashMap<Integer,Integer> map=new HashMap<>();
        
        for(int i=0;i<arr.length;i++){
            if(map.containsKey(arr[i])){
                map.put(arr[i],map.get(arr[i])+1);
            }else{
                map.put(arr[i],1);
            }
        }
        
        for(int i=1;i<=arr.length;i++){
            if(map.containsKey(i)){
                ar.add(map.get(i));
            }else{
                ar.add(0);
            }
        }
        
        return ar;
    }
}

// Frequency of the Most Frequent Element

import java.util.Arrays;

class Solution {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int left = 0, right = 0;
        int n = nums.length;
        long sum = 0;  // Using long to avoid overflow

        while (right < n) {
            sum += nums[right];

            // Check if the current window can be made into an array with all elements as nums[right]
            long requiredSum = (long)nums[right] * (right - left + 1);
            long diff = requiredSum - sum;

            if (diff > k) {
                sum -= nums[left];
                left++;
            }
            right++;
        }

        return right - left;
    }
}https://leetcode.com/problems/maximum-erasure-value/solutions/5182119/sliding-window-two-pointers-pattern/