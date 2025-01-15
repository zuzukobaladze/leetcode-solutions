import java.util.*;

public class ConcatenatedWords {
  public static void main(String[] args) {
    
  }

  public List<String> findAllConcatenatedWordsInADict(String[] words) {
    HashMap<String, Integer> wordMap = new HashMap<>();
    for (String word : words) {
      wordMap.merge(word, 1, Integer::sum);
    }
    System.out.println(wordMap);
    return null;
  }
}
