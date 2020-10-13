//给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。 
//
// 示例: 
//
// 输入: [-2,1,-3,4,-1,2,1,-5,4]
//输出: 6
//解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
// 
//
// 进阶: 
//
// 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。 
// Related Topics 数组 分治算法 动态规划 
// 👍 2505 👎 0


package leetcode.editor.cn;

//最大子序和
//提交时间 2020-10-09 15:00:44
class P53_MaximumSubarray{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P53_MaximumSubarray().new Solution();
		 int i = solution.maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4});
		 System.out.println(i);
	 }
//力扣代码
	//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
	/**
	 * f(i)： 以nums[i]结尾的连续子数组的最大和
	 *
	 * 分支法核心状态转移方程：f(i) = max{f(i-1) + num[i] , num[i]}
	 * 以nums[i]是直接接上上一个结尾，导致出现减小的状况，则另起一行
	 * @param nums input
	 * @return sum of maxSubArray
	 */
	public int maxSubArray(int[] nums) {
		int subArraySum = 0;
		int maximum = nums[0];
		for (int num : nums) {
			subArraySum = Math.max(subArraySum + num, num);
			maximum = Math.max(subArraySum, maximum);
		}
		return maximum;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}