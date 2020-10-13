//给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。 
//
// 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。 
//
// 
//
// 示例 1： 
//
// 输入："abc"
//输出：3
//解释：三个回文子串: "a", "b", "c"
// 
//
// 示例 2： 
//
// 输入："aaa"
//输出：6
//解释：6个回文子串: "a", "a", "a", "aa", "aa", "aaa" 
//
// 
//
// 提示： 
//
// 
// 输入的字符串长度不会超过 1000 。 
// 
// Related Topics 字符串 动态规划 
// 👍 418 👎 0


package leetcode.editor.cn;

//回文子串
//提交时间 2020-10-13 15:28:15
class P647_PalindromicSubstrings{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P647_PalindromicSubstrings().new Solution();
		 System.out.println(solution.countSubstrings("abc"));
	 }
//力扣代码
	//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int countSubstrings(String s) {
    	int ans = 0;
		char[] charArray = s.toCharArray();
		int len = charArray.length;
		boolean[][] dp = new boolean[len][len];

		// 初始化
		for (int i = 0; i < len; i++) {
			dp[i][i] = true;
			ans++;
		}

		for (int i = 0; i < len; i++) {
			for (int j = 0; j < i; j++){
				if (charArray[i] == charArray[j]){
					// 长度短
					if (i - j - 1  < 2) {
						dp[j][i] = true;
						ans++;
					}
					else{
						dp[j][i] = dp[j + 1][i - 1];
						if (dp[j][i])  ans++;
					}
				}
			}
		}
		return ans;
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}