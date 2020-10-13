//给定一个整数数组，其中第 i 个元素代表了第 i 天的股票价格 。 
//
// 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）: 
//
// 
// 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。 
// 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。 
// 
//
// 示例: 
//
// 输入: [1,2,3,0,2]
//输出: 3 
//解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出] 
// Related Topics 动态规划 
// 👍 574 👎 0


package leetcode.editor.cn;

//最佳买卖股票时机含冷冻期
//提交时间 2020-10-11 11:14:39
class P309_BestTimeToBuyAndSellStockWithCooldown{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P309_BestTimeToBuyAndSellStockWithCooldown().new Solution();
		 System.out.println(solution.maxProfit(new int[]{1,2,3,0,2}));
	 }
//力扣代码
	//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
	// 描述状态 dp[i][j] 第i天是否持有股票
	// 描述选择：买入/卖出。休息
	// 状态转移方程 dp[i][0] = max{dp[i-1][0], dp[i-1][0] + prices[i]} 卖出
	// dp[i][1] = max{dp[i-2][0] - prices[i], dp[i-1][1]}
    public int maxProfit(int[] prices) {
//    	int dayCount = prices.length;
//    	int statusCount = 2;// 0/1
//		int[][] dp = new int[dayCount][statusCount];
		int dp_i_0 = 0;
		int dp_i_1 = Integer.MIN_VALUE;
		int dp_pre_0 = 0;
		// 核心：遍历状态
		for (int price : prices) {
			// 滚动
			int temp = dp_i_0;
			dp_i_0 = Math.max(dp_i_0, dp_i_1 + price);
			dp_i_1 = Math.max(dp_i_1, dp_pre_0 - price);
			dp_pre_0 = temp;
		}
		return dp_i_0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}