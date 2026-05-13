class Solution {
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void merge(int[] nums, int left, int mid, int right) {
        List<Integer> temp = new ArrayList<>(right-left+1);
        int i = left, j = mid + 1;
        while (i <= mid && j <= right) {
            if (nums[i] < nums[j]) {
                temp.add(nums[i++]);
            } else {
                temp.add(nums[j++]);
            }
        }
        while (i <= mid) {
            temp.add(nums[i++]);
        }
        while (j <= right) {
            temp.add(nums[j++]);
        }
        int k = left;
        System.out.println(temp);
        for (i = left; i <= right; ++i) {
            nums[i] = temp.get(i-left);
        }
    }

    private void mergeSort(int[] nums, int left, int right) {
        if (left >= right) return;
        int mid = left + (right - left) / 2;
        mergeSort(nums, left, mid);
        mergeSort(nums, mid + 1, right);
        merge(nums, left, mid, right);
    }

    public int[] sortArray(int[] nums) {
        int[] copy = nums.clone();
        mergeSort(copy, 0, copy.length - 1);
        return copy;
    }
}