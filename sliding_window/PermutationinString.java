public class PermutationinString {

  public static boolean checkInclusion(String s1, String s2) {
    int l1 = s1.length();
    int l2 = s2.length();
    int[] freqs = new int[26];

    for (int i = 0; i < l1; i++) {
      freqs[s1.charAt(i) - 'a']--;
      freqs[s2.charAt(i) - 'a']++;
    }

    if (isAllZero(freqs))
      return true;

    for (int i = l1; i < l2; i++) {
      freqs[s2.charAt(i) - 'a']++;
      freqs[s2.charAt(i - l1) - 'a']--;
      if (isAllZero(freqs))
        return true;

    }
    return false;
  }

  public static boolean isAllZero(int[] arr) {
    for (int i : arr) {
      if (i != 0)
        return false;
    }
    return true;
  }

  // public static boolean checkInclusion(String s1, String s2) {
  //   HashMap<Character, Integer> charMap = new HashMap<>();
  //   int matched = 0;

  //   for (char c : s1.toCharArray()) {
  //     charMap.merge(c, 1, Integer::sum);
  //   }

  //   for (int j = 0, i = 0; i < s2.length(); i++) {
  //     char right = s2.charAt(i);

  //     if(charMap.containsKey(right)) {
  //       charMap.compute(right, (k, v) -> v - 1);
  //       if(charMap.get(right) == 0) matched++;
  //     }

  //     if (matched == charMap.size()) return true;

  //     if (i - j + 1 >= s1.length()){
  //       char left = s2.charAt(j++);
  //       if (charMap.containsKey(left)){
  //         if(charMap.get(left) == 0){
  //           matched--;
  //         }
  //         charMap.merge(left, 1, Integer::sum);
  //       }
  //     }
  //   }
  //   return false;
  // }
}