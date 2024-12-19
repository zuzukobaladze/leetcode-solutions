public class MinimumSizeSubarraySum {
  public static void main(String[] args) {
    int[] arr = {2, 1, 5, 2, 3, 2};
    int S = 7;
    System.out.println(minSubArrayLen(S, arr));
  }


  public static int minSubArrayLen(int target, int[] nums){
    int minSize = Integer.MAX_VALUE;
    int curSum = 0;
    for (int j = 0, i = 0; i < nums.length; i++) {
      curSum += nums[i];
      while (curSum >= target) {
        curSum -= nums[j];
        minSize = Math.min(minSize, i - j + 1);
        j++;
      }
    }
    return minSize == Integer.MAX_VALUE ? 0 : minSize;
  }
}