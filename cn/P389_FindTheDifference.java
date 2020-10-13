//给定两个字符串 s 和 t，它们只包含小写字母。 
//
// 字符串 t 由字符串 s 随机重排，然后在随机位置添加一个字母。 
//
// 请找出在 t 中被添加的字母。 
//
// 
//
// 示例 1： 
//
// 输入：s = "abcd", t = "abcde"
//输出："e"
//解释：'e' 是那个被添加的字母。
// 
//
// 示例 2： 
//
// 输入：s = "", t = "y"
//输出："y"
// 
//
// 示例 3： 
//
// 输入：s = "a", t = "aa"
//输出："a"
// 
//
// 示例 4： 
//
// 输入：s = "ae", t = "aea"
//输出："a"
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 1000 
// t.length == s.length + 1 
// s 和 t 只包含小写字母 
// 
// Related Topics 位运算 哈希表 
// 👍 158 👎 0


package leetcode.editor.cn;

//找不同
//提交时间 2020-10-13 17:43:28
class P389_FindTheDifference {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P389_FindTheDifference().new Solution();
        System.out.println(solution.findTheDifference("aa", "aat"));
    }

    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public char findTheDifference(String s, String t) {
            char ans = t.charAt(t.length()-1);
            for (int i = 0; i < s.length(); i++) {
                ans ^= s.charAt(i);
                ans ^= t.charAt(i);
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}