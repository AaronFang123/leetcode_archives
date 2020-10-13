//给定一个无序的整数数组，找到其中最长上升子序列的长度。 
//
// 示例: 
//
// 输入: [10,9,2,5,3,7,101,18]
//输出: 4 
//解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。 
//
// 说明: 
//
// 
// 可能会有多种最长上升子序列的组合，你只需要输出对应的长度即可。 
// 你算法的时间复杂度应该为 O(n2) 。 
// 
//
// 进阶: 你能将算法的时间复杂度降低到 O(n log n) 吗? 
// Related Topics 二分查找 动态规划 
// 👍 1072 👎 0


package leetcode.editor.leetcode_cn;

import java.util.Arrays;

//最长上升子序列
//提交时间 2020-10-12 16:42:49
class P300_LongestIncreasingSubsequence{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P300_LongestIncreasingSubsequence().new Solution();
		 System.out.println(solution.lengthOfLIS(new int[]{2,3,7,101}));
	 }
//力扣代码
	//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int lengthOfLIS(int[] nums) {
    	if (nums.length == 0) return 0;
    	int[] dp = new int[nums.length];
    	// 此处的base case的设置考虑：最坏情况下最短的子序列是他本身
		Arrays.fill(dp, 1);
		for (int i = 0; i < nums.length; i++) {
			// 遍历其之前的部分，如果有小于当前的数字存在，尝试将该数字加入到该子序列中
			// 如：若找到某数字num[j]小于nums[i]，找到num[j]对应的最短子序列长度dp[j]，将其加一
			for (int j = 0; j < i; j++){
				if (nums[j] < nums[i]){
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
		}
		// 遍历解空间，找到最大的一个
		int ans = Integer.MIN_VALUE;
		for (int value : dp) {
			ans = Math.max(ans, value);
		}
		return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}