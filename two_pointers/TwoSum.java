import java.util.HashMap;

class TwoSum {
    //Two Sum with HashMap
    public static int[] twoSumMap(int[] nums, int target) {
      HashMap<Integer, Integer> map = new HashMap<>();
      for (int i = 0; i < nums.length; i++) {
        map.put(nums[i], i);
      }
      for (int i = 0; i < nums.length; i++) {
        Integer j = map.get(target - nums[i]);
        if(j != null && j != i){
          return new int[]{i, j};
        }
      }
        return new int[]{};
    }
}