//给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。 
//
// 求在该柱状图中，能够勾勒出来的矩形的最大面积。 
//
// 
//
// 
//
// 以上是柱状图的示例，其中每个柱子的宽度为 1，给定的高度为 [2,1,5,6,2,3]。 
//
// 
//
// 
//
// 图中阴影部分为所能勾勒出的最大矩形面积，其面积为 10 个单位。 
//
// 
//
// 示例: 
//
// 输入: [2,1,5,6,2,3]
//输出: 10 
// Related Topics 栈 数组 
// 👍 943 👎 0


package leetcode.editor.cn;

import java.util.*;

//柱状图中最大的矩形
//提交时间 2020-10-09 10:53:21
class P84_LargestRectangleInHistogram{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P84_LargestRectangleInHistogram().new Solution();
		 int i = solution.largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3});
		 System.out.println(i);
	 }
//力扣代码
	//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int largestRectangleArea(int[] heights) {
		int n = heights.length;
		int[] left = new int[n];
		int[] right = new int[n];
		Arrays.fill(right, n);

		Deque<Integer> stack = new LinkedList<>();
		for (int i = 0; i < n; i++) {
			while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]){
				right[stack.peek()] = i;
				stack.pop();
			}
			left[i] = stack.isEmpty() ? -1 : stack.peek();
			stack.push(i);
		}
		int ans = 0;
		for (int i = 0; i < n; ++i) {
			ans = Math.max(ans, (right[i] - left[i] - 1) * heights[i]);
		}
		return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}