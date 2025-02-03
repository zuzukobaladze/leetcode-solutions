public class SquaresOfASortedArray {


  public static int[] sortedSquares(int[] nums) {
    int[] res = new int[nums.length];
    int i = 0, j = nums.length - 1;
    for (int k = nums.length - 1; k >= 0; k--) {
      int x = (int) Math.pow(nums[i], 2);
      int y = (int) Math.pow(nums[j], 2);
      if (x >= y) {
        res[k] = x;
        i++;
      }
      else {
        res[k] = y;
        j--;
      }
    }
    return res;
  }
}
