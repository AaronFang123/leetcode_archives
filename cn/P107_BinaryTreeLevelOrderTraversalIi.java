//给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历） 
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
// 返回其自底向上的层次遍历为： 
//
// [
//  [15,7],
//  [9,20],
//  [3]
//]
// 
// Related Topics 树 广度优先搜索 
// 👍 349 👎 0


package leetcode.editor.cn;

import leetcode.editor.cn.base.TreeNode;

import java.util.*;

//二叉树的层次遍历 II
//提交时间 2020-10-16 16:00:36
class P107_BinaryTreeLevelOrderTraversalIi{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P107_BinaryTreeLevelOrderTraversalIi().new Solution();
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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
		List<List<Integer>> ans = new ArrayList<>();
		Queue<TreeNode> queue = new LinkedList<>();

		if(root == null) return ans;
		queue.offer(root);
		while(!queue.isEmpty()){
			int size = queue.size();
			List<Integer> thisLevel = new ArrayList<>();
			for(int i = 0; i < size; i++){
				TreeNode temp = queue.poll();
				thisLevel.add(temp.val);
				if(temp.left != null){
					queue.offer(temp.left);
				}
				if(temp.right != null){
					queue.offer(temp.right);
				}
			}
			ans.add(thisLevel);
		}
		Collections.reverse(ans);
		return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}