//两个整数之间的汉明距离指的是这两个数字对应二进制位不同的位置的数目。 
//
// 给出两个整数 x 和 y，计算它们之间的汉明距离。 
//
// 注意： 
//0 ≤ x, y < 231. 
//
// 示例: 
//
// 
//输入: x = 1, y = 4
//
//输出: 2
//
//解释:
//1   (0 0 0 1)
//4   (0 1 0 0)
//       ↑   ↑
//
//上面的箭头指出了对应二进制位不同的位置。
// 
// Related Topics 位运算 
// 👍 337 👎 0


package leetcode.editor.cn;

//汉明距离
//提交时间 2020-10-12 17:09:39
class P461_HammingDistance{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P461_HammingDistance().new Solution();
		 System.out.println(solution.hammingDistance(1,4));
	 }
//力扣代码
	//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int hammingDistance(int x, int y) {
    	// 消除二进制数的最后一个“1”   n & (n - 1)
		int ans = 0;
		int temp = x ^ y;
		while (temp != 0){
			temp = temp & (temp - 1);
			ans++;
		}
		return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}