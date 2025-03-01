import java.util.*;

public class MaximumSumofDistinctSubarraysWithLengthK {

  public static long maximumSubarraySum(int[] nums, int k) {
    long max = 0;
    long cur = 0;
    Set<Integer> distinct = new HashSet<>();
    for (int j = 0, i = 0; i < nums.length; i++) {
      cur += nums[i];
      while (!distinct.add(nums[i])) {
        cur -= nums[j];
        distinct.remove(nums[j]);
        j++;
      }
      if (i - j + 1 == k) {
        max = Math.max(max, cur);
        cur -= nums[j];
        distinct.remove(nums[j]);
        j++;
      }
    }
    return max;
  }
}