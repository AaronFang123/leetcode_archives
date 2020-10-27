//给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。 
//
// 例如： 
//给定二叉树 [3,9,20,null,null,15,7], 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回锯齿形层次遍历如下： 
//
// [
//  [3],
//  [20,9],
//  [15,7]
//]
// 
// Related Topics 栈 树 广度优先搜索 
// 👍 282 👎 0


package leetcode.editor.cn;

import leetcode.editor.cn.base.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//二叉树的锯齿形层次遍历
//提交时间 2020-10-24 12:44:19
class P103_BinaryTreeZigzagLevelOrderTraversal{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P103_BinaryTreeZigzagLevelOrderTraversal().new Solution();
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		// 层次奇数逆序 偶数逆序
		List<List<Integer>> ans = new ArrayList<>();
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);

		while (!queue.isEmpty()){
			List<Integer> thisLevel = new ArrayList<>();
			int size = queue.size();
			for (int i = 0; i < size; i++){
				TreeNode node = queue.poll();
				if (ans.size() % 2 == 1){
					thisLevel.add(0, node.val);
				}
				if (ans.size() % 2 == 0){
					thisLevel.add(node.val);
				}

				if (node.left != null){
					queue.offer(node.left);
				}
				if (node.right != null){
					queue.offer(node.right);
				}
			}
			ans.add(thisLevel);
		}
		return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}