class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;
        Set<Integer> set = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        int maxLength = 0;
        for (int num : nums) {
            if (!set.contains(num-1)) {
                int currentLength = 1;
                int current = num;
                while (set.contains(current+1)) {
                    ++currentLength;
                    ++current;
                }
                maxLength = Math.max(maxLength, currentLength);
            }
        }
        return maxLength;
    }
}
