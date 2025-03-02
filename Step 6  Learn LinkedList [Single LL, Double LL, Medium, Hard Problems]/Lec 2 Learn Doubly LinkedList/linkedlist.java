// Introduction to Doubly Linked List

Class Solution {
    Node constructDLL(int arr[]) {
        Node head=null;
        Node  tail=null;
        for(int x:arr){
            if(head==null){
                head=insertEnd(tail,x);
                tail=head;
            }else{
                tail=insertEnd(tail,x);
            }
        }
        return head;
    }
    Node insertEnd(Node tail,int x){
        Node temp=new Node(x);
        if(tail==null){
            return temp;
        }
        tail.next=temp;
        temp.prev=tail;
        return temp;
    }
    
}

// Doubly linked list Insertion at given position

class Solution {
    Node addNode(Node head, int p, int x) {
        Node node = new Node(x);
        Node temp =head;
        while(p!=0){
            temp = temp.next;
            p--;
        }
        node.next = temp.next;
        temp.next= node;
        node.prev = temp;
        
        
        return head;
    }
}

 // Delete in a Doubly Linked List

 class Solution {
    public Node deleteNode(Node head, int x) 
    {
        git commit -m "DSA commit"
        if(head == null) return null;
        
        if(x == 1)
        {
            head = head.next;
            if(head != null)
            {
                head.prev = null;
            }
            return head;
        }
        
        Node temp = head;
        
        int count = 1;
        while(temp != null)
        {
            if(count == x) break;
            temp = temp.next;
            count++;
        }
        
        Node back = temp.prev;
        Node front = temp.next;
        
        if(temp.next == null)
        {
            temp.prev = null;
            back.next = null;
        }
        
        else if(temp.prev == null)
        {
            head = head.next;
            temp.next = null;
            head.prev = null;
        }
        else
        {
            back.next = front;
            front.prev = back;
            temp.next = null;
            temp.prev = null;
        }
        return head;
    }
}