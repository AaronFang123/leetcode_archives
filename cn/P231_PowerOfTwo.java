//给定一个整数，编写一个函数来判断它是否是 2 的幂次方。 
//
// 示例 1: 
//
// 输入: 1
//输出: true
//解释: 20 = 1 
//
// 示例 2: 
//
// 输入: 16
//输出: true
//解释: 24 = 16 
//
// 示例 3: 
//
// 输入: 218
//输出: false 
// Related Topics 位运算 数学 
// 👍 254 👎 0


package leetcode.editor.cn;

//2的幂
//提交时间 2020-10-13 17:38:39
class P231_PowerOfTwo{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P231_PowerOfTwo().new Solution();
	 }
//力扣代码
	//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
	public boolean isPowerOfTwo(int n) {
		if(n  <= 0) return false;
		int count = 0;
		while(n != 0){
			n = n & (n - 1);
			count++;
			if(count > 1) return false;
		}
		return true;
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}