class Solution {
    public boolean isValidSudoku(char[][] board) {
        int[] rowMarker = new int[9];
        int[] colMarker = new int[9];
        int[] squareMarker = new int[9];

        for (int i = 0; i < 9; ++i) {
            for (int j = 0; j < 9; ++j) {
                char val = board[i][j];
                if (val != '.') {
                    int pos = 1 << (val - '0');
                    int squareLoc = (i / 3) * 3 + (j / 3);
                    if (
                        (rowMarker[i] & pos) > 0
                        ||
                        (colMarker[j] & pos) > 0
                        ||
                        (squareMarker[squareLoc] & pos) > 0
                    ) return false;
                    rowMarker[i] |= pos;
                    colMarker[j] |= pos;
                    squareMarker[squareLoc] |= pos;
                }
            }
        }
        return true;
    }
}
