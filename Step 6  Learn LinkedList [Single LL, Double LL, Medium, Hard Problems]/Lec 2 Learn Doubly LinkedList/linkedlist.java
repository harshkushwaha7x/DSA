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

 