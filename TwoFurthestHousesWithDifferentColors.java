public class TwoFurthestHousesWithDifferentColors {

    public static int maxDistance(int[] colors) {
        int n = colors.length;
        int ans = 0;

        for (int i = 0; i < n; i++) {
            if (colors[i] != colors[0]) {
                ans = Math.max(ans, i);
            }

            if (colors[i] != colors[n - 1]) {
                ans = Math.max(ans, n - 1 - i);
            }
        }

        return ans;
    }

    public static void main(String[] args) {

        int[] colors = {1, 1, 2, 3, 1};

        int result = maxDistance(colors);

        System.out.println("Maximum Distance Between Two Houses: " + result);
    }
}