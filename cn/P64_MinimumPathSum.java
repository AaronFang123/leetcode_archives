//给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。 
//
// 说明：每次只能向下或者向右移动一步。 
//
// 示例: 
//
// 输入:
//[
//  [1,3,1],
//  [1,5,1],
//  [4,2,1]
//]
//输出: 7
//解释: 因为路径 1→3→1→1→1 的总和最小。
// 
// Related Topics 数组 动态规划 
// 👍 692 👎 0


package leetcode.editor.cn;

//最小路径和
//提交时间 2020-10-11 16:23:18
class P64_MinimumPathSum{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P64_MinimumPathSum().new Solution();
		 System.out.println(
		 		solution.minPathSum(
		 				new int[][]{
								{1,2,5},
								{3,2,1},
						}
				)
		 );
	 }
//力扣代码
	//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minPathSum(int[][] grid) {
    	int m = grid.length;
    	int n = 0;
    	if (m != 0 && grid[0].length != 0){
			n = grid[0].length;
		}
    	else return 0;
		int[][] dp = new int[m][n];
		for (int i = 0; i < m; i++) {
			if (i == 0){
				dp[i][0] =  grid[i][0];
				continue;
			}
			dp[i][0] = dp[i-1][0]  + grid[i][0];
		}
		for (int j = 0; j < n; j++) {
			if (j == 0){
				continue;
			}
			dp[0][j] = dp[0][j-1] + grid[0][j];
		}

		for (int i = 1; i < m; i++){
			for (int j = 1; j < n; j++){
				dp[i][j] = Math.min(dp[i][j-1] , dp[i-1][j]) + grid[i][j];
			}
		}

		return dp[m - 1][n - 1];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}