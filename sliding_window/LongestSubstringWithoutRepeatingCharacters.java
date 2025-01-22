import java.util.*;

public class LongestSubstringWithoutRepeatingCharacters {
  public static int lengthOfLongestSubstring(String s) {
    int maxLength = 0;
    Map<Character, Integer> charIndexMap = new HashMap<>();
    for (int j = 0, i = 0; i < s.length(); i++) {
      char rightChar = s.charAt(i);
      if (charIndexMap.containsKey(rightChar)) {
        j = Math.max(j, charIndexMap.get(rightChar) + 1);
      }
      charIndexMap.put(rightChar, i);
      maxLength = Math.max(maxLength, i - j + 1);
      }
    return maxLength;

    // int maxLen = 0;
    // Set<Character> letters = new HashSet<>();
    // for (int j = 0, i = 0; i < s.length(); i++) {
    //   while (letters.contains(s.charAt(i))) {
    //     letters.remove(s.charAt(j));
    //     j++;
    //   }
    //   letters.add(s.charAt(i));
    //   maxLen = Math.max(maxLen, i - j + 1);
    // }

    // return maxLen;
  }
}
