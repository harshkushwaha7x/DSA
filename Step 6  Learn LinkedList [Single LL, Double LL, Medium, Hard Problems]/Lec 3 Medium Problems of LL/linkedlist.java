// Middle of the Linked List

class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode slow=head;  
        ListNode fast=head;    

        while(fast!=null && fast.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;  
        }

        return slow; 
    }
}

// Reverse Linked List

class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;  
        ListNode current = head;
    
        
        while(current != null) { 
            ListNode next = current.next; 
            current.next = prev;
            prev = current;
            current = next;
        }
       return prev; 
    }
}

//  Reverse Linked List

class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        ListNode nextNode = null;
        while (curr != null) {
            nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }
        return prev;
    }
}

