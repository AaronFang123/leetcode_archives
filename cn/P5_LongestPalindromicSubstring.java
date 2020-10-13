//给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。 
//
// 示例 1： 
//
// 输入: "babad"
//输出: "bab"
//注意: "aba" 也是一个有效答案。
// 
//
// 示例 2： 
//
// 输入: "cbbd"
//输出: "bb"
// 
// Related Topics 字符串 动态规划 
// 👍 2795 👎 0


package leetcode.editor.cn;

//最长回文子串
//提交时间 2020-10-13 11:17:38
class P5_LongestPalindromicSubstring{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P5_LongestPalindromicSubstring().new Solution();
		 System.out.println(solution.longestPalindrome("cbbd"));
	 }
//力扣代码
	//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String longestPalindrome(String s) {
    	// 用于保存结果
		int startIndex = 0;
		int maxLength = 1;

		char[] charArray = s.toCharArray();
		int arrayLen = charArray.length;
		boolean[][] dp = new boolean[arrayLen][arrayLen];
		// 初始化
		for (int i = 0; i < arrayLen; i++){
			dp[i][i] = true;
		}
		// 遍历解空间
		for (int i = 1; i < arrayLen; i++) {
			for (int j = 0; j < i; j++) {
				if (charArray[i] != charArray[j]){
					dp[j][i] = false;
				}
				else{
					// 如果子串长度过短
					if (i - j - 1 < 2){
						dp[j][i] = true;
					}
					else{
						dp[j][i] = dp[j + 1][i - 1];
					}
				}
				// 记录这个子串
				if (dp[j][i] && i - j + 1 > maxLength){
					maxLength = i - j + 1;
					startIndex = j;
				}
			}

		}
		return s.substring(startIndex, maxLength + startIndex) ;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}