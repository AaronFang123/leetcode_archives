//一条包含字母 A-Z 的消息通过以下方式进行了编码： 
//
// 'A' -> 1
//'B' -> 2
//...
//'Z' -> 26
// 
//
// 给定一个只包含数字的非空字符串，请计算解码方法的总数。 
//
// 题目数据保证答案肯定是一个 32 位的整数。 
//
// 
//
// 示例 1： 
//
// 输入："12"
//输出：2
//解释：它可以解码为 "AB"（1 2）或者 "L"（12）。
// 
//
// 示例 2： 
//
// 输入："226"
//输出：3
//解释：它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
// 
//
// 示例 3： 
//
// 输入：s = "0"
//输出：0
// 
//
// 示例 4： 
//
// 输入：s = "1"
//输出：1
// 
//
// 示例 5： 
//
// 输入：s = "2"
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 100 
// s 只包含数字，并且可以包含前导零。 
// 
// Related Topics 字符串 动态规划 
// 👍 537 👎 0


package leetcode.editor.cn;

//解码方法
//提交时间 2020-10-23 10:53:18
class P91_DecodeWays{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P91_DecodeWays().new Solution();
		 System.out.println(solution.numDecodings("232"));
	 }
//力扣代码
	//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
	public int numDecodings(String s, boolean aBoolean){
		int len = s.length();
		int dp_11 = 0, dp_01, dp_1;
		dp_01 = 1;
		dp_1 = s.charAt(0) == '0' ? 0 : 1;
		for (int i = 1; i < len; i++){
			//如果最后一位与倒数第二位拼接的树属于10 - 26，
			if (s.charAt(i - 1) == '1' || (s.charAt(i - 1) == '2' && s.charAt(i) < '7')){
				if (s.charAt(i) == '0'){
					dp_11 = dp_01; // 由dp[i] = dp[i - 2]平移
				}
				else{
					dp_11 =dp_1 + dp_01; // 由dp[i] = dp[i - 2] + dp[i - 1]平移
				}
			}
			else{
				if (s.charAt(i) == '0'){
					return 0;
				}
				else {
					dp_11 = dp_1; // 由dp[i] = dp[i - 1]平移
				}
			}
			// 滚动
			dp_01 = dp_1;
			dp_1 = dp_11;
		}
		return dp_1;
	}
    public int numDecodings(String s) {
		// 如果最后一位与倒数第二位拼接的树属于10 - 26，
		//		如果最后一位是0，最后一位与倒数第二位拼接得到10或20，不能拆开，附加在dp[i-2]上
		//		若不是，可附加，也可拼接
		// 不是
		// 		最后一位是0，不能解码
		// 		不是0，最后一位加到dp[i - 1]后面

		int len = s.length();
		int[] dp = new int[len + 1];
		dp[0] = 1;
		// 并且可以包含前导零。
		dp[1] = s.charAt(0) == '0' ? 0 : 1;
		for (int i = 1; i < len; i++){
			//如果最后一位与倒数第二位拼接的树属于10 - 26，
			if (s.charAt(i - 1) == '1' || (s.charAt(i - 1) == '2' && s.charAt(i) < '7')){
				if (s.charAt(i) == '0'){
					dp[i + 1] = dp[i - 1]; // 由dp[i] = dp[i - 2]平移
				}
				else{
					dp[i + 1] = dp[i] + dp[i - 1]; // 由dp[i] = dp[i - 2] + dp[i - 1]平移
				}
			}
			else{
				if (s.charAt(i) == '0'){
					return 0;
				}
				else {
					dp[i + 1] = dp[i]; // 由dp[i] = dp[i - 1]平移
				}
			}
		}
		return dp[len];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}