import java.util.*;

public class LongestSubstringKDistinct {

  public static int findLength(String s, int k) {
    if(k >= 26){
      return s.length();
    }
    int maxLen = 0;
    HashMap<Character, Integer> charMap = new HashMap<>();
    for (int j = 0, i = 0; i < s.length(); i++) {
      charMap.merge(s.charAt(i), 1, Integer::sum);
      while (charMap.size() > k) {
        charMap.merge(s.charAt(j), -1, Integer::sum);
        j++;
      }
      maxLen = Math.max(maxLen, i - j + 1);
    }
    return maxLen;
  }
}
