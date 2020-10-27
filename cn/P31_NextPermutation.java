//实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。 
//
// 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。 
//
// 必须原地修改，只允许使用额外常数空间。 
//
// 以下是一些例子，输入位于左侧列，其相应输出位于右侧列。 
//1,2,3 → 1,3,2 
//3,2,1 → 1,2,3 
//1,1,5 → 1,5,1 
// Related Topics 数组 
// 👍 698 👎 0


package leetcode.editor.cn;

import java.util.Arrays;

//下一个排列
//提交时间 2020-10-21 16:32:19
class P31_NextPermutation{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P31_NextPermutation().new Solution();
	 	 int[] tc = new int[]{3,2,1};
 	 	 solution.nextPermutation(tc);
		 System.out.println(Arrays.toString(tc));
	 }
//力扣代码
	//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void nextPermutation(int[] nums) {
		// 下一个最大字典序
		int len = nums.length;
		// 找到两个连续的升序
		int i = len - 2;
		while (i >= 0 && nums[i] >= nums[i + 1]) i--;
		if (i >= 0){
			int j = len - 1;
			while (j >= 0 && nums[j] <= nums[i]) j--;
			// swap
			int temp = nums[j];
			nums[j] = nums[i];
			nums[i] = temp;
		}

		// reserve
		int start = i + 1, end = len - 1;
		while (start < end){
			int temp = nums[end];
			nums[end] = nums[start];
			nums[start] = temp;
			start++;
			end--;
		}
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}