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