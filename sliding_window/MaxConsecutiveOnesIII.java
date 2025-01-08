public class MaxConsecutiveOnesIII {

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
