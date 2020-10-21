//给定一个经过编码的字符串，返回它解码后的字符串。 
//
// 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。 
//
// 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。 
//
// 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。 
//
// 
//
// 示例 1： 
//
// 输入：s = "3[a]2[bc]"
//输出："aaabcbc"
// 
//
// 示例 2： 
//
// 输入：s = "3[a2[c]]"
//输出："accaccacc"
// 
//
// 示例 3： 
//
// 输入：s = "2[abc]3[cd]ef"
//输出："abcabccdcdcdef"
// 
//
// 示例 4： 
//
// 输入：s = "abc3[cd]xyz"
//输出："abccdcdcdxyz"
// 
// Related Topics 栈 深度优先搜索 
// 👍 541 👎 0


package leetcode.editor.cn;

import java.util.Deque;
import java.util.LinkedList;

//字符串解码
//提交时间 2020-10-20 16:12:08
class P394_DecodeString{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P394_DecodeString().new Solution();
		 System.out.println(solution.decodeString("3[2[a3[bc]]]zzz"));
	 }
//力扣代码
	//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String decodeString(String s) {
		// 遍历 读取到数字：数字变成整数，并乘上倍数
		// [ ：入栈
		// ] ：出栈
		// 字母：拼接
		Deque<Integer> numStack = new LinkedList<>();
		Deque<StringBuilder> sbStack = new LinkedList<>();
		int num = 0;
		StringBuilder sb = new StringBuilder();
		for (char c : s.toCharArray()){
			// 遇到数字
			if (Character.isDigit(c)){
				num = num * 10 + c - '0'; // 处理倍率
			}
			else if (Character.isAlphabetic(c)){
				sb.append(c);
			}
			else if (c == '['){
				numStack.push(num);
				sbStack.push(sb);
				sb = new StringBuilder();
				num = 0;
			}
			else if (c == ']'){
				StringBuilder builder = sbStack.pop();
				int temp = numStack.pop();
				for (int i = 0; i < temp; i++){
					builder.append(sb);
				}
				sb = builder;
			}
		}
		return sb.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}