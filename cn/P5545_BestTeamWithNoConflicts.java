//假设你是球队的经理。对于即将到来的锦标赛，你想组合一支总体得分最高的球队。球队的得分是球队中所有球员的分数 总和 。 
//
// 然而，球队中的矛盾会限制球员的发挥，所以必须选出一支 没有矛盾 的球队。如果一名年龄较小球员的分数 严格大于 一名年龄较大的球员，则存在矛盾。同龄球员之间
//不会发生矛盾。 
//
// 给你两个列表 scores 和 ages，其中每组 scores[i] 和 ages[i] 表示第 i 名球员的分数和年龄。请你返回 所有可能的无矛盾球队
//中得分最高那支的分数 。 
//
// 
//
// 示例 1： 
//
// 输入：scores = [1,3,5,10,15], ages = [1,2,3,4,5]
//输出：34
//解释：你可以选中所有球员。 
//
// 示例 2： 
//
// 输入：scores = [4,5,6,5], ages = [2,1,2,1]
//输出：16
//解释：最佳的选择是后 3 名球员。注意，你可以选中多个同龄球员。
// 
//
// 示例 3： 
//
// 输入：scores = [1,2,3,5], ages = [8,9,10,1]
//输出：6
//解释：最佳的选择是前 3 名球员。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= scores.length, ages.length <= 1000 
// scores.length == ages.length 
// 1 <= scores[i] <= 106 
// 1 <= ages[i] <= 1000 
// 
// Related Topics 动态规划 
// 👍 1 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

//无矛盾的最佳球队
//提交时间 2020-10-18 12:13:54
class P5545_BestTeamWithNoConflicts{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P5545_BestTeamWithNoConflicts().new Solution();
		 System.out.println(solution.bestTeamScore(new int[]{1,3,5,10,15}, new int[]{1,2,3,4,5}));
	 }
//力扣代码
	//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int bestTeamScore(int[] scores, int[] ages) {
		List<List<Integer>> grid = new ArrayList<>();
		int len = scores.length;
		for (int i = 0; i < len; i++){
			List<Integer> aPlayer = new ArrayList<>();
			aPlayer.add(0, ages[i]);
			aPlayer.add(1, scores[i]);
			grid.add(aPlayer);
		}

		grid.sort(new Comparator<List<Integer>>() {
			@Override
			public int compare(List<Integer> o1, List<Integer> o2) {
				return o1.get(0).equals(o2.get(0)) ? o1.get(1) - o2.get(1) : o1.get(0) - o2.get(0);
			}
		});
		int[] dp = new int[len];
		int ans = 0;
		for (int i = 0; i < len; i++) {
			int maxBenefit = 0;// 前j个的最高得分
			for (int j = i; j >= 0; j--){
				// 向前找 年龄比它小而且分数比他低的一个，由于已经排序，寻找应该比较块
				// dp[i]表示最后一个队员是第i个队员时的最大分数
				// 隐含的记忆化
				if (grid.get(j).get(0) <= grid.get(i).get(0) && grid.get(j).get(1) <= grid.get(i).get(1)){
					maxBenefit = Math.max(dp[j], maxBenefit);
				}
			}
			dp[i] = maxBenefit  + grid.get(i).get(1);
			ans = Math.max(dp[i], ans);
		}
		return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}