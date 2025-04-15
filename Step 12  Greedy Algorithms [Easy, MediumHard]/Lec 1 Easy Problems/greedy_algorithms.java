import java.util.Arrays;

// Assign Cookies

class Solution {
    public int findContentChildren(int[] g, int[] s) {
        int cookiesNums = s.length;
        if(cookiesNums == 0)  return 0;
        Arrays.sort(g);
        Arrays.sort(s);

        int maxNum = 0;
        int cookieIndex = cookiesNums - 1;
        int childIndex = g.length - 1;
        while(cookieIndex >= 0 && childIndex >=0){
            if(s[cookieIndex] >= g[childIndex]){
                maxNum++;
                cookieIndex--;
                childIndex--;
            }
            else{
                childIndex--;
            }
        }

        return maxNum;
    }
}

// Fractional Knapsack

class Item{
    int val,wt;
    double ratio;
    Item(int val,int wt){
        this.val=val;
        this.wt=wt;
        ratio=(double)val/wt;
    }
}
class Solution {
    double fractionalKnapsack(List<Integer> val, List<Integer> wt, int capacity) {
        Item[] arr=new Item[val.size()];
        for(int i=0;i<val.size();i++)arr[i]=new Item(val.get(i),wt.get(i));
        Arrays.sort(arr,(a,b)->Double.compare(b.ratio,a.ratio));
        double res=0.0;
        for(int i=0;i<val.size();i++){
            if(arr[i].wt<=capacity){
                res+=arr[i].val;
                capacity-=arr[i].wt;
            }
            else{
                res+=arr[i].ratio*capacity;
                break;
            }
        }
        return res;
   }
}

// Lemonade Change

class Solution {
    public boolean lemonadeChange(int[] bills) {
        int five = 0, ten = 0;
        
        for (int bill : bills) {
            if (bill == 5) {
                five++;
            } else if (bill == 10) {
                if (five == 0) {
                    return false;
                }
                five--;
                ten++;
            } else if (bill == 20) {
                if (ten > 0 && five > 0) {
                    ten--;
                    five--;
                } else if (five >= 3) {
                    five -= 3;
                } else {
                    return false;
                }
            }
        }
        
        return true;
    }
}

// Valid Parenthesis String

public class Solution {
    public boolean checkValidString(String s) {
        int leftMin = 0, leftMax = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                leftMin++;
                leftMax++;
            } else if (c == ')') {
                leftMin--;
                leftMax--;
            } else {
                leftMin--;
                leftMax++;
            }
            if (leftMax < 0) return false;
            if (leftMin < 0) leftMin = 0;
        }
        
        return leftMin == 0;
    }
}