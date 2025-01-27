import java.util.HashMap;

public class LongestRepeatingCharacterReplacement {

  public static int characterReplacement(String s, int k) {
    int maxLen = 0;
    int mostRepeatedCount = 0;
    HashMap<Character, Integer> charMap = new HashMap<>();
    for (int j = 0, i = 0; i < s.length(); i++) {
      charMap.merge(s.charAt(i), 1, Integer::sum);
      mostRepeatedCount = Math.max(charMap.get(s.charAt(i)), mostRepeatedCount);
      if(i - j + 1 - mostRepeatedCount > k){
        charMap.merge(s.charAt(j), -1, Integer::sum);
        j++;
      }
      maxLen = Math.max(maxLen, i - j + 1);
    }
    return maxLen;
  }
}
