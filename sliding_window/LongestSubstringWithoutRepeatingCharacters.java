
import java.util.*;

public class LongestSubstringWithoutRepeatingCharacters {

    public static int lengthOfLongestSubstring(String s) {
        int size = 0;
        HashMap<Character, Integer> CharIndexMap = new HashMap<>();
        for (int i = 0, j = 0; i < s.length(); i++) {
            CharIndexMap.merge(s.charAt(i), 1, Integer::sum);
            while (CharIndexMap.get(s.charAt(i)) > 1) {
                CharIndexMap.merge(s.charAt(j), -1, Integer::sum);
                j++;
            }
            size = Math.max(size, i - j + 1);
        }
        return size;

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
