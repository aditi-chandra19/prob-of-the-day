public class UniValueGridOperations {

    public static int minOperations(int[][] grid, int x) {
        int n = grid.length;
        int m = grid[0].length;
        int N = n * m;

        int[] freq = new int[10001];
        int min = grid[0][0];
        int max = min;

        for (int[] row : grid) {
            for (int val : row) {
                if ((val - grid[0][0]) % x != 0) {
                    return -1;
                }

                freq[val]++;
                min = Math.min(min, val);
                max = Math.max(max, val);
            }
        }

        int target = (N + 1) / 2;
        int acc = 0;
        int median = min;

        for (int i = min; i <= max; i += x) {
            acc += freq[i];

            if (acc >= target) {
                median = i;
                break;
            }
        }

        int ops = 0;

        for (int i = min; i <= max; i += x) {
            ops += Math.abs(i - median) / x * freq[i];
        }

        return ops;
    }

    public static void main(String[] args) {

        int[][] grid = {
            {2, 4},
            {6, 8}
        };

        int x = 2;

        int result = minOperations(grid, x);

        System.out.println("Minimum Operations: " + result);
    }
}