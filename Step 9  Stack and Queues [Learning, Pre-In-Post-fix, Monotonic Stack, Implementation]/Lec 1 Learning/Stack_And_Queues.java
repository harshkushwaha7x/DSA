// Implement stack using array

class MyStack {
    private int[] arr;
    private int top;

    public MyStack() {
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

class MyQueue {
 
    int front, rear;
int arr[] = new int[100005];
 
    MyQueue()
{
front=0;
rear=0;
}
 
void push(int x)
{
    arr[rear++]=x;
} 
 
int pop() {
        return (front == rear) ? -1 : arr[front++];
    }
 
}

// Implement Stack using Queues

class MyStack {
    private Queue<Integer> q = new LinkedList<>();

    MyStack() {
        
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



class MyQueue {
    private Stack<Integer> s1;
    private Stack<Integer> s2;

    public MyQueue() {
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

class MyStack {
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

class MyQueue
{
    QueueNode front, rear;
    void push(int a)
    {
        QueueNode newNode=new QueueNode(a);
        if(front==null){
            front=newNode;
            rear=newNode;
        }
        else{
           rear.next=newNode;
           rear=newNode;
        } 
    }
    int pop()
    {
        if(front==null)return -1;
        int pop=front.data;
        front=front.next;
        return pop;
    }
}
