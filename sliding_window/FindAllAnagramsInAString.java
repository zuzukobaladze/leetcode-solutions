import java.util.ArrayList;
import java.util.List;

public class FindAllAnagramsInAString {
  public static void main(String[] args) {
    System.out.println(findAnagrams("cbaebabacd", "abc"));
    System.out.println(findAnagrams("baa", "aa"));
  }

  public static List<Integer> findAnagrams(String s, String p) {
    ArrayList<Integer> list = new ArrayList<>();
    int[] letters = new int[26];
    int l1 = s.length();
    int l2 = p.length();

    if(l2 > l1) return list;

    for (int i = 0; i < l2; i++) {
      letters[s.charAt(i) - 'a']++;
      letters[p.charAt(i) - 'a']--;
    }

    if (zeroes(letters)) list.add(0);

    for (int i = l2; i < l1; i++) {
      letters[s.charAt(i) - 'a']++;
      letters[s.charAt(i - l2) - 'a']--;
      if(zeroes(letters)) list.add(i - l2 + 1);
    }
    return list;
  }

  public static boolean zeroes(int[] arr){
    for (int i : arr) {
      if (i != 0) return false;
    }
    return true;
  }
}