class Solution {
    public int majorityElement(int[] nums) {
        int curr = 0;
        int freq = 0;
        for (int num : nums) {
            if (freq == 0) {
                curr = num;
            }
            freq += (curr == num) ? 1 : -1;
        }
        return curr;
    }
}