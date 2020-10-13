//给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。 
//
// 
//
// 示例 1: 
//
// 输入: [2,3,-2,4]
//输出: 6
//解释: 子数组 [2,3] 有最大乘积 6。
// 
//
// 示例 2: 
//
// 输入: [-2,0,-1]
//输出: 0
//解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。 
// Related Topics 数组 动态规划 
// 👍 791 👎 0


package leetcode.editor.leetcode_cn;

//乘积最大子数组
//提交时间 2020-10-12 09:51:01
class P152_MaximumProductSubarray{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P152_MaximumProductSubarray().new Solution();
		 System.out.println(solution.maxProduct(new int[]{-2}));
	 }
//力扣代码
	//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxProduct(int[] nums) {
		int len = nums.length;
//		int[] maxDp = new int[len];
//		int[] minDp = new int[len];

		// 状态转移方程
		// maxDp[i] = max{maxDp[i-1] * nums[i], nums[i], minDp[i-1]* nums[i]}
		// minDp[i] = min{min[i-1] * nums[i], nums[i], maxDp[i-1]* nums[i]}
		// ans = max{maxDp[i]}

		int maxDpi = nums[0];
		int minDpi = nums[0];
		int result = nums[0];
		for (int i= 1; i < len; i++) {
//			if (i == 0) {
//				maxDp[i] = nums[0];
//				minDp[i] = nums[0];
//				continue;
//			}
			int temp_max = maxDpi, temp_min = minDpi;
			maxDpi = Math.max(temp_max * nums[i], Math.max(nums[i], temp_min * nums[i]));
			minDpi = Math.min(temp_min * nums[i], Math.min(nums[i], temp_max * nums[i]));
			result = Math.max(maxDpi, result);

		}

//		int result = Integer.MIN_VALUE;
//		for (int item : maxDp) {
//			result = Math.max(result, item);
//		}
		return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}