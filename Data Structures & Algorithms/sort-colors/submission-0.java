class Solution {
    public void sortColors(int[] nums) {
        int[] counts = new int[3];

        for (int num : nums) {
            ++counts[num];
        }

        int pos = -1;
        for (int i = 0; i < 3; ++i) {
            int count = counts[i];
            while (count != 0) {
                nums[++pos] = i;
                --count;
            }
        }
    }
}