public class MaxConsecutiveOnesIII {
	public static void main(String[] args){
		System.out.println(longestOnes(new int[]{0,0,1,1,0,0,1,1,1}, 3));
		System.out.println(longestOnes(new int[] {1,1,1,0,0,0,1,1,1,1,0}, 2));

	}

	public static int longestOnes(int[] nums, int k) {
		int maxLen = 0;
		int oneCount = 0;
		for (int j = 0, i = 0; i < nums.length; i++) {
			int right = nums[i];
			if(right == 1) oneCount++;
			while(i - j + 1 - oneCount > k){
				if(nums[j] == 1) oneCount--;
				j++;
			}
			maxLen = Math.max(maxLen, i - j + 1);
		}
		return maxLen;
	}
}
