// Sort Characters By Frequency

public class strings {
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) 
            map.put(c, map.getOrDefault(c, 0) + 1);
						
        List<Character> [] bucket = new List[s.length() + 1];
        for (char key : map.keySet()) {
            int frequency = map.get(key);
            if (bucket[frequency] == null) bucket[frequency] = new ArrayList<>();
            bucket[frequency].add(key);
        }
				
        StringBuilder sb = new StringBuilder();
        for (int pos = bucket.length - 1; pos >= 0; pos--)
            if (bucket[pos] != null)
                for (char c : bucket[pos])
                    for (int i = 0; i < pos; i++)
                        sb.append(c);

        return sb.toString();
    }
}

// Maximum Nesting Depth of the Parentheses

class Solution {
    public int maxDepth(String s) {
        int max = 0;
        int count = 0;
        for(char ch : s.toCharArray()){
            if(ch=='(') count++;
            else if(ch==')'){
                max = Math.max(max,count);
                count--;
            }
        }
        return max;
    }
}

// Roman to Integer

class Solution {
    public int romanToInt(String s) {
        HashMap<Character, Integer> romanMap = new HashMap<>();
        romanMap.put('I', 1);
        romanMap.put('V', 5);
        romanMap.put('X', 10);
        romanMap.put('L', 50);
        romanMap.put('C', 100);
        romanMap.put('D', 500);
        romanMap.put('M', 1000);
        int result =0;
        for (int i = 0; i < s.length(); i++) {
            int currentVal = romanMap.get(s.charAt(i));
            if (i < s.length() - 1 && currentVal < romanMap.get(s.charAt(i + 1))) {
                result -= currentVal;
            } else {
                result += currentVal;
            }
        }
        return result;
    }
}

// String to Integer (atoi)

class Solution {
    public int myAtoi(String s) {
        int i = 0, n = s.length(), sign = 1, ans = 0;

        while (i < n && s.charAt(i) == ' ') {
            i++;
        }

        if (i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
            sign = (s.charAt(i) == '-') ? -1 : 1;
            i++;
        }
        
        while (i < n && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
            int digit = s.charAt(i) - '0';

            if(ans>(Integer.MAX_VALUE - digit)/10){
                return (sign ==1)?Integer.MAX_VALUE:Integer.MIN_VALUE;
            }

            ans = ans * 10 + digit;
            i++;
        }

        return ans * sign;
    }
}

// Substrings with K Distinct


class Solution {
    
    long countSubstring(String S, int K) {
        int n = S.length();
        int[] freq = new int[26];
        int uc = 0;
        long count = 0;
        int left = 0;

        for (int right = 0; right < n; right++) {
            if (freq[S.charAt(right) - 'a'] == 0) {
                uc++;
            }
            freq[S.charAt(right) - 'a']++;
            
            while (uc > K) {
                freq[S.charAt(left) - 'a']--;
                if (freq[S.charAt(left) - 'a'] == 0) {
                    uc--;
                }
                left++;
            }
            count += right - left + 1;
        }
        
        return count;
    }
    
    
    long substrCount(String S, int K) {
        if (S == null || K <= 0) {
            return 0;
        }
        
        return countSubstring(S, K) - countSubstring(S, K - 1);
    }
}

// Longest Palindromic Substring

public class Solution {
    private int lo, maxLen;
    
    public String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2)
            return s;
        
        for (int i = 0; i < len-1; i++) {
             extendPalindrome(s, i, i);  
             extendPalindrome(s, i, i+1);
        }
        return s.substring(lo, lo + maxLen);
    }
    
    private void extendPalindrome(String s, int j, int k) {
        while (j >= 0 && k < s.length() && s.charAt(j) == s.charAt(k)) {
            j--;
            k++;
        }
        if (maxLen < k - j - 1) {
            lo = j + 1;
            maxLen = k - j - 1;
        }
    }}

    