import java.util.HashMap;

public class FruitIntoBaskets {

  public static int totalFruit(int[] fruits) {
    int maxSize = 0;
    HashMap<Integer, Integer> freq = new HashMap<>();
    for (int j = 0, i = 0; i < fruits.length; i++) {
      freq.merge(fruits[i], 1, Integer::sum);
      while (freq.size() > 2) {
        freq.merge(fruits[j], -1, Integer::sum);
        j++;
      }
      maxSize = Math.max(maxSize, i - j + 1);
    }
    return maxSize;
  }
}
