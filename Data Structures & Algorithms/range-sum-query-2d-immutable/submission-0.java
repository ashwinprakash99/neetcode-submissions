class NumMatrix {
    private final int[][] sumMatrix;

    private final void computeSumMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        for (int i = 0; i < m; ++i) {
            int sum = 0;
            for (int j = 0; j < n; ++j) {
                sum += matrix[i][j];
                this.sumMatrix[i][j] = sum + (i == 0 ? 0 : this.sumMatrix[i-1][j]);
            }
        }
    }

    public NumMatrix(int[][] matrix) {
        sumMatrix = new int[matrix.length][matrix[0].length];
        computeSumMatrix(matrix);
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sumAtlowerRight = 0, topSum = 0, leftSum = 0, intersectionSum = 0;
        sumAtlowerRight = this.sumMatrix[row2][col2];
        if (row1 != 0) {
            topSum = this.sumMatrix[row1-1][col2];
        }
        if (col1 != 0) {
            leftSum = this.sumMatrix[row2][col1-1];
        }
        if (row1 != 0 && col1 != 0) {
            intersectionSum = this.sumMatrix[row1-1][col1-1];
        }
        return sumAtlowerRight - topSum - leftSum + intersectionSum;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */