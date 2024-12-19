public class MinimumWindowSubstring {
	public static void main(String[] args){
		// System.out.println(minWindow("ADOBECODEBANC", "ABC"));
		// System.out.println(minWindow("a", "a"));
		// System.out.println(minWindow("a", "aa"));
		System.out.println((int) 'z');
		System.out.println((int) 'A');

	}
	public static String minWindow(String s, String t){
		String word = new String(s);
		int l1 = s.length();
		int l2 = t.length();
		int[] letters = new int[52];



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
