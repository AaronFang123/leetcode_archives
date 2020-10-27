//求 1+2+...+n ，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。 
//
// 
//
// 示例 1： 
//
// 输入: n = 3
//输出: 6
// 
//
// 示例 2： 
//
// 输入: n = 9
//输出: 45
// 
//
// 
//
// 限制： 
//
// 
// 1 <= n <= 10000 
// 
// 👍 219 👎 0


package leetcode.editor.cn;

//求1+2+…+n
//提交时间 2020-10-22 09:57:49
class P_Offer_64_Qiu12nLcof{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P_Offer_64_Qiu12nLcof().new Solution();
		 System.out.println(solution.sumNums(10));
	 }
//力扣代码
	//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int sumNums(int n) {
		return sumHelper(n);
    }

	private int sumHelper(int n) {
		if (n == 0) return 0;
		return n + sumNums(n - 1);
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}