//一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。 
//
// 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。 
//
// 问总共有多少条不同的路径？ 
//
// 
//
// 例如，上图是一个7 x 3 的网格。有多少可能的路径？ 
//
// 
//
// 示例 1: 
//
// 输入: m = 3, n = 2
//输出: 3
//解释:
//从左上角开始，总共有 3 条路径可以到达右下角。
//1. 向右 -> 向右 -> 向下
//2. 向右 -> 向下 -> 向右
//3. 向下 -> 向右 -> 向右
// 
//
// 示例 2: 
//
// 输入: m = 7, n = 3
//输出: 28 
//
// 
//
// 提示： 
//
// 
// 1 <= m, n <= 100 
// 题目数据保证答案小于等于 2 * 10 ^ 9 
// 
// Related Topics 数组 动态规划 
// 👍 707 👎 0


package leetcode.editor.leetcode_cn;

//不同路径
//提交时间 2020-10-09 16:47:49
class P62_UniquePaths {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P62_UniquePaths().new Solution();
        System.out.println(solution.uniquePaths(3, 7));
    }

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 状态转移方程  dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
         * dp[i][j] 到达i行j列的不同路径数目
         * 由于只能向右下移动 股到达第0行和第0列的每个格子你都只有一种路径
         *
         * @param m 行
         * @param n 列
         * @return 路径数量合计
         */
        public int uniquePaths(int m, int n){
            int[][] routes = new int[m][n];
//            for (int i = 0; i < n; i++) {
//                routes[0][i] = 1;
//            }
//            for (int i = 0; i < m; i++) {
//                routes[i][0] = 1;
//            }
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (j == 0|| i == 0){
                        routes[i][j] = 1;
                        continue;
                    }
                    routes[i][j] = routes[i - 1][j] + routes[i][j - 1];
                }
            }
            return routes[m-1][n-1];
        }


        int count = 0;

        public int uniquePaths_recursion(int m, int n) {
            boolean[][] visited = new boolean[m + 1][n + 1];
            uniquePathHelper(1, 1, m, n, visited);
            return count;
        }

        private void uniquePathHelper(int x, int y, int x_target, int y_target, boolean[][] visited) {
            if (x == x_target && y == y_target) {
                count++;
                return;
            }
            if (!isInArea(x, y, x_target, y_target) || visited[x][y]) return;
            visited[x][y] = true;
            uniquePathHelper(x + 1, y, x_target, y_target, visited);
            uniquePathHelper(x, y + 1, x_target, y_target, visited);
            visited[x][y] = false;
        }

        private boolean isInArea(int rowActual, int columActual, int rowMax, int columMax) {
            return rowActual <= rowMax && rowActual >= 0 && columActual <= columMax && columActual >= 0;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}