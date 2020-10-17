//给定一个非空二叉树, 返回一个由每层节点平均值组成的数组。 
//
// 
//
// 示例 1： 
//
// 输入：
//    3
//   / \
//  9  20
//    /  \
//   15   7
//输出：[3, 14.5, 11]
//解释：
//第 0 层的平均值是 3 ,  第1层是 14.5 , 第2层是 11 。因此返回 [3, 14.5, 11] 。
// 
//
// 
//
// 提示： 
//
// 
// 节点值的范围在32位有符号整数范围内。 
// 
// Related Topics 树 
// 👍 202 👎 0


package leetcode.editor.cn;

import leetcode.editor.cn.base.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//二叉树的层平均值
//提交时间 2020-10-15 16:58:41
class P637_AverageOfLevelsInBinaryTree{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P637_AverageOfLevelsInBinaryTree().new Solution();
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
    public List<Double> averageOfLevels(TreeNode root) {
		// 层次遍历
		List<Double> ans = new ArrayList<>();
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		while(!queue.isEmpty()){
			int size = queue.size();
			double sumOfThisLevel = 0;
			for (int i= 0 ; i < size; i++){
				TreeNode temp = queue.poll();
				sumOfThisLevel += temp.val;
				if (temp.left != null) queue.offer(temp.left);
				if (temp.right != null) queue.offer(temp.right);
			}
			ans.add(sumOfThisLevel / size);
		}
		return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}