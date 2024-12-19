import java.util.HashMap;

public class FruitIntoBaskets {
  public static void main(String[] args) {
    int[] arr1 = {3,3,3,1,2,1,1,2,3,3,4};
    int[] arr2 = {0,1,6,6,4,4,6};
    System.out.println(totalFruit(arr1));
    System.out.println(totalFruit(arr2));
  }

  public static int totalFruit(int[] fruits) {
    int maxSize = 0;
    HashMap<Integer, Integer> freq = new HashMap<>();
    for (int j = 0, i = 0; i < fruits.length; i++) {
      freq.merge(fruits[i], 1, Integer::sum);
      while (freq.size() > 2) {
        freq.compute(fruits[j], (k, v) -> (v == 1) ? null : v - 1);
        j++;
      }
      maxSize = Math.max(maxSize, i - j + 1);
    }
    return maxSize;
  }
}
