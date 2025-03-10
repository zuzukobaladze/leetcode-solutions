import java.util.HashMap;

public class FruitIntoBaskets {
  public static int totalFruit(int[] fruits) {
    int maxSize = 0;
    HashMap<Integer, Integer> freq = new HashMap<>();
    for (int j = 0, i = 0; i < fruits.length; i++) {
      freq.merge(fruits[i], 1, Integer::sum);
      while (freq.size() > 2) {
        freq.compute(fruits[j], (_, v) -> v == 1 ? null : v - 1);
        j++;
      }
      maxSize = Math.max(maxSize, i - j + 1);
    }
    return maxSize;
  }
}
