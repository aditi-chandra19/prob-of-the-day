import java.util.ArrayList;

public class RotateGridLayers {

    public static int[][] rotateGrid(int[][] grid, int k) {

        int m = grid.length;
        int n = grid[0].length;

        int layers = Math.min(m, n) / 2;

        for (int layer = 0; layer < layers; layer++) {

            ArrayList<Integer> vals = new ArrayList<>();

            int top = layer;
            int left = layer;

            int bottom = m - layer - 1;
            int right = n - layer - 1;

            // Top row
            for (int j = left; j <= right; j++) {
                vals.add(grid[top][j]);
            }

            // Right column
            for (int i = top + 1; i <= bottom - 1; i++) {
                vals.add(grid[i][right]);
            }

            // Bottom row
            for (int j = right; j >= left; j--) {
                vals.add(grid[bottom][j]);
            }

            // Left column
            for (int i = bottom - 1; i >= top + 1; i--) {
                vals.add(grid[i][left]);
            }

            int sz = vals.size();

            int idx = k % sz;

            // Top row
            for (int j = left; j <= right; j++) {

                grid[top][j] = vals.get(idx);

                idx++;

                if (idx == sz) {
                    idx = 0;
                }
            }

            // Right column
            for (int i = top + 1; i <= bottom - 1; i++) {

                grid[i][right] = vals.get(idx);

                idx++;

                if (idx == sz) {
                    idx = 0;
                }
            }

            // Bottom row
            for (int j = right; j >= left; j--) {

                grid[bottom][j] = vals.get(idx);

                idx++;

                if (idx == sz) {
                    idx = 0;
                }
            }

            // Left column
            for (int i = bottom - 1; i >= top + 1; i--) {

                grid[i][left] = vals.get(idx);

                idx++;

                if (idx == sz) {
                    idx = 0;
                }
            }
        }

        return grid;
    }

    public static void main(String[] args) {

        int[][] grid = {
            {40, 10},
            {30, 20}
        };

        int k = 1;

        int[][] result = rotateGrid(grid, k);

        System.out.println("Rotated Grid:");

        for (int[] row : result) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
}