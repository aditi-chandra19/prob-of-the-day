import java.util.Arrays;

public class MaximumDistanceOnSquareBoundary {

    public static int maxDistance(int s, int[][] p, int k) {
        long[] x = new long[p.length];

        for (int i = 0; i < x.length; i++) {
            x[i] = getX(p[i], s);
        }

        Arrays.sort(x);

        int l = 1, r = s, m;

        while (l < r) {
            m = (l + r + 1) / 2;

            if (possible(4L * s, x, m, k)) {
                l = m;
            } else {
                r = m - 1;
            }
        }

        return r;
    }

    private static long getX(int[] p, int s) {
        if (p[1] == 0) return p[0];
        else if (p[1] == s) return 3L * s - p[0];
        else if (p[0] == s) return p[1] + (long) s;
        else return 4L * s - p[1];
    }

    private static boolean possible(long r, long[] x, int m, int k) {
        int c;

        for (int i = 0; i < x.length && x[i] - x[0] < m; i++) {
            c = i;

            for (int j = 1; j < k; j++) {
                c = get(x, x[c] + m, c);

                if (c == x.length || x[c] + m - r > x[i]) {
                    break;
                }
            }

            if (c < x.length && x[c] + m - r <= x[i]) {
                return true;
            }
        }

        return false;
    }

    private static int get(long[] x, long v, int f) {
        int t = x.length, m;

        while (f < t) {
            m = (f + t) / 2;

            if (x[m] < v) {
                f = m + 1;
            } else {
                t = m;
            }
        }

        return f;
    }

    public static void main(String[] args) {

        int s = 4;

        int[][] p = {
            {0, 0},
            {4, 0},
            {4, 4},
            {0, 4}
        };

        int k = 3;

        int result = maxDistance(s, p, k);

        System.out.println("Maximum Distance: " + result);
    }
}