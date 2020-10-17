//给定两个字符串 text1 和 text2，返回这两个字符串的最长公共子序列的长度。 
//
// 一个字符串的 子序列 是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。 
//例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。两个字符串的「公共子序列」是这两个字符串所共同拥有的子序列。
// 
//
// 若这两个字符串没有公共子序列，则返回 0。 
//
// 
//
// 示例 1: 
//
// 输入：text1 = "abcde", text2 = "ace" 
//输出：3  
//解释：最长公共子序列是 "ace"，它的长度为 3。
// 
//
// 示例 2: 
//
// 输入：text1 = "abc", text2 = "abc"
//输出：3
//解释：最长公共子序列是 "abc"，它的长度为 3。
// 
//
// 示例 3: 
//
// 输入：text1 = "abc", text2 = "def"
//输出：0
//解释：两个字符串没有公共子序列，返回 0。
// 
//
// 
//
// 提示: 
//
// 
// 1 <= text1.length <= 1000 
// 1 <= text2.length <= 1000 
// 输入的字符串只含有小写英文字符。 
// 
// Related Topics 动态规划 
// 👍 256 👎 0


package leetcode.editor.cn;

//最长公共子序列
//提交时间 2020-10-14 15:11:11
class P1143_LongestCommonSubsequence{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P1143_LongestCommonSubsequence().new Solution();
		 System.out.println(solution.longestCommonSubsequence("abcde", "ace"));
	 }
//力扣代码
	//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
		// 字符串子序列问题通常使用动态规划算法，因为就算是穷尽也难以列出所有可能性
		// dp数组含义 以dp[i][j]为例，字符串s[0...i]与字符串s[0...j]的LCS的最长长度为dp[i][j]
		// 状态：在/不在LCS
		// 转移：dp[i][j] = dp[i-1][j-1] + 1 (s[i] == s[j])
		//		dp[i][j] = Max{dp[i-1][j], dp[i][j-1]} (s[i] != s[j]) 抛弃其中小的一个
		// 边界条件：
		int m = text1.length();
		int n = text2.length();

		int[][] dp = new int[m + 1][n + 1];

		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++){
				if (text1.charAt(i - 1) == text2.charAt(j - 1)){
					// 找到一个LCS中的字符
					dp[i][j] = dp[i - 1][j - 1] + 1;
				}
				else{
					dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
				}
			}
		}
		return dp[m][n];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}