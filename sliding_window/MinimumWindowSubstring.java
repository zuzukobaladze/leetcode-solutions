import java.util.*;

public class MinimumWindowSubstring {
	public static String minWindow(String s, String t){
		String word = "";
		int l1 = s.length();
		int l2 = t.length();
		int matches = 0;
		int nextIndex = 0;
		HashMap<Character, Integer> targetMap = new HashMap<>();

		for (char c  : t.toCharArray()) {
			targetMap.merge(c, 1, Integer::sum);
		}

		for (int j = 0, i = 0; i < l1; i++) {
			char right = s.charAt(i);
			if(targetMap.containsKey(right)){
				targetMap.compute(right, (k, v) -> v - 1);
				if(targetMap.get(right) == 0) matches++;
			}
		}

		return word;
	}

	public static boolean checkPositive(int[] arr){
		for (int i : arr) {
			if(i < 0){
				return false;
			}
		}
		return true;
	}
}