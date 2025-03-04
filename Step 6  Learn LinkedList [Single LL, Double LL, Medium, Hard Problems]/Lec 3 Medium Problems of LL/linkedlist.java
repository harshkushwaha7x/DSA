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

// Linked List Cycle

public class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (slow == fast) {
                return true;
            }
        }

        return false;
    }
}

// Linked List Cycle II

public class Solution {
    public ListNode detectCycle(ListNode head) {
        
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) {
                slow = head;
                break;
            }
        }
        if (fast == null || fast.next == null) return null;
        while(fast != slow) {
            slow = slow.next;
            fast = fast.next;
        }
        return fast;
    }
}

// Find length of Loop

class Solution {
    public int countNodesinLoop(Node head) {
        int c=1;
        Node slow=head;
        Node fast=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast){
                slow=slow.next;
                while(slow!=fast){
                    slow=slow.next;
                    c+=1;
                }
                return c;
            }
        }
        return 0;
    }
}

// Palindrome Linked List

class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head == null) return false;
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode mid = slow;
        ListNode prev = null;
        ListNode next;
        ListNode curr = mid.next;
        while(curr != null) {
            next = curr.next;
            curr.next = prev;
            prev= curr;
            curr = next;
        }
        ListNode left = head;
        ListNode right = prev;
        while(right != null) {
            if(left.val != right.val) return false;
            left= left.next;
            right = right.next;
        }
        return true;
    }
}

// Odd Even Linked List 

class Solution {
    public ListNode oddEvenList(ListNode head) {
        if(head==null || head.next==null)
        {
            return head;
        }
        ListNode odd=head;
        ListNode even=head.next;
        ListNode evenHead=head.next;
        while(odd.next!=null && even.next!=null)
        {
            odd.next=even.next;
            odd=odd.next;
            even.next=odd.next;
            even=even.next;
        }
        odd.next=evenHead;
        return head;
    }
}

// Remove Nth Node From End of List

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head;
        for(int i=0; i<n ; i++){
            fast = fast.next;
        }
        if(fast == null){
            head = head.next;
            return head;
        }
        ListNode slow = head;
        while(fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return head;
    }
}