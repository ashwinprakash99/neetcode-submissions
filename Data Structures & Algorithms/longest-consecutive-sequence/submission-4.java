class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;
        Arrays.sort(nums);
        int maxLength = 0;
        int currentLength = 1;
        for (int i = 1; i < nums.length; ++i) {
            if (nums[i-1] == nums[i]) continue;
            if (nums[i-1] + 1 == nums[i]) {
                ++currentLength;
            } else {
                maxLength = Math.max(maxLength, currentLength);
                currentLength = 1;
            }
        }
        maxLength = Math.max(maxLength, currentLength);
        return maxLength;
    }
}
