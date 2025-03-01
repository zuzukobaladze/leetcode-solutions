
public class MinimumSizeSubarraySum {

    public static int minSubArrayLen(int target, int[] nums) {
        int minSize = Integer.MAX_VALUE;
        int curSum = 0;
        for (int j = 0, i = 0; i < nums.length; i++) {
            curSum += nums[i];
            while (curSum >= target) {
                minSize = Math.min(minSize, i - j + 1);
                curSum -= nums[j];
                j++;
            }
        }
        return minSize == Integer.MAX_VALUE ? 0 : minSize;
    }
}
