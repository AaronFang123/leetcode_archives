//给你两个单词 word1 和 word2，请你计算出将 word1 转换成 word2 所使用的最少操作数 。 
//
// 你可以对一个单词进行如下三种操作： 
//
// 
// 插入一个字符 
// 删除一个字符 
// 替换一个字符 
// 
//
// 
//
// 示例 1： 
//
// 输入：word1 = "horse", word2 = "ros"
//输出：3
//解释：
//horse -> rorse (将 'h' 替换为 'r')
//rorse -> rose (删除 'r')
//rose -> ros (删除 'e')
// 
//
// 示例 2： 
//
// 输入：word1 = "intention", word2 = "execution"
//输出：5
//解释：
//intention -> inention (删除 't')
//inention -> enention (将 'i' 替换为 'e')
//enention -> exention (将 'n' 替换为 'x')
//exention -> exection (将 'n' 替换为 'c')
//exection -> execution (插入 'u')
// 
// Related Topics 字符串 动态规划 
// 👍 1192 👎 0


package leetcode.editor.cn;

//编辑距离
//提交时间 2020-10-14 15:38:21
class P72_EditDistance{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P72_EditDistance().new Solution();
         System.out.println(solution.minDistance("horse","ros"));
//		 System.out.println(solution.minDistance("horse", "ros"));
	 }
//力扣代码
	//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minDistance(String word1, String word2) {
    	int m = word1.length();
    	int n = word2.length();

    	int[][] dp = new int[m + 1][n + 1];
    	// 初始话，对空字符串的编辑距离
		for (int i = 0; i < m; i++){
			dp[i][0] = i;
		}

		for (int j = 0; j < n; j++){
			dp[0][j] = j;
		}

		// 遍历解空间
		for (int i = 1; i < m + 1; i++) {
			for (int j = 1;j < n + 1;j++){
				if (word1.charAt(i - 1) == word2.charAt(j - 1)){
					// 跳过，编辑距离不变
					dp[i][j] = dp[i - 1][j - 1];
				}
				else{
					// 在增加、删除、修改中选择其中最小的
					dp[i][j] = Math.min(dp[i - 1][j], Math.min( dp[i][j - 1], dp[i - 1][j - 1])) + 1;
				}
			}
		}
		return dp[m][n];
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}