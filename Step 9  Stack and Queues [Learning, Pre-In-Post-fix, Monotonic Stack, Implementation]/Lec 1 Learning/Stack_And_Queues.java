import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;

// Implement stack using array

class ArrayStack {
    private int[] arr;
    private int top;

    public ArrayStack() {
        arr = new int[1000];
        top = -1;
    }

    public void push(int x) {
        arr[++top]=x;
    }

    public int pop() {
        if(top!=-1)return arr[top--];
        return -1;
    }
}

// Queue Using Array

class ArrayQueue {
    int front, rear;
    int arr[] = new int[100005];
 
    ArrayQueue() {
        front=0;
        rear=0;
    }
 
    void push(int x) {
        arr[rear++]=x;
    } 
 
    int pop() {
        return (front == rear) ? -1 : arr[front++];
    }
}

// Implement Stack using Queues

class StackUsingQueues {
    private Queue<Integer> q = new LinkedList<>();

    StackUsingQueues() {
        
    }

    void push(int x) {
        q.add(x);
        int v = q.size() - 1;
        int i = 0;
        while (i < v) {
            q.add(q.poll());
            i++;
        }
    }

    int pop() {
        return q.poll();
    }

    int top() {
        return q.peek();
    }

    boolean empty() {
        return q.isEmpty();
    }
}

// Implement Queue using Stacks

class QueueUsingStacks {
    private Stack<Integer> s1;
    private Stack<Integer> s2;

    public QueueUsingStacks() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    public void push(int x) {
        while (!s1.isEmpty()) {
            s2.push(s1.pop());
        }
        s1.push(x);
        while (!s2.isEmpty()) {
            s1.push(s2.pop());
        }
    }

    public int pop() {
        return s1.pop();
    }

    public int peek() {
        return s1.peek();
    }

    public boolean empty() {
        return s1.isEmpty();
    }
}

// Stack using Linked List

class LinkedListStack {
    StackNode top;
    void push(int a) {
        StackNode newNode=new StackNode(a);
        newNode.next=top;
        top=newNode;
    }
    int pop() {
        if(top==null)return -1;
        int pop=top.data;
        top=top.next;
        return pop;
    }
}

// Queue using Linked List

class LinkedListQueue {
    QueueNode front, rear;

    void push(int a) {
        QueueNode newNode = new QueueNode(a);
        if (front == null) {
            front = newNode;
            rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
    }

    int pop() {
        if (front == null) return -1;
        int pop = front.data;
        front = front.next;
        return pop;
    }
}

class QueueNode {
    int data;
    QueueNode next;

    QueueNode(int data) {
        this.data = data;
        this.next = null;
    }
}

// Valid Parentheses

class ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        for(int i = 0;i<s.length();i++) {
            char ch = s.charAt(i);
            if(ch == '(' || ch == '{' || ch == '[') st.push(ch);
            else {
                if(st.isEmpty()) return false;
                if((ch == ')' && st.peek()=='(') || (ch == '}' && st.peek()=='{') || (ch == ']' && st.peek()=='[' )) st.pop();
                else return false;
            }
        }
        if(st.isEmpty()) return true;
        else return  false;
    }
}

// Min Stack

class MinStack {
    private Node head;
        
    public void push(int x) {
        if (head == null) 
            head = new Node(x, x, null);
        else 
            head = new Node(x, Math.min(x, head.min), head);
    }
    
    public void pop() {
        head = head.next;
    }
    
    public int top() {
        return head.val;
    }
    
    public int getMin() {
        return head.min;
    }
        
    private class Node {
        int val;
        int min;
        Node next;
            
        private Node(int val, int min, Node next) {
            this.val = val;
            this.min = min;
            this.next = next;
        }
    }
}