class Solution {
    public int majorityElement(int[] nums) {
        int[] bits = new int[32];
        for (int num : nums) {
            for (int i = 0; i < 32; ++i) {
                bits[i] += (num >> i) & 1;
            }
        }
        int result = 0;
        for (int i = 0; i < 32; ++i) {
            result |= bits[i] > nums.length / 2 ? (1 << i) : 0;
        }
        return result;
    }
}