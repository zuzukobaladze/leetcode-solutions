
import java.util.Arrays;

public class SquaresOfASortedArray {
  public static void main(String[] args) {
    int[] res1 = sortedSquares(new int[] { -12, -6, -4, -1, 2, 3, 5, 7, 8, 10 });
    int[] res2 = sortedSquares(new int[] {0, 3, 5, 7, 8 });
    System.out.println(Arrays.toString(res1));
    System.out.println(Arrays.toString(res2));
  }

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
