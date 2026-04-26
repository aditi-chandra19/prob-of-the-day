import java.util.*;

public class RottingOranges {

    public static int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int freshOranges = 0;

        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    freshOranges++;
                } else if (grid[i][j] == 2) {
                    q.offer(new int[]{i, j, 0});
                }
            }
        }

        int minLevel = 0;

        int[][] dirs = {
            {-1, 0},
            {0, 1},
            {1, 0},
            {0, -1}
        };

        while (!q.isEmpty()) {
            int i = q.peek()[0];
            int j = q.peek()[1];
            int level = q.peek()[2];
            q.poll();

            minLevel = level;

            for (int[] dir : dirs) {
                int nrow = i + dir[0];
                int ncol = j + dir[1];

                if (nrow >= 0 && nrow < n &&
                    ncol >= 0 && ncol < m &&
                    grid[nrow][ncol] == 1) {

                    q.offer(new int[]{nrow, ncol, level + 1});
                    grid[nrow][ncol] = 2;
                    freshOranges--;
                }
            }
        }

        return freshOranges == 0 ? minLevel : -1;
    }

    public static void main(String[] args) {

        int[][] grid = {
            {2, 1, 1},
            {1, 1, 0},
            {0, 1, 1}
        };

        int result = orangesRotting(grid);

        System.out.println("Minimum time to rot all oranges: " + result);
    }
}