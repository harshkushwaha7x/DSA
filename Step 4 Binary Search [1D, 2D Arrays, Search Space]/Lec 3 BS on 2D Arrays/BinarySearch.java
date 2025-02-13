import java.util.Arrays;

// Row with max 1s
class RowWithMax1s {
    public int rowWithMax1s(int[][] arr) {
        int m = arr.length;
        int n = arr[0].length;
        int maxRow = -1;
        int i = 0, j = n - 1;

        while (i < m && j >= 0) {
            if (arr[i][j] == 1) {
                maxRow = i;
                j--;
            } else {
                i++;
            }
        }
        return maxRow;
    }
}

// Search a 2D Matrix
class Search2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int left = 0, right = m * n - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int midVal = matrix[mid / n][mid % n];

            if (midVal == target) {
                return true;
            } else if (midVal < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }
}

// Search a 2D Matrix II
class Search2DMatrixII {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = 0;
        int col = matrix[0].length - 1;

        while (row < matrix.length && col >= 0) {
            if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] < target) {
                row++;
            } else {
                col--;
            }
        }
        return false;
    }
}

// Find a Peak Element II
class FindPeakElementII {
    private int findMaxInColumn(int[][] mat, int col) {
        int maxRow = 0;
        for (int i = 1; i < mat.length; i++) {
            if (mat[i][col] > mat[maxRow][col]) {
                maxRow = i;
            }
        }
        return maxRow;
    }

    public int[] findPeakGrid(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int low = 0, high = m - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int maxRow = findMaxInColumn(mat, mid);

            int left = mid - 1 >= 0 ? mat[maxRow][mid - 1] : -1;
            int right = mid + 1 < m ? mat[maxRow][mid + 1] : -1;

            if (mat[maxRow][mid] >= left && mat[maxRow][mid] >= right) {
                return new int[]{maxRow, mid};
            } else if (mat[maxRow][mid] < left) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return new int[]{-1, -1};
    }
}

// Median in a row-wise sorted Matrix
class MedianInRowWiseSortedMatrix {
    public int median(int[][] mat) {
        int row = mat.length;
        int col = mat[0].length;
        int[] flattenedMatrix = new int[row * col];
        int index = 0;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                flattenedMatrix[index++] = mat[i][j];
            }
        }

        Arrays.sort(flattenedMatrix);
        return flattenedMatrix[(row * col) / 2];
    }
}