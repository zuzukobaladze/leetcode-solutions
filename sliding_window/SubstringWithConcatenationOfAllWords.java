import java.util.*;

public class SubstringWithConcatenationOfAllWords {
  public static void main(String[] args) {
    String s = "bbarfoofoobarthefoobarman";
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

      if (!wordMap.containsKey(curWord)) { // If current word does not appear
        wordsSeen.clear(); // Clear current map
        i++; // Jump to next index
        j = i; // Start index to i
      } else if (wordsSeen.get(curWord) != wordMap.get(curWord)) { // If current word does not appear same amount in both maps
        wordsSeen.clear();
        j = i; // Change start index
      } else {
        i += wordLength; // Since valid, jump to next possible word
      }

      if (i - j == wordLength * words.length) { // Check if we have needed length of conc. words
        indices.add(j); // Add start index to result
        wordsSeen.clear();
        j += wordLength; // Jump to next word's start index
      }
    }
    return indices;
  }
}
