public class MatrixSimilarityAfterCyclicShifts {

    public static boolean areSimilar(int[][] mat, int k) {
        int m = mat.length, n = mat[0].length;
        k %= n;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int newCol;
                if (i % 2 == 0)
                    newCol = (j + k) % n; // left shift
                else
                    newCol = (j - k + n) % n; // right shift

                if (mat[i][j] != mat[i][newCol])
                    return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        int[][] mat = {
            {1, 2, 1, 2},
            {5, 5, 5, 5},
            {6, 3, 6, 3}
        };

        int k = 2;

        boolean result = areSimilar(mat, k);

        if (result)
            System.out.println("Matrix is similar after cyclic shifts.");
        else
            System.out.println("Matrix is NOT similar after cyclic shifts.");
    }
}