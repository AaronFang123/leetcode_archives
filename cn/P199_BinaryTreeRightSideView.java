//给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。 
//
// 示例: 
//
// 输入: [1,2,3,null,5,null,4]
//输出: [1, 3, 4]
//解释:
//
//   1            <---
// /   \
//2     3         <---
// \     \
//  5     4       <---
// 
// Related Topics 树 深度优先搜索 广度优先搜索 
// 👍 344 👎 0


package leetcode.editor.cn;

import leetcode.editor.cn.base.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//二叉树的右视图
//提交时间 2020-10-19 15:44:58
class P199_BinaryTreeRightSideView{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P199_BinaryTreeRightSideView().new Solution();
		 System.out.println();
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
    public List<Integer> rightSideView(TreeNode root) {
		// 层次遍历
		Queue<TreeNode> queue = new LinkedList<>();
		List<Integer> ans = new ArrayList<>();
		queue.offer(root);
		while (!queue.isEmpty()){
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				TreeNode node = queue.poll();
				if(node.left != null){
					queue.offer(node.left);
				}
				if (node.right != null){
					queue.offer(node.right);
				}
				if (i == size - 1) ans.add(node.val);
			}
		}
		return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}