//我们把数组 A 中符合下列属性的任意连续子数组 B 称为 “山脉”： 
//
// 
// B.length >= 3 
// 存在 0 < i < B.length - 1 使得 B[0] < B[1] < ... B[i-1] < B[i] > B[i+1] > ... > B
//[B.length - 1] 
// 
//
// （注意：B 可以是 A 的任意子数组，包括整个数组 A。） 
//
// 给出一个整数数组 A，返回最长 “山脉” 的长度。 
//
// 如果不含有 “山脉” 则返回 0。 
//
// 
//
// 示例 1： 
//
// 输入：[2,1,4,7,3,2,5]
//输出：5
//解释：最长的 “山脉” 是 [1,4,7,3,2]，长度为 5。
// 
//
// 示例 2： 
//
// 输入：[2,2,2]
//输出：0
//解释：不含 “山脉”。
// 
//
// 
//
// 提示： 
//
// 
// 0 <= A.length <= 10000 
// 0 <= A[i] <= 10000 
// 
// Related Topics 双指针 
// 👍 98 👎 0


package leetcode.editor.cn;

import javax.swing.plaf.metal.MetalTheme;

//数组中的最长山脉
//提交时间 2020-10-25 09:49:31
class P845_LongestMountainInArray{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P845_LongestMountainInArray().new Solution();
		 System.out.println(solution.longestMountain(new int[]{2,1,4,7,3,2,5}));
	 }
//力扣代码
	//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int longestMountain(int[] A) {
		// 左右指针，先找到左边第一个递增，右边第一个递增
		int len = A.length;
		if (len < 3) {
			return 0;
		}
		// 动态规划
		// 如果i作为山顶，左/右两边有多少个符合条件
		int[] dp_r = new int[len];
		int[] dp_l = new int[len];

		for (int i = len - 1; i > 0 ; i--){
			if (A[i] < A[i - 1]) dp_r[i - 1] = dp_r[i] + 1;
		}
		for (int i = 1; i < len; i++){
			if (A[i] > A[i - 1]) dp_l[i] = dp_l[i - 1] + 1;
		}
		int max= 0;
		for (int i = 0 ;i < len; i++){
			if (dp_l[i] > 0 && dp_r[i] > 0) {
				max = Math.max(max, dp_l[i] + dp_r[i] + 1);
			}
		}
		return  max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}