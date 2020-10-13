//给定一个只包含正整数的非空数组。是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。 
//
// 注意: 
//
// 
// 每个数组中的元素不会超过 100 
// 数组的大小不会超过 200 
// 
//
// 示例 1: 
//
// 输入: [1, 5, 11, 5]
//
//输出: true
//
//解释: 数组可以分割成 [1, 5, 5] 和 [11].
// 
//
// 
//
// 示例 2: 
//
// 输入: [1, 2, 3, 5]
//
//输出: false
//
//解释: 数组不能分割成两个元素和相等的子集.
// 
//
// 
// Related Topics 动态规划 
// 👍 492 👎 0


package leetcode.editor.cn;

//分割等和子集
//提交时间 2020-10-11 14:03:47
class P416_PartitionEqualSubsetSum{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P416_PartitionEqualSubsetSum().new Solution();
		 System.out.println(solution.canPartition(new int[]{1,5,11,5}));
	 }
//力扣代码
	//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
	private boolean sonsets(int[] nums, int sum) {
		int n = nums.length;
		boolean[][] dp = new boolean[n][sum + 1];
		// 初始化 当前背包容量为0 什么都不装是唯一的装法
		for (int i = 0; i < nums.length; i++) {
			dp[i][0] = true;
		}
		dp[0][nums[0]] = true;
		// "状态" 背包的容量 剩余可选择的物品 “选择” 装入背包/不装入背包
		// nums[i-1] 代表的是第 i 个物品的重量
		for (int i = 1; i < n; i++) {
			for (int j = 1; j <= sum; j++) {
				if (j >= nums[i]){
					// 若当前物品的重量小于背包大小
					// 意义；
					// 1. 若当前转入背包 dp[i-1][j-nums[i-1]] 那么只要看前 i - 1 个物品有几种方法可以装满 j - nums[i-1] 的重量就行了
					// 2. 当前不装入背包 dp[i-1][j]
					dp[i][j] = dp[i-1][j] | dp[i-1][j-nums[i]];
				}
				else{
					dp[i][j] = dp[i-1][j];
				}
			}
		}
		return dp[n - 1][sum];
	}
	public boolean canPartition(int[] nums) {
		if(nums.length < 2) return false;
		if(nums.length  == 2) {
			return nums[1] == nums[0];
		}
		int sum = 0;
		for(int num : nums){
			sum += num;
		}
		if(sum % 2 == 1 || sum == 0) return false;
		return sonsets(nums, sum / 2);
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}