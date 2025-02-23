
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