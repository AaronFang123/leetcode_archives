//给定一个二叉搜索树，编写一个函数 kthSmallest 来查找其中第 k 个最小的元素。 
//
// 说明： 
//你可以假设 k 总是有效的，1 ≤ k ≤ 二叉搜索树元素个数。 
//
// 示例 1: 
//
// 输入: root = [3,1,4,null,2], k = 1
//   3
//  / \
// 1   4
//  \
//   2
//输出: 1 
//
// 示例 2: 
//
// 输入: root = [5,3,6,2,4,null,null,1], k = 3
//       5
//      / \
//     3   6
//    / \
//   2   4
//  /
// 1
//输出: 3 
//
// 进阶： 
//如果二叉搜索树经常被修改（插入/删除操作）并且你需要频繁地查找第 k 小的值，你将如何优化 kthSmallest 函数？ 
// Related Topics 树 二分查找 
// 👍 302 👎 0


package leetcode.editor.cn;

import leetcode.editor.cn.base.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

//二叉搜索树中第K小的元素
//提交时间 2020-10-24 12:27:48
class P230_KthSmallestElementInABst{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P230_KthSmallestElementInABst().new Solution();
	 }
//力扣代码
	//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        // 第k个中序遍历值
		// 迭代法
		Deque<TreeNode> stack = new LinkedList<>();
		TreeNode curr = root;
		while(!stack.isEmpty() || curr != null){
			while (curr != null){
				stack.push(curr);
				curr = curr.left;
			}
			if (!stack.isEmpty()){
				k--;
				TreeNode node = stack.pop();
				if (k == 0){
					return node.val;
				}
				curr = node.right;
			}
		}
		return 0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}