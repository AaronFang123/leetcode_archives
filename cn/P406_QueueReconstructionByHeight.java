//假设有打乱顺序的一群人站成一个队列。 每个人由一个整数对(h, k)表示，其中h是这个人的身高，k是排在这个人前面且身高大于或等于h的人数。 编写一个算法来
//重建这个队列。 
//
// 注意： 
//总人数少于1100人。 
//
// 示例 
//
// 
//输入:
//[[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
//
//输出:
//[[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
// 
// Related Topics 贪心算法 
// 👍 508 👎 0


package leetcode.editor.cn;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

//根据身高重建队列
//提交时间 2020-10-16 15:35:59
class P406_QueueReconstructionByHeight{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P406_QueueReconstructionByHeight().new Solution();
		 System.out.println(Arrays.deepToString(solution.reconstructQueue(new int[][]{

		 })));
	 }
//力扣代码
	//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] reconstructQueue(int[][] people) {
		Arrays.sort(people, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				// 身高降序排，序号升序排
				return o1[0] != o2[0] ? o2[0] - o1[0] : o1[1] - o2[1];
			}
		});

		// 高个对矮个视而不见
		List<int[]> list = new LinkedList<>();
		for (int[] person : people) {
			list.add(person[1], person);
		}

		return list.toArray(new int[people.length][2]);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}