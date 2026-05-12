class Solution {
    public int removeElement(int[] nums, int val) {
        int i = 0;
        int j = nums.length - 1;
        if (i == j && nums[i] == val) return 0;
        while (i <= j) {
            if (nums[j] == val) {
                --j;
                continue;
            }
            if (nums[i] == val) {
                nums[i] = nums[j--];
            }
            ++i;
        }
        return j+1;
    }
}