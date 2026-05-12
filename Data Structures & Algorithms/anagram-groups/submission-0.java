class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] sarr = s.toCharArray();
            Arrays.sort(sarr);
            String sorted = new String(sarr);
            if (map.containsKey(sorted)) {
                map.get(sorted).add(s);
            } else {
                List<String> newList = new ArrayList<>();
                newList.add(s);
                map.put(sorted, newList);
            }
        }
        List<List<String>> result = new ArrayList();
        for (List<String> value : map.values()) {
            result.add(value);
        }
        return result;
    }
}
