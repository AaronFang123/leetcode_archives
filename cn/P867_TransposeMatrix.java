//给定一个矩阵 A， 返回 A 的转置矩阵。 
//
// 矩阵的转置是指将矩阵的主对角线翻转，交换矩阵的行索引与列索引。 
//
// 
//
// 示例 1： 
//
// 输入：[[1,2,3],[4,5,6],[7,8,9]]
//输出：[[1,4,7],[2,5,8],[3,6,9]]
// 
//
// 示例 2： 
//
// 输入：[[1,2,3],[4,5,6]]
//输出：[[1,4],[2,5],[3,6]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= A.length <= 1000 
// 1 <= A[0].length <= 1000 
// 
// Related Topics 数组 
// 👍 113 👎 0


package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Deque;

//转置矩阵
//提交时间 2020-10-17 16:10:30
class P867_TransposeMatrix{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P867_TransposeMatrix().new Solution();
//		 System.out.println(solution.maxDepth("(1)+((2))+(((3)))"));
	 }
//力扣代码
	//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] transpose(int[][] A) {
		// step1 转置
		int row = A.length;
		int column = A[0].length;

		// 转置只需转一半
		for (int i = 0; i < row; i++) {
			for (int j = i; j < column; j++) {
				int temp = A[j][i];
				A[j][i] = A[i][j];
				A[i][j] = temp;
			}
		}
		return A;
	}

	public int maxDepth(String s) {
		int countMax = 0;
		Deque<Character> stack = new ArrayDeque<>();
		int lenOfString = s.length();
		// 若是左括号或右括号
		for (int i = 0; i < lenOfString; i++){
			if (s.charAt(i) == '('){
				stack.addLast(')');
				countMax = Math.max(countMax, stack.size());
			}
			else if(s.charAt(i) ==')' && !stack.isEmpty()){
				if (stack.peekLast() == ')'){

					stack.pop();
				}
			}
		}
		return countMax;
	}
	
}
//leetcode submit region end(Prohibit modification and deletion)

}