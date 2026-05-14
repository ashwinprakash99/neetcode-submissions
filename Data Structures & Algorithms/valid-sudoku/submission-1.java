class Solution {
    public boolean isValidSudoku(char[][] board) {
        Map<Integer, Set<Character>> rowMap = new HashMap<>();
        Map<Integer, Set<Character>> colMap = new HashMap<>();
        Map<String, Set<Character>> squareMap = new HashMap<>();

        for (int i = 0; i < 9; ++i) {
            for (int j = 0; j < 9; ++j) {
                char val = board[i][j];
                if (val != '.') {
                    if (!(
                        rowMap.computeIfAbsent(i, k -> new HashSet<>()).add(val)
                        &&
                        colMap.computeIfAbsent(j, k -> new HashSet<>()).add(val)
                        &&
                        squareMap.computeIfAbsent(String.format("%d-%d", i/3, j/3), k -> new HashSet<>()).add(val)
                    )) return false;
                }
            }
        }
        return true;
    }
}
