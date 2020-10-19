//给定一个整数数组，你需要寻找一个连续的子数组，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。 
//
// 你找到的子数组应是最短的，请输出它的长度。 
//
// 示例 1: 
//
// 
//输入: [2, 6, 4, 8, 10, 9, 15]
//输出: 5
//解释: 你只需要对 [6, 4, 8, 10, 9] 进行升序排序，那么整个表都会变为升序排序。
// 
//
// 说明 : 
//
// 
// 输入的数组长度范围在 [1, 10,000]。 
// 输入的数组可能包含重复元素 ，所以升序的意思是<=。 
// 
// Related Topics 数组 
// 👍 419 👎 0


package leetcode.editor.cn;

//最短无序连续子数组
//提交时间 2020-10-19 10:33:08
class P581_ShortestUnsortedContinuousSubarray{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P581_ShortestUnsortedContinuousSubarray().new Solution();
		 System.out.println(solution.findUnsortedSubarray(new int[]{2, 6, 4, 8, 10, 9, 15}));
	 }
//力扣代码
	//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findUnsortedSubarray(int[] nums) {
		// 左区 右区 ：增
		// 中间 ：最小值大于左区最大值，最大值小于右区最小值
		// 关键：找到从两边开始找到最后一个逆序的下标(从前往后就是找最后一个非递增的，从后往前相反)
		int len =nums.length;
		int start = 0, end = 0;
		int max = nums[0], min = nums[len - 1];
		for (int i = 0;i < len; i++){
			if (max  <= nums[i]) max = nums[i];
			else end = i;

			if (min >= nums[len - 1 - i]) min = nums[len - 1 - i];
			else start = len - 1 - i;
		}
		return end - start + 1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}