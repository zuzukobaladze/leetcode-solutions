import java.util.HashMap;

public class LongestSubstringKDistinct {
  public static void main(String[] args) {
    System.out.println(findLength("araaci", 2));
    System.out.println(findLength("araaci", 1));
    System.out.println(findLength("cbbebi", 3));
  }

  public static int findLength(String s, int k) {
    if(k >= 26){
      return s.length();
    }
    int maxLen = 0;
    HashMap<Character, Integer> charMap = new HashMap<>();
    for (int j = 0, i = 0; i < s.length(); i++) {
      charMap.merge(s.charAt(i), 1, Integer::sum);
      while (charMap.size() > k) {
        charMap.compute(s.charAt(j), (key, value) -> (value == 1) ? null : value - 1);
        j++;
      }
      maxLen = Math.max(maxLen, i - j + 1);
    }
    return maxLen;
  }
}
