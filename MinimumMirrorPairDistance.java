import java.util.*;

public class MinimumMirrorPairDistance {

    public static int minMirrorPairDistance(int[] nums) {
        int res = 100000, i = 0;
        HashMap<Integer, Integer> seen = new HashMap<>();

        for (int n : nums) {
            int r;

            if (seen.containsKey(n)) {
                res = Math.min(res, i - seen.get(n));
            }

            r = 0;
            int temp = n;

            while (temp > 0) {
                r = r * 10 + (temp % 10);
                temp /= 10;
            }

            seen.put(r, i++);
        }

        return res == 100000 ? -1 : res;
    }

    public static void main(String[] args) {

        int[] nums = {12, 21, 13, 31, 12};

        int result = minMirrorPairDistance(nums);

        if (result == -1) {
            System.out.println("No mirror pair found.");
        } else {
            System.out.println("Minimum Mirror Pair Distance: " + result);
        }
    }
}