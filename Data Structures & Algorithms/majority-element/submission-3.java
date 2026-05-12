class Solution {
    public int majorityElement(int[] nums) {
        int curr = nums[0];
        int freq = 1;
        for (int i = 1; i < nums.length; ++i) {
            if (curr == nums[i]) {
                ++freq;
            } else {
                if (freq != 0) {
                    --freq;
                } else {
                    curr = nums[i];
                    freq = 1;
                }
            }
        }
        return curr;
    }
}