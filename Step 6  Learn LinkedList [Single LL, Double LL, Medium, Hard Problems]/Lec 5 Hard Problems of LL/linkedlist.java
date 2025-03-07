// Reverse Nodes in k-Group

class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) {
            return head;
        }

        int size = getListSize(head);
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;

        while (size >= k) {
            ListNode curr = prev.next;
            ListNode next = null;
            ListNode subPrev = null;

            for (int i = 0; i < k; i++) {
                next = curr.next;
                curr.next = subPrev;
                subPrev = curr;
                curr = next;
            }

            ListNode start = prev.next; 
            prev.next = subPrev;
            start.next = curr;

            prev = start;
            size -= k;
        }

        return dummy.next;
    }

    private int getListSize(ListNode head) {
        int size = 0;
        while (head != null) {
            size++;
            head = head.next;
        }
        return size;
    }
}

// Rotate List

class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }

        int length = 1;
        ListNode temp = head;

        while (temp.next != null) {
            temp = temp.next;
            length++;
        }

        temp.next = head;
        k = k % length;
        k = length - k;

        while (k-- > 0) {
            temp = temp.next;
        }

        head = temp.next;
        temp.next = null;

        return head;
    }
}

// Flattening a Linked List

class Solution {
    Node flatten(Node root) {
        if(root==null || root.next==null) return root;
        while(root.next!=null){
            Node t = root.next;
            if(root.data>t.data){
                root.next=null;
                Node prev=root;
                root=t;
                t=t.bottom;
                root.bottom=prev;
            }
            else{
                root.next=t.next;
                t.next=null;
            }
            while(t!=null){
                Node nextbottom = t.bottom;
                Node x = root;
                while(x.bottom!=null && x.bottom.data<t.data){
                    x=x.bottom;
                }
                t.bottom=x.bottom;
                x.bottom=t;
                t=nextbottom;
            }
        }
        return root;
        
    }
}

// Copy List with Random Pointer

public class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) return null;
        
        HashMap<Node, Node> oldToNew = new HashMap<>();
        
        Node curr = head;
        while (curr != null) {
            oldToNew.put(curr, new Node(curr.val));
            curr = curr.next;
        }
        
        curr = head;
        while (curr != null) {
            oldToNew.get(curr).next = oldToNew.get(curr.next);
            oldToNew.get(curr).random = oldToNew.get(curr.random);
            curr = curr.next;
        }
        
        return oldToNew.get(head);
    }
}