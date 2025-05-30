// Infix to Postfix
import java.util.Stack;

class InfixToPostfixConverter {
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

// Prefix to Infix Conversion
class PrefixToInfixConverter {
    static String preToInfix(String pre_exp) {
        Stack<String> stack=new Stack<>();
        for(int i=pre_exp.length()-1;i>=0;i--){
            char ch=pre_exp.charAt(i);
            if(Character.isLetterOrDigit(ch))stack.push(String.valueOf(ch));
            else{
                String t1=stack.pop();
                String t2=stack.pop();
                stack.push("("+t1+ch+t2+")");
            }
        }
        return stack.pop();
    }
}

// Prefix to Postfix Conversion
class PrefixToPostfixConverter {
    static String preToPost(String pre_exp) {
        Stack<String> stack=new Stack<>();
        for(int i=pre_exp.length()-1;i>=0;i--){
            char ch=pre_exp.charAt(i);
            if(Character.isLetterOrDigit(ch))stack.push(String.valueOf(ch));
            else{
                String t1=stack.pop();
                String t2=stack.pop();
                stack.push(t1+t2+ch);
            }
        }
        return stack.pop();
    }
}

// Postfix to Prefix Conversion
class PostfixToPrefixConverter {
    static String postToPre(String post_exp) {
        Stack<String> stack=new Stack<>();
        for(char ch:post_exp.toCharArray()){
            if(Character.isLetterOrDigit(ch))stack.push(String.valueOf(ch));
            else{
                String t1=stack.pop();
                String t2=stack.pop();
                stack.push(ch+t2+t1);
            }
        }
        return stack.pop();
    }
}

// Postfix to Infix Conversion
class PostfixToInfixConverter {
    static String postToInfix(String exp) {
        Stack<String> stack=new Stack<>();
        for(char ch:exp.toCharArray()){
            if(Character.isLetterOrDigit(ch))stack.push(String.valueOf(ch));
            else{
                String t1=stack.pop();
                String t2=stack.pop();
                stack.push("("+t2+ch+t1+")");
            }
        }
        return stack.pop();
    }
}

// Infix to Postfix (duplicate - can be removed)
class InfixToPostfixConverter2 {
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