//实现 pow(x, n) ，即计算 x 的 n 次幂函数。 
//
// 示例 1: 
//
// 输入: 2.00000, 10
//输出: 1024.00000
// 
//
// 示例 2: 
//
// 输入: 2.10000, 3
//输出: 9.26100
// 
//
// 示例 3: 
//
// 输入: 2.00000, -2
//输出: 0.25000
//解释: 2-2 = 1/22 = 1/4 = 0.25 
//
// 说明: 
//
// 
// -100.0 < x < 100.0 
// n 是 32 位有符号整数，其数值范围是 [−231, 231 − 1] 。 
// 
// Related Topics 数学 二分查找 
// 👍 522 👎 0


package leetcode.editor.cn;

//Pow(x, n)
//提交时间 2020-10-26 10:22:17
class P50_PowxN{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P50_PowxN().new Solution();
		 System.out.println(solution.myPow(2,9));
	 }
//力扣代码
	//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
	public double myPow(double x, int n){
		// x^n = x²^(n/2) 偶
		// x^n = x²^(n/2) x 奇
		long num = n;
		double ans = 1.0;
		if (num < 0){
			x = 1 / x;
			num = -num;
		}
		while (num > 0){
			if ((num & 1) == 1) ans = ans * x;
			x *= x;
			num >>= 1;
		}
		return ans;
	}

    public double myPow_r(double x, int n) {
		// 递
		if (n == 0) return 1f;
		if (n == 1) return x;
		if (n > 0)  return helper(x, n);
		return 1.0/helper(x, -n);
    }

    double helper(double x, int n){
    	// 退出条件
		if (n == 2) return x * x;
		if (n == 1) return x;
		if (n % 2 == 1) {
			double aHalf = helper(x , (n - 1) / 2);
			return aHalf * aHalf * x;
		}
		else{
			double aHalf = helper(x , n / 2);
			return aHalf * aHalf;
		}
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}