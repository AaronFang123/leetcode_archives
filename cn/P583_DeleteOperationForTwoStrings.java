//给定两个单词 word1 和 word2，找到使得 word1 和 word2 相同所需的最小步数，每步可以删除任意一个字符串中的一个字符。 
//
// 
//
// 示例： 
//
// 输入: "sea", "eat"
//输出: 2
//解释: 第一步将"sea"变为"ea"，第二步将"eat"变为"ea"
// 
//
// 
//
// 提示： 
//
// 
// 给定单词的长度不超过500。 
// 给定单词中的字符只含有小写字母。 
// 
// Related Topics 字符串 
// 👍 150 👎 0


package leetcode.editor.cn;

//两个字符串的删除操作
//提交时间 2020-10-18 14:46:42
class P583_DeleteOperationForTwoStrings{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P583_DeleteOperationForTwoStrings().new Solution();
		 System.out.println(solution.minDistance("b", "a"));
	 }
//力扣代码
	//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minDistance(String word1, String word2) {
    	int len1 = word1.length();
    	int len2 = word2.length();
    	if (len1 * len2 == 0){
    		return len1 == 0 ? len2 :len1;
		}
		int[][] dp = new int[len1 + 1][len2 + 1];

		for (int i = 0;i <= len1; i++){
			dp[i][0] = i;
		}
		for (int j = 0;j <= len2; j++){
			dp[0][j] = j;
		}

		for (int i = 1; i <= len1; i++){
			for (int j = 1; j <= len2; j++){
				if (word1.charAt(i - 1) == word2.charAt(j - 1)){
					dp[i][j] = dp[i - 1][j - 1];
				}
				else{
					dp[i][j] = Math.min(dp[i][j-1], dp[i-1][j]) + 1;
				}
			}
		}
		return dp[len1][len2];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}