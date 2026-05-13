class Solution {
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private int partition(int[] nums, int left, int right) {
        int pivot = nums[right];
        int i = left;
        for (int j = left; j < right; ++j) {
            if (nums[j] < pivot) {
                swap(nums, i, j);
                ++i;
            }
        }
        swap(nums, i, right);
        return i;
    }

    private void insertionSort(int[] nums, int left, int right) {
        if (left >= right) return;
        int k = partition(nums, left, right);
        insertionSort(nums, left, k - 1);
        insertionSort(nums, k + 1, right);
    }

    public int[] sortArray(int[] nums) {
        int[] copy = nums.clone();
        insertionSort(copy, 0, copy.length - 1);
        return copy;
    }
}