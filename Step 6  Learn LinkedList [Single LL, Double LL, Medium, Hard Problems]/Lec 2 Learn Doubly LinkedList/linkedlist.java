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