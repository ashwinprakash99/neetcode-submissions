class Solution {
    public boolean isValidSudoku(char[][] board) {
        int[] rowMarker = new int[10];
        int[] colMarker = new int[10];
        int[][][] smallBoxMarker = new int[3][3][10];

        for (int i = 0; i < 9; ++i) {
            for (int j = 0; j < 9; ++j) {
                if (board[i][j] != '.') {
                    if (rowMarker[board[i][j]-'0'] != 0) return false;
                    rowMarker[board[i][j]-'0'] = 1;

                    if (smallBoxMarker[i/3][j/3][board[i][j]-'0'] != 0) return false;
                    smallBoxMarker[i/3][j/3][board[i][j]-'0'] = 1;
                }
                if (board[j][i] != '.') {
                    if (colMarker[board[j][i]-'0'] != 0) return false;
                    colMarker[board[j][i]-'0'] = 1;
                }
            }
            rowMarker = new int[10];
            colMarker = new int[10];
        }

        return true;
    }
}
