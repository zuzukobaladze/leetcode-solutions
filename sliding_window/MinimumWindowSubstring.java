import java.util.HashMap;
import java.util.HashSet;

public class MinimumWindowSubstring {
	public static void main(String[] args){
	public static String minWindow(String s, String t){
		String word = new String(s);
		int l1 = s.length();
		int l2 = t.length();
		int matches = 0;
		int nextIndex = 0;
		HashMap<Character, Integer> targetMap = new HashMap<>();
		HashSet<Character> targetSet = new HashSet<>();

		for (char c  : t.toCharArray()) {
			targetMap.merge(c, 1, Integer::sum);
			targetSet.add(c);
		}

		for (int j = 0, i = 0; i < l1; i++) {
			char right = s.charAt(i);
			if(targetMap.containsKey(right)){
				targetMap.compute(right, (k, v) -> v - 1);
				if(targetMap.get(right) == 0) matches++;
			}
			else if(matches == l2){
				if(word.length() > i - j + 1){
					word = s.substring(j, i);
				}
				char left = s.charAt(j);
				if (targetSet.contains(left)) {
					targetMap.merge(left, 1, Integer::sum);
					matches--;
				}
				j = nextIndex;
			}
			else{
				nextIndex++;
			}
			System.out.println(targetMap);
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