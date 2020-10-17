//在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。 
//
// 示例 1: 
//
// 输入: [3,2,1,5,6,4] 和 k = 2
//输出: 5
// 
//
// 示例 2: 
//
// 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
//输出: 4 
//
// 说明: 
//
// 你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。 
// Related Topics 堆 分治算法 
// 👍 744 👎 0


package leetcode.editor.cn;

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

//数组中的第K个最大元素
//提交时间 2020-10-15 11:29:48
class P215_KthLargestElementInAnArray{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P215_KthLargestElementInAnArray().new Solution();
		 System.out.println(solution.findKthLargest(new int[]{3,2,3,1,2,4,5,5,6}, 4));
	 }
//力扣代码
	//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findKthLargest(int[] nums, int k) {
    	// 堆
		PriorityQueue<Integer> heap = new PriorityQueue<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o1.compareTo(o2);
			}
		});
		for (int i = 0;i < nums.length; i++){
			if (heap.size() < k){
				heap.add(nums[i]);
			}
			else if (heap.peek()  < nums[i]){
				heap.poll();
				heap.add(nums[i]);
			}
		}
		return heap.peek();
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}