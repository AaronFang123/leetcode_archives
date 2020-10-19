//给定一个二叉树，判断其是否是一个有效的二叉搜索树。 
//
// 假设一个二叉搜索树具有如下特征： 
//
// 
// 节点的左子树只包含小于当前节点的数。 
// 节点的右子树只包含大于当前节点的数。 
// 所有左子树和右子树自身必须也是二叉搜索树。 
// 
//
// 示例 1: 
//
// 输入:
//    2
//   / \
//  1   3
//输出: true
// 
//
// 示例 2: 
//
// 输入:
//    5
//   / \
//  1   4
//     / \
//    3   6
//输出: false
//解释: 输入为: [5,1,4,null,null,3,6]。
//     根节点的值为 5 ，但是其右子节点值为 4 。
// 
// Related Topics 树 深度优先搜索 
// 👍 810 👎 0


package leetcode.editor.cn;

import leetcode.editor.cn.base.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

//验证二叉搜索树
//提交时间 2020-10-18 11:30:54
class P98_ValidateBinarySearchTree{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P98_ValidateBinarySearchTree().new Solution();
	 	 TreeNode root = new TreeNode(2, new TreeNode(1), new TreeNode(3));
		 System.out.println(solution.isValidBST(root));
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
    public boolean isValidBST(TreeNode root) {
    	TreeNode curr = root;
    	int pre = root.val;
		Deque<TreeNode> stack = new ArrayDeque<>();
		while(!stack.isEmpty() || curr != null){
			while (curr != null){
				stack.push(curr);
				curr = curr.left;
			}
			if (!stack.isEmpty()){
				TreeNode temp = stack.pop();
				if (temp.val > pre){
					pre = temp.val;
					curr = temp.right;
				}
				else {
					return false;
				}
			}
		}
		return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}