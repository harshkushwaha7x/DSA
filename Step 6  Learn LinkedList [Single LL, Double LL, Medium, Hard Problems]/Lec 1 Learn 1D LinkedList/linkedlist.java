// Array to Linked List
class ArrayToLinkedList {
    static Node constructLL(int arr[]) {
        Node head = new Node(arr[0]);
        Node mover = head;
        for (int i = 1; i < arr.length; i++) {
            Node temp = new Node(arr[i]);
            mover.next = temp;
            mover = temp;
        }
        return head;
    }
}

// Linked List Insertion At End
class LinkedListInsertion {
    Node insertAtEnd(Node head, int x) {
        if (head == null) {
            return new Node(x);
        }

        Node newNode = new Node(x);
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
        return head;
    }
}

// Delete Node in a Linked List
class DeleteNode {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}

// Count Linked List Nodes
class CountNodes {
    public int getCount(Node head) {
        int count = 0;
        Node current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }
}

// Search in Linked List
class SearchInLinkedList {
    static boolean searchKey(int n, Node head, int key) {
        Node counter = head;
        while (counter != null) {
            if (counter.data == key) {
                return true;
            }
            counter = counter.next;
        }
        return false;
    }
}

// Node class definition
class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

// ListNode class definition (if needed)
class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}