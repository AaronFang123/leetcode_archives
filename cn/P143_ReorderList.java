//给定一个单链表 L：L0→L1→…→Ln-1→Ln ， 
//将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→… 
//
// 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。 
//
// 示例 1: 
//
// 给定链表 1->2->3->4, 重新排列为 1->4->2->3. 
//
// 示例 2: 
//
// 给定链表 1->2->3->4->5, 重新排列为 1->5->2->4->3. 
// Related Topics 链表 
// 👍 347 👎 0


package leetcode.editor.cn;

import leetcode.editor.cn.base.ListNode;

//重排链表
//提交时间 2020-10-20 09:13:48
class P143_ReorderList{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P143_ReorderList().new Solution();
	 }
//力扣代码
	//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {
        // 1. 快慢指针找中点
		// 2. 后链表逆序
		// 3. 依次合并链表

		// 特判
		if(head == null || head.next == null) return;
		ListNode endOfFirstHalf = endOfFirstHalf(head);
		ListNode nextHead = endOfFirstHalf.next;
		// 断开
		endOfFirstHalf.next = null;
		ListNode reverseMid = reverse(nextHead);
		mergeList(head, reverseMid);
	}

	/**
	 * 以l1 => l2 = > l1 ... 的顺序合并链表
	 * @param l1
	 * @param l2
	 */
	public void mergeList(ListNode l1, ListNode l2) {
		ListNode l1_tmp;
		ListNode l2_tmp;
		while (l1 != null && l2 != null) {
			l1_tmp = l1.next;
			l2_tmp = l2.next;

			l1.next = l2;
			l1 = l1_tmp;

			l2.next = l1;
			l2 = l2_tmp;
		}
	}

	// 反转链表
	private ListNode reverse(ListNode head) {
    	if (head == null) return head;
		ListNode prev = null;
		ListNode curr = head;
		ListNode nextPtr;

		while(true){
			nextPtr = curr.next;
			curr.next = prev;
			prev = curr;
			if (nextPtr == null) break;
			curr = nextPtr;
		}
		return curr;
	}

	/**
	 * 返回首部分的最后一个节点
	 * @param head 头节点
	 * @return null
	 */
	private ListNode endOfFirstHalf(ListNode head) {
		ListNode fast = head;
		ListNode slow = head;
		while (fast.next!= null && fast.next.next != null){
			fast = fast.next.next;
			slow = slow.next;
		}
		return slow;
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}