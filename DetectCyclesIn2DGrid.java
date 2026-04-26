public class DetectCyclesIn2DGrid {

    static int[][] dirs = {
        {0, -1},
        {0, 1},
        {-1, 0},
        {1, 0}
    };

    public static boolean containsCycle(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        boolean[][] visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    if (dfs(i, j, -1, -1, grid, visited, m, n)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    private static boolean dfs(int r, int c, int pr, int pc,
                               char[][] grid, boolean[][] visited,
                               int m, int n) {

        visited[r][c] = true;

        for (int[] dir : dirs) {
            int nr = r + dir[0];
            int nc = c + dir[1];

            if (nr < 0 || nr >= m || nc < 0 || nc >= n) {
                continue;
            }

            if (grid[nr][nc] != grid[r][c]) {
                continue;
            }

            if (nr == pr && nc == pc) {
                continue;
            }

            if (visited[nr][nc]) {
                return true;
            }

            if (dfs(nr, nc, r, c, grid, visited, m, n)) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {

        char[][] grid = {
            {'a', 'a', 'a', 'a'},
            {'a', 'b', 'b', 'a'},
            {'a', 'b', 'b', 'a'},
            {'a', 'a', 'a', 'a'}
        };

        boolean result = containsCycle(grid);

        if (result) {
            System.out.println("Cycle detected in the grid.");
        } else {
            System.out.println("No cycle found in the grid.");
        }
    }
}