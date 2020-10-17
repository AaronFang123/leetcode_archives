//给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。 
//
// 你可以假设数组是非空的，并且给定的数组总是存在多数元素。 
//
// 
//
// 示例 1: 
//
// 输入: [3,2,3]
//输出: 3 
//
// 示例 2: 
//
// 输入: [2,2,1,1,1,2,2]
//输出: 2
// 
// Related Topics 位运算 数组 分治算法 
// 👍 765 👎 0


package leetcode.editor.cn;

import java.util.Arrays;

//多数元素
//提交时间 2020-10-14 17:02:40
class P169_MajorityElement{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P169_MajorityElement().new Solution();
		 System.out.println(solution.majorityElement(new int[]{2,2,1,1,1,2,2}));

		 String s1 = new String("1");
		 String intern = s1.intern();
		 int i = intern.hashCode();
//		 Object o = new Object();
//		 o.hashCode();
	 }
//力扣代码
	//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int majorityElement(int[] nums) {
    	Arrays.sort(nums);
    	return nums[(int) nums.length / 2];

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}