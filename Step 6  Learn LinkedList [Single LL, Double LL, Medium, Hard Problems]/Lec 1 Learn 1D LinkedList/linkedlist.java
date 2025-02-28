// Array to Linked List

class Solution {
    static Node constructLL(int arr[]) {
        Node head= new Node(arr[0]);
        Node mover = head;
        for(int i=1;i<arr.length;i++)
        {
            Node temp= new Node(arr[i]);
            mover.next=temp;
            mover=temp;
        }
        return head;
    }
}

// Linked List Insertion At End

class Solution {
    Node insertAtEnd(Node head, int x) {
        if(head==null){
            return new Node(x);
        }
        
        Node newNode=new Node(x);
        Node temp=head;
        while(temp.next!=null){
            temp=temp.next;
        }
        temp.next=newNode;
        return head;
    }
}

