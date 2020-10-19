//给出一个区间的集合，请合并所有重叠的区间。 
//
// 
//
// 示例 1: 
//
// 输入: intervals = [[1,3],[2,6],[8,10],[15,18]]
//输出: [[1,6],[8,10],[15,18]]
//解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
// 
//
// 示例 2: 
//
// 输入: intervals = [[1,4],[4,5]]
//输出: [[1,5]]
//解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。 
//
// 注意：输入类型已于2019年4月15日更改。 请重置默认代码定义以获取新方法签名。 
//
// 
//
// 提示： 
//
// 
// intervals[i][0] <= intervals[i][1] 
// 
// Related Topics 排序 数组 
// 👍 652 👎 0


package leetcode.editor.cn;

import java.util.*;

//合并区间
//提交时间 2020-10-18 09:40:57
class P56_MergeIntervals{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P56_MergeIntervals().new Solution();
		 System.out.println(Arrays.deepToString(solution.merge(new int[][]{
//				 {1,3}, {2,6}, {8,10}, {15,18}
				 {1,4},{0,0}
//				 {1,4},{0,2},{3,5}
//				 {1,4},{0,4},{2,4},
		 })));
	 }
//力扣代码
	//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] merge(int[][] intervals) {
		if(intervals.length == 0) return new int[][]{};
		if(intervals.length == 1) return intervals;
		Arrays.sort(intervals, (o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0]);
		List<int[]> list = new ArrayList<>();
		int currEnd = intervals[0][1];
		for (int i = 1; i < intervals.length ; i++) {
			if (currEnd >= intervals[i][0]){
				int preStart = intervals[i - 1][0];
				intervals[i-1][1] = -2;
				intervals[i-1][0] = -1;
				intervals[i][0] = Math.min(preStart, intervals[i][0] );
				currEnd = intervals[i][1];
			}
		}
		for (int[] interval : intervals) {
			if (interval[0] <= interval[1]){
				list.add(interval);
			}
		}
		int len = list.size();
		int[][] ans = new int[len][2];
		return list.toArray(ans);
    }
	public int maxLengthBetweenEqualCharacters(String s) {
		HashMap<Character, Integer> map = new HashMap<>();
		int size = s.length();
		int max = 0;
		for (int i = 0; i < size; i++){
			if (!map.containsKey(s.charAt(i))){
				map.put(s.charAt(i), i);
			}
			else{
				max = Math.max(max, i - map.get(s.charAt(i)));
			}
		}
		return max;
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}