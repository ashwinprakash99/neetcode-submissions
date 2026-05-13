class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        System.out.println(map);

        List<Integer>[] arr = new List[nums.length+1];
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (arr[entry.getValue()] != null) {
                arr[entry.getValue()].add(entry.getKey());
            } else {
                List<Integer> newList = new ArrayList<>();
                newList.add(entry.getKey());
                arr[entry.getValue()] = newList;
            }
        }
        System.out.println(Arrays.toString(arr));

        int[] result = new int[k];
        for (int i = arr.length-1; i >= 0; --i) {
            List<Integer> a = arr[i];
            if (a != null) {
                for (int x : a) {
                    result[--k] = x;
                    if (k == 0) return result;
                }
            }
        }
        return result;
    }
}
