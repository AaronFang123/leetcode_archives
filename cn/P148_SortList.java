//在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。 
//
// 示例 1: 
//
// 输入: 4->2->1->3
//输出: 1->2->3->4
// 
//
// 示例 2: 
//
// 输入: -1->5->3->4->0
//输出: -1->0->3->4->5 
// Related Topics 排序 链表 
// 👍 784 👎 0


package leetcode.editor.cn;

import leetcode.editor.cn.base.ListNode;

//排序链表
//提交时间 2020-10-19 19:52:01
class P148_SortList{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P148_SortList().new Solution();
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
	public ListNode sortList(ListNode head){
		int len = getLength(head);
		ListNode dummy = new ListNode(-1);
		dummy.next = head;

		for (int step = 1; step < len; step *= 2){
			ListNode pre = dummy;
			ListNode cur = dummy.next;
			while (cur != null){
				ListNode h1 = cur;
				ListNode h2 = split(h1, step);
				cur = split(h2, step); // 剩余部分的头
				ListNode temp = merge(h1, h2);
				pre.next = temp;
				while (pre.next != null) pre = pre.next;
			}
		}
		return dummy.next;
	}

	private ListNode split(ListNode head, int step) {
		// 断链操作，返回第二部分的头
		if (head == null) return null;
		ListNode cur = head;
		for (int i = 1; i < step && cur.next != null; i++){
			cur = cur.next;
		}
		ListNode right = cur.next;
		cur.next = null;
		return right;
	}

	private int getLength(ListNode head) {
		int count = 0;
		while (head != null){
			count++;
			head = head.next;
		}
		return count;
	}

	public ListNode sortListWithRecursion(ListNode head) {
    	// 由于快指针的存在，判空标准要到下一个next，防止空指针
		if (head == null || head.next == null) return head;
		ListNode slow = head;
		ListNode fast = head;
		ListNode pre = null;

		// 快慢指针分成两半
		while (fast != null && fast.next != null){
			pre = fast;
			slow = slow.next;
			fast = fast.next.next;
		}

		// 此时pre是第二部分的头节点
		ListNode secHead = pre;
		pre.next = null;

		// 递归排序分割后的链表
		ListNode left = sortListWithRecursion(head);
		ListNode right = sortListWithRecursion(secHead);

		return merge(left, right);
    }

    // 粒度最小是合并的是两个各只有一个节点的，此后均为有序链表
	private ListNode merge(ListNode left, ListNode right) {
		// 合并有序链表
		ListNode dummy = new ListNode(-1);
		ListNode curr = dummy;
		while (left != null && right != null){
			if (left.val >= right.val){
				curr.next = right;
				right = right.next;
				curr = curr.next;
			}
			else {
				curr.next = left;
				left = left.next;
				curr = curr.next;
			}
		}
		if (left == null) curr.next = right;
		if (right == null) curr.next = left;
		return dummy.next;
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}