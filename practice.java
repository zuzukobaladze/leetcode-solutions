
public class practice {

    public static void main(String[] args) {
        System.out.println(minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}));
    }

    public static int minSubArrayLen(int target, int[] nums) {
        int len = Integer.MAX_VALUE;
        int curSum = 0;
        for (int i = 0, j = 0; i < nums.length; i++) {
            curSum += nums[i];
            while (curSum >= target) {
                len = Math.min(i - j + 1, len);
                curSum -= nums[j];
                j++;
            }
        }
        return len == Integer.MAX_VALUE ? 0 : len;
    }
}
