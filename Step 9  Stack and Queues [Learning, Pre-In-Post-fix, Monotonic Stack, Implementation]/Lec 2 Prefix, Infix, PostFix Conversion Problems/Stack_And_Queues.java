// Infix to Postfix

class Solution {
    public static int priority(char ch) {
        if (ch == '+' || ch == '-') return 1;
        if (ch == '*' || ch == '/') return 2;
        if (ch == '^') return 3;
        return -1; 
    }
    public static String infixToPostfix(String s) {
        StringBuilder ans=new StringBuilder();
        Stack<Character> stack=new Stack<>();
        for(char ch:s.toCharArray()){
            if((ch>='A'&&ch<='Z')||(ch>='a' && ch<='z')||(ch>='0'&&ch<='9'))ans.append(ch);
            else if(ch=='(')stack.push(ch);
            else if(ch==')'){
                while(!stack.isEmpty() && stack.peek()!='('){
                    ans.append(stack.pop());
                }stack.pop();
            }
            else{
                while(!stack.isEmpty() && priority(ch)<=priority(stack.peek())){
                    ans.append(stack.pop());
                }
                stack.push(ch);
            }
        }
        while(!stack.isEmpty()){
            ans.append(stack.pop());
        }
        return ans.toString();
    }
} 