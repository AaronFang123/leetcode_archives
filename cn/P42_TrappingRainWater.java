//给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。 
//
// 
//
// 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 感谢 Mar
//cos 贡献此图。 
//
// 示例: 
//
// 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
//输出: 6 
// Related Topics 栈 数组 双指针 
// 👍 1745 👎 0


package leetcode.editor.cn;

import java.util.Deque;
import java.util.LinkedList;

//接雨水
//提交时间 2020-10-15 09:28:17
class P42_TrappingRainWater{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P42_TrappingRainWater().new Solution();
		 System.out.println(solution.trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
	 }
//力扣代码
	//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int trap(int[] height) {
		// 接雨水 最小栈
		Deque<Integer> stack = new LinkedList<>();
		int ans = 0;
		for (int i = 0; i < height.length; i++){
			while(!stack.isEmpty() && height[i] > height[stack.peek()]){
				int temp = stack.pop();
				if (stack.isEmpty())  break;
				int w = i - stack.peek() - 1;
				int h =Math.min(height[stack.peek()], height[i]) - height[temp] ;
				ans += w * h;
			}
			stack.push(i);
		}
		return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}