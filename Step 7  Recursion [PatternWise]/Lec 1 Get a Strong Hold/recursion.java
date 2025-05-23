import java.util.Stack;

// String to Integer (atoi)

class StringToInteger {
    public int myAtoi(String s) {
        s = s.trim();
        if (s.isEmpty()) {
            return 0;
        }

        int ans = 0, i = 0;
        boolean neg = s.charAt(0) == '-';
        boolean pos = s.charAt(0) == '+';

        if (neg || pos) {
            i++;
        }

        while (i < s.length() && Character.isDigit(s.charAt(i))) {
            int digit = s.charAt(i) - '0';

            if (ans > Integer.MAX_VALUE / 10 || (ans == Integer.MAX_VALUE / 10 && digit > Integer.MAX_VALUE % 10)) {
                return neg ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }

            ans = ans * 10 + digit;
            i++;
        }

        return neg ? -ans : ans;
    }
}

// Pow(x, n)

class PowerXN {
    public double powerX(double x, long n){
        
        if(x == 0) return 0;
        if(n == 0) return 1;
        if(n%2 == 0){
            return powerX(x*x, n/2); 
        }
        else{
            return x * powerX(x*x, (n-1)/2); 
        }
        
    }

    public double myPow(double x, int n) {
        double pow = 0;
        long absN = n;  
        if(n < 0){
            pow = 1.0 / powerX(x, -absN);
            
        }
        else{
            pow = powerX(x, absN);
        }
        return pow;

    }
}

// Count Good Numbers

class CountGoodNumbers {
    
    public long MOD = 1_000_000_007;
    public int countGoodNumbers(long n) {
        
        long odd = n/2;
        long even = (n+1)/2;
        
        
        return (int)(pow(5,even) * pow(4,odd) % MOD);
    }
    
    public long pow(long x, long n){
        
        if(n==0) 
            return 1;
        
        long temp = pow(x,n/2);
        
        if(n%2==0){
            return (temp * temp)% MOD;
        }
        else{
            return (x * temp * temp)% MOD;
        }
    }
}

// Sort a stack

class SortStack {
    public Stack<Integer> sort(Stack<Integer> s) {
        if (!s.isEmpty()) {
            int temp = s.pop(); 
            sort(s); 
            insertSorted(s, temp); 
        }
        return s;
    }

    private void insertSorted(Stack<Integer> s, int temp) {
        if (s.isEmpty() || s.peek() <= temp) {
            s.push(temp); 
            return;
        }
        
        int top = s.pop(); 
        insertSorted(s, temp); 
        s.push(top); 
    }
}

// Reverse a Stack

class ReverseStack { 
    static void reverse(Stack<Integer> s)
    {
        int size = s.size();
        int i = 0;
        int j = size - 1;
        
        while (i < j) {  
            int temp = s.get(i);  
            s.set(i, s.get(j));   
            s.set(j, temp);       
            i++;
            j--;
            
        }
    }
}