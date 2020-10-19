//将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
//
// 
//
// 示例： 
//
// 输入：1->2->4, 1->3->4
//输出：1->1->2->3->4->4
// 
// Related Topics 链表 
// 👍 1333 👎 0


package leetcode.editor.cn;

import leetcode.editor.cn.base.ListNode;

//合并两个有序链表
//提交时间 2020-10-19 16:28:55
class P21_MergeTwoSortedLists{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P21_MergeTwoSortedLists().new Solution();
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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(-1);
        ListNode prev = dummyHead;
        while(l1 != null && l2 != null){
        	if (l1.val <= l2.val){
        		prev.next = l1;
        		prev = l1;
        		l1 = l1.next;
			}
        	else{
				prev.next = l2;
				prev = l2;
				l2 = l2.next;
			}
		}

        if (l1 == null){
        	prev.next = l2;
		}

        if (l2 == null){
        	prev.next = l1;	
		}

        return dummyHead.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}