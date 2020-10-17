//n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。 
//
// 
//
// 上图为 8 皇后问题的一种解法。 
//
// 给定一个整数 n，返回 n 皇后不同的解决方案的数量。 
//
// 示例: 
//
// 输入: 4
//输出: 2
//解释: 4 皇后问题存在如下两个不同的解法。
//[
// [".Q..",  // 解法 1
//  "...Q",
//  "Q...",
//  "..Q."],
//
// ["..Q.",  // 解法 2
//  "Q...",
//  "...Q",
//  ".Q.."]
//]
// 
//
// 
//
// 提示： 
//
// 
// 皇后，是国际象棋中的棋子，意味着国王的妻子。皇后只做一件事，那就是“吃子”。当她遇见可以吃的棋子时，就迅速冲上去吃掉棋子。当然，她横、竖、斜都可走一或 N
//-1 步，可进可退。（引用自 百度百科 - 皇后 ） 
// 
// Related Topics 回溯算法 
// 👍 170 👎 0


package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

//N皇后 II
//提交时间 2020-10-17 11:49:04
class P52_NQueensIi{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P52_NQueensIi().new Solution();
		 System.out.println(solution.totalNQueens(4));
	 }
//力扣代码
	//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
	private boolean[] col;
	private boolean[] sub;
	private boolean[] main;
	private int n;
	private int count;
    public int totalNQueens(int n) {
		this.n = n;
		this.count = 0;
		this.col = new boolean[n];
		this.main = new boolean[2 * n - 1];
		this.sub = new boolean[2 * n - 1];
		Deque<Integer> path = new ArrayDeque<>();
		dfs(0, path);
		return count;
    }

	private void dfs(int row, Deque<Integer> path) {
		if (row == n){
			count++;
			return;
		}
		for (int j = 0; j < n; j++){
			if (!col[j] && !sub[row + j] && !main[row - j + n - 1]){
				path.addLast(j);
				col[j] = true;
				sub[row + j] = true;
				main[row - j + n - 1] = true;

				dfs(row + 1, path);

				main[row - j + n - 1] = false;
				sub[row + j] = false;
				col[j] = false;
				path.removeLast();
			}
		}
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}