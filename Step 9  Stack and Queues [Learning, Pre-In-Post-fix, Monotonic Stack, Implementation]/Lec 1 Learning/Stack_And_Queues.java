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
