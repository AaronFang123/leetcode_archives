//请判断一个链表是否为回文链表。 
//
// 示例 1: 
//
// 输入: 1->2
//输出: false 
//
// 示例 2: 
//
// 输入: 1->2->2->1
//输出: true
// 
//
// 进阶： 
//你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？ 
// Related Topics 链表 双指针 
// 👍 682 👎 0


package leetcode.editor.cn;

import leetcode.editor.cn.base.ListNode;

//回文链表
//提交时间 2020-10-23 08:54:00
class P234_PalindromeLinkedList{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P234_PalindromeLinkedList().new Solution();
		 System.out.println(solution.isPalindrome(ListNode.initLinkListByArray(new int[]{0,0})));
	 }
//力扣代码
	//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
		ListNode endOfFirstHalf = findLastNodeOfFirstHalf(head);
		ListNode nextStart = endOfFirstHalf.next;
		endOfFirstHalf.next = null;
		ListNode reversedHead = reverse(nextStart);

		// 等位判断
		while (reversedHead != null){
			if (head.val != reversedHead.val){
				return false;
			}
			head = head.next;
			reversedHead = reversedHead.next;
		}
		return true;
    }

    ListNode findLastNodeOfFirstHalf(ListNode head){
    	ListNode fast = head;
    	ListNode slow = head;
    	while (fast.next != null && fast.next.next != null){
    		fast = fast.next.next;
    		slow = slow.next;
		}
    	return slow;
	}
	ListNode reverse(ListNode head){
    	ListNode prev = null;
    	if (head == null) return null;
    	ListNode curr = head;
    	ListNode nextPtr;

    	while (true){
    		nextPtr = curr.next;
    		// 反转操作
			curr.next = prev;

			prev = curr;
			if (nextPtr == null) break;
			curr = nextPtr;
		}

    	return curr;
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}