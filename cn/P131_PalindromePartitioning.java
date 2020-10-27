//给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。 
//
// 返回 s 所有可能的分割方案。 
//
// 示例: 
//
// 输入: "aab"
//输出:
//[
//  ["aa","b"],
//  ["a","a","b"]
//] 
// Related Topics 回溯算法 
// 👍 405 👎 0


package leetcode.editor.cn;

import java.util.*;

//分割回文串
//提交时间 2020-10-26 09:57:39
class P131_PalindromePartitioning{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P131_PalindromePartitioning().new Solution();
		 System.out.println(solution.partition("aabaa"));
	 }
//力扣代码
	//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<String>> partition(String s) {
    	// 回溯
		List<List<String>> ans = new ArrayList<>();
		Deque<String> stack = new LinkedList<>();
		dfs(s, 0, s.length(), stack, ans);
		return ans;
    }

    void dfs(String target, int start, int len, Deque<String> stack, List<List<String>> ans){
		// 退出条件
		if (start == len){
			ArrayList<String> strings = new ArrayList<>(stack);
			Collections.reverse(strings);
			ans.add(new ArrayList<>(stack));
			return;
		}
		// 遍历分支
		for (int i = start; i < len; i++){
			// 剪枝，截出来的不是回文
			if (!checkPalindrome(start, i, target)){
				continue;
			}
			// 往下递归
			stack.push(target.substring(start, i + 1));
			dfs(target, i + 1, len, stack, ans);
			stack.pop();
		}
	}

	private boolean checkPalindrome(int start, int end, String target) {
		while (start < end){
			if (target.charAt(start) != target.charAt(end)) return false;
			start++;
			end--;
		}
		return true;
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}