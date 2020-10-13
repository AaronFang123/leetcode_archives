//给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。 
//
// 设计一个算法来计算你所能获取的最大利润。你最多可以完成 两笔 交易。 
//
// 注意: 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。 
//
// 示例 1: 
//
// 输入: [3,3,5,0,0,3,1,4]
//输出: 6
//解释: 在第 4 天（股票价格 = 0）的时候买入，在第 6 天（股票价格 = 3）的时候卖出，这笔交易所能获得利润 = 3-0 = 3 。
//     随后，在第 7 天（股票价格 = 1）的时候买入，在第 8 天 （股票价格 = 4）的时候卖出，这笔交易所能获得利润 = 4-1 = 3 。 
//
// 示例 2: 
//
// 输入: [1,2,3,4,5]
//输出: 4
//解释: 在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。   
//     注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。   
//     因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。
// 
//
// 示例 3: 
//
// 输入: [7,6,4,3,1] 
//输出: 0 
//解释: 在这个情况下, 没有交易完成, 所以最大利润为 0。 
// Related Topics 数组 动态规划 
// 👍 524 👎 0


package leetcode.editor.cn;

//买卖股票的最佳时机 III
//提交时间 2020-10-11 14:23:01
class P123_BestTimeToBuyAndSellStockIii {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P123_BestTimeToBuyAndSellStockIii().new Solution();
        System.out.println(solution.maxProfit(new int[]{1,2,3,4,5}));
    }

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
		public int maxProfit(int[] prices){
			// 改造
			int dp_i_2_0 = 0;
			int dp_i_1_0 = 0;
			int dp_i_2_1 = -10000;
			int dp_i_1_1 = -10000;
			for (int price : prices) {
				dp_i_2_0 = Math.max(dp_i_2_0, dp_i_2_1 + price);// 卖出
				dp_i_2_1 = Math.max(dp_i_2_1, dp_i_1_0 - price);// 买入
				dp_i_1_0 = Math.max(dp_i_1_0, dp_i_1_1 + price);// 卖出
				dp_i_1_1 = Math.max(dp_i_1_1, -price);// 买入
			}
			return dp_i_2_0;
		}

        // 空间优化前写法
        public int maxProfit_temp(int[] prices) {
            // 三维dp数组，用于描述状态：天数，剩余可交易次数(只有卖出时交易次数减一)，持有状态
            int days = prices.length;
            int dues = 2;
            int holdings = 2;
            int[][][] dp = new int[days][dues + 1][holdings];

            // 遍历解空间
            // 天数
            for (int i = 0; i < days; ++i) {
                // 交易次数
                for (int k = dues; k > 0; k--) {
                    if (i == 0) {
                        dp[0][k][0] = 0;
                        dp[0][k][1] = Integer.MIN_VALUE;
                        continue;
                    }
                    dp[i][k][0] = Math.max(dp[i - 1][k][0], dp[i - 1][k][1] + prices[i]);// 卖出
                    dp[i][k][1] = Math.max(dp[i - 1][k][1], dp[i - 1][k - 1][0] - prices[i]);// 买入
					/*
					去掉内层循环：
						dp[i][2][0] = Math.max(dp[i-1][2][0], dp[i-1][2][1] + prices[i]);// 卖出
						dp[i][2][1] = Math.max(dp[i-1][2][1], dp[i-1][1][0] - prices[i]);// 买入
						dp[i][1][0] = Math.max(dp[i-1][1][0], dp[i-1][1][1] + prices[i]);// 卖出
						dp[i][1][1] = Math.max(dp[i-1][1][1], -prices[i]);// 买入
					 */
                }
            }
            return dp[days - 1][dues][0];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}