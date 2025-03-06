// Class to delete all occurrences of a given key in a doubly linked list
class DeleteOccurrences {
    static Node deleteAllOccurOfX(Node head, int x) {
        Node dummy = new Node();
        dummy.next = head;
        Node cur = head;
        Node prev = dummy;

        while (cur != null) {
            if (cur.data == x) {
                prev.next = cur.next;
                if (cur.next != null) {
                    cur.next.prev = prev;
                }
                cur = prev.next;
            } else {
                prev = cur;
                cur = cur.next;
            }
        }
        return dummy.next;
    }
}

// Class to find pairs with a given sum in a doubly linked list
class FindPairs {
    public static ArrayList<ArrayList<Integer>> findPairsWithGivenSum(int target, Node head) {
        Node last = head;
        Node first = head;
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        if (head == null || head.next == null) return ans;

        while (last.next != null) {
            last = last.next;
        }

        while (first.data < last.data) {
            ArrayList<Integer> temp = new ArrayList<>();
            if (first.data + last.data == target) {
                temp.add(first.data);
                temp.add(last.data);
                ans.add(temp);
                first = first.next;
                last = last.prev;
            } else if (first.data + last.data > target) {
                last = last.prev;
            } else {
                first = first.next;
            }
        }
        return ans;
    }
}

// Class to remove duplicates from a sorted doubly linked list
class RemoveDuplicates {
    Node removeDuplicates(Node head) {
        if (head == null || head.next == null) return head;

        Node temp = head;
        while (temp != null && temp.next != null) {
            Node t = temp;
            while (t.next != null && t.data == t.next.data) {
                t = t.next;
            }

            temp.next = t.next;
            if (t.next != null) {
                t.next.prev = temp;
            }

            temp = temp.next;
        }
        return head;
    }
}