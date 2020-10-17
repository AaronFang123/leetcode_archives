//给定仅有小写字母组成的字符串数组 A，返回列表中的每个字符串中都显示的全部字符（包括重复字符）组成的列表。例如，如果一个字符在每个字符串中出现 3 次，但不
//是 4 次，则需要在最终答案中包含该字符 3 次。 
//
// 你可以按任意顺序返回答案。 
//
// 
//
// 示例 1： 
//
// 输入：["bella","label","roller"]
//输出：["e","l","l"]
// 
//
// 示例 2： 
//
// 输入：["cool","lock","cook"]
//输出：["c","o"]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= A.length <= 100 
// 1 <= A[i].length <= 100 
// A[i][j] 是小写字母 
// 
// Related Topics 数组 哈希表 
// 👍 118 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

//查找常用字符
//提交时间 2020-10-14 09:12:38
class P1002_FindCommonCharacters{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P1002_FindCommonCharacters().new Solution();
		 List<String> strings = solution.commonChars(new String[]{"bella", "label", "roller"});
		 System.out.println(Arrays.toString(strings.toArray()));
	 }
//力扣代码
	//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<String> commonChars(String[] A) {
    	int strNum = A.length;
    	if (strNum == 0) return new ArrayList<>();
		HashMap<Character, Integer> hashMap = new HashMap<>();
		// 遍历所有单词
		String firstStr = A[0];
		for (int i = 0; i < A[0].length(); i++) {
			hashMap.put(firstStr.charAt(i), hashMap.getOrDefault(firstStr.charAt(i), 0)+ 1);
		}
		for (int i = 1; i < A.length; i++) {
			HashMap<Character, Integer> hashMap2 = new HashMap<>();
			String thisStr = A[i];
			for(Character c : thisStr.toCharArray()){
				if (hashMap.containsKey(c)){
					hashMap2.put(c, Math.min(hashMap.get(c), hashMap2.getOrDefault(c,0) + 1));
				}
			}
			hashMap = hashMap2;
		}
		// 处理，出现次数
		List<String> ans = new ArrayList<>();
		for (Character c : hashMap.keySet()){
		int occurTimes = hashMap.get(c);
			for (int i = 0; i < occurTimes; i++) {
				ans.add(String.valueOf(c));
			}
		}
		return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}