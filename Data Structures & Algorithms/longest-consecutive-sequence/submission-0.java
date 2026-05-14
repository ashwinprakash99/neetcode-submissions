class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;
        List<Integer> list = Arrays.stream(nums).distinct().sorted().boxed().collect(Collectors.toList());
        int maxLength = 0;
        int currentLength = 1;
        for (int i = 1; i < list.size(); ++i) {
            if (list.get(i-1) + 1 == list.get(i)) {
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
