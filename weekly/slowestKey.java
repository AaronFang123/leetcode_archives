package leetcode.editor.weekly;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class slowestKey {
    public static void main(String[] args) {
//        var b = new slowestKey().checkArithmeticSubarrays(new int[]{4,6,5,9,3,7}, new int[]{0,0,2}, new int[]{2,3,5});
//        System.out.println(b);
        int i = new slowestKey().minimumEffortPath(new int[][]{
                {1, 2, 2}, {3, 8, 2}, {5, 3, 5}
        });
        System.out.println(i);
    }

    public char slowestKey(int[] releaseTimes, String keysPressed) {
        int[] resultArray = new int[releaseTimes.length];
        resultArray[0] = releaseTimes[0];

        char charOfMaxFrequency = keysPressed.charAt(0);
        int maxFrequency = releaseTimes[0];
        for (int i = 1; i < resultArray.length; i++) {
            resultArray[i] = releaseTimes[i] - releaseTimes[i - 1];
            if (resultArray[i] == maxFrequency && keysPressed.charAt(i) > charOfMaxFrequency){
                charOfMaxFrequency = keysPressed.charAt(i);
            }
            if (resultArray[i] > maxFrequency){
                maxFrequency = resultArray[i];
                charOfMaxFrequency = keysPressed.charAt(i);
            }
        }
        return charOfMaxFrequency;
    }

    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        List<Boolean> ans = new ArrayList<>();
        for (int i = 0; i < l.length; i++){
            ans.add(checkSubArray(nums, l[i], r[i]));
        }
        return ans;
    }

    boolean checkSubArray(int[] nums, int left, int right) {
        int[] temp = Arrays.copyOfRange(nums, left, right+ 1);
        Arrays.sort(temp);
        int n_pre = temp[1] - temp[0];
        for (int i = 1; i < temp.length; i++){
            int n = temp[i] - temp[i - 1];
            if (n != n_pre) return false;
            n_pre = n;
        }
        return true;
    }

    public int minimumEffortPath(int[][] heights) {
        int width = heights.length;
        int length = heights[0].length;
        int base = heights[0][0];

        int[][] dp = new int[width ][width];
        // 初始化
        dp[0][0] = 0;
        for (int i = 1; i < length; i++){
            dp[0][i] = heights[0][i] >= base - dp[0][i - 1]
                    && heights[0][i] <= base + dp[0][i - 1]
                    ?  dp[0][i - 1] : Math.abs(heights[0][i]- base);
        }
        for (int j = 1; j < width; j++){
            dp[j][0] = heights[j][0] >= base - dp[j - 1][0]
                    && heights[j][0] <= base + dp[j - 1][0]
                    ? dp[j - 1][0] : Math.abs(heights[j][0] - base);
        }

        for (int i = 1; i < length; i++){
            for (int j = 1; j < width; j++){
                int left = heights[i][j] >= base - dp[i - 1][j]
                        && heights[i][j] <= base + dp[i - 1][j]
                        ? dp[i - 1][j] : Math.abs(heights[i][j] - base);
                int top = heights[i][j] >= base - dp[i][j - 1]
                        && heights[i][j] <= base + dp[i ][j - 1]
                        ? dp[i][j - 1] : Math.abs(heights[i][j] - base);
                dp[i][j] = Math.min(left, top);
            }
        }
        return dp[width - 1][length - 1];
    }
}
