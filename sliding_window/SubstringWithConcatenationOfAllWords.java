import java.util.*;

public class SubstringWithConcatenationOfAllWords {
  public static void main(String[] args) {
    String s = "barfoofoobarthefoobarman";
    String[] words = { "bar", "foo", "the" };
    System.out.println(findSubstring(s, words));
  }

  public static List<Integer> findSubstring(String s, String[] words) {
    ArrayList<Integer> indices = new ArrayList<>(); // Result array
    HashMap<String, Integer> wordMap = new HashMap<>(); // Map of words
    HashMap<String, Integer> wordsSeen = new HashMap<>(); // Map of current words in loop
    int wordLength = words[0].length(); // Length of each word in words

    for (String word : words) { // Add words as map
      wordMap.merge(word, 1, Integer::sum);
    }

    for (int i = 0, j = 0; i < s.length() - wordLength;) {
      String curWord = s.substring(i, i + wordLength); // Get current word
      wordsSeen.merge(curWord, 1, Integer::sum); // Add current words as seen in map

      if (!wordMap.containsKey(curWord) || wordsSeen.get(curWord) != wordMap.get(curWord)) { // If current word does not appear or we dont have same amount in maps
        wordsSeen.clear(); // Clear current map
        j = i + 1; // Jump to next word's start index
        i++;
      } else {
        i += wordLength;
      }

      if (i - j + 1 == wordLength * words.length) { // Check if we have needed length of conc. words
        indices.add(j);
        wordsSeen.clear();
        j += wordLength;
      }
    }

    return indices;
  }
}
