package leetcode.editor.cn.base;

import java.util.ArrayList;
import java.util.List;

public class ListNode {
    public int val;
    public ListNode next;

    ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    // 根据数组形成链表
    public static ListNode initLinkListByArray(int[] target){
        if (target.length == 0) {
            throw new RuntimeException("长度不可为0 length of array cannot be 0");
        }
        int len = target.length;
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;

        for (int value : target) {
            curr.next = new ListNode(value);
            curr = curr.next;
        }

        return dummy.next;
    }

    // 打印链表
    public static void printLinkedList(ListNode head){
        List<Integer> list = new ArrayList<>();
        while (head!= null){
            list.add(head.val);
            head = head.next;
        }
        System.out.println(list.toString());
    }
}