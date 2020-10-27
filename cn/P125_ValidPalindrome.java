//给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。 
//
// 说明：本题中，我们将空字符串定义为有效的回文串。 
//
// 示例 1: 
//
// 输入: "A man, a plan, a canal: Panama"
//输出: true
// 
//
// 示例 2: 
//
// 输入: "race a car"
//输出: false
// 
// Related Topics 双指针 字符串 
// 👍 284 👎 0


package leetcode.editor.cn;

//验证回文串
//提交时间 2020-10-21 14:38:02
class P125_ValidPalindrome{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P125_ValidPalindrome().new Solution();
		 System.out.println(solution.isPalindrome("0p"));
	 }
//力扣代码
	//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
	public boolean isPalindrome(String s) {
		s = s.toLowerCase();
		StringBuilder sb = new StringBuilder();
		for(char c : s.toCharArray()) {
			if (Character.isAlphabetic(c) || Character.isDigit(c)) sb.append(c);
		}
		s = sb.toString();
		int len = s.length();
		int mid = len / 2;
		if(len % 2 == 0){
			for(int i = 1; i <= mid; i++){
				if(s.charAt(mid - i) != s.charAt(mid + i - 1)) return false;
			}
		}
		if(len % 2 == 1){
			for(int i = 1; i <= mid; i++){
				if(s.charAt(mid - i ) != s.charAt(mid + i)) {
					System.out.println(i);
					return false;
				}
			}
		}
		return true;
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}