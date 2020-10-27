//将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。 
//
// 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。 
//
// 示例: 
//
// 给定有序数组: [-10,-3,0,5,9],
//
//一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
//
//      0
//     / \
//   -3   9
//   /   /
// -10  5
// 
// Related Topics 树 深度优先搜索 
// 👍 621 👎 0


package leetcode.editor.cn;

import leetcode.editor.cn.base.ListNode;
import leetcode.editor.cn.base.TreeNode;

import java.util.List;

//将有序数组转换为二叉搜索树
//提交时间 2020-10-24 11:48:31
class P108_ConvertSortedArrayToBinarySearchTree{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P108_ConvertSortedArrayToBinarySearchTree().new Solution();
		 List<List<Integer>> lists = TreeNode.levelOrder(solution.sortedArrayToBST(new int[]{0,1,2, 3,4,5}));
		 System.out.println(lists.toString());
	 }
//力扣代码
	//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
		int len = nums.length;
		if (len == 0) return null;
		int midIndex = len/2;
		TreeNode left = helper_left(midIndex - 1, nums);
		TreeNode right = helper_right(midIndex + 1, nums);
		TreeNode res = new TreeNode(nums[midIndex]);
		res.left = left;
		res.right = right;
		return res;
    }

	private TreeNode helper_right(int i, int[] nums) {
    	if (i > nums.length - 1) return null;
		if (i == nums.length - 1) return new TreeNode(nums[nums.length - 1]);

		TreeNode node = new TreeNode(nums[i]);
		node.right = helper_right(i + 1, nums);
		return node;
	}

	private TreeNode helper_left(int i, int[] nums) {
    	if (i < 0) return null;
    	if (i == 0) return new TreeNode(nums[0]);

    	TreeNode node = new TreeNode(nums[i]);
    	node.left = helper_left(i - 1, nums);
    	return node;
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}