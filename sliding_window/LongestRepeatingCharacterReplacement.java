import java.util.HashMap;

public class LongestRepeatingCharacterReplacement {
  public static void main(String[] args) {
    System.out.println(characterReplacement("aabccbb", 2));
    System.out.println(characterReplacement("abbcb", 1));
    System.out.println(characterReplacement("abccde", 1));
    System.out.println(characterReplacement("ABAB", 2));
    System.out.println(characterReplacement("AABABBA", 1));
  }

  public static int characterReplacement(String s, int k) {
    int maxLen = 0;
    int mostRepeatedCount = 0;
    HashMap<Character, Integer> charMap = new HashMap<>();
    for (int j = 0, i = 0; i < s.length(); i++) {
      charMap.merge(s.charAt(i), 1, Integer::sum);
      mostRepeatedCount = Math.max(charMap.get(s.charAt(i)), mostRepeatedCount);
      if(i - j + 1 - mostRepeatedCount > k){
        charMap.compute(s.charAt(j), (key, val) -> val - 1);
        j++;
      }
      maxLen = Math.max(maxLen, i - j + 1);
    }
    return maxLen;

    // int[] count = new int[26];
    // int l = 0;
    // int maxChar = 0;
    // int ans = 0;
    // for (int r = 0; r < s.length(); r++) {
    //   char c = s.charAt(r);
    //   count[c - 'A']++;
    //   maxChar = Math.max(maxChar, count[c - 'A']);
    //   while (r - l + 1 - maxChar > k) {
    //     count[s.charAt(l) - 'A']--;
    //     l++;
    //   }
    //   ans = Math.max(ans, r - l + 1);
    // }
    // return ans;
  }
}
