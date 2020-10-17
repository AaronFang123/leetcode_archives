//给定一个非空的整数数组，返回其中出现频率前 k 高的元素。 
//
// 
//
// 示例 1: 
//
// 输入: nums = [1,1,1,2,2,3], k = 2
//输出: [1,2]
// 
//
// 示例 2: 
//
// 输入: nums = [1], k = 1
//输出: [1] 
//
// 
//
// 提示： 
//
// 
// 你可以假设给定的 k 总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。 
// 你的算法的时间复杂度必须优于 O(n log n) , n 是数组的大小。 
// 题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的。 
// 你可以按任意顺序返回答案。 
// 
// Related Topics 堆 哈希表 
// 👍 546 👎 0


package leetcode.editor.cn;

import java.util.*;

//前 K 个高频元素
//提交时间 2020-10-15 10:52:52
class P347_TopKFrequentElements{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P347_TopKFrequentElements().new Solution();
		 System.out.println(Arrays.toString(solution.topKFrequent(new int[]{1,1,1,2,2,2,3,3,3}, 3)));
	 }
//力扣代码
	//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
		// 建立出现词频的映射
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int num : nums){
			map.put(num, map.getOrDefault(num, 0) + 1);
		}
		// Java中堆的实现
		// 指定排序依据，出现次数少的在前（小根堆）
		PriorityQueue<Integer> heap = new PriorityQueue<>((o1, o2) -> map.get(o1) - map.get(o2));

//		map.keySet().forEach((key) -> {
//			if (heap.size() < k){
//				heap.add(key);
//			}
//			else if(map.get(key) > map.get(heap.peek())){
//				heap.remove();
//				heap.add(key);
//			}
//		});
		for (Integer key : map.keySet()){
			if (heap.size() < k){
				heap.add(key);
			}
			else if(map.get(key) > map.get(heap.peek())){
				heap.remove();
				heap.add(key);
			}
		}


		int[] ans = new int[heap.size()];
		int index = 0;
		while ((!heap.isEmpty())){
			ans[index++] = heap.remove();
		}
		int size = heap.size();
		for (int i = 0; i < size; i++){
			ans[i] = heap.poll();
		}

		return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}