//n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。 
//
// 
//
// 上图为 8 皇后问题的一种解法。 
//
// 给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。 
//
// 每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。 
//
// 
//
// 示例： 
//
// 输入：4
//输出：[
// [".Q..",  // 解法 1
//  "...Q",
//  "Q...",
//  "..Q."],
//
// ["..Q.",  // 解法 2
//  "Q...",
//  "...Q",
//  ".Q.."]
//]
//解释: 4 皇后问题存在两个不同的解法。
// 
//
// 
//
// 提示： 
//
// 
// 皇后彼此不能相互攻击，也就是说：任何两个皇后都不能处于同一条横行、纵行或斜线上。 
// 
// Related Topics 回溯算法 
// 👍 635 👎 0


package leetcode.editor.cn;

import java.util.*;

//N 皇后
//提交时间 2020-10-17 09:58:37
class P51_NQueens {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P51_NQueens().new Solution();
		System.out.println(solution.solveNQueens(4));
//		System.out.println(Integer.valueOf("123 word"));
    }

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
    	// 用于记录某列，某主对角线，某副对角线是否放置过
        private boolean[] col;
        private boolean[] sub;
        private boolean[] main;
        private int n;
        private List<List<String>> res;

        public List<List<String>> solveNQueens(int n) {
			res = new ArrayList<>();
			if (n == 0) return res;
			this.n = n;
			this.col = new boolean[n];
			this.main = new boolean[2 * n - 1];
			this.sub = new boolean[2 * n - 1];

			Deque<Integer> path = new ArrayDeque<>();
			dfs(0, path);
			return res;
        }

		private void dfs(int row, Deque<Integer> path) {
			if (row == n){
				List<String> board = covert2Board(path);
				res.add(board);
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

		private List<String> covert2Board(Deque<Integer> path) {
			List<String> board = new ArrayList<>();
			for (Integer num : path) {
				StringBuilder row = new StringBuilder();
				row.append(".".repeat(Math.max(0, n)));
				row.replace(num, num + 1, "Q");
				board.add(row.toString());
			}
			return board;
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}