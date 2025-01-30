import java.util.*;

public class ThreeSum {

  public static List<List<Integer>> threeSum(int[] nums) {
    List<List<Integer>> res = new ArrayList<>();
    Arrays.sort(nums);
    System.out.println(Arrays.toString(nums));
    for (int i = 0; i < nums.length; i++) {
      if (i != 0 && nums[i] == nums[i - 1]) {
        continue;
      }
      int j = i + 1;
      int k = nums.length - 1;
      while (j < k) {
        int sum = nums[i] + nums[j] + nums[k];
        if (sum < 0) {
          j++;
        } else if (sum > 0) {
          k--;
        } else {
          res.add(Arrays.asList(nums[i], nums[j], nums[k]));
          j++;
          while(nums[j] == nums[j - 1] && j < k){
            j++;
          }
        }
      }
    }
    return res;
  }
}
