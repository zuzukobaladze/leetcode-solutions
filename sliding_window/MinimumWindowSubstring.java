import java.util.*;

public class MinimumWindowSubstring {

	public static String minWindow(String s, String t) {
		Map<Character, Integer> map = new HashMap<>();
		for (char c : t.toCharArray()) {
			map.merge(c, 1, Integer::sum);
		}

		int startIndex = 0, minLen = Integer.MAX_VALUE;
		int count = map.size();
		for (int left = 0, right = 0; right < s.length(); right++) {
			char cRight = s.charAt(right);
			if (map.containsKey(cRight)) {
				map.merge(cRight, -1, Integer::sum);
				if (map.get(cRight) == 0) {
					count -= 1;
				}
			}

			while (count <= 0) {
				char cLeft = s.charAt(left);
				if (map.containsKey(cLeft)) {
					map.merge(cLeft, 1, Integer::sum);
					if (map.get(cLeft) > 0) {
						count += 1;
					}
				}
				if (right - left + 1 < minLen) {
					startIndex = left;
					minLen = right - left + 1;
				}
				left++;
			}
		}
		return minLen == Integer.MAX_VALUE ? "" : s.substring(startIndex, startIndex + minLen);
	}
}