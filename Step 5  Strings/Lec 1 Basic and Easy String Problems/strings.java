
// Remove Outermost Parentheses

class Solution {
    public String removeOuterParentheses(String S) {
    StringBuilder s = new StringBuilder();
    int opened = 0;
    for (char c : S.toCharArray()) {
        if(c == '(') {
            if(opened > 0) s.append(c);
            opened++;
        } else {
            if(opened > 1) s.append(c);
            opened--;
        }
    }
    return s.toString();
}
}

// Reverse Words in a String

class Solution {
    public String reverseWords(String s) {
        String[] str = s.trim().split("\\s+");

        String out = "";

        for (int i = str.length - 1; i > 0; i--) {
            out += str[i] + " ";
        }

        return out + str[0];
    }
}

// Largest Odd Number in String

class Solution {
    public String largestOddNumber(String num) {

        for(int i=num.length()-1; i>=0; i--){
            if(num.charAt(i) % 2 == 1){
                return num.substring(0, i+1);
            }
        }
        return "";
    }
}

// Longest Common Prefix

class Solution {
    public String longestCommonPrefix(String[] strs) {
        String prefix = strs[0];
        for(int i = 1;i < strs.length(); i++){
            while(strs[i].indexOf(prefix) != 0)
                prefix = prefix.substring(0, prefix.length() - 1);
            if(prefix.isEmpty())
                break;
        }
        return prefix;
    }
}

// Isomorphic Strings

class Solution {
    public boolean isIsomorphic(String s, String t) {
        int len = s.length();
		int[] sArray = new int[128];
		int[] tArray = new int[128];
		for (int i = 0; i < len; i++) {
			char ch1 = s.charAt(i);
			char ch2 = t.charAt(i);
			if (sArray[ch1] != tArray[ch2]) {
				return false;
			}
			sArray[ch1] = i + 1;
			tArray[ch2] = i + 1;
		}
		return true;
    }
}

// Rotate String

class Solution {
    public boolean rotateString(String s, String goal) {
        if (s.length() != goal.length()) {
            return false;
        }
        
        String comb = s + s;
        return comb.contains(goal);
    }
}

// Valid Anagram

public class Solution {
    public boolean isAnagram(String s, String t) {
        int[] alphabet = new int[26];
        for (int i = 0; i < s.length(); i++) alphabet[s.charAt(i) - 'a']++;
        for (int i = 0; i < t.length(); i++) alphabet[t.charAt(i) - 'a']--;
        for (int i : alphabet) if (i != 0) return false;
        return true;
    }
}