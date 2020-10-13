//给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。 
//
// 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。 
//
// 
//
// 示例: 
//
// 给定 1->2->3->4, 你应该返回 2->1->4->3.
// 
// Related Topics 链表 
// 👍 657 👎 0


package leetcode.editor.leetcode_cn;


class ListNode {
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

//两两交换链表中的节点
//提交时间 2020-10-13 09:08:48
class P24_SwapNodesInPairs {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P24_SwapNodesInPairs().new Solution();
    }
//力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        public ListNode swapPairs(ListNode head) {
            if (head == null) return null;
            if (head.next == null) return head;
            ListNode dummy = new ListNode(-1);
            dummy.next = head;
            ListNode prev = dummy;
            ListNode curr = head;
            ListNode nextP = curr.next;

            while(curr != null && curr.next != null){
                prev.next = nextP;
                ListNode temp = nextP.next;
                nextP.next = curr;
                curr.next = temp;

                prev = curr;
                curr = prev.next;
                if (curr.next == null) break;
                nextP  = curr.next;

            }

            return dummy.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}