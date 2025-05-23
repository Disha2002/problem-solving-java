package DSA.LinkedLists;

public class AddTwoNumbers {

    public static class ListNode {

        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
            this.next = null;
        }

    }

    public ListNode addTwoNumbers(ListNode a, ListNode b) {

        ListNode dummyNode = new ListNode(0);
        ListNode current = dummyNode;
        int carry = 0;

        while (a != null || b != null || carry != 0) {
            int x = (a != null) ? a.val : 0;
            int y = (b != null) ? b.val : 0;
            int sum = x + y + carry;
            carry = sum / 10;
            current.next = new ListNode(sum % 10);
            current = current.next;
            if (a != null)
                a = a.next;
            if (b != null)
                b = b.next;
        }

        return dummyNode.next;
    }

}

// used dummy node to simplify list construction
// used current to advance in the list
// basic sum and carry math concept
// handling left over carry