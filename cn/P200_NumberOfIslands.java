//给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。 
//
// 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。 
//
// 此外，你可以假设该网格的四条边均被水包围。 
//
// 
//
// 示例 1： 
//
// 
//输入：grid = [
//  ["1","1","1","1","0"],
//  ["1","1","0","1","0"],
//  ["1","1","0","0","0"],
//  ["0","0","0","0","0"]
//]
//输出：1
// 
//
// 示例 2： 
//
// 
//输入：grid = [
//  ["1","1","0","0","0"],
//  ["1","1","0","0","0"],
//  ["0","0","1","0","0"],
//  ["0","0","0","1","1"]
//]
//输出：3
// 
//
// 
//
// 提示： 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 300 
// grid[i][j] 的值为 '0' 或 '1' 
// 
// Related Topics 深度优先搜索 广度优先搜索 并查集 
// 👍 811 👎 0


package leetcode.editor.cn;

//岛屿数量
//提交时间 2020-10-17 14:42:40
class P200_NumberOfIslands {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P200_NumberOfIslands().new Solution();
        System.out.println(solution.numIslands(new char[][]{
                {'1','1','1','1','0'},
                {'1','1','0','0','0'},
                {'1','1','0','1','0'},
                {'0','0','0','0','0'}
        }));
    }

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private int row;
        private int column;
        private char[][] grid;
        public int numIslands(char[][] grid) {
            if (grid.length == 0) return 0;
            int ans = 0;
            this.grid = grid;
            this.row = grid.length;
            this.column = grid[0].length;
            boolean[][] visited = new boolean[row][column];
            for (int i = 0; i < row; ++i){
                for (int j = 0;j < column; ++j){
                    if (grid[i][j] =='1'){
                        if (dfs(i, j, visited))  ans++;
                    }
                }
            }
            return ans;
        }

        private boolean dfs(int x, int y, boolean[][] visited) {
            // 判断是否越界
            if (x < 0 || y < 0 || x >= row || y >= column || grid[x][y] == '0') return false;
            // 若已经访问过
            if (visited[x][y]) return false;

            visited[x][y] = true;
            // 核心
            dfs(x + 1, y, visited);
            dfs(x , y + 1, visited);
            dfs(x - 1, y, visited);
            dfs(x, y - 1, visited);

            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}