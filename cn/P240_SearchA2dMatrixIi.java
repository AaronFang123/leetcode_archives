//编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target。该矩阵具有以下特性： 
//
// 
// 每行的元素从左到右升序排列。 
// 每列的元素从上到下升序排列。 
// 
//
// 示例: 
//
// 现有矩阵 matrix 如下： 
//
// [
//  [1,   4,  7, 11, 15],
//  [2,   5,  8, 12, 19],
//  [3,   6,  9, 16, 22],
//  [10, 13, 14, 17, 24],
//  [18, 21, 23, 26, 30]
//]
// 
//
// 给定 target = 5，返回 true。 
//
// 给定 target = 20，返回 false。 
// Related Topics 二分查找 分治算法 
// 👍 458 👎 0


package leetcode.editor.cn;

//搜索二维矩阵 II
//提交时间 2020-10-21 15:11:09
class P240_SearchA2dMatrixIi{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P240_SearchA2dMatrixIi().new Solution();
		 System.out.println(solution.searchMatrix(new int[][]{
				 {1,4,7, 11, 15},
				 {2,5,8, 12, 19},
				 {3,6,9, 16, 22},
				 {10, 13, 14, 17, 24},
				 {18, 21, 23, 26, 30}
		 }, 20));
	 }
//力扣代码
	//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
	 	// 类比二叉搜索树，从右上角开始
    public boolean searchMatrix(int[][] matrix, int target) {
        int width = matrix.length;
        if (width == 0) return false;
        int length = matrix[0].length;
        int x = 0, y = length - 1;
        int root = matrix[x][y];
        while (true){
        	if (target < root){
        		// 往左子树走
				if (y - 1 < 0)  return false;
				root = matrix[x][--y];
				continue;
			}
        	if (target > root){
        		if (x + 1 > width - 1) return false;
        		root = matrix[++x][y];
        		continue;
			}
        	if (target == root) return true;
		}
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}