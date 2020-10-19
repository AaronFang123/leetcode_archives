//给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。 
//
// 示例： 
//
// 给定一个链表: 1->2->3->4->5, 和 n = 2.
//
//当删除了倒数第二个节点后，链表变为 1->2->3->5.
// 
//
// 说明： 
//
// 给定的 n 保证是有效的。 
//
// 进阶： 
//
// 你能尝试使用一趟扫描实现吗？ 
// Related Topics 链表 双指针 
// 👍 1034 👎 0


package leetcode.editor.cn;

import leetcode.editor.cn.base.ListNode;

//删除链表的倒数第N个节点
//提交时间 2020-10-18 09:05:25
class P19_RemoveNthNodeFromEndOfList{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P19_RemoveNthNodeFromEndOfList().new Solution();
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
    public ListNode removeNthFromEnd(ListNode head, int n) {
    	int temp = n;
        ListNode tail = head;
        ListNode pre = null;
        ListNode curr = head;
		int counter = 0;
        while (n != 0){
        	counter++;
        	tail = tail.next;
        	n--;
		}
        while (tail != null){
        	counter++;
        	tail = tail.next;
        	pre = curr;
        	curr = curr.next;
		}
        if (counter == temp) return head.next;
        // 删除操作
		pre.next = curr.next;
        curr.next = null;
        return head;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}