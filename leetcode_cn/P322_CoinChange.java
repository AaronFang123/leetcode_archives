//给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回
// -1。 
//
// 你可以认为每种硬币的数量是无限的。 
//
// 
//
// 示例 1： 
//
// 
//输入：coins = [1, 2, 5], amount = 11
//输出：3 
//解释：11 = 5 + 5 + 1 
//
// 示例 2： 
//
// 
//输入：coins = [2], amount = 3
//输出：-1 
//
// 示例 3： 
//
// 
//输入：coins = [1], amount = 0
//输出：0
// 
//
// 示例 4： 
//
// 
//输入：coins = [1], amount = 1
//输出：1
// 
//
// 示例 5： 
//
// 
//输入：coins = [1], amount = 2
//输出：2
// 
//
// 
//
// 提示： 
//
// 
// 1 <= coins.length <= 12 
// 1 <= coins[i] <= 231 - 1 
// 0 <= amount <= 104 
// 
// Related Topics 动态规划 
// 👍 858 👎 0


package leetcode.editor.leetcode_cn;

import java.util.Arrays;

//零钱兑换
//提交时间 2020-10-10 19:56:12
class P322_CoinChange {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P322_CoinChange().new Solution();
        System.out.println(solution.coinChange(new int[]{2}, 3));
    }

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 方法：动态；自底向上
        public int coinChange(int[] coins, int amount) {
            // 由memory的启发
            int[] dp = new int[amount + 1];
            Arrays.fill(dp, Integer.MAX_VALUE - 50);
            dp[0] = 0;
            // 从小推大 迭代； 从大推小 递归
            for (int i = 0; i < dp.length; i++) {
                for (int coin : coins) {
                    if (i - coin < 0) continue;
                    dp[i] = Math.min(dp[i - coin] + 1, dp[i]);
                }
            }
            return dp[amount] == Integer.MAX_VALUE-50 ? -1 : dp[amount];
        }

        public int coinChange_memory(int[] coins, int amount) {
            // 备忘录：记录int temp = coinChange(coins, amount - coin)的结果，避免重复计算
            // 大小设为amount + 1, 记录每种amount的可能 ，0... amount
            int[] memory = new int[amount + 1];
            Arrays.fill(memory, -2);
            return helper_coinChange(coins, amount, memory);
        }

        private int helper_coinChange(int[] coins, int amount, int[] memory) {
            if (amount == 0) return 0;
            // 是否命中，命中直接返回
            if (memory[amount] != -2) return memory[amount];
            int result = Integer.MAX_VALUE;
            for (int coin : coins) {
                if (amount - coin < 0) continue;
                int temp = coinChange(coins, amount - coin);
                result = Math.min(result, temp + 1);
            }
            // 记录
            memory[amount] = result == Integer.MAX_VALUE ? -1 : result;
            return memory[amount];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}