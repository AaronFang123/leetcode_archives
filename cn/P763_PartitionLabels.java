//字符串 S 由小写字母组成。我们要把这个字符串划分为尽可能多的片段，同一个字母只会出现在其中的一个片段。返回一个表示每个字符串片段的长度的列表。 
//
// 
//
// 示例 1： 
//
// 输入：S = "ababcbacadefegdehijhklij"
//输出：[9,7,8]
//解释：
//划分结果为 "ababcbaca", "defegde", "hijhklij"。
//每个字母最多出现在一个片段中。
//像 "ababcbacadefegde", "hijhklij" 的划分是错误的，因为划分的片段数较少。
// 
//
// 
//
// 提示： 
//
// 
// S的长度在[1, 500]之间。 
// S只包含小写字母 'a' 到 'z' 。 
// 
// Related Topics 贪心算法 双指针 
// 👍 272 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//划分字母区间
//提交时间 2020-10-22 09:06:12
class P763_PartitionLabels{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P763_PartitionLabels().new Solution();
		 System.out.println(solution.partitionLabels("ababcbacadefegdehijhklij"));
	 }
//力扣代码
	//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
	/**
	 * ababcbaca de
	 * last[b] = 5;
	 * 区间 start end
	 * 维护一个数组，里面存放的是 <p>每个位置的字符最远能到达的位置</>
	 * 思路类似于leetcode45：跳跃游戏II
	 * @param S
	 * @return
	 */
	public List<Integer> partitionLabels(String S) {
		// map保存的是最远某字符能到达的最远下标
		HashMap<Character, Integer> map = new HashMap<>();
		List<Integer> ans = new ArrayList<>();
		int startIndex= 0;
		int len = S.length();
		for (int i = 0 ;i < len; i++){
			map.put(S.charAt(i), i);
		}
		int farthestIndex = 0;
		for (int i = 0; i < len; i++){
			int currFarthestIndex = map.get(S.charAt(i));
			farthestIndex = Math.max(currFarthestIndex, farthestIndex);
			if (i == farthestIndex){
				ans.add(i - startIndex + 1);
				startIndex = i + 1;
			}
		}
		return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}