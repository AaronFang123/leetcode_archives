//给定一个非负整数数组，你最初位于数组的第一个位置。 
//
// 数组中的每个元素代表你在该位置可以跳跃的最大长度。 
//
// 判断你是否能够到达最后一个位置。 
//
// 示例 1: 
//
// 输入: [2,3,1,1,4]
//输出: true
//解释: 我们可以先跳 1 步，从位置 0 到达 位置 1, 然后再从位置 1 跳 3 步到达最后一个位置。
// 
//
// 示例 2: 
//
// 输入: [3,2,1,0,4]
//输出: false
//解释: 无论怎样，你总会到达索引为 3 的位置。但该位置的最大跳跃长度是 0 ， 所以你永远不可能到达最后一个位置。
// 
// Related Topics 贪心算法 数组 
// 👍 872 👎 0


package leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashMap;

//跳跃游戏
//提交时间 2020-10-15 16:23:13
class P55_JumpGame{
	 public static void main(String[] args) {
	 	 int[] test = new int[10000];
		 Arrays.fill(test, 1);
	 	 //测试代码
	 	 Solution solution = new P55_JumpGame().new Solution();
		 System.out.println(solution.canJump(test));
	 }
//力扣代码
	//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
	 	// 贪心
	public boolean canJump(int[] nums) {
		// 实时维护最远可以到达的距离，一旦末尾的包含在内，返回true
		int maxIndexCanReach = 0;
		for (int i = 0; i < nums.length; i++){
			// 当前遍历到的这个位置必须位于可访问到的范围内
			if (i <= maxIndexCanReach){
				maxIndexCanReach = Math.max(maxIndexCanReach, nums[i] + i);
				if (maxIndexCanReach >= nums.length - 1) return true;
			}

		}
		return false;
	}
	 	// 递归 + 备忘录
	HashMap<Integer, Boolean> map;
    public boolean canJump_backtrace(int[] nums) {
    	map = new HashMap<>();
		return canJumpHelper(nums, nums.length - 1) ;
	}

    private boolean canJumpHelper(int[] nums, int i){
    	if (map.containsKey(i)) return map.get(i);
    	if (i == 0) return true;
    	boolean res = false;
    	for (int j = 0; j < i; j++){
			res |= canJumpHelper(nums, j) && i - j <= nums[j];
		}
    	map.put(i, res);
    	return res;
	}

}
//leetcode submit region end(Prohibit modification and deletion)

}