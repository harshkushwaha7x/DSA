// Minimum Add to Make Parentheses Valid
class Solution {
    public int minAddToMakeValid(String s) {
        int n = s.length();
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<n;i++){
            if(s.charAt(i) == '('){
                stack.push('(');
            }
            else{
                if(!stack.isEmpty() && stack.peek() == '('){
                    stack.pop();
                }
                else{
                    stack.push(')');
                }
            }
        }
        return stack.size();
    }
}

// Count and Say
class Solution {
    public String count(int n, String a) {
        if(n == 1) return a;
        Map<Character, Integer> map = new HashMap<>();
        char prev = a.charAt(0);
        StringBuilder sb = new StringBuilder();
        int point = 1, count = 1;
        while(point < a.length()) {
            if(prev != a.charAt(point)) {
                sb.append(count).append(prev);
                count = 1;
            }
            else count++;
            prev = a.charAt(point);
            point++;
        }
        sb.append(count).append(prev);
        return count(n - 1, sb.toString());

    }
    public String countAndSay(int n) {
        return count(n, "1");
    }
}

// Repeated String Match
class Solution {
    public int repeatedStringMatch(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int count = 0;

       
        while (sb.length() < b.length()) {
            sb.append(a);
            count++;
        }

        
        if (kmpsearch(sb.toString().toCharArray(), b.toCharArray())) {
            return count;
        }

        
        sb.append(a);
        count++;
        if (kmpsearch(sb.toString().toCharArray(), b.toCharArray())) {
            return count;
        }

        return -1;
    }

    public boolean kmpsearch(char[] str, char[] pattern) {
        int[] helper = prepare(pattern);
        int i = 0;
        int j = 0;

        while (i < str.length) {
            if (str[i] == pattern[j]) {
                i++;
                j++;
                if (j == pattern.length) return true; 
            } else {
                if (j != 0) {
                    j = helper[j - 1];
                } else {
                    i++;
                }
            }
        }
        return false;
    }

    
    public int[] prepare(char[] pattern) {
        int[] helper = new int[pattern.length];
        int index = 0;

        for (int i = 1; i < pattern.length; ) {
            if (pattern[i] == pattern[index]) {
                helper[i] = index + 1;
                index++;
                i++;
            } else {
                if (index != 0) {
                    index = helper[index - 1];
                } else {
                    helper[i] = 0;
                    i++;
                }
            }
        }

        return helper;
    }
}

// Find the Index of the First Occurrence in a String
class Solution {
    public int strStr(String haystack, String needle) 
    {
        return haystack.indexOf(needle);
        
    }
}

//  Find the Index of the First Occurrence in a String
class Solution {
    public int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }
}

// Shortest Palindrome
class Solution {
    long base = 29;
    long mod = (long)1e9 + 7;
    public String shortestPalindrome(String s) {
      long fh = 0;
      long rh = 0; 
      long power = 1; 
      int index = -1; 
      for(int i =0; i<s.length(); i++)
      {
        char ch = s.charAt(i);
        fh = (fh*base + (ch-'a' + 1))%mod;
        rh = (rh + (ch-'a'+1)*power)%mod;
        power = (power*base)%mod;
        if(fh==rh)
        index = i; 
      }
    String remSuffix = s.substring(index+1);
    StringBuilder sb = new StringBuilder(remSuffix).reverse();
    return sb.append(s).toString();
      

    }
}

// Longest Happy Prefix
class Solution {
    public String longestPrefix(String s) {
        int n = s.length();
        int[] lps = new int[n];
        int len = 0;
        int i = 1;

        while (i < n) {
            if (s.charAt(i) == s.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return s.substring(0, lps[n - 1]);
    }
}