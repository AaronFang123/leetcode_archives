//在上次打劫完一条街道之后和一圈房屋后，小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为“根”。 除了“根”之外，每栋房子有且只有一个“父“
//房子与之相连。一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。 如果两个直接相连的房子在同一天晚上被打劫，房屋将自动报警。 
//
// 计算在不触动警报的情况下，小偷一晚能够盗取的最高金额。 
//
// 示例 1: 
//
// 输入: [3,2,3,null,3,null,1]
//
//     3
//    / \
//   2   3
//    \   \ 
//     3   1
//
//输出: 7 
//解释: 小偷一晚能够盗取的最高金额 = 3 + 3 + 1 = 7. 
//
// 示例 2: 
//
// 输入: [3,4,5,1,3,null,1]
//
//     3
//    / \
//   4   5
//  / \   \ 
// 1   3   1
//
//输出: 9
//解释: 小偷一晚能够盗取的最高金额 = 4 + 5 = 9.
// 
// Related Topics 树 深度优先搜索 
// 👍 605 👎 0


package leetcode.editor.cn;

import leetcode.editor.cn.base.TreeNode;

import java.util.HashMap;

//打家劫舍 III
//提交时间 2020-10-13 17:06:00
class P337_HouseRobberIii {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P337_HouseRobberIii().new Solution();
    }
//力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    class Solution {
        HashMap<TreeNode, Integer> map = new HashMap<>();

        public int rob(TreeNode root) {
            return rob_iii_helper(root);
        }

        private int rob_iii_helper(TreeNode root) {
            // 退出条件
            if (root == null) return 0;
            if (map.containsKey(root)) return map.get(root);
            // 抢这家和下下家
            int goForIt = root.val +
                    (root.left != null ? rob_iii_helper(root.left.left) + rob_iii_helper(root.left.right): 0) +
                    (root.right != null ? rob_iii_helper(root.right.right) +  rob_iii_helper(root.right.left): 0);

            // 不抢这家，抢下家
            int no_rob =  rob_iii_helper(root.left) + rob_iii_helper(root.right);
            int benefitOfThisNode = Math.max(no_rob, goForIt);
            map.put(root, benefitOfThisNode);
            return benefitOfThisNode;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}