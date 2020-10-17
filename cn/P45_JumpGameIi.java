//给定一个非负整数数组，你最初位于数组的第一个位置。 
//
// 数组中的每个元素代表你在该位置可以跳跃的最大长度。 
//
// 你的目标是使用最少的跳跃次数到达数组的最后一个位置。 
//
// 示例: 
//
// 输入: [2,3,1,1,4]
//输出: 2
//解释: 跳到最后一个位置的最小跳跃数是 2。
//     从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
// 
//
// 说明: 
//
// 假设你总是可以到达数组的最后一个位置。 
// Related Topics 贪心算法 数组 
// 👍 727 👎 0


package leetcode.editor.cn;

//跳跃游戏 II
//提交时间 2020-10-16 09:52:54
class P45_JumpGameIi{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P45_JumpGameIi().new Solution();
		 System.out.println(solution.jump(new int[]{2,3,1,1,4}));
	 }
//力扣代码
	//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int jump(int[] nums) {
		// 每次到边界时，步数加一
		// 贪心：找到最优子问题
		// 对于每一个取到的数，确定它允许的最大跳转范围，再在该范围内找到跳转值最大的
		// 发现规律，遍历到的index == border时，必定可以触发一次跳转
		int border = 0;
		int maxIndex = 0;
		int ans = 0;
		for (int i = 0; i < nums.length; i++){
			maxIndex = Math.max(maxIndex, nums[i] + i);
			if (i == border){
				ans++;
				border = maxIndex;
			}
		}
		return ans - 1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}