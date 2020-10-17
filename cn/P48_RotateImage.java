//给定一个 n × n 的二维矩阵表示一个图像。 
//
// 将图像顺时针旋转 90 度。 
//
// 说明： 
//
// 你必须在原地旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要使用另一个矩阵来旋转图像。 
//
// 示例 1: 
//
// 给定 matrix = 
//[
//  [1,2,3],
//  [4,5,6],
//  [7,8,9]
//],
//
//原地旋转输入矩阵，使其变为:
//[
//  [7,4,1],
//  [8,5,2],
//  [9,6,3]
//]
// 
//
// 示例 2: 
//
// 给定 matrix =
//[
//  [ 5, 1, 9,11],
//  [ 2, 4, 8,10],
//  [13, 3, 6, 7],
//  [15,14,12,16]
//], 
//
//原地旋转输入矩阵，使其变为:
//[
//  [15,13, 2, 5],
//  [14, 3, 4, 1],
//  [12, 6, 8, 9],
//  [16, 7,10,11]
//]
// 
// Related Topics 数组 
// 👍 604 👎 0


package leetcode.editor.cn;

import java.util.Arrays;

//旋转图像
//提交时间 2020-10-17 15:46:45
class P48_RotateImage{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P48_RotateImage().new Solution();
	 }
//力扣代码
	//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void rotate(int[][] matrix) {
		// step1 转置
		int row = matrix.length;
		int column = matrix[0].length;

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				matrix[i][j] = matrix[i][j] ^ matrix[j][i];
				matrix[j][i] = matrix[i][j] ^ matrix[j][i];
				matrix[i][j] = matrix[i][j] ^ matrix[j][i];
			}
		}

		// step2 镜像
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column / 2; j++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[row - i - 1][j];
				matrix[row - i - 1][j] = temp;
			}
		}
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}