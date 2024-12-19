public class MaximumSumofSubarraysWithLengthK {
  public static void main(String[] args) {
    int[] nums = {1,5,4,2,9,9,9};
    System.out.println(maxSubArrayK(nums, 3));
  }

  public static int maxSubArrayK(int[] nums, int k){
      int max = Integer.MIN_VALUE;
      int cur = 0;
      for (int j = 0, i = 0; i < nums.length; i++) {
        cur += nums[i];
        if (i - j + 1 == k) {
          max = Math.max(max, cur);
          cur -= nums[j];
          j++;
        }
      }
      return max;
  }
}