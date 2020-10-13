//给定一个非负整数数组，a1, a2, ..., an, 和一个目标数，S。现在你有两个符号 + 和 -。对于数组中的任意一个整数，你都可以从 + 或 -中选
//择一个符号添加在前面。 
//
// 返回可以使最终数组和为目标数 S 的所有添加符号的方法数。 
//
// 
//
// 示例： 
//
// 输入：nums: [1, 1, 1, 1, 1], S: 3
//输出：5
//解释：
//
//-1+1+1+1+1 = 3
//+1-1+1+1+1 = 3
//+1+1-1+1+1 = 3
//+1+1+1-1+1 = 3
//+1+1+1+1-1 = 3
//
//一共有5种方法让最终目标和为3。
// 
//
// 
//
// 提示： 
//
// 
// 数组非空，且长度不会超过 20 。 
// 初始的数组的和不会超过 1000 。 
// 保证返回的最终结果能被 32 位整数存下。 
// 
// Related Topics 深度优先搜索 动态规划 
// 👍 424 👎 0


package leetcode.editor.cn;

import org.junit.Test;

//目标和
//提交时间 2020-10-10 10:50:01
class P494_TargetSum {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P494_TargetSum().new Solution();
//        int targetSumWays = solution.findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 3);
        int targetSumWays =new P494_TargetSum().new Solution().sunsets(new int[]{1,1,1,1}, 2);
        System.out.println(targetSumWays);
    }

    @Test
    void test(){
        new P494_TargetSum().new Solution().sunsets(new int[]{1,1,1,1}, 2);
    }

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 问题等效转化为：在给定数组中寻找符合条件的子集A的个数，使得sum(A) =( target + sum(nums) ) / 2
         * 动态规划算法：参照背包问题
         * 翻译成子集问题: 若只在 nums 的前 i 个元素中选择，若目标和为 j，则最多有 x 种方法划分子集。
         * 解析见 https://leetcode-cn.com/problems/target-sum/solution/dong-tai-gui-hua-he-hui-su-suan-fa-dao-di-shui-shi/
         *
         * @param nums
         * @param S
         * @return
         */
        public int findTargetSumWays(int[] nums, int S) {
            int sum = 0;
            for (int n : nums) {
                sum += n;
            }
            // 不可能出现合理的子集划分的状况
            if (Math.abs(S)>sum|| (S + sum) % 2 == 1) return 0;
            return sunsets(nums, (S + sum) / 2);
        }

        /** dp[i][j] = dp[i-1][j] + dp[i-1][j-nums[i-1]];
         * dp[i][j] = x 表示，若只在前 i 个物品中选择，若当前背包的容量为 j，则最多有 x 种方法可以恰好装满背包
         * @param nums
         * @param sum
         * @return
         */
         int sunsets(int[] nums, int sum) {
            int n = nums.length;
            int[][] dp = new int[n + 1][sum + 1];
            // 初始化 当前背包容量为0 什么都不装是唯一的装法
            for (int i = 0; i < n; i++) {
                dp[i][0] = 1;
            }

            // "状态" 背包的容量 剩余可选择的物品 “选择” 装入背包/不装入背包
            // nums[i-1] 代表的是第 i 个物品的重量
            for (int i = 1; i <= n; i++) {
                for (int j = 0; j <= sum; j++) {
                    if (j >= nums[i - 1]){
                        // 若当前物品的重量小于背包大小
                        // 意义；
                        // 1. 若当前转入背包 dp[i-1][j-nums[i-1]] 那么只要看前 i - 1 个物品有几种方法可以装满 j - nums[i-1] 的重量就行了
                        // 2. 当前不装入背包 dp[i-1][j]
                        dp[i][j] = dp[i-1][j] + dp[i-1][j-nums[i-1]];
                    }
                    else{
                        dp[i][j] = dp[i-1][j];
                    }
                }
            }
            return dp[n][sum];
        }


        int count = 0;

        /**
         * 递归算法
         *
         * @param nums
         * @param S    target
         * @return ways
         */
        public int findTargetSumWays_recursion(int[] nums, int S) {
            dfs(0, S, 0, nums);
            return count;
        }

        private void dfs(int currSum, int target, int level, int[] nums) {
            if (currSum == target && level == nums.length) {
                count++;
                return;
            }
            if (level >= nums.length) return;
            dfs(currSum + nums[level], target, level + 1, nums);
            dfs(currSum - nums[level], target, level + 1, nums);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}