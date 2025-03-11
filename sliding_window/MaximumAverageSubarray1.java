public class MaximumAverageSubarray1 {
    public double findMaxAverage(int[] nums, int k) {
        double max = Integer.MIN_VALUE;
        double cur = 0;
        for (int j = 0, i = 0; i < nums.length; i++) {
            cur += nums[i];
            if (i - j + 1 == k) {
                max = Math.max(max, cur / k);
                cur -= nums[j];
                j++;
            }
        }
        return max;
    }
}
