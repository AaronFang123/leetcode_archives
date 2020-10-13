//假设你正在爬楼梯。需要 n 阶你才能到达楼顶。 
//
// 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？ 
//
// 注意：给定 n 是一个正整数。 
//
// 示例 1： 
//
// 输入： 2
//输出： 2
//解释： 有两种方法可以爬到楼顶。
//1.  1 阶 + 1 阶
//2.  2 阶 
//
// 示例 2： 
//
// 输入： 3
//输出： 3
//解释： 有三种方法可以爬到楼顶。
//1.  1 阶 + 1 阶 + 1 阶
//2.  1 阶 + 2 阶
//3.  2 阶 + 1 阶
// 
// Related Topics 动态规划 
// 👍 1269 👎 0


package leetcode.editor.leetcode_cn;

//爬楼梯
//提交时间 2020-10-09 15:11:24
class P70_ClimbingStairs{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P70_ClimbingStairs().new Solution();
		 System.out.println(solution.climbStairs(7));
	 }
//力扣代码
	//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
	int[] steps = {1,2};
	int result = 0;
	public int climbStairs(int n) {
		result = 0;
		dfs(n, 0);
		return result;
	}

	private void dfs(int target, int currSum){
		if(target == currSum) {
			result++;
			return;
		}
		for(int i = 0; i < 2; ++i){
			if(currSum + steps[i] > target) continue;
			dfs(target, currSum + steps[i]);
		}
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}