import java.util.*;

public class MaximumSumofDistinctSubarraysWithLengthK {

  public static void main(String[] args) {
    int[] nums1 = {1,5,4,2,9,9,9};
    int[] nums2 = {1,1,1,7,8,9};
    int[] nums3 = {5,3,3,1,1};
    System.out.println(maximumSubarraySum(nums1, 3));
    System.out.println(maximumSubarraySum(nums2, 3));
    System.out.println(maximumSubarraySum(nums3, 3));
  }

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