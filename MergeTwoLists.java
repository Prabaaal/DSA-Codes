public class MergeTwoLists {
    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode mergeTwoList(ListNode a, ListNode b) {
        ListNode ans = new ListNode();
        ListNode curr = ans;

        while (a != null && b != null) {
            if (a.val < b.val) {
                curr.next = a;
                a = a.next;
            } else {
                curr.next = b;
                b = b.next;
            }

            curr = curr.next;
        }

        if (a == null) {
            curr.next = b;
        }

        if (b == null) {
            curr.next = a;
        }

        return ans.next;
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        int n = lists.length;
        ListNode ans = null;

        for (int i = 0; i < n; i++) {
            ans = mergeTwoList(ans, lists[i]);
        }

        return ans;
    }
}
