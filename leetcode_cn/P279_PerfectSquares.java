//给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。 
//
// 示例 1: 
//
// 输入: n = 12
//输出: 3 
//解释: 12 = 4 + 4 + 4. 
//
// 示例 2: 
//
// 输入: n = 13
//输出: 2
//解释: 13 = 4 + 9. 
// Related Topics 广度优先搜索 数学 动态规划 
// 👍 623 👎 0


package leetcode.editor.leetcode_cn;

//完全平方数
//提交时间 2020-10-11 17:02:20
class P279_PerfectSquares{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P279_PerfectSquares().new Solution();
		 System.out.println(solution.numSquares(13));
	 }
//力扣代码
	//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
	 	// dp[n] = min{dp[count - coins[i]]}, i ∈ (0, coins.length)
		// 打备忘录
    public int numSquares(int n) {
		int len = (int) Math.sqrt(n);
		int[] coins = new int[len];
		int[] dp = new int[n + 1];
 		for (int i = 0; i < len; i++) {
			int temp = i + 1;
			coins[i] = temp * temp;
		}

		for (int i = 0; i <= n; i++) {
			int currMin = Integer.MAX_VALUE;
			for (int j = 0; j < len; j++) {
				if (i - coins[j] < 0) break;
				dp[i] = Math.min(dp[i - coins[j]] + 1, currMin);
				currMin = dp[i];
			}
		}
		return dp[n];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}